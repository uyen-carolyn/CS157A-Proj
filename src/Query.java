package project;

import java.sql.*;

public class Query {

// JDBC driver name and database URL
static final String DB_URL = "jdbc:mysql://localhost:3306/fletnix?serverTimezone=UTC";
static final String USER = "root";
static final String PASS = "coyote3";
	
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
		case 1:  one(stmt, limit); break;
		case 2:  two(stmt, limit); break;
		case 3:	 three(stmt, limit); break;
		case 4:  four(stmt, limit); break;
		case 5:  five(stmt, limit); break;
		case 6:  six(stmt, limit); break;
		case 7:  seven(stmt, limit); break;
		case 8:	 eight(stmt, limit); break;
		case 9:  nine(stmt, limit); break;
		case 10: ten(stmt, limit); break;
		case 11: eleven(stmt, limit); break;
		case 12: twelve(stmt, limit); break;
		case 13: thirteen(stmt, limit); break;
		case 14: fourteen(stmt, limit); break;
		case 15: fifteen(stmt, limit); break;
		case 16: printUsers(stmt, limit); break;
		case 17: printTitles(stmt, limit); break;
		case 18: printRatings(stmt, limit); break;
		case 19: printEpisodes(stmt, limit); break;
		case 20: printNames(stmt, limit); break;
		case 21: printPrincipals(stmt, limit); break;
		case 22: printFavorites(stmt, limit); break;
		case 23: printArchive(stmt, limit); break;
	}
}

//-------------------------------------------

