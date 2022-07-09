package daos;

import java.util.List;

import models.Reimbursement;

public interface EmployerDao {
	List<Reimbursement> getReimbursement();
}
