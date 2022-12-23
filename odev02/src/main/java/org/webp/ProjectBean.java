package org.webp;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Stateless
public class ProjectBean {

    @PersistenceContext
    private EntityManager em;

    public ProjectBean(){}

    public void AddProject(Long categoryId ,Long projectManagerId ,String categoryName, String description){
        CategoryBean categoryBean = new CategoryBean();
        Category category = categoryBean.getCategoryById(categoryId);

        ProjectManagerBean projectManagerBean = new ProjectManagerBean();
        ProjectManager projectManager = projectManagerBean.getProjectManagerById(projectManagerId);
        Project project = new Project();

        project.setProjectName(categoryName);
        project.setDescription(description);
        project.setProjectManager(projectManager);
        project.setCategory(category);
        em.persist(project);
    }

    public List<Project> getProjects() {
        TypedQuery<Project> query = em.createQuery("select u from Project u", Project.class);
        return query.getResultList();
    }
}

