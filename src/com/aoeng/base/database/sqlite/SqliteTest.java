package com.aoeng.base.database.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.CORBA.INTERNAL;

/**
 * @author zhangshaocheng <sczhang0131@163.com>
 * 
 * @Nov 7, 2012 9:56:23 AM
 */
public class SqliteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println("javaLibrary到底是什么?" + System.getProperties().get("java.library.path").toString());

		// createTable();
		// insertCountryEn();
		// insertCountryCN();
		// insertProvinceCN();
		// createNewCountryTable();
		// createNewProvinceTable();
		// insertNewCountry();
//		insertNewProvince();
	}

	/**
	 * 
	 */
	// private static void insertNewProvince() {
	// // TODO Auto-generated method stub
	// try {
	// Class.forName("org.sqlite.JDBC");
	// Connection connection =
	// DriverManager.getConnection("jdbc:sqlite://home/paynet/address.db");
	// PreparedStatement preparedStatement =
	// connection.prepareStatement("insert into province(countryId,provinceShout,provinceNameCN) values(?,?,?)");
	// Map<String, String> countryEnMap = AddressUtilsCN.getCanadaProvince();
	// // Map<String, String> countryEnMap =
	// // AddressUtilsCN.getCanadaProvince();
	// Iterator iterator = countryEnMap.entrySet().iterator();
	// while (iterator.hasNext()) {
	// Map.Entry<String, String> entry = (Entry<String, String>)
	// iterator.next();
	// // preparedStatement.setString(1, "840");
	// preparedStatement.setString(1, "124");
	// preparedStatement.setString(2, entry.getKey());
	// preparedStatement.setString(3, entry.getValue());
	// preparedStatement.addBatch();
	// }
	//
	// preparedStatement.executeBatch();
	//
	// preparedStatement.close();
	// connection.close();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	/**
	 * 
	 */
	private static void createNewProvinceTable() {
		// TODO Auto-generated method stub
		String fileName = "//home/paynet/address.db";
		try {
			Class.forName(org.sqlite.JDBC.class.getName());
			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
			Statement statement = connection.createStatement();
			// String dropTableString = "drop table if exists country_cn  ";
			// String dropTableString = "drop table if exists country_en  ";
			String dropTableString = "drop table if exists province  ";
			statement.execute(dropTableString);
			String createTableString = "create table province(id integer primary key ,countryId text  ,provinceShout text,provinceNameEN text ,provinceNameCN text )";

			boolean resultSet = statement.execute(createTableString);

			System.out.println("resultSet" + resultSet);
			statement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
//	private static void insertNewCountry() {
//		// TODO Auto-generated method stub
//		int i = 0;
//		try {
//			Class.forName("org.sqlite.JDBC");
//			Connection connection = DriverManager.getConnection("jdbc:sqlite://home/paynet/address.db");
//			PreparedStatement preparedStatement = connection.prepareStatement("insert into country(countryId,countryNameEN,countryNameCN) values(?,?,?)");
//			Map<String, String> countryCnMap = AddressUtilsCN.getCountryMap();
//			Map<String, String> countryEnMap = AddressUtilsEN.getCountryMap();
//			Iterator iterator = countryEnMap.entrySet().iterator();
//
//			while (iterator.hasNext()) {
//				Map.Entry<String, String> entry = (Entry<String, String>) iterator.next();
//				String cn = countryCnMap.get(entry.getKey());
//				if (null == cn) {
//					cn = " ";
//					i++;
//				}
//
//				preparedStatement.setString(1, entry.getKey());
//				preparedStatement.setString(2, entry.getValue());
//				preparedStatement.setString(3, cn);
//				preparedStatement.addBatch();
//			}
//
//			preparedStatement.executeBatch();
//
//			preparedStatement.close();
//			connection.close();
//			System.out.println("i" + i);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/**
	 * 
	 */
//	private static void createNewCountryTable() {
//		// TODO Auto-generated method stub
//		String fileName = "//home/paynet/address.db";
//		try {
//			Class.forName(org.sqlite.JDBC.class.getName());
//			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
//			Statement statement = connection.createStatement();
//			// String dropTableString = "drop table if exists country_cn  ";
//			// String dropTableString = "drop table if exists country_en  ";
//			String dropTableString = "drop table if exists country  ";
//			statement.execute(dropTableString);
//			// String createTableString =
//			// "create table country_en(id integer primary key ,countryId text not null ,countryName text not null )";
//			String createTableString = "create table country(id integer primary key ,countryId text not null ,countryNameEN text not null,countryNameCN text not null )";
//			// String createTableString =
//			// "create table province_cn(id integer primary key ,countryId text not null ,provinceShout text,provinceName text not null )";
//
//			boolean resultSet = statement.execute(createTableString);
//
//			System.out.println("resultSet" + resultSet);
//			statement.close();
//			connection.close();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/**
	 * 
	 */
//	private static void insertProvinceCN() {
//		// TODO Auto-generated method stub
//		try {
//			Class.forName("org.sqlite.JDBC");
//			Connection connection = DriverManager.getConnection("jdbc:sqlite://home/paynet/Address.db");
//			PreparedStatement preparedStatement = connection.prepareStatement("insert into province_cn(countryId,provinceShout,provinceName) values(?,?,?)");
//			Map<String, String> countryEnMap = AddressUtilsCN.getAmericaProvinceMap();
//			Iterator iterator = countryEnMap.entrySet().iterator();
//			while (iterator.hasNext()) {
//				Map.Entry<String, String> entry = (Entry<String, String>) iterator.next();
//				preparedStatement.setString(1, "840");
//				preparedStatement.setString(2, entry.getKey());
//				preparedStatement.setString(3, entry.getValue());
//				preparedStatement.addBatch();
//			}
//
//			preparedStatement.executeBatch();
//
//			preparedStatement.close();
//			connection.close();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 
//	 */
//	private static void insertCountryCN() {
//		// TODO Auto-generated method stub
//		try {
//			Class.forName("org.sqlite.JDBC");
//			Connection connection = DriverManager.getConnection("jdbc:sqlite://home/paynet/Address.db");
//			PreparedStatement preparedStatement = connection.prepareStatement("insert into country_cn(countryId,countryName) values(?,?)");
//			Map<String, String> countryEnMap = AddressUtilsCN.getCountryMap();
//			Iterator iterator = countryEnMap.entrySet().iterator();
//			while (iterator.hasNext()) {
//				Map.Entry<String, String> entry = (Entry<String, String>) iterator.next();
//				preparedStatement.setString(1, entry.getKey());
//				preparedStatement.setString(2, entry.getValue());
//				preparedStatement.addBatch();
//			}
//
//			preparedStatement.executeBatch();
//
//			preparedStatement.close();
//			connection.close();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 
//	 */
//	private static void insertCountryEn() {
//		// TODO Auto-generated method stub
//		try {
//			Class.forName("org.sqlite.JDBC");
//			Connection connection = DriverManager.getConnection("jdbc:sqlite://home/paynet/Address.db");
//			PreparedStatement preparedStatement = connection.prepareStatement("insert into country_en(countryId,countryName) values(?,?)");
//			Map<String, String> countryEnMap = AddressUtilsEN.getCountryMap();
//			Iterator iterator = countryEnMap.entrySet().iterator();
//			while (iterator.hasNext()) {
//				Map.Entry<String, String> entry = (Entry<String, String>) iterator.next();
//				preparedStatement.setString(1, entry.getKey());
//				preparedStatement.setString(2, entry.getValue());
//				preparedStatement.addBatch();
//			}
//
//			preparedStatement.executeBatch();
//
//			preparedStatement.close();
//			connection.close();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * 
//	 */
//	private static void createTable() {
//		// TODO Auto-generated method stub
//		String fileName = "//home/paynet/Address.db";
//		try {
//			Class.forName(org.sqlite.JDBC.class.getName());
//			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
//			Statement statement = connection.createStatement();
//			// String dropTableString = "drop table if exists country_cn  ";
//			// String dropTableString = "drop table if exists country_en  ";
//			String dropTableString = "drop table if exists province_cn  ";
//			statement.execute(dropTableString);
//			// String createTableString =
//			// "create table country_en(id integer primary key ,countryId text not null ,countryName text not null )";
//			String createTableString = "create table province_cn(id integer primary key ,countryId text not null ,provinceShout text,provinceName text not null )";
//
//			boolean resultSet = statement.execute(createTableString);
//
//			System.out.println("resultSet" + resultSet);
//			statement.close();
//			connection.close();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
