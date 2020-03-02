package hw2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String text, int row, int col){
        super(text);
        System.err.println("В " + row + " строке, " + col +  " столбце ");

    }
    public MyArrayDataException(String text){
        super(text);
    }
}
