package daos;

import java.util.List;

import models.Reimbursement;

public interface EmployerDao {
	List<Reimbursement> getReimbursement();
	void updateReimbursement(Reimbursement r);
	//Reimbursement getReimbursementbyId(int id);
}