// Query 1
public static void one(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT uName, primaryTitle, rating, ratingDate " + 
				"FROM Ratings R, Users U, Titles T, Favorites F " + 
				"WHERE R.uID=F.uID AND R.uID=U.uID AND T.tconst=R.tconst AND T.tconst=F.tconst " + 
				"ORDER BY U.uID, primaryTitle " + 
				limit + ";");

		
		// Process the results
		while(rs.next()){
			sop("Username: " + rs.getString("uName") + 
					", Primary Title: " + rs.getString("primaryTitle") + 
					", Rating: " + rs.getInt("rating") + 
					", Rating Date: " + rs.getDate("ratingDate"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

// Query 2 
public static void two(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT N.primaryName " + 
				"FROM Names N NATURAL JOIN Principals P NATURAL JOIN Titles T " +
				"GROUP BY primaryName " + 
				"HAVING Count(T.tconst) > 10 "
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

// Query 4 
public static void four(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT T.genre, COUNT(uID) " + 
				"FROM Titles T NATURAL JOIN Favorites F " + 
				"GROUP BY T.genre " + 
				"ORDER BY COUNT(*) DESC "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Genre: " + rs.getString("genre") + 
					", Number of Favorites: " + rs.getInt("COUNT(uID)"));
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

// Query 6
public static void six(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT primaryTitle as title, MAX(rating) - MIN(rating) as rating_spread " + 
				"FROM Ratings NATURAL JOIN Titles " + 
				"GROUP BY primaryTitle " + 
				"ORDER BY rating_spread DESC, title "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Title: " + rs.getString("title") + 
					", Rating Spread: " + rs.getInt("rating_spread"));
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

// Query 8
public static void eight(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT titleType, COUNT(tconst) " + 
				"FROM Titles NATURAL JOIN Favorites " + 
				"GROUP BY titleType "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Format: " + rs.getString("titleType") + 
					", Number of Titles: " + rs.getString("COUNT(tconst)"));
			}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

// Query 9
public static void nine(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT primaryName, primaryProfession, COUNT(tconst) " + 
				"FROM Names NATURAL JOIN Principals " + 
				"GROUP BY Names.nconst " + 
				"ORDER BY primaryName " 
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Primary Name: " + rs.getString("primaryName") + 
					", Primary Profession: " + rs.getString("primaryProfession") +
					", Number of Title IDs: " + rs.getString("COUNT(tconst)"));
			}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

// Query 10
public static void ten(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT primaryTitle, startYear, MIN(age), MAX(age) " + 
				"FROM Users U, Titles T, Favorites F " + 
				"WHERE titleType='movie' AND U.uID=F.uID AND T.tconst=F.tconst "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("Primary Title: " + rs.getString("primaryTitle") + 
					", Min Age: " + rs.getString("MIN(age)") +
					", Max Age: " + rs.getString("MAX(age)") 
					);
			}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

// Query 11
public static void eleven(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT DISTINCT N.nconst, N.primaryName " + 
				"FROM Ratings R NATURAL JOIN Titles T NATURAL JOIN Principals P NATURAL JOIN Names N " + 
				"WHERE T.titleType = 'movie' AND (N.primaryProfession = 'actor' OR N.primaryProfession = 'actress') " + 
				"GROUP BY N.nconst " + 
				"HAVING AVG(R.rating) >= 4 "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("ID: " + rs.getString("nconst") + 
					", Primary Name: " + rs.getString("primaryName"));
			}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

// Query 12
public static void twelve(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT primaryTitle, seasonNum, episodeNum " +
				"FROM Titles NATURAL JOIN Episodes " +
				"WHERE titleType='tvepisode' " +
				"ORDER BY primaryTitle, seasonNum, episodeNum " +
				limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("primaryTitle: "+ rs.getString("primaryTitle") +
					", seasonNum: " + rs.getInt("seasonNum") +
					", episodeNum: " + rs.getInt("episodeNum"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

// Query 13
public static void thirteen(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT F.uID, F.tconst " +
				"FROM Favorites F LEFT OUTER JOIN Ratings ON (F.uID=Ratings.uID) " +
				"WHERE rating IS NULL " +
				limit + ";");
	
		// Process the results
		while(rs.next()){
			sop("uID: " + rs.getInt("F.uID") +
					", tconst: " + rs.getString("F.tconst"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

// Query 14
public static void fourteen(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT primaryTitle, titleType, genre, startYear " +
				"FROM Users U, Titles " +
				"WHERE tconst IN (SELECT tconst FROM Favorites WHERE uID=U.uID) " +
				limit + ";");

		// Process the results
		while(rs.next()){
			sop("primaryTitle: " + rs.getString("primaryTitle") +
					", titleType: " + rs.getString("titleType") +
					", genre: " + rs.getString("genre") + 
					", startYear: " + rs.getInt("startYear"));
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

// Query 15
public static void fifteen(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT N.nconst, primaryName, COUNT(tconst) " +
				"FROM Names N NATURAL JOIN Principals " +
				"WHERE deathYear IS NOT NULL " +
				"GROUP BY N.nconst " +
				limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("nconst: " + rs.getString("N.nconst")
					+ ", primaryName: " + rs.getString("primaryName")
					+ ", Number of Titles: " + rs.getInt("COUNT(tconst)"));
			
		}
	}
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

// -----------------------------------

//Prints the Users Table
public static void printUsers(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT * FROM Users "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("uID: " + rs.getInt("uID") + 
					", uName: " + rs.getString("uName") +
					", age: " + rs.getInt("age") +
					", isAdult: " + rs.getBoolean("isAdult") +
					", isAdmin: " + rs.getBoolean("isAdult")
				);
		}
	} 
	
	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Prints the Titles Table
public static void printTitles(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT * FROM Titles "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("tconst: " + rs.getString("tconst") + 
					", titleType: " + rs.getString("titleType") +
					", primaryTitle: " + rs.getString("primaryTitle") +
					", startYear: " + rs.getInt("startYear") +
					", endYear: " + rs.getInt("endYear") +
					", runtimeMinutes: " + rs.getInt("runtimeMinutes") +
					", genre: " + rs.getString("genre") +
					", updatedAt: " + rs.getTimestamp("updatedAt"));
		}
	} 

	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Prints the Ratings Table
public static void printRatings(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT * FROM Ratings "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("uID: " + rs.getInt("uID") + 
					", tconst: " + rs.getString("tconst") +
					", rating: " + rs.getInt("rating") +
					", ratingDate: " + rs.getDate("ratingDate"));
		}
	} 

	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Prints the Episodes Table
public static void printEpisodes(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT * FROM Episodes "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("tconst: " + rs.getString("tconst") + 
					", parentTconst: " + rs.getString("parentTconst") +
					", seasonNum: " + rs.getInt("seasonNum") +
					", episodeNum: " + rs.getInt("episodeNum"));
		}
	} 

	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Prints the Names Table
