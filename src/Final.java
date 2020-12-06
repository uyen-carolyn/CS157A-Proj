package project;

import java.util.Scanner;

public class Final {


/**
 * List of possible query calls:
 * 
 * 		QueryCalls.q1(limit50);
 * 		QueryCalls.q2(limit50);
 * 		QueryCalls.q3(limit50);
 * 		QueryCalls.q4(limit50);
 * 		QueryCalls.q5(limit50);
 * 		QueryCalls.q6(limit50);
 * 		QueryCalls.q7(limit50);
 * 		QueryCalls.q8(limit50);
 * 		QueryCalls.q9(limit50);
 * 		QueryCalls.q10(limit50);
 * 		QueryCalls.q11(limit50);
 * 		QueryCalls.q12(limit50);
 * 		QueryCalls.q13(limit50);
 * 		QueryCalls.q14(limit50);
 * 		QueryCalls.q15(limit50);
 * 
 * List of Table Calls
 * 		QueryCalls.usersTable(limit);
 * 		QueryCalls.titlesTable(limit50);
 *  	QueryCalls.ratingsTable(limit50);
 * 		QueryCalls.episodesTable(limit50);
 * 		QueryCalls.namesTable(limit50);
 * 		QueryCalls.principalsTable(limit50);
 * 		QueryCalls.favoritesTable(limit50);
 * 		QueryCalls.archiveProcedure(limit50);
 * 
 * Used for stored procedure of archive
 * 		Query.archiveFunction("Archive Function", limit50);
 * 
 * Used for key violations
 * 		Query.userKey();
 * 		Query.favoriteKey();
 */

//Print Methods
public static void sop(String s) {
	System.out.print(s);
}

public static void sopln(String s) {
	System.out.println(s);
}

public static void main(String[] args) {
	
	sopln("List of possible queries to run: ");
	QueryCalls.queryList();
	sopln("");
	
	Scanner scanner = new Scanner(System.in);
   
    
    String stay = "stay";
    
    while (!stay.equals("exit")) {
    	
    	int queryNumber, limit;
    	      
    	sop("Enter Query Number: ");
    	queryNumber = scanner.nextInt();
    	    
    	sop("Number of Outputs: ");
    	limit = scanner.nextInt();

    	// Gets the string limit
    	String strLimit = "LIMIT " + Integer.toString(limit);
    
		switch(queryNumber) {
			case 1:  QueryCalls.q1(strLimit); break;
			case 2:  QueryCalls.q2(strLimit); break;
			case 3:	 QueryCalls.q3(strLimit); break;
			case 4:  QueryCalls.q4(strLimit); break;
			case 5:  QueryCalls.q5(strLimit); break;
			case 6:  QueryCalls.q6(strLimit); break;
			case 7:  QueryCalls.q7(strLimit); break;
			case 8:	 QueryCalls.q8(strLimit); break;
			case 9:  QueryCalls.q9(strLimit); break;
			case 10: QueryCalls.q10(strLimit); break;
			case 11: QueryCalls.q11(strLimit); break;
			case 12: QueryCalls.q12(strLimit); break;
			case 13: QueryCalls.q13(strLimit); break;
			case 14: QueryCalls.q14(strLimit); break;
			case 15: QueryCalls.q15(strLimit); break;
			case 16: QueryCalls.usersTable(strLimit); break;
			case 17: QueryCalls.titlesTable(strLimit); break;
			case 18: QueryCalls.ratingsTable(strLimit); break;
			case 19: QueryCalls.episodesTable(strLimit); break;
			case 20: QueryCalls.namesTable(strLimit); break;
			case 21: QueryCalls.principalsTable(strLimit); break;
			case 22: QueryCalls.favoritesTable(strLimit); break;
			case 23: QueryCalls.archiveTable(strLimit); break;
			case 24: QueryCalls.archiveProcedure(strLimit); break;
			case 25: Query.userKey(); break;
			case 26: Query.favoriteKey(); break;
		}
		
		sop("Stay? ('exit' to leave): ");
		stay = scanner.next();
		
    }
    
    scanner.close();

	Query.sop("Goodbye!");
	   
}//end main

}







