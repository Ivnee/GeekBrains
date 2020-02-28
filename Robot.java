package hw;

public class Robot implements Players {
    boolean onDistance = true;
    String name;
    int runLimit;
    float jumpLimit;
    public Robot(String name, int runLimit){
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = 0;

    }
    public Robot(String name){
        this.name=name;
        runLimit = 10;
        jumpLimit = 0;
    }
    @Override
    public void run(){
        if(Road.distance <= runLimit) {
            System.out.println("Робот " + name + " пробежал дистанцию");
        }else{
            System.out.println("Робот " + name + " устал ");
            onDistance = false;
        }
    }
    @Override
    public void jump() {
        if (Wall.height <= jumpLimit) {
            System.out.println("Робот " + name + " перепрыгнул стену");
        } else {
            System.out.println("Робот " + name + " не смог перепрыгнуть");
            onDistance = false;

        }
    }
    @Override
    public boolean onDistance() {
        return onDistance;
    }
}
