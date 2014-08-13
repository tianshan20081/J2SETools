/**
 * 
 */
package com.aoeng.base.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

/**
 * @author Aoeng @email<zhangshch2008@gmail.com>
 * @DateTime Feb 4, 2013 5:15:28 PM
 * @Program Upop
 * @Version 1.0
 */
public class SendMail {

	public static void main(String[] args) throws Exception {

		test01();
		// text02();
	}

	/**
	 * @throws Exception
	 * 
	 */
	@Test
	private static void text02() throws Exception {
		// TODO Auto-generated method stub
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.126.com");
		email.setAuthentication("zhangshch0131@126.com", "0000!@#$%^");
		email.addTo("zhangshch2008@qq.com");
		email.setSubject("hello this email is from java Client !");
		email.setMsg("hello this is email's Body !");
		System.out.println("Sending ....");
		email.send();
		System.out.println("Sending OK !");
	}

	/**
	 * @throws Exception
	 * 
	 */
	private static void test01() throws Exception {
		// TODO Auto-generated method stub
		Email email = new SimpleEmail();
		email.setHostName("smtp.126.com");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.setAuthentication("zhangshch0131@126.com", "20070507206");
		email.setFrom("user@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("foo@bar.com");
		email.send();
	}
}
