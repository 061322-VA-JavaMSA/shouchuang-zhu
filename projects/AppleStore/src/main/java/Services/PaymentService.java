package Services;

import java.io.IOException;

import DAOs.PaymentDao;
import DAOs.PaymentPostgres;
import Models.Payment;

public class PaymentService {

	private PaymentDao pd = new PaymentPostgres();
	
	public Payment createPayment(Payment p) throws IOException {
		return pd.createPayment(p);
	}
}
