package com.vik.cj11.usingpropertes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExceptionLog
{		
  public static void main(String args[]) throws Exception {		
    String sourcefile = "c:\\server.log.2012-10-07";	
     List<String> exceptionsCountList = exceptionsCount(sourcefile) ;
       for(String ex:exceptionsCountList) {
            System.out.println(ex);
       }
  }

// returns an arrayList which exception and its occurence
  public static ArrayList<String> exceptionsCount(String sourcefile) {
      Set<String> exceptionsSet = new TreeSet<String>();
         exceptionsSet= findExceptionNames(sourcefile);

          ArrayList<String> exceptionsCount = new ArrayList<String>();
          for(String ex : exceptionsSet) {
                exceptionsCount.add(ex+": "+wordCount(sourcefile,ex));
          }
          return exceptionsCount;
     }




// returns the count of a single exception occurence in a file and counts only once in a single line
      public static int wordCount(String sourcefile, String wordCount) {
       int searchLength=wordCount.length();
	   try {
		BufferedReader br = new BufferedReader (new FileReader (sourcefile));
		String line = null;
		int lcnt = 0;
		int searchCount = 0;
		while ((line = br.readLine()) != null) {
			lcnt++;
			for(int searchIndex=0;searchIndex<line.length();) {
				int index=line.indexOf(wordCount,searchIndex);
				if(index!=-1) {					
    					searchCount++;
					break;
				} else {  break;  }
			}
		}
		return searchCount;
	   } catch(Exception e) { System.out.println(e);    return 0;  }

     }



// returns the names of all exceptions
  public static Set<String> findExceptionNames(String sourcefile) {
      Pattern pattern = Pattern.compile("[A-Z]\\w*Exception");
      Set<String> exceptions = new TreeSet<String>();
      try{
          BufferedReader br = new BufferedReader (new FileReader (sourcefile));      
          while (br.readLine() != null) {			
             Matcher matcher = pattern.matcher(br.readLine());
             int count = 0;
             while (matcher.find()) {     exceptions.add(matcher.group());        }
          }
        return exceptions;
      }
      catch(Exception ex) { return exceptions; }
    
  }


 
}
