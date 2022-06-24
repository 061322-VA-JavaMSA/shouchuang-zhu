package DAOs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Models.Offer;

public interface OfferDao {
	List<Offer> retrieveOffers() throws SQLException, IOException;
}
