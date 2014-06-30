/**
 * 
 */
package com.aoeng.dp.cat1.ch1.t1;

/**
 * @author [ShaoCheng Zhang] Oct 16, 2013:2:53:44 PM
 * @Email [zhangshch2008@gmail.com]
 */
public class PhysicalRocket {

	private double burnArea;
	private double burnRate;
	private double fuelMass;
	private double totalMass;

	/**
	 * @param burnArea
	 * @param burnRate
	 * @param fuelMass
	 * @param totalMass
	 */
	public PhysicalRocket(double burnArea, double burnRate, double fuelMass, double totalMass) {
		super();
		this.burnArea = burnArea;
		this.burnRate = burnRate;
		this.fuelMass = fuelMass;
		this.totalMass = totalMass;
	}

	public double getMass(double time) {
		return 0;
	}

	public double getBurnTime() {
		return 0;
	}

	public double getThrust(double time) {
		return 0;
	}

	/**
	 * @return the burnArea
	 */
	public double getBurnArea() {
		return burnArea;
	}

	/**
	 * @param burnArea
	 *            the burnArea to set
	 */
	public void setBurnArea(double burnArea) {
		this.burnArea = burnArea;
	}

	/**
	 * @return the burnRate
	 */
	public double getBurnRate() {
		return burnRate;
	}

	/**
	 * @param burnRate
	 *            the burnRate to set
	 */
	public void setBurnRate(double burnRate) {
		this.burnRate = burnRate;
	}

	/**
	 * @return the fuelMass
	 */
	public double getFuelMass() {
		return fuelMass;
	}

	/**
	 * @param fuelMass
	 *            the fuelMass to set
	 */
	public void setFuelMass(double fuelMass) {
		this.fuelMass = fuelMass;
	}

	/**
	 * @return the totalMass
	 */
	public double getTotalMass() {
		return totalMass;
	}

	/**
	 * @param totalMass
	 *            the totalMass to set
	 */
	public void setTotalMass(double totalMass) {
		this.totalMass = totalMass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhysicalRocket [burnArea=" + burnArea + ", burnRate=" + burnRate + ", fuelMass=" + fuelMass + ", totalMass=" + totalMass + "]";
	}

}
