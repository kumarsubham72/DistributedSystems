package com.rmi.comm.async.tasks;

import com.rmi.comm.service.ComputationService;
import javafx.concurrent.Task;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AddTask extends Task<Integer> {
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public Integer call() {
        Integer result = null;
        try {
            System.out.println("*****Add Task started asynchronously");
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            ComputationService computationService = (ComputationService) registry.lookup("computationService");
            System.out.println(" Enter first numbers to add");
            int i = sc.nextInt();
            System.out.println(" Enter second numbers to add");
            int j = sc.nextInt();
            System.out.println();
            result = computationService.add(i, j);
            System.out.println("*****Asynchronous Add Task is finished ");
        } catch (RemoteException e) {
            System.out.println("Error in the AsyncComputationClient");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("Error in the  AsyncComputationClient");
            e.printStackTrace();
        }
        return result;
    }
}
