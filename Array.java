package Prof;

import java.util.ArrayList;
import java.util.List;

public class Array <T>{
    private T [] arr ;
    private List <T> al;
    public  Array(T... arr) {
        this.arr = arr;
        // задание 1
    }
    public void swapForIndex(int swap1,int swap2){
        T first = this.arr[swap1];
        T second = this.arr[swap2];
        this.arr[swap1] = second;
        this.arr[swap2] = first;
    }
    public void printArr(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //задание 2
    public void createAlFromArr(){
        this.al = new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            al.add(arr[i]);
        }
    }
    public void printAl(){
        System.out.println(this.al);
    }
}
