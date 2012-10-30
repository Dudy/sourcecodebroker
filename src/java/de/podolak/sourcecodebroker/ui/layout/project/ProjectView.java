package de.podolak.sourcecodebroker.ui.layout.project;

/**
 *
 * @author Dude
 */
import com.vaadin.data.Container;
import com.vaadin.data.Container.ItemSetChangeEvent;
import com.vaadin.data.Container.PropertySetChangeEvent;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.terminal.Sizeable;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import de.podolak.sourcecodebroker.data.Project;
import de.podolak.sourcecodebroker.data.Task;
import de.podolak.sourcecodebroker.data.code.Node;
import de.podolak.sourcecodebroker.data.json.SerializationDemo;
import de.podolak.sourcecodebroker.util.Utilities;
import java.util.Collection;

@SuppressWarnings("serial")
public class ProjectView extends HorizontalLayout /* implements  Accordion.SelectedTabChangeListener */ {

    private static final ThemeResource icon = new ThemeResource("icons/mail_new.png");

    private Project project;
    private Accordion a;
    private HorizontalSplitPanel horizontalSplitPanel;
    private HierarchicalContainer container = new HierarchicalContainer();
    private int sourceCodeRootNodeId = -1;
    private Node rootNode;
    
    private Panel projectPanel;
    private Tree projectTree;
    
    public ProjectView(Project project) {
        this.project = project;
        
        setMargin(true);
        addStyleName("taskList");
        
        horizontalSplitPanel = new HorizontalSplitPanel();
        horizontalSplitPanel.setSizeFull();
        horizontalSplitPanel.setSplitPosition(200, Sizeable.UNITS_PIXELS);
        horizontalSplitPanel.setFirstComponent(getProjectPanel());
        horizontalSplitPanel.setSecondComponent(getTasksPanel());
        horizontalSplitPanel.setMargin(true);
        
        addComponent(horizontalSplitPanel);
    }
    
    private Panel getProjectPanel() {
        projectPanel = new Panel(Utilities.getI18NText("projectView.panelName.project"));
        projectTree = new Tree();
        projectTree.setContainerDataSource(getTreeContainer());
        projectTree.setItemCaptionPropertyId("caption");
        projectTree.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);
        projectTree.addListener(new Listener() {

            @Override
            public void componentEvent(Event event) {
                System.out.println("=================================================================");
                System.out.println(event);
                System.out.println(event.getComponent());
                System.out.println(event.getSource());
                System.out.println("=================================================================");
            }
        });
        projectTree.addListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                System.out.println("-----------------------------------------------------------------");
                System.out.println(event);
                System.out.println(event.getProperty());
                System.out.println(event.getProperty().getType());
                System.out.println(event.getProperty().getValue());
                System.out.println("-----------------------------------------------------------------");
            }
        });
        projectTree.addListener(new ItemClickHandler());

