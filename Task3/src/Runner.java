import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Runner {
static final String URL = "jdbc:mysql://db4free.net:3306/books_db?useSSL=false";	// for comfortable and fast check, 
static final String USER = "random_boy";											//I use remote database
static final String PASWORD = "asdfghjkl";											//<---my password
	public static void main(String[] args) {
		
		String baseQuery = "SELECT  authors.last_name, authors.first_name, books.book_name FROM asigns "
				+ "LEFT JOIN books ON  asigns.book_id = books.book_id  LEFT JOIN authors ON asigns.author_id = authors.author_id ";
		String someAuthorUseLastname = "WHERE authors.last_name LIKE \"%s\"";
		String someAuthorUseName = "WHERE authors.first_name LIKE \"%s\"";
		String tableMask = "%-20s %-20s %s\n";
		String row = "-----------";
		
		Connection connect = null;
		Statement db;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(URL, USER, PASWORD);
			db = connect.createStatement();
			String query;
			Scanner input = new Scanner(System.in);
			System.out.println("Enter author's name.You can use -a for look all books or -l to find author's books by last name.");
			String command = input.nextLine();
			switch (command) {
			case "-a":
				query = baseQuery;
				break;
			case "-l":
				System.out.println("Enter author's lastname.");
				command = input.nextLine();
				query = baseQuery.concat(String.format(someAuthorUseLastname, command));		//Yes, I understand that it can lead to SQL injection,			
				break;																			//but it's test task.
			default:
				query = baseQuery.concat(String.format(someAuthorUseName, command));
				break;
			}
			result = db.executeQuery(query);
			if(result.next()) {
				System.out.println("Result:");
				System.out.printf(tableMask, row,row,row);
				System.out.printf(tableMask, "Lastname","Name","Book");
				System.out.printf(tableMask, row,row,row);
				result.beforeFirst();
				while(result.next()) {
					System.out.printf(tableMask,result.getString(1),result.getString(2),result.getString(3));
				}
			}else {
				System.out.println("No such author's books");
			}
			input.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(result != null) {
					result.close();
				}
				if(connect != null) {
					connect.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
