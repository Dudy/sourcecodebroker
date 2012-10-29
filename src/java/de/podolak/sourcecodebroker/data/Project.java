package de.podolak.sourcecodebroker.data;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dude
 */
public class Project implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static final int CURRENT_SERIALIZATION_VERSION = 1;

    private Long id;
    private Integer serializationVersion;
    private String projectName;
    private List<Task> taskList;

    public Project() {
    }

    public Project(Long id, String projectName, List<Task> taskList) {
        this.id = id;
        this.serializationVersion = CURRENT_SERIALIZATION_VERSION;
        this.projectName = projectName;
        this.taskList = taskList;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSerializationVersion() {
        return serializationVersion;
    }

    public void setSerializationVersion(Integer serializationVersion) {
        this.serializationVersion = serializationVersion;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
    
    public String toJsonString() {
        String jsonString = null;
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jsonString;
    }
    
    public static Project fromString(String jsonString) {
        Project project = null;
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            project = mapper.readValue(jsonString, Project.class);
        } catch (JsonParseException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return project;
    }
    
}
