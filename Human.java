package hw;

public class Human implements Players{
    boolean onDistance = true;
    String name;
    int runLimit;
    float jumpLimit;
    public Human(String name, int runLimit, float jumpLimit){
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }
    public Human(String name){
        this.name=name;
        runLimit = 5;
        jumpLimit = 1.5f;

    }
    @Override
    public void run(){
        if(Road.distance <= runLimit) {
            System.out.println("Человек " + name + " пробежал дистанцию");
        }else{
            System.out.println("Человек " + name + " устал");
            onDistance = false;
        }
    }
    @Override
    public void jump(){
        if(Wall.height <= jumpLimit) {
            System.out.println("Человек " + name + " перепрыгнул стену");
        }else{
            System.out.println("Человек " + name + " не смог перепрыгнуть");
            onDistance = false;
        }
    }
    @Override
    public boolean onDistance(){
        return onDistance;
    }
}
