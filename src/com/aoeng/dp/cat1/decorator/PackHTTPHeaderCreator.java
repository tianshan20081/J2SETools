/**
 * 
 */
package com.aoeng.dp.cat1.decorator;

/**
 * Jun 23, 2014 11:43:20 AM
 * 
 */
public class PackHTTPHeaderCreator extends PacketCreator {

	/**
	 * @param creator
	 */
	public PackHTTPHeaderCreator(IPacketCreator creator) {
		super(creator);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.decorator.IPacketCreator#handleContent()
	 */
	@Override
	public String handleContent() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("Cache-Control:no-cache\n");
		buffer.append("Date:Mon ,23Jun201411:45:20GTM\n");
		buffer.append(creator.handleContent());
		return buffer.toString();
	}

}
