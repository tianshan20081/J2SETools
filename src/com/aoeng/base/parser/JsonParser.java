package com.aoeng.base.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSON;

import org.junit.Test;

import com.google.gson.stream.JsonReader;

public class JsonParser {
	
	@Test
	public void parser(){
		String spec = "";
		try {
			URL url = new URL(spec);
			InputStream is = url.openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
