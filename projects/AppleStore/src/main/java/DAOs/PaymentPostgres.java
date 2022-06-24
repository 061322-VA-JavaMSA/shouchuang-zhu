package DAOs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Payment;
import Util.ConnectionUtil;

public class PaymentPostgres implements PaymentDao {
	public Payment createPayment(Payment p) throws IOException {
		String sql = "insert into payments (user_id, item_id, offer) values (?,?,?) returning payment_id;";
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, p.getUserId());
			ps.setInt(2, p.getItemId());
			ps.setInt(3, p.getOffer());
			
			ResultSet rs = ps.executeQuery(); // return the id generated by the database
			if(rs.next()) {
				p.setPaymentId(rs.getInt("payment_id") + 1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}