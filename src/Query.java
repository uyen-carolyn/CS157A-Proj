package project;

import java.sql.*;

public class Query {

// JDBC driver name and database URL
static final String DB_URL = "jdbc:mysql://localhost:3306/fletnix?serverTimezone=UTC";
static final String USER = "root";
static final String PASS = "##########";
	
// Print Method
public static void sop(String s) {
		System.out.println(s);
}

// ---------------------------------------------

// Basic Query
public static void query(int query, String desc, String limit) {

	Connection conn = null;
	Statement stmt = null;
	
	try {
		// Open a connection, create a statement
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
			
		// Execute Query
		sop(desc);
		choice(query, stmt, limit);
	}
		
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName
		
	// Close Resources 
	finally {
		// Close Statement
		try{ if (stmt != null) stmt.close(); } 
		catch (SQLException se2) {} 				// Nothing
		
		// Close Connection
		try{ if (conn != null) conn.close(); } 
		catch (SQLException se){ se.printStackTrace(); } 	//Handles errors for JDBC
	}	
	
}

// Choosing which query to execute
public static void choice(int query, Statement stmt, String limit) {
	
	switch(query) {
		case 1:  one(stmt, limit);
		case 2:  two(stmt, limit);
		case 3:	 three(stmt, limit);
		case 4:  four(stmt, limit);
		case 5:  five(stmt, limit);
		case 6:  six(stmt, limit);
		case 7:  seven(stmt, limit);
		case 8:	 eight(stmt, limit);
		case 9:  nine(stmt, limit);
		case 10: ten(stmt, limit);
		case 11: eleven(stmt, limit);
		case 12: twelve(stmt, limit);
		case 13: thirteen(stmt, limit);
		case 14: fourteen(stmt, limit);
		case 15: fifteen(stmt, limit);
	
	}
}

// Query 1
public static void one(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT uName, primaryTitle, rating, ratingDate " + 
				"FROM Ratings R, Users U, Favorites F " + 
				"WHERE R.uID=U.uID AND T.tconst=R.tconst " + 
				"ORDER BY U.uID, primaryTitle; " + 
				""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Username: " + rs.getString("uName") + 
					", Primary Title: " + rs.getInt("primaryTitle") + 
					", Rating: " + rs.getInt("rating") + 
					", Rating Date: " + rs.getInt("ratingDate"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Query 2 
public static void two(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT N.primaryName " + 
				"FROM Name N NATURAL JOIN Principals P NATURAL JOIN Titles T " + 
				"GROUP BY primaryName " + 
				"HAVING Count(T.tconst) > 10; " + 
				""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Primary Name: " + rs.getString("primaryName"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}


// Query 3
public static void three(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT primaryTitle, startYear, endYear, rating "
				+ "FROM Titles, Ratings "
				+ "WHERE Titles.tconst = Ratings.tconst "
				+ "ORDER BY rating DESC "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Title: " + rs.getString("primaryTitle") + 
				", Start Year: " + rs.getInt("startYear") + 
				", End Year: " + rs.getInt("endYear") + 
				", Rating: " + rs.getInt("rating"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}


//Query 4 
public static void four(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT genre, COUNT(uID) " + 
				"FROM Titles T NATURAL JOIN Favorites F " + 
				"GROUP BY tconst " + 
				"ORDER BY COUNT(*); " + 
				""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Genre: " + rs.getString("uName") + 
					", Number of uID: " + rs.getInt("COUNT(uID)"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}


// Query 5
public static void five(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT primaryTitle, startYear, AVG(age) "
				+ "FROM Users U, Titles T, Favorites F "
				+ "WHERE titleType='movie' AND U.uID=F.uID AND T.tconst=F.tconst "
				+ "GROUP BY T.tconst "
				+ limit + ";");
			
		// Process the results
		while(rs.next()){
			sop("Title: " + rs.getString("primaryTitle") + 
					", Year: " + rs.getInt("startYear") + 
					", Average Age: " + rs.getInt("AVG(age)"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Query 6 
public static void six(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT primaryTitle as title, MAX(rating) - MIN(rating) as rating_spread " + 
				"FROM Ratings NATURAL JOIN Titles " + 
				"GROUP BY primaryString " + 
				"ORDER BY rating_spread DESC, title; " + 
				""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Title: " + rs.getString("primaryTitle") + 
					", Rating Spread: " + rs.getInt("MAX(rating) - MIN(rating)"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}


// Query 7
public static void seven(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		
		rs = stmt.executeQuery("SELECT Ratings.uID, uName, COUNT(Ratings.uID) AS numRatings "
				+ "FROM Users, Ratings "
				+ "WHERE Users.uID = Ratings.uID  "
				+ "GROUP BY uName HAVING COUNT(Ratings.uID) >= 3;");
	
		
		while(rs.next()){
			sop("User ID: " + rs.getString("Ratings.uID") + 
				", Name: " + rs.getString("uName") + 
				", Number of Ratings Made: " + rs.getInt("numRatings"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}


//Query 8 (INCOMPLETE)
public static void eight(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery(""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("");
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Query 9 (INCOMPLETE)
public static void nine(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery(""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("");
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Query 10 (INCOMPLETE)
public static void ten(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery(""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("");
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Query 11 (INCOMPLETE)
public static void eleven(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery(""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("");
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Query 12 (INCOMPLETE)
public static void twelve(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery(""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("");
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Query 13 (INCOMPLETE)
public static void thirteen(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery(""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("");
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Query 14 (INCOMPLETE)
public static void fourteen(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery(""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("");
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Query 15 (INCOMPLETE)
public static void fifteen(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery(""
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("");
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}


	
} // End of class
