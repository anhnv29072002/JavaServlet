package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Category;
import Utils.JpaUtils;

public class CategoryDao {
	private EntityManager em;
	private EntityTransaction transaction;

	public CategoryDao() {
		this.em = JpaUtils.getEntityManager();
	}

	public List<Category> getAll() {
		String jpql = "SELECT c FROM Category c";
		TypedQuery<Category> query = this.em.createQuery(jpql, Category.class);
		return query.getResultList();
	}

	public Category findById(int id) {
		return this.em.find(Category.class, id);
	}

	public Category insert(Category c) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.persist(c);
			this.transaction.commit();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public Category update(Category c) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.merge(c);
			this.transaction.commit();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public Category delete(Category c) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.remove(c);
			this.transaction.commit();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public Category deleteById(int id) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			Category c = this.em.find(Category.class, id);
			this.em.remove(c);
			this.transaction.commit();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

}
