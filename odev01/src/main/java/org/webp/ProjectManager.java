package org.webp;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity

public class ProjectManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Size(min = 2 , max = 128)
    private String name;
    @Size(min = 2 , max = 128)
    private String surname;

    @OneToOne(mappedBy = "projectManager")
    private Project project;



    public ProjectManager(){}

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}