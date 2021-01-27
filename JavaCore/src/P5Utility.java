import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class P5Utility {

	public static void main2(String[] args) {
		P5Utility t = new P5Utility();
		System.out.println("Starting Main--");

		System.out.println("Exiting Main--");
		
		String s1 =t.test1();
	}

	
	private String test1() {
		ArrayList<String> al = new ArrayList(Arrays.asList(null, "vikas", "hello"));
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			String s = itr.next();
			if (!isEmpty(s))
				return s;
		}
		return null;
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static void mainPrintPrivileges(String[] args) {
		String[] type = {"ORG", "BRANCH", "AREA", "USER", "CLASS", "SECTION" };
		String[] mode = {"CREATE", "EDIT", "DELETE", "VIEW", "VIEW_ALL", "SEARCH"};
		int i=100,j=100, k=0;
		for(String t: type) {
			for(String m: mode) {
				String s = "("+i+", '"+t+"_"+m+"',''),";
				System.out.println(s);
				
				i++;
			}
			j=j+100;
			i=j;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
		/*
		for (int i = 1; i <= 2; i++) {
			for (int j = 100; j <= 600; j=j+100) {
				for(int k=0;k<=5;k++) {
					int privId=j+k;
				String s = "(" + i + "," + privId + "),";
				System.out.println(s);
				}
			}
			
		}
		*/
	}	
	
	
	public static void main_v1(String[] args) {
		String[] orgs = {"P5","P6"};
		
		
		System.out.println("Printing Super Users: SU01, SU02");
		System.out.println("Printing Dba Users: DB01, DB02");
		
		for(int i=1;i<=orgs.length;i++) {
			String orgName=orgs[i-1];
			System.out.println("Org Users: "+orgName+"_U1, "+orgName+"_U2");
			
			for(int j=1;j<=4;j++) {
				String branchName=orgName+"B"+j;

				System.out.print("Printing BranchUsers:");
				System.out.println(branchName+"_BR01, "+branchName+"_BR02");
				
				System.out.print("Printing Admins: ");
				System.out.println(branchName+"_AD01, "+branchName+"_AD02");
				
				System.out.print("Printing Principle: ");
				System.out.println(branchName+"_PR01 ");
				
				
				System.out.print("Printing Teachers: ");
				System.out.println(branchName+"_TE01, "+branchName+"_TE02, "+branchName+"_TE03, "+branchName+"_TE04, "+branchName+"_TE05");

				System.out.print("Printing Parents and Students: ");
				for(int k=1;k<20;k++) {
					if(k<10) {
						System.out.print(branchName+"_PA0"+k+", ");
						System.out.print(branchName+"_ST0"+k+",   ");
					}
					else {
						System.out.print(branchName+"_PA"+k+", ");
						System.out.print(branchName+"_ST"+k+",   ");
					}
				}
				System.out.println();
				
			}			
			
		}
		

		//end main
	}
	
	public static void prepareUsers(String[] args) {
		String[] orgs = {"P5","P6"};
		
		
		System.out.println("SU01, SU02, DB01, DB02, ");
		
		for(int i=1;i<=orgs.length;i++) {
			String orgName=orgs[i-1];
			System.out.print(orgName+"_ORU1, "+orgName+"_ORU2, ");
			
			for(int j=1;j<=4;j++) {
				String branchName=orgName+"B"+j;

				System.out.print(branchName+"_BR01, "+branchName+"_BR02, ");
				
				System.out.print(branchName+"_AD01, "+branchName+"_AD02, ");
				
				System.out.print(branchName+"_PR01, ");
				
				
				System.out.print(branchName+"_TE01, "+branchName+"_TE02, "+branchName+"_TE03, "+branchName+"_TE04, "+branchName+"_TE05, ");

				for(int k=1;k<=20;k++) {
					if(k<10) {
						System.out.print(branchName+"_PA0"+k+", ");
						System.out.print(branchName+"_ST0"+k+", ");
					}
					else {
						System.out.print(branchName+"_PA"+k+", ");
						System.out.print(branchName+"_ST"+k+", ");
					}
				}
				System.out.println();
				
			}
			
			int id;
		/*	
			String s = "(id, username, '$2a$10$8L1xorS/.CV.XgKa1OhccuLbE763ZRbg1sDTZqTbmwr2.VW9FLWiG', 
					'Firstname','Mid','Lastname',to_date('1963-09-01', 'YYYY-MM-DD'),'test@test.com',false, false, false, true),""
			*/
		}
		

		//end main
	}
	
	
	
	public static void mainPrintUsers(String[] args) {
		String[] users={"SU01","SU02","DB01","DB02",
				"P5_ORU1","P5_ORU2","P5B1_BR01","P5B1_BR02","P5B1_AD01","P5B1_AD02","P5B1_PR01","P5B1_TE01","P5B1_TE02","P5B1_TE03","P5B1_TE04","P5B1_TE05","P5B1_PA01","P5B1_ST01","P5B1_PA02","P5B1_ST02","P5B1_PA03","P5B1_ST03","P5B1_PA04","P5B1_ST04","P5B1_PA05","P5B1_ST05","P5B1_PA06","P5B1_ST06","P5B1_PA07","P5B1_ST07","P5B1_PA08","P5B1_ST08","P5B1_PA09","P5B1_ST09","P5B1_PA10","P5B1_ST10","P5B1_PA11","P5B1_ST11","P5B1_PA12","P5B1_ST12","P5B1_PA13","P5B1_ST13","P5B1_PA14","P5B1_ST14","P5B1_PA15","P5B1_ST15","P5B1_PA16","P5B1_ST16","P5B1_PA17","P5B1_ST17","P5B1_PA18","P5B1_ST18","P5B1_PA19","P5B1_ST19","P5B1_PA20","P5B1_ST20",
				"P5B2_BR01","P5B2_BR02","P5B2_AD01","P5B2_AD02","P5B2_PR01","P5B2_TE01","P5B2_TE02","P5B2_TE03","P5B2_TE04","P5B2_TE05","P5B2_PA01","P5B2_ST01","P5B2_PA02","P5B2_ST02","P5B2_PA03","P5B2_ST03","P5B2_PA04","P5B2_ST04","P5B2_PA05","P5B2_ST05","P5B2_PA06","P5B2_ST06","P5B2_PA07","P5B2_ST07","P5B2_PA08","P5B2_ST08","P5B2_PA09","P5B2_ST09","P5B2_PA10","P5B2_ST10","P5B2_PA11","P5B2_ST11","P5B2_PA12","P5B2_ST12","P5B2_PA13","P5B2_ST13","P5B2_PA14","P5B2_ST14","P5B2_PA15","P5B2_ST15","P5B2_PA16","P5B2_ST16","P5B2_PA17","P5B2_ST17","P5B2_PA18","P5B2_ST18","P5B2_PA19","P5B2_ST19","P5B2_PA20","P5B2_ST20",
				"P5B3_BR01","P5B3_BR02","P5B3_AD01","P5B3_AD02","P5B3_PR01","P5B3_TE01","P5B3_TE02","P5B3_TE03","P5B3_TE04","P5B3_TE05","P5B3_PA01","P5B3_ST01","P5B3_PA02","P5B3_ST02","P5B3_PA03","P5B3_ST03","P5B3_PA04","P5B3_ST04","P5B3_PA05","P5B3_ST05","P5B3_PA06","P5B3_ST06","P5B3_PA07","P5B3_ST07","P5B3_PA08","P5B3_ST08","P5B3_PA09","P5B3_ST09","P5B3_PA10","P5B3_ST10","P5B3_PA11","P5B3_ST11","P5B3_PA12","P5B3_ST12","P5B3_PA13","P5B3_ST13","P5B3_PA14","P5B3_ST14","P5B3_PA15","P5B3_ST15","P5B3_PA16","P5B3_ST16","P5B3_PA17","P5B3_ST17","P5B3_PA18","P5B3_ST18","P5B3_PA19","P5B3_ST19","P5B3_PA20","P5B3_ST20",
				"P5B4_BR01","P5B4_BR02","P5B4_AD01","P5B4_AD02","P5B4_PR01","P5B4_TE01","P5B4_TE02","P5B4_TE03","P5B4_TE04","P5B4_TE05","P5B4_PA01","P5B4_ST01","P5B4_PA02","P5B4_ST02","P5B4_PA03","P5B4_ST03","P5B4_PA04","P5B4_ST04","P5B4_PA05","P5B4_ST05","P5B4_PA06","P5B4_ST06","P5B4_PA07","P5B4_ST07","P5B4_PA08","P5B4_ST08","P5B4_PA09","P5B4_ST09","P5B4_PA10","P5B4_ST10","P5B4_PA11","P5B4_ST11","P5B4_PA12","P5B4_ST12","P5B4_PA13","P5B4_ST13","P5B4_PA14","P5B4_ST14","P5B4_PA15","P5B4_ST15","P5B4_PA16","P5B4_ST16","P5B4_PA17","P5B4_ST17","P5B4_PA18","P5B4_ST18","P5B4_PA19","P5B4_ST19","P5B4_PA20","P5B4_ST20",
				"P6_ORU1","P6_ORU2","P6B1_BR01","P6B1_BR02","P6B1_AD01","P6B1_AD02","P6B1_PR01","P6B1_TE01","P6B1_TE02","P6B1_TE03","P6B1_TE04","P6B1_TE05","P6B1_PA01","P6B1_ST01","P6B1_PA02","P6B1_ST02","P6B1_PA03","P6B1_ST03","P6B1_PA04","P6B1_ST04","P6B1_PA05","P6B1_ST05","P6B1_PA06","P6B1_ST06","P6B1_PA07","P6B1_ST07","P6B1_PA08","P6B1_ST08","P6B1_PA09","P6B1_ST09","P6B1_PA10","P6B1_ST10","P6B1_PA11","P6B1_ST11","P6B1_PA12","P6B1_ST12","P6B1_PA13","P6B1_ST13","P6B1_PA14","P6B1_ST14","P6B1_PA15","P6B1_ST15","P6B1_PA16","P6B1_ST16","P6B1_PA17","P6B1_ST17","P6B1_PA18","P6B1_ST18","P6B1_PA19","P6B1_ST19","P6B1_PA20","P6B1_ST20",
				"P6B2_BR01","P6B2_BR02","P6B2_AD01","P6B2_AD02","P6B2_PR01","P6B2_TE01","P6B2_TE02","P6B2_TE03","P6B2_TE04","P6B2_TE05","P6B2_PA01","P6B2_ST01","P6B2_PA02","P6B2_ST02","P6B2_PA03","P6B2_ST03","P6B2_PA04","P6B2_ST04","P6B2_PA05","P6B2_ST05","P6B2_PA06","P6B2_ST06","P6B2_PA07","P6B2_ST07","P6B2_PA08","P6B2_ST08","P6B2_PA09","P6B2_ST09","P6B2_PA10","P6B2_ST10","P6B2_PA11","P6B2_ST11","P6B2_PA12","P6B2_ST12","P6B2_PA13","P6B2_ST13","P6B2_PA14","P6B2_ST14","P6B2_PA15","P6B2_ST15","P6B2_PA16","P6B2_ST16","P6B2_PA17","P6B2_ST17","P6B2_PA18","P6B2_ST18","P6B2_PA19","P6B2_ST19","P6B2_PA20","P6B2_ST20",
				"P6B3_BR01","P6B3_BR02","P6B3_AD01","P6B3_AD02","P6B3_PR01","P6B3_TE01","P6B3_TE02","P6B3_TE03","P6B3_TE04","P6B3_TE05","P6B3_PA01","P6B3_ST01","P6B3_PA02","P6B3_ST02","P6B3_PA03","P6B3_ST03","P6B3_PA04","P6B3_ST04","P6B3_PA05","P6B3_ST05","P6B3_PA06","P6B3_ST06","P6B3_PA07","P6B3_ST07","P6B3_PA08","P6B3_ST08","P6B3_PA09","P6B3_ST09","P6B3_PA10","P6B3_ST10","P6B3_PA11","P6B3_ST11","P6B3_PA12","P6B3_ST12","P6B3_PA13","P6B3_ST13","P6B3_PA14","P6B3_ST14","P6B3_PA15","P6B3_ST15","P6B3_PA16","P6B3_ST16","P6B3_PA17","P6B3_ST17","P6B3_PA18","P6B3_ST18","P6B3_PA19","P6B3_ST19","P6B3_PA20","P6B3_ST20",
				"P6B4_BR01","P6B4_BR02","P6B4_AD01","P6B4_AD02","P6B4_PR01","P6B4_TE01","P6B4_TE02","P6B4_TE03","P6B4_TE04","P6B4_TE05","P6B4_PA01","P6B4_ST01","P6B4_PA02","P6B4_ST02","P6B4_PA03","P6B4_ST03","P6B4_PA04","P6B4_ST04","P6B4_PA05","P6B4_ST05","P6B4_PA06","P6B4_ST06","P6B4_PA07","P6B4_ST07","P6B4_PA08","P6B4_ST08","P6B4_PA09","P6B4_ST09","P6B4_PA10","P6B4_ST10","P6B4_PA11","P6B4_ST11","P6B4_PA12","P6B4_ST12","P6B4_PA13","P6B4_ST13","P6B4_PA14","P6B4_ST14","P6B4_PA15","P6B4_ST15","P6B4_PA16","P6B4_ST16","P6B4_PA17","P6B4_ST17","P6B4_PA18","P6B4_ST18","P6B4_PA19","P6B4_ST19","P6B4_PA20","P6B4_ST20"};
		
		//printUserInsertQuery(users);	
		printRoleMapping(users);
		
		
	}
	
	public static void printUserInsertQuery(String[] users) {
		String insertQuery="insert into users(id, username, password, firstName, middle_name, last_name, dob, email, is_act_expired, is_act_locked, is_cred_expired, is_enabled) values";
		System.out.println(insertQuery);
		int userId=1000;
		for(String userName: users) {
			
			String s = "(" +userId+",'"+userName+"', '$2a$10$8L1xorS/.CV.XgKa1OhccuLbE763ZRbg1sDTZqTbmwr2.VW9FLWiG', 'Firstname','Mid','Lastname',to_date('1963-09-01', 'YYYY-MM-DD'),'test@test.com',false, false, false, true),";
			System.out.println(s);
			userId++;
		}
	}
	
	public static void printRoleMapping(String[] users) {
		String insertQuery="insert into users_roles_map(user_id, role_id) values";
		System.out.println(insertQuery);
		for(String userName: users) {
			String getUserId = "(select id from users where username='"+userName+"')";
			int roleId = getRoleIdByUserName(userName);
			System.out.println("("+getUserId+","+roleId+"),");
		}
		
	}
	
	//String getUserId = "select id from users where username='"+username+"'";
	private static int getRoleIdByUserName(String userName) {
		if(userName.contains("SU")) return 1;
		else if(userName.contains("DB")) return 2;
		else if(userName.contains("OR")) return 3;
		else if(userName.contains("BR")) return 4;
		else if(userName.contains("AD")) return 5;
		else if(userName.contains("PR")) return 6;
		else if(userName.contains("TE")) return 7;
		else if(userName.contains("PA")) return 8;
		else if(userName.contains("ST")) return 9;
		
		else return 0;
	}
	
	
	
}