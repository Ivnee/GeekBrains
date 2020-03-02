package hw2;

import hw3.MyArrayDataException;
import hw3.MyArrySizeExeption;

public class Main {
    public static void main(String[] args){
        String [][] arr = {{"2", "4", "3", "1"},
                {"2", "3", "6", "8"},
                {"12", "13", "15", "16"},
                {"21", "22", "26"}
        };

        String [][] arr2 = {{"2", "4", "3", "1"},
                {"2", "3", "6", "8"},
                {"12", "13", "15", "16"},
                {"21", "22", "26","g"}
        };
        try {
            array2(arr);
        } catch (MyArrySizeExeption e) {
            e.printStackTrace();

        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            array2(arr2);
        } catch (MyArrySizeExeption e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }
    public static int array2(String [][] arr) throws MyArrySizeExeption, MyArrayDataException {
        int a = 0;
        for (int i=0;i<arr.length;i++){
            if(!(arr.length == 4 && arr[i].length == 4)){
                throw new MyArrySizeExeption("Ошибка размера массива ");
            }
            for(int j=0;j<arr[i].length;j++){
                int b;
                try {
                    b = Integer.parseInt(arr[i][j]);
                }catch(NumberFormatException e){
                    throw new MyArrayDataException("Неверный формат ", i, j);
                }
                a += b;
                System.out.println(a);
            }
        }
        return a;
    }

}
