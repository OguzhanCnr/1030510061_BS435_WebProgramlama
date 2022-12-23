package org.webp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProjectManagerBean {

    @PersistenceContext
    private EntityManager em;

    public ProjectManagerBean(){}

    public void AddProjectManager(String name,String surname){

        ProjectManager projectManager = new ProjectManager();
        projectManager.setName(name);
        projectManager.setSurname(surname);
        em.persist(projectManager);
    }

    public long getNumberOfProjectManager(){
        TypedQuery<Long> query = em.createQuery("select count(u) from ProjectManager u", Long.class);
        long n = query.getSingleResult();
        return n;
    }
    public List<ProjectManager> getProjectManagers() {
        TypedQuery<ProjectManager> query = em.createQuery("select u from ProjectManager u", ProjectManager.class);
        return query.getResultList();
    }
    public ProjectManager getProjectManagerById(long projectManagerId) {
        ProjectManager projectManager = em.find(ProjectManager.class,projectManagerId);
        return projectManager;
    }


}

