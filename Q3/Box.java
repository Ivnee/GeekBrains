package Prof.Q3;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> al = new ArrayList<>();
    private T fruit;


    public void addFruit(T fruit){
        al.add(fruit);
    }
    public void getFruitAmount(){
        System.out.println("Количество фруктво в коробке: " + al.size());
    }
    public float getWeight  (){
        float boxWeight = 0f;
        for(T w: al){
            boxWeight += w.getWeight().floatValue();
        }
        return boxWeight;
    }
    public boolean compare(Box<? extends Fruit> fruitBox){
        return (Math.abs(this.getWeight() - fruitBox.getWeight()) < 0.00001);
    }
    public void dropFruitTo(Box<T> fruitBox,int amount){
        for (int i = 0; i <amount ; i++) {
            fruitBox.addFruit(this.al.get((al.size())-1));
            this.al.remove((al.size())-1);
        }
        System.out.println("Вы пересыпали "+ amount+" фруктов");
    }


}
