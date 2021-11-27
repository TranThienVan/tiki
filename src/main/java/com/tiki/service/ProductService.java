package com.tiki.service;

import com.tiki.model.Category;
import com.tiki.model.Product;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveProduct(Product product){
        sessionFactory.getCurrentSession().save(product);
    }

    public List<Category> getAllCategories(){
        return sessionFactory.getCurrentSession().createQuery("from Category").list();

    }

    public Product getProduct(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where id:id");
        query.setInteger("id", id);

        return (Product) query.uniqueResult();

    }


    public List<Product> getAllProducts(){
        Query query = sessionFactory.getCurrentSession().createQuery("from Product");
        return query.list();
    }

    public List<Product> findProducts(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Product s where s.name like :name");

        query.setString("name", "%"+name+"%");

        return query.list();
    }
}
