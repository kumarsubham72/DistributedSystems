package com.rmi.comm.sync.client;

import com.rmi.comm.service.OperationInterface;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileHandlerClient {
    public static void main(String[] args) throws Exception {
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
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9300);
        OperationInterface inter = (OperationInterface) registry.lookup("operation");
        //to upload a file
        if (upload.equals(args[0])) {
            clientpath = args[1];
            serverpath = args[2];
            byte[] fileData = Files.readAllBytes(Paths.get(clientpath));
            inter.uploadFileToServer(fileData,serverpath,fileData.length);
            System.out.println("File uploaded successfully..");

        }
        //to download a file
        if (download.equals(args[0])) {
            serverpath = args[1];
            clientpath = args[2];

            byte[] mydata = inter.downloadFileFromServer(serverpath);
            System.out.println("downloading...");
            Path path = Paths.get(clientpath);
            Files.write(path, mydata);
            System.out.println("File downloaded successfully");
        }

        //to delete a file
        if (delete.equals(args[0])) {
            deletepath = args[1];
            File fileObj = new File(deletepath);
            if (fileObj.delete()) {
                System.out.println("Successfully Delted: " + fileObj.getName());
            } else {
                System.out.println("Deletion Failed");
            }
        }

        //to rename a file
        if (rename.equals(args[0])) {
            OldFileName = args[1];
            NewFileName = args[2];
            File OldFile = new File(OldFileName);
            File NewFile = new File(NewFileName);
            if (OldFile.renameTo(NewFile)) {
                System.out.println("Name changed successfully");
            }
        }
    }
}
