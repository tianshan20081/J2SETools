/**
 * 
 */
package com.aoeng.dp.cat1.ch1.t2;

/**
 * @author [ShaoCheng Zhang] Oct 16, 2013:4:53:54 PM
 * @Email [zhangshch2008@gmail.com]
 */
public class Skyrocket {

	private double mass;
	private double thrust;
	private double burnTime;
	protected double simTime;

	/**
	 * 
	 */
	public Skyrocket() {
		super();
	}

	/**
	 * @param mass
	 * @param thrust
	 * @param burnTime
	 */
	public Skyrocket(double mass, double thrust, double burnTime) {
		super();
		this.mass = mass;
		this.thrust = thrust;
		this.burnTime = burnTime;
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
	 * @return the thrust
	 */
	public double getThrust() {
		return thrust;
	}

	/**
	 * @param thrust
	 *            the thrust to set
	 */
	public void setThrust(double thrust) {
		this.thrust = thrust;
	}

	/**
	 * @return the burnTime
	 */
	public double getBurnTime() {
		return burnTime;
	}

	/**
	 * @param burnTime
	 *            the burnTime to set
	 */
	public void setBurnTime(double burnTime) {
		this.burnTime = burnTime;
	}

}
