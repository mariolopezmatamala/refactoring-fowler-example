package ubu.gii.dass.refactoring;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1

 * 
 */
public class VideoClubTest {
	protected Movie m0, m11, m12, m2;
	protected Customer c1;
	private static final String ANY_TITLE = "Any Movie Title";

	@Before
	public void setUp() {
		m11 = new Movie("Sky Captain", 1);
		m12 = new Movie("Alejandro Magno", 1);
		m0 = new Movie("Accion Mutante", 0);
		m2 = new Movie("Hermano Oso", 2);
		c1 = new Customer("Manuel");
	}
	@After
	public void tearDown() throws Exception {}
	@Test
	public void testAlquiler() {
		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);
		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);
		String salida = c1.statement();
		String salidaEsperada = new String("Rental Record for Manuel\n"
				+ "\tSky Captain\t15.0\n" + "\tAccion Mutante\t2.0\n"
				+ "\tHermano Oso\t12.0\n" + "Amount owed is 29.0\n"
				+ "You earned 4 frequent renter points");
		assertTrue("Calcula mal el alquiler", salidaEsperada.equals(salida));

	}

	@Test
	public void testMovieRegular() {
		Movie aMovie = new Movie(ANY_TITLE,Movie.REGULAR);
		assertEquals(Movie.REGULAR, aMovie.getPriceCode());
	}

	@Test
	public void testMovieChildren() {
		Movie aMovie = new Movie(ANY_TITLE,Movie.CHILDRENS);
		assertEquals(Movie.CHILDRENS, aMovie.getPriceCode());
	}

	@Test
	public void testMovieNewRelease() {
		Movie aMovie = new Movie(ANY_TITLE,Movie.NEW_RELEASE);
		assertEquals(Movie.NEW_RELEASE, aMovie.getPriceCode());
	}

	@Test
	public void testFrequentRenterPointsRegular() {
		int points[] = { 1, 1, 1 };
		Movie aMovie = new Movie(ANY_TITLE,Movie.REGULAR);
		for (int daysRented = 1; daysRented <= points.length; daysRented++) {
			assertEquals(points[daysRented-1], aMovie.getFrequentRenterPoints(daysRented));
		}
	}

	@Test
	public void testFrequentRenterPointsChildrens() {
		int points[] = { 1, 1, 1 };
		Movie aMovie = new Movie(ANY_TITLE,Movie.CHILDRENS);
		for (int daysRented = 1; daysRented <= points.length; daysRented++) {
			assertEquals(points[daysRented-1], aMovie.getFrequentRenterPoints(daysRented));
		}
	}

	@Test
	public void testFrequentRenterPointsNewRelease() {
	int points[] = { 1, 2, 2, 2 };
		Movie aMovie = new Movie(ANY_TITLE,Movie.NEW_RELEASE);
		for (int daysRented = 1; daysRented <= points.length; daysRented++) {
			assertEquals(points[daysRented-1], aMovie.getFrequentRenterPoints(daysRented));
		}
	}

	@Test
	public void testChargeForRegular() {
	double charges[] = { 2.0, 2.0, 3.5, 5.0, 6.5, 8.0 };
		Movie aMovie = new Movie(ANY_TITLE,Movie.REGULAR);
		for (int daysRented = 1; daysRented <= charges.length; daysRented++) {
			assertEquals(charges[daysRented-1], aMovie.getCharge(daysRented),0);
		}
	}

	@Test
	public void testChargeForChildrens() {
		double charges[] = { 1.5, 1.5, 1.5, 3.0, 4.5, 6.0, 7.5 };
		Movie aMovie = new Movie(ANY_TITLE,Movie.CHILDRENS);
		for (int daysRented = 1; daysRented <= charges.length; daysRented++) {
			assertEquals(charges[daysRented-1], aMovie.getCharge(daysRented),0);
		}
	}

	@Test
	public void testChargeNewRelease() {
		double charges[] = { 3.0, 6.0, 9.0, 12.0 };
		Movie aMovie = new Movie(ANY_TITLE,Movie.NEW_RELEASE);
		for (int daysRented = 1; daysRented <= charges.length; daysRented++) {
			assertEquals(charges[daysRented-1], aMovie.getCharge(daysRented),0);
		}
	}

	@Test
	public void testChildrensPrice() {
		Price aPrice = new ChildrensPrice();
		assertEquals(Movie.CHILDRENS,aPrice.getPriceCode());
	}
}
