package com.rmi.comm.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ComputationService extends Remote {

    int add(int i, int j) throws RemoteException;

    List<Integer> sort(List<Integer> array) throws RemoteException;
}
