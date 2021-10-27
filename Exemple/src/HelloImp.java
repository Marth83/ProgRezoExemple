import java.rmi.RemoteException;

public class HelloImp implements Hello{
    private String message;

    public HelloImp(String s){
        message = s;
    }

    public String sayHello() throws RemoteException{
        return message;
    }
}