package daos;

import java.util.List;

import models.Reimbursement;

public interface EmployeeDao {
	Reimbursement insertReimbursement(Reimbursement r);
	List<Reimbursement> getReimbursement();
	
}
