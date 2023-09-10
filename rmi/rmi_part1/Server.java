import java.rmi.*;
import java.rmi.registry.*;
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Server{
public Server () throws RemoteException{
super();
}
public static void main(String args[]) throws Exception{
Registry reg=LocateRegistry.createRegistry(104);
OperationImpl oi=new OperationImpl();
reg.rebind( "operation",oi);
System.out.println("Server is running....");
}
}



