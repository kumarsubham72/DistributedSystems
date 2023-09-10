package com.rmi.comm.async.client;

import com.rmi.comm.async.tasks.AddTask;
import com.rmi.comm.async.tasks.SortTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncComputationClient {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        CompletableFuture.supplyAsync(new AddTask()::call, executorService)
                .thenAccept(result -> System.out.println("The result is: " + result));
        CompletableFuture.supplyAsync(new SortTask()::call, executorService)
                .thenAccept(result -> System.out.println("The sorted result is: " + result));
        executorService.shutdown();
    }
}
