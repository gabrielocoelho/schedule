package br.com.bitlab.factories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectFactoryJDBC {
	
	
	public static Connection connection() throws  SQLException, IOException {

		InputStream is =  ConnectFactoryJDBC.class.getClassLoader().getResourceAsStream("application.properties");
		if(is == null) {
			throw new FileNotFoundException("O arquivo de configuração do banco de dados não foi encontrado");
		}
		
       Properties properties = new Properties();
       properties.load(is);
       String url = properties.getProperty("url");
       String user = properties.getProperty("user");
       String password = properties.getProperty("password");
   
       DriverManager.registerDriver(new com.mysql.jdbc.Driver());
     
       Connection con =  DriverManager.getConnection(url , user,  password);
		
		
		return con;
		
		
	}
}
