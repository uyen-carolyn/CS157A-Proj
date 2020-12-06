package project;

public class QueryCalls {
	
// Descriptions of Queries
static String desc1 = "Finding all users and their ratings of their favorite movies:";
static String desc2 = "Finding all popular actors:";
static String desc3 = "Finding all ratings of titles from best to worst:";
static String desc4 = "Finding most popular genres:";
static String desc5 = "Finding the average age of users for each favorite movie:";
static String desc6 = "Finding all controversial movies:";
static String desc7 = "Finding all users who have reviewed three or more titles:";
static String desc8 = "Finding total number of favorite movies, tv shows, and episodes:";
static String desc9 = "Finding all actors and total number of roles they acted:";
static String desc10 = "Finding age ranges of favorited movies:";
static String desc11 = "Finding all actors in high-rated movies";
static String desc12 = "Finding all episodes ordered by TV show titles and episode number:";
static String desc13 = "Finding all users with favorited but not rated movies:";
static String desc14 = "Finding all ongoing titles favorited by the user:";
static String desc15 = "Finding all deceased actors and total number of titles they've done:";

//Print Method
public static void sop(String s) {
	System.out.print(s);
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







}











