package de.podolak.sourcecodebroker.data;

import java.io.Serializable;

/**
 *
 * @author Dude
 */
public class Requirement implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String shortText;
    private String description;

    public Requirement() {
    }

    public Requirement(String shortText, String description) {
        this.shortText = shortText;
        this.description = description;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String requirementName) {
        this.shortText = requirementName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String output() {
        StringBuilder descriptionBuilder = new StringBuilder();
        
        descriptionBuilder
                .append(shortText)
                .append("\n")
                .append(description)
                .append("\n");
                
        return descriptionBuilder.toString();
    }
    
}
