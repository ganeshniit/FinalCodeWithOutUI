package com.alibaba.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.model.Product;
@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	 SessionFactory sessionfactory;
	public void addProduct(Product product) {
		Session session=sessionfactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(product);
		transaction.commit();
		System.out.println("Done");
		
	}
	public List<Product> viewProducts() {
		Session session=sessionfactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		List<Product> products=session.createCriteria(Product.class).list();
		transaction.commit();
		return products;
	}
	public void deleteProductById(int id) {
		Session session=sessionfactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Product prod=session.get(Product.class, new Integer(id));
		session.delete(prod);
		transaction.commit();
	}
	
	

}
