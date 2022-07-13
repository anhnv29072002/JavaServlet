package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.OderBill;
import Utils.JpaUtils;

public class OderBillDao {
	private EntityManager em;
	private EntityTransaction transacion;

	public OderBillDao() {
		this.em = JpaUtils.getEntityManager();
	}

	public List<OderBill> getAll() {
		String jpql = "SELECT o FROM OderBill o";
		TypedQuery<OderBill> query = this.em.createQuery(jpql, OderBill.class);
		return query.getResultList();
	}

	public OderBill findById(int id) {
		return this.em.find(OderBill.class, id);
	}

	public OderBill insert(OderBill o) throws Exception {
		this.transacion = this.em.getTransaction();
		try {
			this.em.clear();
			this.transacion.begin();
			this.em.persist(o);
			this.transacion.commit();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			this.transacion.rollback();
			throw e;
		}
	}

	public OderBill update(OderBill o) throws Exception {
		this.transacion = this.em.getTransaction();
		try {
			this.em.clear();
			this.transacion.begin();
			this.em.merge(o);
			this.transacion.commit();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			this.transacion.rollback();
			throw e;
		}
	}

	public OderBill delete(OderBill o) throws Exception {
		this.transacion = this.em.getTransaction();
		try {
			this.em.clear();
			this.transacion.begin();
			this.em.remove(o);
			this.transacion.commit();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			this.transacion.rollback();
			throw e;
		}
	}

	public void deleteById(int id) throws Exception {
		this.transacion = this.em.getTransaction();
		try {
			this.em.clear();
			this.transacion.begin();
			OderBill o = this.em.find(OderBill.class, id);
			this.em.remove(o);
			this.transacion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.transacion.rollback();
			throw e;
		}
	}

	public List<OderBill> getByStatus(String status) {
		String jpql = "SELECT o FROM OderBill o WHERE o.status =:status";
		TypedQuery<OderBill> query = this.em.createQuery(jpql, OderBill.class);
		query.setParameter("status", status);
		return query.getResultList();
	}

	public List<OderBill> getByIdAndStatus(int id, String status) {
		String jpql = "SELECT o FROM OderBill o WHERE o.user.id =:id AND o.status =:status";
		TypedQuery<OderBill> query = this.em.createQuery(jpql, OderBill.class);
		query.setParameter("id", id);
		query.setParameter("status", status);
		return query.getResultList();
	}

}
