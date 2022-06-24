package DAOs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Models.Offer;

public interface OfferDao {
	List<Offer> retrieveOffers() throws SQLException, IOException;
	boolean updateOffer(Offer o) throws SQLException, IOException;
	Offer retrieveOffersById(int id) throws SQLException, IOException;
}
