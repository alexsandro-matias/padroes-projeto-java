package singleton;

public class App {
    public static void main(String[] args) {
        SecurityManager manager = SecurityManager.getInstance();
        SecurityManager manager2 = SecurityManager.getInstance();

        System.out.println(manager);
        System.out.println(manager2);
    }
}
