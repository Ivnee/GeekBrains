package hw;

public class Cat implements Players {
    boolean onDistance = true;
    String name;
    int runLimit;
    float jumpLimit;

    public Cat(String name, int runLimit, float jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public Cat(String name) {
        this.name = name;
        runLimit = 2;
        jumpLimit = 3;
    }

    @Override
    public void run() {
        if (Road.distance <= runLimit) {
            System.out.println("Кот " + name + " пробежал дистанцию");
        } else {
            System.out.println("Кот " + name + " устал");
            onDistance = false;
        }
    }

    @Override
    public void jump() {
        if (Wall.height <= jumpLimit) {
            System.out.println("Кот " + name + " перепрыгнул стену");
        } else {
            System.out.println("Кот " + name + "не смог перепрыгнуть");
            onDistance = false;
        }
    }
    @Override
    public boolean onDistance (){
        return onDistance;
    }
}