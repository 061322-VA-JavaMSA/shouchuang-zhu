package daos;

import java.util.List;

import org.hibernate.Session;

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

}
