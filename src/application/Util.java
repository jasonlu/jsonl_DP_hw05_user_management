package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Util {

	protected static String jdbcPath = "jdbc:sqlite:bigdata.com.sqlite";
	public Util() {
		// TODO Auto-generated constructor stub
	}
	public static ResultSet doQuery(String query) {
		try {	
			Connection conn = DriverManager.getConnection(jdbcPath);
			PreparedStatement stm;
			ResultSet rs;
			stm = conn.prepareStatement(query);
			System.out.println("params processed");
			rs = stm.executeQuery();
			return rs;
		} catch (SQLException e1) {
			System.out.println("SQLException: " + e1 );
			return null;
		}
	}
	public static ResultSet doQuery(String query, HashMap<String, Object> params) {
		System.out.println(query);
		try {	
			Connection conn = DriverManager.getConnection(jdbcPath);
			PreparedStatement stm;
			ResultSet rs;
			System.out.println("params: " + params );
			stm = conn.prepareStatement(query);
			
			
			if(params != null) {
				int i = 0;
				for(Entry<String, Object> entry : params.entrySet()) {
				    String key = entry.getKey().toLowerCase();
				    System.out.println("Entry:" + entry);
				    
				    
				    switch(key) {
				    case "string":
				    	stm.setString(i, (String)entry.getValue());
				    	break;
				    case "int":
				    	stm.setInt(i, (int)entry.getValue());
				    	break;
				    case "float":
				    	stm.setFloat(i, (float)entry.getValue());
				    	break;
				    }
				    i++;
				}
				System.out.println("params processed");
			}			
			rs = stm.executeQuery();
			return rs;
		} catch (SQLException e1) {
			System.out.println("SQLException: " + e1 );
			return null;
		}
	}
	
	public static ResultSet doQuery(String query, ArrayList<Object> params) {
		System.out.println(query);
		try {	
			Connection conn = DriverManager.getConnection(jdbcPath);
			PreparedStatement stm;
			ResultSet rs;
			System.out.println("params: " + params );
			stm = conn.prepareStatement(query);
			
			
			if(params != null) {
				int i = 0;
				for(Object o : params) {
					
					if(o.getClass().equals(Integer.class)) {
						stm.setInt(i, (int)o);
					} else if(o.getClass().equals(Long.class)) {
						stm.setLong(i, (long)o);
					} else if(o.getClass().equals(Float.class)) {
						stm.setFloat(i, (float)o);
					} else if(o.getClass().equals(Double.class)) {
						stm.setDouble(i, (double)o);
					} else {
						stm.setString(i, o.toString());
					}
				    i++;
				}
				System.out.println("params processed, sql:\n\t" + stm);
			}			
			rs = stm.executeQuery();
			return rs;
		} catch (SQLException e1) {
			System.out.println("SQLException: " + e1 );
			return null;
		}
	}

}
