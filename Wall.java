package hw;

public class Wall implements Obstraction{
    static float height;

    public Wall(float height) {
        this.height=height;
    }
    @Override
    public void doIt(Players player){
        player.jump();
    }
}
