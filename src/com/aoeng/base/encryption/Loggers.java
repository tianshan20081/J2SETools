package com.aoeng.base.encryption;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * 日志
 * 
 * @author liu
 * 
 */
public final class Loggers {
	private static FileHandler handler;
	static Logger logger = Logger.getLogger("LoggingException ");
	static {

		try {
			handler = new FileHandler("LoggingException.log ", true);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handler.setFormatter(new SimpleFormatter());
		logger.addHandler(handler);

	}

	public static void log(String msg) throws Exception, Exception {

		logger.log(Level.INFO, msg);
		logger.log(Level.WARNING, "Warning, Warning! ");
		handler.close();
	}

	/**
	 * @param string
	 */
	public static void i(String msg) {
		// TODO Auto-generated method stub
		logger.log(Level.INFO, msg);
		handler.close();
	}

	/**
	 * @param string
	 */
	public static void w(String msg) {
		// TODO Auto-generated method stub
		logger.log(Level.WARNING, msg);
		handler.close();
	}
}
