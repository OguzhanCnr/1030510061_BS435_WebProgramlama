package org.webp;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2 , max = 128)
    private String projectName;
    @Size(min = 2 , max = 128)
    private String description;

    @OneToOne
    private ProjectManager projectManager;

    @ManyToOne
    @JoinColumn(name ="categoryId")
    private Category category;

    public Project(){}

    public Long getId() {
        return id;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

