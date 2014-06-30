/**
 * 
 */
package com.aoeng.dp.cat1.ch1.t1;

/**
 * @author [ShaoCheng Zhang] Oct 16, 2013:2:58:47 PM
 * @Email [zhangshch2008@gmail.com]
 */
public class OozinozRocket extends PhysicalRocket implements RocketSim {

	private double time;

	/**
	 * @param burnArea
	 * @param burnRate
	 * @param fuelMass
	 * @param totalMass
	 */
	public OozinozRocket(double burnArea, double burnRate, double fuelMass, double totalMass) {
		super(burnArea, burnRate, fuelMass, totalMass);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.ch1.RocketSim#getMass()
	 */
	@Override
	public double getMass() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.ch1.RocketSim#getThrust()
	 */
	@Override
	public double getThrust() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.ch1.RocketSim#setSimTime(double)
	 */
	@Override
	public void setSimTime(double time) {
		// TODO Auto-generated method stub
		this.time = time;
	}

}
