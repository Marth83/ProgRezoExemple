import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote{
    //Une méthode de l'objet distant
    public String sayHello() throws RemoteException;
}