package de.podolak.sourcecodebroker.data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;
import de.podolak.sourcecodebroker.data.json.SerializationDemo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dude
 */
public class PersistenceHandler {
    
    private static final String KEY_TYPE_PROJECT_JSON     = "Project_JSON";
    private static final String KEY_TYPE_PROJECT_ENTITIES = "Project_entities";
    
    //TODO

    /**
     * Loads a project from the GAE datastore.
     * In the GAE datastore the entities of the projects, its tasks and their requirements are stored
     * as separate entities without a connection. The project contains a list of datastore keys that
     * reference the tasks and each task contains a list of its requirements.
     * 
     * @param id
     * @return 
     */
    public static Project loadDocumentByTypeGAE_entities(Long id) {
//        Key key = KeyFactory.createKey("Project", id);
//            
//        try {
//            Entity projectEntity = DatastoreServiceFactory.getDatastoreService().get(key);
//            Project document = loadDocumentFromString(((Text)datastoreDocument.getProperty("content")).getValue());
//            document.setCreateDate(new Date((Long)datastoreDocument.getProperty("createDate")));
//            document.setLastModifyDate(new Date((Long)datastoreDocument.getProperty("lastModifyDate")));
//            return document;
//        } catch (EntityNotFoundException ex) {
//            Logger.getLogger(DocumentPersistence.class.getName()).log(Level.SEVERE, null, ex);
//            
//            Entity dd = new Entity("Document", id);
//            dd.setProperty("content", new Text(DocumentJpaController.document.getContent()));
//            dd.setProperty("createDate", new Date().getTime());
//            dd.setProperty("lastModifyDate", new Date().getTime());
//            DatastoreServiceFactory.getDatastoreService().put(dd);
//            return loadDocumentFromString(DocumentJpaController.document.getContent());
//        }
        
        return null;
    }
    
    public static Project storeProjectByTypeGAE_entities(Project project) {
//        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//
//        Long id = project.getId();
//        Entity datastoreDocument = null;
//        
//        if (id != null) {
//            Key key = KeyFactory.createKey(PROJECT_KEY_TYPE, id);
//            
//            try {
//                datastoreDocument = datastore.get(key);
//                //datastoreDocument.setProperty("createDate", project.getCreateDate().getTime());
//            } catch (EntityNotFoundException ex) {
//                Logger.getLogger(PersistenceHandler.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            datastoreDocument = new Entity(PROJECT_KEY_TYPE);
//            project.setId(datastoreDocument.getKey().getId());
//            //datastoreDocument.setProperty("createDate", new Date().getTime());
//        }
//        
//        if (datastoreDocument != null) {
//            datastoreDocument.setProperty("content", new Text(SimpleDocumentWriter.write(project).getContent()));
//            datastoreDocument.setProperty("lastModifyDate", new Date().getTime());
//            datastore.put(datastoreDocument);
//        }
//        
//        return project;
        
        return null;
    }

    public static Project loadProjectByTypeGAE_JSON(Long id) {
        Project project;
        
        Key key = KeyFactory.createKey(KEY_TYPE_PROJECT_JSON, id);
        try {
            Entity entity = DatastoreServiceFactory.getDatastoreService().get(key);
            project = Project.fromString(((Text)entity.getProperty("content")).getValue());
        } catch (EntityNotFoundException ex) {
            Logger.getLogger(PersistenceHandler.class.getName()).log(Level.SEVERE, null, ex);
            
            // dummy for creating a new project if it does not yet exist
            project = SerializationDemo.getDummyProject();
            Entity entity = new Entity(KEY_TYPE_PROJECT_JSON, id);
            entity.setProperty("content", new Text(project.toJsonString()));
            DatastoreServiceFactory.getDatastoreService().put(entity);
        }
        
        return project;
    }
    
    public static Project storeProjectByTypeGAE_JSON(Project project) {
        Long id = project.getId();
        Entity entity;
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey(KEY_TYPE_PROJECT_JSON, id);
        
        if (id != null) {
            try {
                entity = datastore.get(key);
            } catch (EntityNotFoundException ex) {
                entity = new Entity(KEY_TYPE_PROJECT_JSON, id);
                project.setId(entity.getKey().getId());
            }
        } else {
            entity = new Entity(KEY_TYPE_PROJECT_JSON);
            project.setId(entity.getKey().getId());
        }
        
        entity.setProperty("content", project.toJsonString());
        datastore.put(entity);
        
        return project;
    }
    
}
