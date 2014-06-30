/**
 * 
 */
package com.aoeng.dp.cat1.ch1.t3;

/**
 * @author [ShaoCheng Zhang] Oct 17, 2013:9:42:45 AM
 * @Email [zhangshch2008@gmail.com]
 */
public class Rocket extends Firework {
	private double apogee;
	private double thrust;

	/**
	 * 
	 */
	public Rocket() {
		super();
	}

	/**
	 * @param apogee
	 * @param thrust
	 */
	public Rocket(double apogee, double thrust) {
		super();
		this.apogee = apogee;
		this.thrust = thrust;
	}

	/**
	 * @param string
	 * @param d
	 * @param dollars
	 * @param i
	 * @param j
	 * @param e
	 */
	public Rocket(String name, double mass, Dollars price, double apogee, double thrust) {
		// TODO Auto-generated constructor stub
		super(name, mass, price);
		setApogee(apogee);
		setThrust(thrust);
	}

	/**
	 * @return the apogee
	 */
	public double getApogee() {
		return apogee;
	}

	/**
	 * @param apogee
	 *            the apogee to set
	 */
	public void setApogee(double apogee) {
		this.apogee = apogee;
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

}
