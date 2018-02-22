package eg.edu.alexu.csd.oop.jdbc.cs25;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import eg.edu.alexu.csd.oop.jdbc.cs25.Driver.DBDriver;
public class JDBCExample {

	public static void main(String[] args) {

//		 Contains Database name.
//		final String url = "jdbc:mySubprotocol:myDataSource";
//		Connection con;
		Statement stmt;

		try
		{
			final DBDriver driver = new DBDriver();
			final Properties info = new Properties();
			final File dbDir = new File("jdbj");
			System.out.println(dbDir.getAbsoluteFile());
			info.put("path", dbDir.getAbsoluteFile());
			final Connection connection = driver.connect("jdbc:xmldb://localhost", info);
//		con = DriverManager.getConnection(url, "myLogin", "myPassword");
		stmt = connection.createStatement();
		stmt.execute("Create TABLE table_name1(CustomerName varchar, ContactName varchar, Address varchar, City varchar, PostalCode int, Country varchar)"); // Execute SQL queries.
		System.out.println();
		stmt.executeUpdate("INSERT INTO table_name1 (CustomerName, ContactName, Address, City, PostalCode, Country)VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway')");
		stmt.close();
		connection.close();
		} catch (final SQLException ex)
		{
		System.err.println("SQLException: " + ex.getMessage());
		}
		/*Driver driver = new MyDriver();
		Properties info = new Properties();
		File dbDir = new File(your database folder location);
		info.put("path", dbDir.getAbsoluteFile());
		Connection connection = driver.connect("jdbc:xmldb://localhost", info);*/

	}

}
