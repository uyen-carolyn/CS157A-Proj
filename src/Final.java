package project;

public class Final {
	
// Limits the number of tuples printed
static String limit = "";
static String limit20 = "LIMIT 20";
static String limit50 = "LIMIT 50";
static String limit100 = "LIMIT 100";

/**
 * List of possible query calls:
 * 
 * 		QueryCalls.q1(limit);
 * 		QueryCalls.q2(limit);
 * 		QueryCalls.q3(limit);
 * 		QueryCalls.q4(limit);
 * 		QueryCalls.q5(limit);
 * 		QueryCalls.q6(limit);
 * 		QueryCalls.q7(limit);
 * 		QueryCalls.q8(limit);
 * 		QueryCalls.q9(limit);
 * 		QueryCalls.q10(limit);
 * 		QueryCalls.q11(limit);
 * 		QueryCalls.q12(limit);
 * 		QueryCalls.q13(limit);
 * 		QueryCalls.q14(limit);
 * 		QueryCalls.q15(limit);
 * 
 */

public static void main(String[] args) {

	QueryCalls.q5(limit20);
			
	Query.sop("Goodbye!");
	   
}//end main

}
