package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Oder;
import Utils.JpaUtils;

public class OderDao {
	private EntityManager em;
	private EntityTransaction transaction;

	public OderDao() {
		this.em = JpaUtils.getEntityManager();
	}

	public List<Oder> getAll() {
		String jpql = "SELECT o FROM Oder o";
		TypedQuery<Oder> query = this.em.createQuery(jpql, Oder.class);
		return query.getResultList();
	}

	public Oder findById(int id) {
		return this.em.find(Oder.class, id);
	}

	public Oder insert(Oder o) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.persist(o);
			this.transaction.commit();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public Oder update(Oder o) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.merge(o);
			this.transaction.commit();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public Oder delete(Oder o) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			this.em.remove(o);
			this.transaction.commit();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

	public void deleteById(int id) throws Exception {
		this.transaction = this.em.getTransaction();
		try {
			this.em.clear();
			this.transaction.begin();
			Oder o = this.em.find(Oder.class, id);
			this.em.remove(o);
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}
	}

}
