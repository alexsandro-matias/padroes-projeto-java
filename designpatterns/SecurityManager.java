package designpatterns;


public class SecurityManager {


    private static SecurityManager instance;

    private SecurityManager() {
    }

    public static SecurityManager getInstance() {
        if (instance == null) {
            instance = new SecurityManager();
            System.out.println("Login realizado com sucesso");
        }
        return instance;

    }

    public void login() {

    }

}

