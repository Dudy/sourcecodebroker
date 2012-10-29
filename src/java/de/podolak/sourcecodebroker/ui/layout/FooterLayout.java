package de.podolak.sourcecodebroker.ui.layout;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 *
 * @author Dude
 */
public class FooterLayout extends HorizontalLayout {

    public FooterLayout() {
        init();
    }
    
    private void init() {
        setMargin(true);
        setSpacing(true);
        setStyleName("footer");
        setWidth("100%");
        
        Label text = new Label("footer");
        addComponent(text);
        
        Label signature = new Label("by Dirk Podolak 2012");
        addComponent(signature);
        setComponentAlignment(signature, Alignment.MIDDLE_RIGHT);
        signature.setStyleName("signature");
        setExpandRatio(signature, 1);
    }
    
}
