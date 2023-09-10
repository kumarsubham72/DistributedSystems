package com.rmi.comm.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperationInterface extends Remote{

    void uploadFileToServer(byte[] mybyte, String serverpath, int length) throws RemoteException;
    byte[] downloadFileFromServer(String servername) throws RemoteException;
    boolean deleteFileFromServer(String serverpath) throws RemoteException;
    boolean renameFileFromServer(String serverpath, String clientserverpath) throws RemoteException;

}