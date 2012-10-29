package de.podolak.sourcecodebroker.ui.layout;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import de.podolak.sourcecodebroker.util.Utilities;

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
        
        Label text = new Label(Utilities.getI18NText("footer.dummytext"));
        addComponent(text);
        
        Link link = new Link(Utilities.getI18NText("footer.dudytext"), new ExternalResource(Utilities.getI18NText("footer.dudylink")));
        addComponent(link);
        setComponentAlignment(link, Alignment.MIDDLE_RIGHT);
        link.setStyleName("signature");
        setExpandRatio(link, 1);
    }
    
}
