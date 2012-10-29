package de.podolak.sourcecodebroker.ui.layout.task;

/**
 *
 * @author Dude
 */
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import de.podolak.sourcecodebroker.data.Project;
import de.podolak.sourcecodebroker.data.Task;
import de.podolak.sourcecodebroker.util.Utilities;

@SuppressWarnings("serial")
public class TaskList extends HorizontalLayout /* implements Accordion.SelectedTabChangeListener */ {

    private static final ThemeResource icon = new ThemeResource("icons/mail_new.png");

    private Accordion a;
    
    public TaskList(Project project) {
        setMargin(true);
        addStyleName("taskList");
        
        Panel panel = new Panel(Utilities.getI18NText("taskList.panelName"));
        panel.setSizeFull();
        panel.addStyleName("panelName");
        
        a = new Accordion();
        a.setHeight("100%");
        a.setWidth("100%");
        
        for (Task task : project.getTaskList()) {
            a.addTab(
                    new TaskLayout(task),
                    task.getTaskName(),
                    icon);
        }

        panel.setContent(a);
        
        addComponent(panel);
        setExpandRatio(panel, 1);
    }
    
    public Task getSelectedTask() {
        return ((TaskLayout)a.getSelectedTab()).getTask();
    }

// I don't delete this for a while in case I need it later on ...
//    @Override
//    public void selectedTabChange(SelectedTabChangeEvent event) {
//        TabSheet tabsheet = event.getTabSheet();
//        Tab tab = tabsheet.getTab(tabsheet.getSelectedTab());
//        if (tab != null) {
//            getWindow().showNotification("selected: " + tab.getCaption());
//        }
//    }
}