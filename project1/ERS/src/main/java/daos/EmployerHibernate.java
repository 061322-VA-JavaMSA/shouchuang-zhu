package daos;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Reimbursement;
import utils.HibernateUtil;

public class EmployerHibernate implements EmployerDao {
	public List<Reimbursement> getReimbursement(){
		List<Reimbursement> r = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			r = s.createQuery("from Reimbursement", Reimbursement.class).list();
		}
		return r;
		
	}
	
	public void updateReimbursement(Reimbursement r) {
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			String str = "Update Reimbursement set reimbResolved = :res," + "reimbStatusId = :sid " + "where reimbId = :id";
			Transaction txn = s.beginTransaction();
			Query query = s.createQuery(str);
			
			query.setParameter("res", r.getReimbResolved());
			query.setParameter("sid", r.getReimbStatusId());
			query.setParameter("id", r.getReimbId());
			query.executeUpdate();
			txn.commit();
			
		}
	}
	

}
