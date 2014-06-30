/**
 * 
 */
package com.aoeng.dp.cat1.decorator;

/**
 * Jun 23, 2014 11:39:58 AM
 * 
 */
public abstract class PacketCreator implements IPacketCreator {
	IPacketCreator creator;

	public PacketCreator(IPacketCreator creator) {
		this.creator = creator;
	}
}
