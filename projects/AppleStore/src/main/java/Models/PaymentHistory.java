package Models;

public class PaymentHistory {
	int historyId;
	int paymentId;
	int userId;
	int payment;
	
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	public String toString() {
		return "paymenthistory [historyId=" + historyId + ",paymentId=" + paymentId + ",userId=" + userId + ", payment amount=" + payment + "]";
	}
	
}
