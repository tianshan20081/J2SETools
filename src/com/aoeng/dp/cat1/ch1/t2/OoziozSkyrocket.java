/**
 * 
 */
package com.aoeng.dp.cat1.ch1.t2;

import com.aoeng.dp.cat1.ch1.t1.PhysicalRocket;

/**
 * @author [ShaoCheng Zhang] Oct 16, 2013:4:55:33 PM
 * @Email [zhangshch2008@gmail.com]
 */
public class OoziozSkyrocket extends Skyrocket {
	private PhysicalRocket rocket;

	/**
	 * @param rocket
	 */
	public OoziozSkyrocket(PhysicalRocket rocket) {
		super(rocket.getMass(0), rocket.getThrust(0), rocket.getBurnTime());
		this.rocket = rocket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.ch1.t2.Skyrocket#getMass()
	 */
	@Override
	public double getMass() {
		// TODO Auto-generated method stub
		return rocket.getMass(simTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.ch1.t2.Skyrocket#getThrust()
	 */
	@Override
	public double getThrust() {
		// TODO Auto-generated method stub
		return rocket.getThrust(simTime);
	}

}
