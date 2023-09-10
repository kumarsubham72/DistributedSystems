package com.rmi.comm.service.impl;

import com.rmi.comm.service.ComputationService;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

public class ComputationServiceImpl implements ComputationService {
    public ComputationServiceImpl() throws RemoteException {
    }

    public int add(int i, int j) throws RemoteException {
        return i + j;
    }

    public List<Integer> sort(List<Integer> array) throws RemoteException {
        Collections.sort(array);
        return array;
    }
}
