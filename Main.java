package hw;

public class Main {
    public static void main(String[] args) {

        Players [] players = {new Cat("Валера"),new Human("Мухтар"), new Robot("Толик")};
        Obstraction [] obs = {new Road(3), new Wall(2),};
        for(Players p: players){
            for(Obstraction o: obs){
                o.doIt(p);
                if(!p.onDistance()){
                    break;
                }

            }
        }
    }
}
