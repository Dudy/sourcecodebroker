package de.podolak.sourcecodebroker;

import com.vaadin.Application;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import de.podolak.sourcecodebroker.data.PersistenceHandler;
import de.podolak.sourcecodebroker.data.Project;
import de.podolak.sourcecodebroker.ui.layout.FooterLayout;
import de.podolak.sourcecodebroker.ui.layout.HeaderLayout;
import de.podolak.sourcecodebroker.ui.layout.project.ProjectView;
import de.podolak.sourcecodebroker.util.Utilities;

@SuppressWarnings("serial")
public class SourcecodeBrokerApplication extends Application {

    private Window window;
    private IndexedContainer dataContainer;
    private Project currentProject;
    
    private ProjectView projectView;

    @Override
    public void init() {
        initData();
        buildMainLayout();
    }
    
    private void buildMainLayout() {
        setTheme("sourcecodebroker");
        
        window = new Window(Utilities.getI18NText("window.title"));
        setMainWindow(window);

        VerticalLayout main = new VerticalLayout();
        main.setSizeFull();
        getMainWindow().setContent(main);

        // header
        HeaderLayout header = new HeaderLayout(this);
        main.addComponent(header);

        // list
        projectView = new ProjectView(currentProject);
        projectView.setSizeFull();
        main.addComponent(projectView);
        main.setExpandRatio(projectView, 1.0f);
        
        // header
        FooterLayout footer = new FooterLayout();
        main.addComponent(footer);
    }
    
    /**
     * data structure:
     *   type GAE_JSON:
     *     In the GAE datastore there are entities with the sole attribute "content".
     *     The content contains a <code>Project</code> that has been serialized by its
     *     <code>toJSONString()</code> method. It will be deserialized by its <code>
     *     fromJSONString()</code> method call.
     * internal:
     *   POJO:
     *     Internally the data is stored in a relational format. A <code>Project</code>
     *     object contains an id, a name, a list of <code>Task</code> objects and so on.
     *   Vaadin:
     *     For the use within the Vaadin framework the <code>Project</code> object again
     *     is encapsulated within a container bean (<code>ProjectContainer</code>).
     * 
     * For now we just load the <code>Project</code> with id 1 and display all of its
     * tasks.
     */
    private void initData() {
        currentProject = PersistenceHandler.loadProjectByTypeGAE_JSON(1L);
        
// don't need that now, may use this for lists etc
//        dataContainer = new IndexedContainer();
//        dataContainer.addContainerProperty("name", String.class, "");
//        
//        int id = 2;
//        for (Task task : currentProject.getTaskList()) {
//            Item item = dataContainer.addItem(id++);
//            item.getItemProperty("name").setValue(task.getTaskName());
//        }
        
    }

    public void updateTaskList() {
        projectView.update();
    }
    
}
