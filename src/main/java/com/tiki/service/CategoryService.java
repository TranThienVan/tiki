package com.tiki.service;

import com.tiki.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private  SessionFactory sessionFactory;

    public Category save(Category category) {

        sessionFactory.getCurrentSession().save(category);
        return category;
    }
}
