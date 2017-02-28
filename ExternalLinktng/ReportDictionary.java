package ExternalLinktng;

import java.util.ArrayList;
//import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;




public class ReportDictionary {

   
    public static String MaptoJson(Map<String, HashMap<String,Object>> qluedictionary) {
        Gson gson = new Gson();
        String json = gson.toJson(qluedictionary);
        return json;
    }

      
    public static void DisplayMap(Map<String, HashMap<String,Object>> map) {
        for (String key : map.keySet()) {
            System.out.println("map.get(\"" + key + "\") = " + map.get(key));
        }
    }

   
    public static void GenerateJson(String json) {
        System.out.println("delayed bag = " + json);
    }

  
    public static void main(String[] args) {
        Map<String,HashMap<String,Object>> qluedictionary = new HashMap<String,HashMap<String,Object>>();
        Map<String,Object> qluedictionary2 = new HashMap<String,Object>();
        Map<String,Object> qluedictionary3 = new HashMap<String,Object>();
        Map<String,Object> qluedictionary4 = new HashMap<String,Object>();
        ArrayList<String> qluedictionary5 = new ArrayList<String>();
        
//        q
//        qluedictionary2.put("selectedValue", qluedictionary5);
//        qluedictionary.put("status", "true");
//        
//        
//        qluedictionary.put("multi select", qluedictionary2);
//        
//        
//        qluedictionary3.put("status", "pass");
//        qluedictionary3.put("selectedValue", "CL 5581 SJC-WYS 9/15/2016 ");
//        
//        qluedictionary.put("single select", qluedictionary3);
//        
//        qluedictionary4.put("status", "pass");
//        qluedictionary4.put("selectedValue", "CL 5581 SJC-WYS 9/15/2016 ");
//        
//        qluedictionary.put("single select", qluedictionary4);
 
        String delayed_bag = MaptoJson(qluedictionary); 
        GenerateJson(delayed_bag); 

        System.out.println();

       
    }

}

















//import com.google.gson.Gson;
//import java.util.*;
//import session_package.RequestandResponse;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.google.gson.reflect.TypeToken;
//
//
//public class ReportDictionary {
//	
//	
//	
//	  public static void main(String[] args) {
//	        Map <String, String> dictionary;
//	        dictionary = new TreeMap <String , String>();
//	       
//	        dictionary.put("Single Select", "talk about something");
//	        dictionary.put("Multi Select", "a narrow opening");
//	        dictionary.put("Picture", "sudden but for short time");
//	            
//	       
//	       System.out.println("The all data = "+dictionary.size());
//	       Iterator it = dictionary.entrySet().iterator();
//			while (it.hasNext()) {
//				Map.Entry pairs = (Map.Entry) it.next();
//				System.out.println(pairs.getKey() + " = " + pairs.getValue());
//				
//				
//				// Converting HashMap keys into ArrayList
//				List<String> keyList = new ArrayList<String>(dictionary.keySet());
//				System.out.println("\n==> Size of Key list: " + keyList.size());
//		 
//				for (String temp : keyList) {
//					System.out.println(temp);
//				}
//
//	       
//	       
//				JsonElement jElement = new JsonParser().parse("Picture");
//				JsonObject  jObject = jElement.getAsJsonObject();
//				jObject = jObject.getAsJsonObject("Picture");
//	       } 
//	    }
//}
//	
//	






	

//		    public static void main(String[] args) {
//		    	
//	    
//	    		try {
//	    			
//	    			  RequestandResponse ress= new RequestandResponse();
//	                 
//	    		         
//	    		         List<Map<String,List<String>>> list = new ArrayList<Map<String,List<String>>>();
//	    		         Map<String, List<String>> map1 = new HashMap<String, List<String>>();
//	    		         List<String> arraylist1 = new ArrayList<String>();
//	    		         arraylist1.add("Text");
//	    		        map1.put("DelayedBag",arraylist1);
//	    		        
//	    		        boolean testmap = list.add(map1);
//	    					
//	    					   				
//	    					
//	    		        Gson json = new Gson();
//	    				   // json.putAll(  );
//	    				    System.out.printf( "JSon: %s", json.toString());
//
//	    		} catch (Exception e) {
//	    			System.out.println(e.toString());
//	    		}
//	    		
//	    	}
//		    
//



	
	

