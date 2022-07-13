package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Product;
import Utils.JpaUtils;

public class ProductDao {
	private EntityManager em;
	private EntityTransaction transaction;

	public ProductDao() {
		this.em = JpaUtils.getEntityManager();
	}

	public List<Product> getAll() {
		String jpql = "SELECT p FROM Product p";
		TypedQuery<Product> query = this.em.createQuery(jpql, Product.class);
		return query.getResultList();
	}

	public Product findById(int id) {
		return this.em.find(Product.class, id);
	}

	public Product insert(Product p) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.persist(p);
			this.transaction.commit();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public Product update(Product p) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.merge(p);
			this.transaction.commit();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public Product delete(Product p) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.remove(p);
			this.transaction.commit();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public Product deleteById(int id) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			Product p = this.em.find(Product.class, id);
			this.em.remove(p);
			this.transaction.commit();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

}
