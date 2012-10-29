package de.podolak.sourcecodebroker.data;

import de.podolak.sourcecodebroker.util.Utilities;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dude
 */
public class Task implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String taskName;
    private String codeTemplate;
    private List<Requirement> requirementList;

    public Task() {
    }

    public Task(String taskName, String codeTemplate, List<Requirement> requirementList) {
        this.taskName = taskName;
        this.codeTemplate = codeTemplate;
        this.requirementList = requirementList;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCodeTemplate() {
        return codeTemplate;
    }

    public void setCodeTemplate(String codeTemplate) {
        this.codeTemplate = codeTemplate;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }
    
    public String output() {
        StringBuilder descriptionBuilder = new StringBuilder();
        
        descriptionBuilder
                .append(taskName)
                .append("\n")
                .append(Utilities.formatCodeTemplate(codeTemplate))
                .append("\n");
        
        for (Requirement requirement : requirementList) {
            descriptionBuilder.append(requirement.output());
        }
                
        return descriptionBuilder.toString();
    }
    
}
