package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.User;
import Utils.JpaUtils;

public class UserDao {
	private EntityManager em;
	private EntityTransaction transaction;

	public UserDao() {
		this.em = JpaUtils.getEntityManager();
	}

	public List<User> getAll() {
		String jpql = "SELECT u FROM User u";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		return query.getResultList();
	}

	public User findById(int id) {
		return this.em.find(User.class, id);
	}

	public User insert(User u) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.persist(u);
			this.transaction.commit();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public User update(User u) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.merge(u);
			this.transaction.commit();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public User delete(User u) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.remove(u);
			this.transaction.commit();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}
	
	public User deleteById(int id) {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			User u = this.em.find(User.class, id);
			this.em.remove(u);
			this.transaction.commit();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}
	
	public User findByEmail(String email) {
		String jpql = "SELECT u FROM User u WHERE u.email =:email";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
