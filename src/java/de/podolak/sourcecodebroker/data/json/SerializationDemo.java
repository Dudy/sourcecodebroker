package de.podolak.sourcecodebroker.data.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.podolak.sourcecodebroker.data.Project;
import de.podolak.sourcecodebroker.data.code.Node;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dude
 */
public class SerializationDemo {
    
    private static ObjectMapper mapper = new ObjectMapper();

    public static void write(Project project) {
        try {
            mapper.writeValue(new File("project01-modified.json"), project);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String toString(Project project) {
        String jsonString = null;
        
        try {
            jsonString = mapper.writeValueAsString(project);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jsonString;
    }
    
    public static Project read() {
        try {
            return mapper.readValue(new File("project01.json"), Project.class);
        } catch (JsonParseException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static Node readNode() {
        try {
            return mapper.readValue(new File("sourcecode01.json"), Node.class);
        } catch (JsonParseException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static Project read(String jsonText) {
        Project project = null;
        
        try {
            project = mapper.readValue(jsonText, Project.class);
        } catch (JsonParseException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return project;
    }
    
    public static Project getDummyProject() {
        Project project = null;
        
        try {
            project = mapper.readValue(
                    SerializationDemo.class
                        .getResource("/de/podolak/sourcecodebroker/data/json/project01.json")
                        .openStream(),
                    Project.class);
        } catch (IOException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return project;
    }
    
    public static Node getDummyNode() {
        Node node = null;
        
        try {
            node = mapper.readValue(
                    SerializationDemo.class
                        .getResource("/de/podolak/sourcecodebroker/data/json/sourcecode01.json")
                        .openStream(),
                    Node.class);
        } catch (IOException ex) {
            Logger.getLogger(SerializationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return node;
    }
}
