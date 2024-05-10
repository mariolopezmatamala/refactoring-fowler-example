package ubu.gii.dass.refactoring;

public class ChildrensPrice extends Price{
	@Override
	protected int getPriceCode() {
		return Movie.CHILDRENS;
	}

	protected double getCharge(int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;

	}
}
