package hw3;

import hw4.Contacts;

import java.util.*;

public class hw3 {
    public static void main(String[] args) {
        //1
        String [] zz={"z1","z2","z3","z4","z5","z6","z7","z8","z1","z2","z3"};
        Map<String,Integer> map = new TreeMap();
        for(String x: zz){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        System.out.println(map);

        //2
        Contacts contact = new Contacts();
        contact.add("Zel", 228);
        contact.add("Zel", 223);
        contact.add("Key", 224);
        contact.add("Nyam", 123);
        contact.add("Sesk", 111);

        contact.get("Zel");
        contact.get("Key");

    }
}