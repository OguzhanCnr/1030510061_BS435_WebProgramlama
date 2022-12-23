package org.webp;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class CategoryBean {

    @PersistenceContext
    private EntityManager em;

    public CategoryBean(){}

    public void AddCategory(String categoryName){

        Category category = new Category();
        category.setCategoryName(categoryName);
        em.persist(category);
    }

    public long getNumberOfCategories(){
        TypedQuery<Long> query = em.createQuery("select count(u) from Category u", Long.class);
        long n = query.getSingleResult();
        return n;
    }
    public List<Category> getCategories() {
        TypedQuery<Category> query = em.createQuery("select u from Category u", Category.class);
        return query.getResultList();
    }
    public Category getCategoryById(long categoryId) {
        Category category = em.find(Category.class,categoryId);
        return category;
    }


}

