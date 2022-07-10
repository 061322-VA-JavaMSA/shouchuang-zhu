package services;

import java.util.List;

import daos.EmployerDao;
import daos.EmployerHibernate;
import models.Reimbursement;

public class EmployerService {
	private EmployerDao ed = new EmployerHibernate();
	public List<Reimbursement> getReimbursement(){
		return ed.getReimbursement();
	}
	
	public void updateReimbursement(Reimbursement r) {
		ed.updateReimbursement(r);
	}
	
	
}
