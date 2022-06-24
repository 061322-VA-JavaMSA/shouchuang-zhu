package DAOs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.Offer;
import Util.ConnectionUtil;

public class OfferPostgres implements OfferDao {


	public List<Offer> retrieveOffers() throws SQLException, IOException {
		// TODO Auto-generated method stub
		String sql = "select * from offers;";
		List<Offer> offers = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile();) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Offer o = new Offer();
				o.setOfferId(rs.getInt("offer_id"));
				o.setItemID(rs.getInt("item_id"));
				o.setUserId(rs.getInt("user_id"));
				o.setPrice(rs.getInt("offer"));
				offers.add(o);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}

}
