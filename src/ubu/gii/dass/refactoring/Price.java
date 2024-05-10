package ubu.gii.dass.refactoring;

abstract class Price {
	protected abstract int getPriceCode();
	
	protected abstract double getCharge(int daysRented);
	
	protected abstract int getFrequentRenterPoints(int daysRented);
}