public static void printNames(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT * FROM Names "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("nconst: " + rs.getString("nconst") + 
					", primaryName: " + rs.getString("primaryName") +
					", birthYear: " + rs.getInt("birthYear") +
					", deathYear: " + rs.getInt("deathYear") + 
					", primaryProfession: " + rs.getString("primaryProfession"));
		}
	} 

	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Prints the Principals Table
public static void printPrincipals(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT * FROM Principals "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("tconst: " + rs.getString("tconst") + 
					", nconst: " + rs.getString("nconst") +
					", category: " + rs.getString("category"));
		}
	} 

	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Prints the Favorites Table
public static void printFavorites(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT * FROM Favorites "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("uID: " + rs.getInt("uID") + 
					", tconst: " + rs.getString("tconst"));
		}
	} 

	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//Prints the Archive Table
public static void printArchive(Statement stmt, String limit) {
	
	ResultSet rs = null;
	
	try {
		rs = stmt.executeQuery("SELECT * FROM Archive "
				+ limit + ";");
		
		// Process the results
		while(rs.next()){
			sop("tconst: " + rs.getString("tconst") + 
					", titleType: " + rs.getString("titleType") +
					", primaryTitle: " + rs.getString("primaryTitle") +
					", startYear: " + rs.getInt("startYear") +
					", endYear: " + rs.getInt("endYear") +
					", runtimeMinutes: " + rs.getInt("runtimeMinutes") +
					", genre: " + rs.getString("genre") +
					", updatedAt: " + rs.getTimestamp("updatedAt"));
		}
	} 

	// Catch Blocks
	catch (SQLException se) { se.printStackTrace();	} 	// Handle errors for JDBC
	catch (Exception e) { e.printStackTrace();	} 		// Handle errors for Class.forName

}

//-------------------------------------------

//Archive Stored Procedure
//Stores all 'Crime' titles in the archive (by changing the updatedAt value).
public static void archiveFunction(String desc, String limit) {

	Connection conn = null;
	Statement stmt = null;
	CallableStatement cs = null;
	
	try {
		// Open a connection, create a statement
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
			
		// Execute Update
		sop(desc);
		stmt.executeUpdate("UPDATE Titles SET updatedAt='2008-01-01 00:00:01' WHERE genre='Crime';");
		
		// Archive Procedure		
		sop("Calling the procedure archiveProcedure");
		cs = conn.prepareCall("{CALL archiveProcedure(?)}");
		cs.setString(1, "2010-01-01");
		cs.executeQuery();		
		
		// Prints Archive
		printArchive(stmt, limit);
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
	


//-------------------------------------------
// Key Violations

// Violation of Primary Key uID in Users Table
public static void userKey() {

	Connection conn = null;
	Statement stmt = null;
	
	try {
		// Open a connection, create a statement
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
			
		// Execute Update
		sop("Primary Key Violation (Users)");
		stmt.executeUpdate("UPDATE Users SET uID=uID+1 WHERE uID>0;");
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

//Violation of Foreign Key uID in Users Table
public static void favoriteKey() {

	Connection conn = null;
	Statement stmt = null;
	
	try {
		// Open a connection, create a statement
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
			
		// Execute Update
		sop("Foreign Key Violation (Favorites)");
		stmt.executeUpdate("INSERT INTO Favorites VALUES (1, 'string');");
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





} // End of class
