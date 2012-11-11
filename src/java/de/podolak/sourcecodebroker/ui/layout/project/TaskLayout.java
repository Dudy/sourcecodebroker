package de.podolak.sourcecodebroker.ui.layout.project;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import de.podolak.sourcecodebroker.data.Requirement;
import de.podolak.sourcecodebroker.data.Task;
import de.podolak.sourcecodebroker.data.code.Node;
import de.podolak.sourcecodebroker.util.Utilities;

/**
 *
 * @author Dude
 */
public class TaskLayout extends VerticalLayout {

    private Task task;
    private Node rootNode;

    public TaskLayout(Task task, Node rootNode) {
        this.task = task;
        this.rootNode = rootNode;
        init();
    }

    private void init() {
        addStyleName("taskLayout");
        setSpacing(true);
        setMargin(true);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(Utilities.getI18NText("taskLayout.name"));
        label.addStyleName("label");
        label.setWidth("100px");
        layout.addComponent(label);
        label = new Label(task.getTaskName());
        label.addStyleName("data");
        label.setWidth("100%");
        layout.addComponent(label);
        layout.setExpandRatio(label, 1);
        addComponent(layout);

// such a pity ... GAE doesn't allow java.awt.Toolkit, and you can't fill the clipboard from javascript
// see comment below
//        layout = new HorizontalLayout();
//        VerticalLayout verticalLayout = new VerticalLayout();
//        label = new Label(Utilities.getI18NText("taskLayout.codeTemplate"));
//        label.addStyleName("label");
//        verticalLayout.addComponent(label);
//        Button button = new Button(Utilities.getI18NText("taskLayout.button.copyCode"), new CopyToClipboardHandler());
//        button.addStyleName("multiline");
//        verticalLayout.addComponent(button);
//        layout.addComponent(verticalLayout);
        layout = new HorizontalLayout();
        layout.setSizeFull();
        label = new Label(Utilities.getI18NText("taskLayout.codeTemplate"));
        label.addStyleName("label");
        label.setWidth("100px");
        layout.addComponent(label);
        
        TextArea ta = new TextArea();
        ta.addStyleName("data code");
        ta.setWidth("100%");
        ta.setValue(task.getCodeTemplate()); // use Utilities.formatCodeTemplate() when it has a cool code formatter (not yet)
        ta.setRows(20);
        layout.addComponent(ta);
        layout.setExpandRatio(ta, 1);
        addComponent(layout);
        
        layout = new HorizontalLayout();
        layout.setSizeFull();
        label = new Label(Utilities.getI18NText("taskLayout.requirements"));
        label.addStyleName("label");
        label.setWidth("100px");
        layout.addComponent(label);
        Table table = new Table();
        table.setContainerDataSource(getRequirementsContainer());
        table.setColumnHeaders(new String[] {
            Utilities.getI18NText("taskLayout.requirements.shortText"),
            Utilities.getI18NText("taskLayout.requirements.description")
        });
        table.addStyleName("data");
        table.setWidth("100%");
        layout.addComponent(table);
        layout.setExpandRatio(table, 1);
        addComponent(layout);
        
        layout = new HorizontalLayout();
        layout.setSizeFull();
        label = new Label(Utilities.getI18NText("taskLayout.context"));
        label.addStyleName("label");
        label.setWidth("100px");
        layout.addComponent(label);
        
        ta = new TextArea();
        ta.addStyleName("data code");
        ta.setWidth("100%");
        ta.setValue(rootNode.getTextByPath(task.getPath())); // use Utilities.formatCodeTemplate() when it has a cool code formatter (not yet)
        ta.setRows(20);
        layout.addComponent(ta);
        layout.setExpandRatio(ta, 1);
        addComponent(layout);
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

// such a pity ... GAE doesn't allow java.awt.Toolkit, and you can't fill the clipboard from javascript
// see comment above
//    private class CopyToClipboardHandler implements Button.ClickListener {
//        @Override
//        public void buttonClick(ClickEvent event) {
//            StringSelection stringSelection = new StringSelection(task.getCodeTemplate());
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//        }
//    }
    
    private IndexedContainer getRequirementsContainer() {
        int id = 1;
        IndexedContainer container = new IndexedContainer();
        container.addContainerProperty("name", String.class, null);
        container.addContainerProperty("description", String.class, null);
        Item item;
        
        for (Requirement requirement : task.getRequirementList()) {
            item = container.addItem(id++);
            item.getItemProperty("name").setValue(requirement.getShortText());
            item.getItemProperty("description").setValue(requirement.getDescription());
        }
        
        return container;
    }
        
}
