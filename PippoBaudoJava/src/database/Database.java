package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database 
{
	private String percorso;
	private String username;
	private String password;
	private Connection c;
		
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public Database(String percorso, String username, String password) 
	{
		setPercorso(percorso);
		setUsername(username);
		setPassword(password);
	}

	public String getPercorso() 
	{
		return percorso;
	}

	public void setPercorso(String nomeDb) 
	{
		//String timeZone = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String connection = "jdbc:mysql://localhost:3306/";
		this.percorso = connection + nomeDb;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public Connection getC() 
	{
		return c;
	}

	public void setC(Connection c) 
	{
		this.c = c;
	}
		
	public void getConnection()
	{
			try
			{
				Class.forName(DRIVER);
				c = DriverManager.getConnection(percorso, username, password);
			}
			catch(Exception e)
			{
				System.out.println("Controlla build path, username e password");
			}
		}
		
		public void closeConnection()
		{
			try
			{
				c.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}	
	}
