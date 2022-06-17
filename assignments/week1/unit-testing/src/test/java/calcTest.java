import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calc.simplecalc;
import calc.exceptions.DivideBy0Exception;
import calc.exceptions.Number13Exception;


public class calcTest {
private static simplecalc sut;
	
	/*
	 * JUnit 5
	 * 	- @BeforeAll
	 *  - @BeforeEach
	 *  - @AfterAll
	 *  - @AfterEach
	 *  
	 *  - @Test
	 *  - @Ignore
	 *  - @Order
	 */
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new simplecalc();
	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("Tear down behavior.");
	}
	
	@BeforeEach
	public void before() {
		System.out.println("@Before each behavior");
	}
	
	@Test
	public void addOneAndTwo() {
		int expected = 3;
		int actual = sut.add(1, 2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldNotBeZero() {
		int expected = 0;
		int actual = sut.div(5, 0);
		assertNotEquals(expected, actual);
	}
	
	
	@Test
	public void addEightAndFive() {
		assertThrows(Number13Exception.class, () -> sut.add(8, 5));
	}
	
	@Test
	public void addZeroAndThirteen() {
		assertThrows(Number13Exception.class, () -> sut.add(0, 13));
	}
	@Test
	public void diviedBy0() {
		assertThrows(DivideBy0Exception.class, () -> sut.div(20, 0));
	}
}
