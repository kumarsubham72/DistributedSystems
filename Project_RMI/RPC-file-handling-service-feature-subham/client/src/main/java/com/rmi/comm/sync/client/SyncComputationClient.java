package com.rmi.comm.sync.client;

import com.rmi.comm.service.ComputationService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import static com.rmi.comm.utils.RandomNumGenerator.getRandomNumbers;

public class SyncComputationClient {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            System.out.println(" Synchronous Client Started");
            ComputationService computationService = (ComputationService) registry.lookup("computationService");
            System.out.println("*********Adding Two Numbers************");
            System.out.println(" Enter first numbers to add");
            int i = sc.nextInt();
            System.out.println(" Enter second numbers to add");
            int j = sc.nextInt();
            System.out.println(computationService.add(i, j));
            System.out.println("*********Sorting Numbers with random integer data ************");
            System.out.println(computationService.sort(getRandomNumbers(5000)));
        } catch (RemoteException | NotBoundException e) {
            System.out.println("Error in the SyncComputationClient");
            e.printStackTrace();
        }
    }

}

