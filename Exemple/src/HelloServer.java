import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            if (System.getSecurityManager() == null)
                System.setSecurityManager(new SecurityManager()); //Defini Security manager
            //System.setProperty("java.security.policy","file:./default.policy");
            //LocateRegistry.createRegistry(1099);
            HelloImp h = new HelloImp("Hello World!"); //Créer l'objet distant implemente
            Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);
            Registry registry = LocateRegistry.getRegistry(1099); //Récupère le registre
            registry.bind("Hello1", h_stub); //Ajoute objet distant au registre
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Error on server : " + e);
            e.printStackTrace();
        }
    }
}