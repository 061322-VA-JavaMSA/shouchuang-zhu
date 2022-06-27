package DAOs;

import java.io.IOException;
import java.util.List;

import Models.Payment;
import Models.PaymentHistory;

public interface PaymentDao {
	Payment createPayment(Payment p) throws IOException;
	List<Payment> retrivePaymentByUserId(int userId) throws IOException;
	boolean makePayment(int payment, int payment_id, int user_id) throws IOException;
	int retriveRemainingPaymentByPaymentId(int paymentId) throws IOException;
	boolean createPaymentHistory(int user_id, int payment_id, int payment) throws IOException;
	List<PaymentHistory> retrievePaymentHistory() throws IOException;
	int retriveWeeklySum() throws IOException;
}
