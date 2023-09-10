package com.rmi.comm.servers;

import com.rmi.comm.service.OperationInterface;
import com.rmi.comm.service.impl.OperationImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class FileServer {

    public static void main(String[] args) {
        try {
            System.out.println("Remote Server Started ");
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            OperationInterface oi = new OperationImpl();
            OperationInterface oiStub = (OperationInterface) UnicastRemoteObject.exportObject(oi,0);
            LocateRegistry.createRegistry(9300);
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 9300);
            reg.rebind("operation", oiStub);
        } catch (RemoteException e) {
            System.out.println("Error in the FileServer[Remote]");
            e.printStackTrace();
        }
    }

}
