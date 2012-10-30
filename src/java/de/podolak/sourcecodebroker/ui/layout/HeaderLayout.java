package de.podolak.sourcecodebroker.ui.layout;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import de.podolak.sourcecodebroker.SourcecodeBrokerApplication;
import de.podolak.sourcecodebroker.util.Utilities;

/**
 *
 * @author Dude
 */
public class HeaderLayout extends HorizontalLayout implements Button.ClickListener {

    private SourcecodeBrokerApplication app;
    
    public HeaderLayout() {
        init();
    }
    
    public HeaderLayout(SourcecodeBrokerApplication app) {
        this.app = app;
        init();
    }
    
    private void init() {
        setMargin(true);
        setSpacing(true);
        setStyleName("header");
        setWidth("100%");
        
        Button addNode = new Button(Utilities.getI18NText("action.addNode.button.caption"));
        addComponent(addNode);
        addNode.addListener((Button.ClickListener) this);
        addNode.setIcon(new ThemeResource("icons/edit_add.png"));
        addNode.addStyleName("multiline");
        
        Label appname = new Label(Utilities.getI18NText("window.title"));
        addComponent(appname);
        setComponentAlignment(appname, Alignment.MIDDLE_RIGHT);
        appname.setStyleName("appname");
        setExpandRatio(appname, 1);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        if (app != null) {
            app.updateTaskList();
        }
    }
    
}
