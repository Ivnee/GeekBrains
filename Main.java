package hw5;
import javax.naming.PartialResultException;
public class Main {
    static final int size = 10000000;
    static final int half = size/2;
    public static void main(String[] args) {
        float [] array = new float[size];
        arr(array);
        arr2(array);
    }

    static void arr(float[] array) {
        for (int i = 0; i < size ; i++) {
            array[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size ; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i/5)* Math.cos(0.2f +i/5)* Math.cos(0.4 +i/2));
        }
        System.out.println("Основной поток " + (System.currentTimeMillis() - a));

    }
        static void arr2(float[] array){
        for (int i = 0; i <size ; i++) {
            array[i] = 1;
        }
        long a = System.currentTimeMillis();
        float [] a1 = new float[half];
        float [] a2 = new float[half];

        Thread t1 = new Thread(() -> {
            System.arraycopy(array, 0, a1, 0, half );
            for (int i = 0; i < half; i++) {
                a1[i] = (float) (array[i] * Math.sin(0.2f + i/5)* Math.cos(0.2f +i/5)* Math.cos(0.4 +i/2));
            }
            System.arraycopy(a1,0,array,0,half);
        });
        System.out.println();

        Thread t2 = new Thread(() ->{
            System.arraycopy(array, half, a2, 0, half);
            for (int i = 0; i < half ; i++) {
                a2[i] = (float) (array[i] * Math.sin(0.2f + i/5)* Math.cos(0.2f +i/5)* Math.cos(0.4 +i/2));
            }
            System.arraycopy(a2,0,array,half,half);
        });


        t1.start();
        t2.start();
        System.out.println("Многопоточный " + (System.currentTimeMillis() - a));
        
    }

}
