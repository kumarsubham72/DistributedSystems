package com.rmi.comm.async.tasks;

import com.rmi.comm.service.ComputationService;
import javafx.concurrent.Task;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import static com.rmi.comm.utils.RandomNumGenerator.getRandomNumbers;

public class SortTask extends Task<List<Integer>> {

    @Override
    public List<Integer> call() {
        List<Integer> result = null;
        try {
            System.out.println("*****Sorting Task with random integer data started asynchronously");
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            ComputationService computationService = (ComputationService) registry.lookup("computationService");
            result = computationService.sort(getRandomNumbers(5000));
            System.out.println("*****Asynchronous Sorting Task is finished ");
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
