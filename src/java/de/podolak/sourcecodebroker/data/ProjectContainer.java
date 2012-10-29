package de.podolak.sourcecodebroker.data;

import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Dude
 */
public class ProjectContainer extends BeanItemContainer<Project> implements Serializable {
    
    public ProjectContainer() throws InstantiationException, IllegalAccessException {
        super(Project.class);
    }
    
}
