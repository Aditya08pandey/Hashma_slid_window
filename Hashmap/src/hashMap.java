import java.util.*;
import java.io.*;

public class hashMap {
    public static void main(String[] args) {
        HashMap<Integer,String> hashmap= new HashMap<>();

        //functionality of put function
        hashmap.put(1,"Priya");
        hashmap.put(2,"Priyam");
        hashmap.put(3,"Priyanka");
        hashmap.put(4,"Pritam");

        System.out.print("Hashmap is: "+hashmap);

        //functionality of get function
        System.out.println();
        String result= hashmap.get(3);
        System.out.println("Value is :"+result);

        //functionality of conatinskey
        System.out.println(hashmap.containsKey(2));

        //functonality of remove() function
        hashmap.remove(1);
        System.out.println("Updated hashmap is:" +hashmap);

        //iterating using loop
        for(Map.Entry<Integer,String> e: hashmap.entrySet()){
            System.out.println("Hashmap is=> " +e.getKey()+ " : " + e.getValue());
        }


    }
}
