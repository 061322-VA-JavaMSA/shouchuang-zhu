package DAOs;

import java.io.IOException;
import java.util.List;

import Models.Payment;

public interface PaymentDao {
	Payment createPayment(Payment p) throws IOException;
	List<Payment> retrivePaymentByUserId(int userId) throws IOException;
}
