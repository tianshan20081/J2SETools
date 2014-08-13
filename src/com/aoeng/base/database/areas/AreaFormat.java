/**
 * 
 */
package com.aoeng.base.database.areas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.Test;

/**
 * May 26, 2014 6:28:41 PM
 * 
 */
public class AreaFormat {
	public static void main(String[] args) throws Exception {
		String path = "src/com/aoeng/areas/area.txt";
		String dir = "src/com/aoeng/areas/area.sql";
		BufferedReader reader = new BufferedReader(new FileReader(
				new File(path)));
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(new File(dir)));
		String ar = "";
		while ((ar = reader.readLine()) != null) {
			String[] ars = ar.split(",");
			String str = "db.execSQL(\"INSERT INTO `petoken_areas` VALUES ("
					+ ars[0] + ",'" + ars[1] + "', " + ars[2] + ", " + ars[3]
					+ ", " + ars[4] + ", " + ars[5] + ")\");";
			System.out.println(str);
			writer.write(str);
			writer.write("\n");
			// System.out.println();
		}
		reader.close();
		writer.close();
	}

	@Test
	public void testDir() {
		File file = new File("res" + File.separator + "area1.txt");
		if (file.exists()) {
			System.out.println(file.getName());
		}
	}

}
