package Services;

import java.io.IOException;
import java.util.List;

import DAOs.PaymentDao;
import DAOs.PaymentPostgres;
import Models.Payment;

public class PaymentService {

	private PaymentDao pd = new PaymentPostgres();
	
	public Payment createPayment(Payment p) throws IOException {
		return pd.createPayment(p);
	}
	
	public List<Payment> checkPaymentInfo(int userId) throws IOException {
		return pd.retrivePaymentByUserId(userId);
	}
}
