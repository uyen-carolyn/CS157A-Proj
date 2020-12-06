package project;

public class QueryCalls {
	
// Descriptions of Queries
static String desc1 = "Finding all users and their ratings of their favorite movies";
static String desc2 = "Finding all popular names in the entertainment industry (10+ titles)";
static String desc3 = "Finding all ratings of titles from best to worst";
static String desc4 = "Finding the most popular genres by the number of favorites";
static String desc5 = "Finding the average age for favorite movies among users";
static String desc6 = "Finding all controversial (greatest rating spread in ratings) movies";
static String desc7 = "Finding all users who have reviewed three or more titles";
static String desc8 = "Finding total number of favorite title type (movie, tv series)";
static String desc9 = "Finding the total number of principals that all names have been in";
static String desc10 = "Finding age groups of favorited movies";
static String desc11 = "Finding all actors/actresses in high-rated movies";
static String desc12 = "Finding all episodes ordered by TV show titles and episode number";
static String desc13 = "Finding all users with favorited but not rated movies";
static String desc14 = "Finding all ongoing titles that have been favorited by at least one user";
static String desc15 = "Finding all deceased names and total number of titles they've been in";

// Descriptions of Table Queries
static String desc16 = "Gets the Users Table";
static String desc17 = "Gets the Titles Table";
static String desc18 = "Gets the Ratings Table";
static String desc19 = "Gets the Episodes Table";
static String desc20 = "Gets the Names Table";
static String desc21 = "Gets the Principals Table";
static String desc22 = "Gets the Favorites Table";
static String desc23 = "Gets the Archive Table";
static String desc24 = "Uses the archive stored procedure example";

//Print Methods
public static void sop(String s) {
	System.out.print(s);
}

public static void sopln(String s) {
	System.out.println(s);
}

// List of descriptions:
public static void queryList() {
	sopln("q1: " + desc1);
	sopln("q2: " + desc2);
	sopln("q3: " + desc3);
	sopln("q4: " + desc4);
	sopln("q5: " + desc5);
	sopln("q6: " + desc6);
	sopln("q7: " + desc7);
	sopln("q8: " + desc8);
	sopln("q9: " + desc9);
	sopln("q10: " + desc10);
	sopln("q11: " + desc11);
	sopln("q12: " + desc12);
	sopln("q13: " + desc13);
	sopln("q14: " + desc14);
	sopln("q15: " + desc15);
	sopln("q16: " + desc16);
	sopln("q17: " + desc17);
	sopln("q18: " + desc18);
	sopln("q19: " + desc19);
	sopln("q20: " + desc20);
	sopln("q21: " + desc21);
	sopln("q22: " + desc22);
	sopln("q23: " + desc23);
	sopln("q24: " + desc24);
	sopln("q25: " + "Primary Key Violation");
	sopln("q26: " + "Foreign Key Violation");

}


// ---------------------------------------

// Query 1
public static void q1(String limit) {
	sop("Query 1 - ");
	Query.query(1, desc1, limit);
	Query.sop("");
}

// Query 2
public static void q2(String limit) {
	sop("Query 2 - ");
	Query.query(2, desc2, limit);
	Query.sop("");
}

// Query 3
public static void q3(String limit) {
	sop("Query 3 - ");
	Query.query(3, desc3, limit);
	Query.sop("");
}

// Query 4
public static void q4(String limit) {
	sop("Query 4 - ");
	Query.query(4, desc4, limit);
	Query.sop("");
}

// Query 5
public static void q5(String limit) {
	sop("Query 5 - ");
	Query.query(5, desc5, limit);
	Query.sop("");
}

// Query 6
public static void q6(String limit) {
	sop("Query 6 - ");
	Query.query(6, desc6, limit);
	Query.sop("");
}

// Query 7
public static void q7(String limit) {
	sop("Query 7 - ");
	Query.query(7, desc7, limit);
	Query.sop("");
}

// Query 8
public static void q8(String limit) {
	sop("Query 8 - ");
	Query.query(8, desc8, limit);
	Query.sop("");
}

// Query 9
public static void q9(String limit) {
	sop("Query 9 - ");
	Query.query(9, desc9, limit);
	Query.sop("");
}

// Query 10
public static void q10(String limit) {
	sop("Query 10 - ");
	Query.query(10, desc10, limit);
	Query.sop("");
}
	
// Query 11
public static void q11(String limit) {
	sop("Query 11 - ");
	Query.query(11, desc11, limit);
	Query.sop("");
}

// Query 12
public static void q12(String limit) {
	sop("Query 12 - ");
	Query.query(12, desc12, limit);
	Query.sop("");
}

// Query 13
public static void q13(String limit) {
	sop("Query 13 - ");
	Query.query(13, desc13, limit);
	Query.sop("");
}

// Query 14
public static void q14(String limit) {
	sop("Query 14 - ");
	Query.query(14, desc14, limit);
	Query.sop("");
}

// Query 15
public static void q15(String limit) {
	sop("Query 15 - ");
	Query.query(15, desc15, limit);
	Query.sop("");
}

// Users Table
public static void usersTable(String limit) {
	sop("Users Table - ");
	Query.query(16, desc16, limit);
	Query.sop("");
}

// Titles Table
public static void titlesTable(String limit) {
	sop("Titles Table - ");
	Query.query(17, desc17, limit);
	Query.sop("");
}

// Ratings Table
public static void ratingsTable(String limit) {
	sop("Ratings Table - ");
	Query.query(18, desc18, limit);
	Query.sop("");
}

// Episodes Table
public static void episodesTable(String limit) {
	sop("Episodes Table - ");
	Query.query(19, desc19, limit);
	Query.sop("");
}

// Names Table
public static void namesTable(String limit) {
	sop("Names Table - ");
	Query.query(20, desc20, limit);
	Query.sop("");
}

// Principals Table
public static void principalsTable(String limit) {
	sop("Principals Table - ");
	Query.query(21, desc21, limit);
	Query.sop("");
}

// Favorites Table
public static void favoritesTable(String limit) {
	sop("Favorites Table - ");
	Query.query(22, desc22, limit);
	Query.sop("");
}

// Archive Table
public static void archiveTable(String limit) {
	sop("Archive Table - ");
	Query.query(23, desc23, limit);
	Query.sop("");
}

// Stored Procedure: Archive 
public static void archiveProcedure(String limit) {
	sop("Updated Archive Table - ");
	Query.archiveFunction(desc24, limit);
	Query.sop("");
}



}











