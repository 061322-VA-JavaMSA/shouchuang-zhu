package DAOs;

import java.io.IOException;

import Models.Payment;

public interface PaymentDao {
	Payment createPayment(Payment p) throws IOException;
}
