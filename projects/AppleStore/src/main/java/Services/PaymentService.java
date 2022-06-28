package Services;

import java.io.IOException;
import java.util.List;

import DAOs.PaymentDao;
import DAOs.PaymentPostgres;
import Models.Payment;
import Models.PaymentHistory;

public class PaymentService {

	private PaymentDao pd = new PaymentPostgres();
	
	public Payment createPayment(Payment p) throws IOException {
		return pd.createPayment(p);
	}
	
	public List<Payment> checkPaymentInfo(int userId) throws IOException {
		return pd.retrivePaymentByUserId(userId);
	}
	
	public boolean makePayment(int payment, int paymentId, int user_id) throws IOException {
		return pd.makePayment(payment, paymentId, user_id);
	}
	
	public int remainingPayment(int paymentId) throws IOException {
		return pd.retriveRemainingPaymentByPaymentId(paymentId);
	}
	public boolean addToHistory(int userId, int paymentId, int payment) throws IOException {
		return pd.createPaymentHistory(userId, paymentId, payment);
	}
	
	public List<PaymentHistory> checkPaymentHistory() throws IOException {
		return pd.retrievePaymentHistory();
	}
	
	public int checkWeeklyPayment() throws IOException {
		return pd.retriveWeeklySum();
	}
	
	public boolean addToOwnedItems(int userId, int itemId) throws IOException {
		return pd.addToOwnedItems(userId, itemId);
	}
	
	public Payment retrivePaymentByPaymentId (int paymentId) throws IOException {
		return pd.retrivePaymentByPaymentId(paymentId);
	}
	
	public List<String> checkOwnedItems(int userId) throws IOException{
		return pd.retriveOwnedItem(userId);
	}
	
}
