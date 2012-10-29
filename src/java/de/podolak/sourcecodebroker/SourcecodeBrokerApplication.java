package de.podolak.sourcecodebroker;

import com.vaadin.Application;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import de.podolak.sourcecodebroker.ui.layout.FooterLayout;
import de.podolak.sourcecodebroker.ui.layout.HeaderLayout;
import de.podolak.sourcecodebroker.ui.layout.TaskList;

@SuppressWarnings("serial")
public class SourcecodeBrokerApplication extends Application {

    private Window window;

    @Override
    public void init() {
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
        HeaderLayout header = new HeaderLayout();
        main.addComponent(header);

        // list
        TaskList taskList = new TaskList();
        taskList.setSizeFull();
        main.addComponent(taskList);
        main.setExpandRatio(taskList, 1.0f);
        
        // header
        FooterLayout footer = new FooterLayout();
        main.addComponent(footer);
    }
    
}
