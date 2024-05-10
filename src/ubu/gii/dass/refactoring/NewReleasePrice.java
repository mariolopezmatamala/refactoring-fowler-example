package ubu.gii.dass.refactoring;

public class NewReleasePrice extends Price{
	@Override
	protected int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	protected double getCharge(int daysRented) {
		return daysRented * 3;
	}
}
