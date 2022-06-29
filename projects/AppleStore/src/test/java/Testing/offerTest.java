package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Services.OfferService;

class offerTest {
	public static OfferService o = new OfferService();
	@Test
	void getOfferByIdTest() throws SQLException, IOException {
		assertNull(o.retrieveOfferById(0));
	}
	@Test
	void getOfferTest() throws SQLException, IOException {
		assertNotNull(o.getOffers());
	}
}