//
//        setImmediate(true);
//        setSelectable(true);
//        setMultiSelect(false);
//        setNullSelectionAllowed(false);
//
//        addListener((ItemClickEvent.ItemClickListener) app);
//        addListener((Property.ValueChangeListener) app);
//        addListener((Container.ItemSetChangeListener) app);
//        addListener((Container.PropertySetChangeListener) app);
        
        projectPanel.addComponent(projectTree);
        
        return projectPanel;
    }
    
    private Panel getTasksPanel() {
        Panel panel = new Panel(Utilities.getI18NText("projectView.panelName.taskList"));
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
        
        return panel;
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
    
    private HierarchicalContainer getTreeContainer() {
        // most of this is dummy data
        
        int id = 1;
        int rootId = 1;
        
        container.removeAllItems();
        container.addContainerProperty("caption", String.class, "");
        container.addContainerProperty("text", String.class, "");
        
        Item item;
        item = container.addItem(id);
        item.getItemProperty("caption").setValue(project.getProjectName());
        container.setChildrenAllowed(id, true);
        id++;
        
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("Projektmanager");
        container.setChildrenAllowed(id, true);
        container.setParent(id, rootId);
        id++;
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("Dirk Podolak");
        container.setChildrenAllowed(id, false);
        container.setParent(id, id - 1);
        id++;
        
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("Erzeugungszeitpunkt");
        container.setChildrenAllowed(id, true);
        container.setParent(id, rootId);
        id++;
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("30.10.2012 00:36:08");
        container.setChildrenAllowed(id, false);
        container.setParent(id, id - 1);
        id++;
        
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("Zeitpunkt letzte Änderung");
        container.setChildrenAllowed(id, true);
        container.setParent(id, rootId);
        id++;
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("30.10.2012 00:36:46");
        container.setChildrenAllowed(id, false);
        container.setParent(id, id - 1);
        id++;
        
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("Anzahl Tasks");
        container.setChildrenAllowed(id, true);
        container.setParent(id, rootId);
        id++;
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("37");
        container.setChildrenAllowed(id, false);
        container.setParent(id, id - 1);
        id++;
        
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("Anzahl unbearbeiteter Tasks");
        container.setChildrenAllowed(id, true);
        container.setParent(id, rootId);
        id++;
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("12");
        container.setChildrenAllowed(id, false);
        container.setParent(id, id - 1);
        id++;
        
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("Anzahl Codestücke");
        container.setChildrenAllowed(id, true);
        container.setParent(id, rootId);
        id++;
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("31");
        container.setChildrenAllowed(id, false);
        container.setParent(id, id - 1);
        id++;
        
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("Anzahl akzeptierter Codestücke");
        container.setChildrenAllowed(id, true);
        container.setParent(id, rootId);
        id++;
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("7");
        container.setChildrenAllowed(id, false);
        container.setParent(id, id - 1);
        id++;
        
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("Anzahl ausgezahlter Credits");
        container.setChildrenAllowed(id, true);
        container.setParent(id, rootId);
        id++;
        item = container.addItem(id);
        item.getItemProperty("caption").setValue("19");
        container.setChildrenAllowed(id, false);
        container.setParent(id, id - 1);
        id++;
        
        // TODO add root node of source code tree here, get it from GitHub ;-)
        rootNode = SerializationDemo.getDummyNode();
        fillDataContainer(id, rootNode);
        
        container.addListener(new ItemSetChangeHandler());
        container.addListener(new PropertySetChangeHandler());
        container.addListener(new ValueChangeHandler());
        
        return container;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" data container handling ">
    /**
     * Adds the source code tree to the container.
     * The global container already contains some data. The source code tree is given by its root
     * node. The next valid id is also given such that we can start adding the root node and all
     * of its children to the container.
     * 
     * @param currentId
     * @param rootNode 
     */
    private void fillDataContainer(int currentId, Node rootNode) {
        sourceCodeRootNodeId = currentId;
        addItem(rootNode, currentId, currentId);
    }

    private int addItem(Node node, int itemId, int parentId) {
        // add new item
        Item item;
        item = container.addItem(itemId);
        item.getItemProperty("caption").setValue(node.getName());
        item.getItemProperty("text").setValue(node.getText());

        container.setChildrenAllowed(itemId, node.getNumberOfChildren() > 0);

        // add parent
        if (parentId >= 0) {
            container.setChildrenAllowed(parentId, true);
            container.setParent(itemId, parentId);
        }

        // add children
        int newId = itemId + 1;
        for (Node child : node.getChildren()) {
            newId = addItem(child, newId, itemId);
        }

        // return last valid id
        return newId;
    }

    private Node getNode(int itemId) {
        Item item = container.getItem(itemId);
        Node node = new Node(
                item.getItemProperty("caption").getValue().toString(),
                item.getItemProperty("text").getValue().toString());

        Collection<?> children = container.getChildren(itemId);
        if (children != null && children.size() > 0) {
            for (Object childIdObject : children) {
                node.addChild(getNode((Integer) childIdObject));
            }
        }

        return node;
    }
    // </editor-fold>

    public Tree getProjectTree() {
        return projectTree;
    }
    
    public void update() {
        
    }

    private class ItemSetChangeHandler implements Container.ItemSetChangeListener {

        @Override
        public void containerItemSetChange(ItemSetChangeEvent event) {
            System.out.println("---------------------------------------------");
            System.out.println("----- 1");
            System.out.println(event);
            System.out.println(event.getContainer());
            System.out.println("---------------------------------------------");
        }
        
    }
    
    private class PropertySetChangeHandler implements Container.PropertySetChangeListener {

        @Override
        public void containerPropertySetChange(PropertySetChangeEvent event) {
            System.out.println("---------------------------------------------");
            System.out.println("----- 2");
            System.out.println(event);
            System.out.println("---------------------------------------------");
        }
        
    }
    
    private class ValueChangeHandler implements ValueChangeListener {

        @Override
        public void valueChange(ValueChangeEvent event) {
            System.out.println("---------------------------------------------");
            System.out.println("----- 3");
            System.out.println(event);
            System.out.println(event.getProperty());
            System.out.println("---------------------------------------------");
        }
        
    }
    
    private class ItemClickHandler implements ItemClickListener {

        @Override
        public void itemClick(ItemClickEvent event) {
            System.out.println("---------------------------------------------");
            System.out.println("----- 3");
            System.out.println(event);
            System.out.println(event.getItem());
            System.out.println("---------------------------------------------");
            
            
            
        }
        
    }
    
}