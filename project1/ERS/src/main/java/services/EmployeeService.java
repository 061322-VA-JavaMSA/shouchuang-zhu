package services;

import java.util.List;

import daos.EmployeeDao;
import daos.EmployeeHibernate;
import models.Reimbursement;

public class EmployeeService {
	private EmployeeDao ed = new EmployeeHibernate();
	
	public Reimbursement insertReimbursement(Reimbursement r) {
		return ed.insertReimbursement(r);
	}
	
	public List<Reimbursement> getReimbursement(){
		return ed.getReimbursement();
	}
}
