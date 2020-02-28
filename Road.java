package hw;

public class Road implements Obstraction {
    static int distance;
    public Road(int distance) {
        this.distance = distance;
    }
    @Override
    public  void doIt(Players player){
        player.run();
    }

}
