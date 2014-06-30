/**
 * 
 */
package com.aoeng.dp.cat1.ch1.t3;

/**
 * Oct 17, 2013:9:52:34 AM
 */
public class Firework {

	private String name;
	private double mass;
	private Dollars price;

	public static Firework lookup(String name) {

		return new Firework(name, 9.0, new Dollars(3));
	}

	/**
	 * 
	 */
	public Firework() {
		super();
	}

	/**
	 * @param name
	 * @param mass
	 * @param price
	 */
	public Firework(String name, double mass, Dollars price) {
		super();
		setName(name);
		setMass(mass);
		setPrice(price);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * @param mass
	 *            the mass to set
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}

	/**
	 * @return the price
	 */
	public Dollars getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Dollars price) {
		this.price = price;
	}

}
