import java.rmi.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.rmi.server.UnicastRemoteObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class OperationImpl extends UnicastRemoteObject implements OperationInterface, Serializable{
public OperationImpl() throws RemoteException{
super();
}


public void uploadFileToServer(byte[] mydata, String serverpath, int length) throws RemoteException {
			System.out.println("hello world");
    	try {
    		
    		File serverpathfile = new File(serverpath);
    		FileOutputStream out=new FileOutputStream(serverpathfile);
    		byte [] data=mydata;
			
    		out.write(data);
			out.flush();
	    	out.close();
	 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    	System.out.println("Done writing data...");
		
	}
	
	public byte[] downloadFileFromServer(String serverpath) throws RemoteException {
		System.out.println("hellowworld");			
		byte [] mydata;	
		
			File serverpathfile = new File(serverpath);			
			mydata=new byte[(int) serverpathfile.length()];
			FileInputStream in;
			try {
				in = new FileInputStream(serverpathfile);
				try {
					in.read(mydata, 0, mydata.length);
				} catch (IOException e) {
					
					e.printStackTrace();
				}						
				try {
					in.close();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}		
			
			return mydata;
				 
	}
	public boolean deleteFileFromServer(String serverpath) throws RemoteException {	
		File serverpathdelete = new File(serverpath);
		return serverpathdelete.delete();
		
	}

	public boolean renameFileFromServer(String serverpath, String clientserverpath) throws RemoteException {
		File serverpathrename = new File(serverpath);
		File serverpathrename2 = new File(clientserverpath);
		return serverpathrename.renameTo(serverpathrename2);
		
	}

}