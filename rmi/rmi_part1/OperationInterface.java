import java.rmi.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public interface OperationInterface extends Remote{

public void uploadFileToServer(byte[] mybyte, String serverpath, int length) throws RemoteException;
public byte[] downloadFileFromServer(String servername) throws RemoteException;
public boolean deleteFileFromServer(String serverpath) throws RemoteException;
public boolean renameFileFromServer(String serverpath,String clientserverpath) throws RemoteException;

}