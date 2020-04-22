public class Cat {
    String name ;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Test(priority = 6)
    public static void jump(){
        System.out.println("Кот прыгул");
    }

    @BeforSuit
    public static void eat(){
        System.out.println("Сначала Кот поел");
    }
    @Test(priority = 10)
    public static void run(){
        System.out.println("Кот пробежал");
    }
    @Test(priority = 3)
    public static void walk(){
        System.out.println("Кот погулял");
    }
    @AfterSuit
    public static void sleep(){
        System.out.println("Потом Кот поспал");
    }


}
