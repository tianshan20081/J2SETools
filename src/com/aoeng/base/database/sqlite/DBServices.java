/**
 * 
 */
package com.aoeng.base.database.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.sqlite.SQLite;

/**
 * @author Aoeng @email<zhangshch2008@gmail.com>
 * @DateTime Jan 30, 2013 11:47:54 AM
 * @Program Upop
 * @Version 1.0
 */
public class DBServices {
	private static String dataUrl = "jdbc:sqlite://home/paynet/AndroidDev/Address/add.db";

	public static boolean insertMapToVillage(List<City> list) {
		// TODO Auto-generated method stub
		Connection connection = SqliteUtils.getConn(dataUrl);
		PreparedStatement preparedStatement = null;
		if (null == list || list.isEmpty()) {
			System.out.println("条目列表为空");
			return true;
		}
		try {
			preparedStatement = connection.prepareStatement("insert into village(townid,villageid,villagename) values(?,?,?)");
			for (City entry : list) {
				preparedStatement.setString(1, entry.getPid());
				preparedStatement.setString(2, entry.getId());
				preparedStatement.setString(3, entry.getName());
				preparedStatement.addBatch();
			}

			preparedStatement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;

	}

	public static boolean createVillageTable(String dataUrl) {
		Connection connection = SqliteUtils.getConn(dataUrl);
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String dropTableString = "drop table if exists village  ";
			statement.execute(dropTableString);
			String createTableString = "create table village(id integer primary key ,townid text,villageid text ,villagename text )";

			boolean resultSet = statement.execute(createTableString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}

	public static boolean insertListToTown(List<City> list) {
		// TODO Auto-generated method stub
		Connection connection = SqliteUtils.getConn(dataUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into town(areaid,townid,townname) values(?,?,?)");
			int i = 0;
			for (City city : list) {
				preparedStatement.setString(1, city.getPid());
				preparedStatement.setString(2, city.getId());
				preparedStatement.setString(3, city.getName());
				// System.out.println(entry.getValue().toString());
				preparedStatement.addBatch();
				if ("610326000000".equals(city.getHref())) {
					System.out.println(city.toString());
				}
				i++;
				if (i % 1000 == 0) {
					// System.out.println("已经添加" + i + "条数据");
				}
			}

			preparedStatement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;

	}

	public static boolean createTownTable(String dataUrl) {
		Connection connection = SqliteUtils.getConn(dataUrl);
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String dropTableString = "drop table if exists town  ";
			statement.execute(dropTableString);
			String createTableString = "create table town(id integer primary key ,areaid text,townid text ,townname text )";

			boolean resultSet = statement.execute(createTableString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}

	public static boolean insertMapToArea(List<City> list) {
		// TODO Auto-generated method stub
		Connection connection = SqliteUtils.getConn(dataUrl);
		PreparedStatement preparedStatement = null;
		System.out.println("list.size()" + list.size());
		try {
			preparedStatement = connection.prepareStatement("insert into area(cityid,areaid,areaname) values(?,?,?)");
			for (City entry : list) {
				preparedStatement.setString(1, entry.getPid());
				preparedStatement.setString(2, entry.getId());
				preparedStatement.setString(3, entry.getName());
				preparedStatement.addBatch();
			}

			preparedStatement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;

	}

	public static boolean createAreaTable(String dataUrl) {
		Connection connection = SqliteUtils.getConn(dataUrl);
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String dropTableString = "drop table if exists area  ";
			statement.execute(dropTableString);
			String createTableString = "create table area(id integer primary key ,cityid text,areaid text ,areaname text )";

			boolean resultSet = statement.execute(createTableString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}

	public static boolean insertMapToCity(List<City> list) {
		// TODO Auto-generated method stub
		Connection connection = SqliteUtils.getConn(dataUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into city(proid,cityid,cityname) values(?,?,?)");
			for (City entry : list) {
				preparedStatement.setString(1, entry.getPid());
				preparedStatement.setString(2, entry.getId());
				preparedStatement.setString(3, entry.getName());
				preparedStatement.addBatch();
			}

			preparedStatement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;

	}

	public static boolean createCityTable(String dataUrl) {
		Connection connection = SqliteUtils.getConn(dataUrl);
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String dropTableString = "drop table if exists city  ";
			statement.execute(dropTableString);
			String createTableString = "create table city(id integer primary key ,proid text,cityid text ,cityname text )";

			boolean resultSet = statement.execute(createTableString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				return false;
			}
		}

		return true;
	}

	public static boolean createProTable(String dataUrl) {
		Connection connection = SqliteUtils.getConn(dataUrl);
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String dropTableString = "drop table if exists province  ";
			statement.execute(dropTableString);
			String createTableString = "create table province(id integer primary key ,proid text  ,proname text )";

			boolean resultSet = statement.execute(createTableString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				return false;
			}
		}
		// String dropTableString = "drop table if exists country_cn  ";
		// String dropTableString = "drop table if exists country_en  ";

		return true;
	}

	/**
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static boolean insertMapToProvince(String dataUrl, List<City> list) {
		// TODO Auto-generated method stub
		Connection connection = SqliteUtils.getConn(dataUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into province(proid,proname) values(?,?)");
			for (City entry : list) {
				preparedStatement.setString(1, entry.getId());
				preparedStatement.setString(2, entry.getName());
				preparedStatement.addBatch();
			}

			preparedStatement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;

	}

}
