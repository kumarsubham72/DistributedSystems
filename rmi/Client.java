import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client{
	public static void main(String[] args) throws Exception{
		String clientpath;
		String serverpath;
		String deletepath;
		String OldFileName;
		String NewFileName;
		String upload = "upload";
		String download = "download";
		String delete = "delete";
		String rename = "rename";

		System.out.println(args[0]);
		System.out.println(args[1]);
		OperationInterface inter = (OperationInterface)Naming.lookup("rmi://localhost:104/operation");
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		//to upload a file
		
		if(upload.equals(args[0]))
		{
			clientpath= args[1];
			serverpath = args[2];
			File clientpathfile = new File(clientpath);
			byte [] mydata=new byte[(int) clientpathfile.length()];
			FileOutputStream fos = new FileOutputStream(serverpath);
			fos.write(mydata, 0, mydata.length);
			fos.close();
			System.out.println("File uploaded successfully..");

		}
		//to download a file
		if(download.equals(args[0]))
		{
			serverpath = args[1];
			clientpath= args[2];

			byte [] mydata = inter.downloadFileFromServer(serverpath);
			System.out.println("downloading...");
			File clientpathfile = new File(clientpath);
			FileOutputStream out=new FileOutputStream(clientpathfile);				
			out.write(mydata);
			out.flush();
			out.close();
			System.out.println("File downloaded successfully");
		}

		//to delete a file
		if(delete.equals(args[0]))
		{
			deletepath = args[1];


			File fileObj = new File(deletepath); 
			if (fileObj.delete()) { 
				System.out.println("Successfully Delted: " + fileObj.getName());
			} else {
				System.out.println("Deletion Failed");
			} 
		}

		//to rename a file
		if(rename.equals(args[0]))
		{
			OldFileName = args[1];
			NewFileName = args[2];


			File OldFile = new File(OldFileName);
			File NewFile  = new File(NewFileName);
			if(OldFile.renameTo(NewFile)){
				System.out.println("Name changed successfully");
			}
		}
	}
}
