package de.podolak.sourcecodebroker.data.code;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This Node is an entry in the source code tree.
 * It is either a package or a file.
 * Its name must always be given.
 * If it is a package there are children but no text.
 * If it is a file there are no children but text.
 * 
 * @author Dude
 */
public class Node implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String name;
    private String text;
    private List<Node> children;

    public Node() {
        this("", "", null);
    }
    
    public Node(String title) {
        this(title, "", null);
    }

    public Node(String title, String text) {
        this(title, text, null);
    }
    
    public Node(String name, String text, List<Node> children) {
        this.name = name;
        
        if (text != null && !text.isEmpty() && children != null && children.size() > 0) {
            throw new IllegalArgumentException("text and children cannot be filled both");
        }
        
        this.text = text;
        this.children = children;
        
        if (this.children == null) {
            this.children = new ArrayList<Node>();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text != null && !text.isEmpty() && children != null && children.size() > 0) {
            throw new IllegalArgumentException("text and children cannot be filled both");
        }
        
        this.text = text;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        if (text != null && !text.isEmpty() && children != null && children.size() > 0) {
            throw new IllegalArgumentException("text and children cannot be filled both");
        }
        
        this.children = children;
    }
    
    public boolean addChild(Node child) {
        return this.children.add(child);
    }
    
    public boolean removeChild(Node child) {
        return this.children.remove(child);
    }
    
    public int getNumberOfChildren() {
        return this.children.size();
    }

    @Override
    public String toString() {
        return
                "node=[" +
                "name=" + name + "," +
                "text=" + text + "," +
                children +
                "]";
    }

}
