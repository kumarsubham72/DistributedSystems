package com.rmi.comm.servers;

import com.rmi.comm.service.ComputationService;
import com.rmi.comm.service.impl.ComputationServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputationServer {

    public static void main(String[] args) {
        try {
            System.out.println("Remote Server Started ");
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            ComputationService computationService = new ComputationServiceImpl();
            ComputationService computationServiceStub = (ComputationService) UnicastRemoteObject.exportObject(computationService, 0);
            LocateRegistry.createRegistry(9100);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            registry.rebind("computationService", computationServiceStub);
        } catch (RemoteException e) {
            System.out.println("Error in the ComputationServer[Remote]");
            e.printStackTrace();
        }
    }
}
