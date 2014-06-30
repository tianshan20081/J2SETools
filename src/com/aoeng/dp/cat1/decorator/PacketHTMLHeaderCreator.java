/**
 * 
 */
package com.aoeng.dp.cat1.decorator;

/**
 * Jun 23, 2014 11:41:19 AM
 * 
 */
public class PacketHTMLHeaderCreator extends PacketCreator {

	/**
	 * @param creator
	 */
	public PacketHTMLHeaderCreator(IPacketCreator creator) {
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
		buffer.append("<html>");
		buffer.append("<body>");
		buffer.append(creator.handleContent());
		buffer.append("</body>");
		buffer.append("</html>");

		return buffer.toString();
	}

}
