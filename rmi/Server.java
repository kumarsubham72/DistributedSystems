import java.rmi.*;
import java.rmi.registry.*;
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import java.io.Serializable;
public class Server implements Serializable{
public Server () throws RemoteException{
super();
}
public static void main(String args[]) throws Exception{
Registry reg=LocateRegistry.createRegistry(104);
OperationImpl oi=new OperationImpl("E:\Studies\DistributedSystems\rmi\rmi_part1");
reg.rebind( "operation",oi);
System.out.println("Server is running....");

}
}



