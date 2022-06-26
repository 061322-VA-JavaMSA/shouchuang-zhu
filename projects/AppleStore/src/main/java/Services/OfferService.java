package Services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAOs.OfferDao;
import DAOs.OfferPostgres;
import Models.Offer;

public class OfferService {
	private OfferDao od = new OfferPostgres();
	public List<Offer> getOffers() throws SQLException, IOException {
		return od.retrieveOffers();
	}
	
	public boolean ChangeOfferStatus(Offer o) throws SQLException, IOException {
		return od.updateOffer(o);
		
	}
	
	public Offer retrieveOfferById(int offerid) throws SQLException, IOException {
		return od.retrieveOffersById(offerid);
	}
	
	public boolean rejectPendingOffers(int itemId) throws IOException {
		return od.rejectPendingOffer(itemId);
	}
}
