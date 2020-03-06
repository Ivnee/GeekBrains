package hw3;

import java.util.Map;
import java.util.TreeMap;

public class Contacts {
    private String name;
    private int number;
    Map<String,Integer> map = new TreeMap<>();
    public void add(String name, int number){
        map.put(name,number);
    }
    public void get(String name){
        System.out.println(map.get(name));
    }
}
