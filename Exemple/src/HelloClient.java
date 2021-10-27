import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage : java HelloClient <server host>");
            return;
        }
        try {
            if (System.getSecurityManager() == null)
                System.setSecurityManager(new SecurityManager()); //Defini Security manager
            System.setProperty("java.security.policy","file:./default.policy");
            String host = args[0];
            Registry registry = LocateRegistry.getRegistry(host);
            Hello h = (Hello) registry.lookup("Hello1");
            String res = h.sayHello();
            System.out.println(res);
        } catch (Exception e) {
            System.err.println("Error on server : " + e);
            e.printStackTrace();
        }
    }
}