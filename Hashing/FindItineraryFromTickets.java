import java.util.*;
public class FindItineraryFromTickets {
    
    public static String getStart(HashMap<String,String>tickets){
        HashMap<String,String> revMap=new HashMap<>();
        //traverse over loop
        for(String key:tickets.keySet()){
            //reverse key and values
            revMap.put(tickets.get(key), key);
        }

        for(String key:tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key; //starting point
            }
        }
        return null;
    }
    public static void main(String[] args) {
         HashMap<String,String> tickets=new HashMap<>();
         tickets.put("Chennai", "Bengaluru");
         tickets.put("Mumbai", "Delhi");
         tickets.put("Goa", "Chennai");
         tickets.put("Delhi", "Goa");

         //get the starting point
         String start=getStart(tickets);
         System.out.print(start);
         for(String key:tickets.keySet()){
                System.out.print("->"+tickets.get(start));
                start=tickets.get(start);
         }
         System.out.println();
    }
}
