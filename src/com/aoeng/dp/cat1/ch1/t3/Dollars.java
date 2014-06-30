/**
 * 
 */
package com.aoeng.dp.cat1.ch1.t3;

/**
 * Oct 17, 2013:9:54:56 AM
 */
public class Dollars {
	public static final Dollars cent = new Dollars(0.01);
	static final int CENTS_PER_DOLLAR = 100;
	long cents;

	/**
	 * @param d
	 */
	public Dollars(double value) {
		// TODO Auto-generated constructor stub
		this.cents = Math.round(value * CENTS_PER_DOLLAR);
	}

	public boolean isZero() {
		return cents == 0;
	}

	public Dollars plus(Dollars that) {
		return new Dollars(1.0 * (this.cents + that.cents) / CENTS_PER_DOLLAR);
	}

	public Dollars times(int multiplier) {
		return new Dollars((this.cents * multiplier) / CENTS_PER_DOLLAR);
	}

	public Dollars dividedBy(int divisor) {
		double newCents = (1.0 * cents / divisor) / CENTS_PER_DOLLAR;
		return new Dollars(newCents);
	}

	public boolean isLessThan(Dollars that) {
		return this.cents < that.cents;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer("$");
		long dollars = cents / CENTS_PER_DOLLAR;
		result.append(dollars).append(".");
		long pennies = cents % CENTS_PER_DOLLAR;
		if (pennies < 10)
			result.append('0');
		result.append(pennies);
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!obj.getClass().equals(this.getClass()))
			return false;
		Dollars that = (Dollars) obj;
		return this.cents == that.cents;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int) cents;
	}

	public long asCents() {
		return cents;
	}
}
