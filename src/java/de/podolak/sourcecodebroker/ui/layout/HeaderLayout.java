package de.podolak.sourcecodebroker.ui.layout;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import de.podolak.sourcecodebroker.Utilities;

/**
 *
 * @author Dude
 */
public class HeaderLayout extends HorizontalLayout implements Button.ClickListener {

    public HeaderLayout() {
        init();
    }
    
    private void init() {
        Button addNode = new Button(Utilities.getI18NText("action.addNode.button.caption"));
        addComponent(addNode);
        addNode.addListener((Button.ClickListener) this);
        addNode.setIcon(new ThemeResource("icons/edit_add.png"));
        addNode.addStyleName("multiline");

        setMargin(true);
        setSpacing(true);
        setStyleName("header");
        setWidth("100%");
        
        Label appname = new Label("SourcecodeBroker");
        addComponent(appname);
        setComponentAlignment(appname, Alignment.MIDDLE_RIGHT);
        appname.setStyleName("appname");
        setExpandRatio(appname, 1);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
