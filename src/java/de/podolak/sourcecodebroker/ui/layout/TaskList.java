package de.podolak.sourcecodebroker.ui.layout;

/**
 *
 * @author Dude
 */
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;

@SuppressWarnings("serial")
public class TaskList extends HorizontalLayout implements
        Accordion.SelectedTabChangeListener {

    private static final ThemeResource icon = new ThemeResource("icons/mail_new.png");

    private Accordion a;

    public TaskList() {
        setMargin(true);
        
        Panel panel = new Panel("List of Tasks");
        panel.setSizeFull();

        Label l1 = new Label("Task 1");
        Label l2 = new Label("Task 2");
        Label l3 = new Label("Task 3");

        a = new Accordion();
        a.setHeight("100%");
        a.setWidth("100%");
        a.addTab(l1, "show task 1", icon);
        a.addTab(l2, "show task 2", icon);
        a.addTab(l3, "show task 3", icon);
        a.addListener(this);

        panel.setContent(a);
        
        addComponent(panel);
        setExpandRatio(panel, 1);
    }
    
    @Override
    public void selectedTabChange(SelectedTabChangeEvent event) {
        TabSheet tabsheet = event.getTabSheet();
        Tab tab = tabsheet.getTab(tabsheet.getSelectedTab());
        if (tab != null) {
            getWindow().showNotification("selected: " + tab.getCaption());
        }
    }
}