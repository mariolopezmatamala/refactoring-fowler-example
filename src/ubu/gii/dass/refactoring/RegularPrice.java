package ubu.gii.dass.refactoring;

public class RegularPrice extends Price{
	@Override
	protected int getPriceCode() {
		return Movie.REGULAR;
	}

	protected double getCharge(int daysRented) {
		double result = 2;
		if (daysRented > 2)
			result += (daysRented - 2) * 1.5;
		return result;
	}
	
	protected int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
