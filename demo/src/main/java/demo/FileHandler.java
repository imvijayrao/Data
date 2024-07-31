package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler{
    //FileCreator
    public void fileCreationHandler(String fileName){
        try {
            File objFile = new File(fileName);
            if(objFile.createNewFile()){
                System.out.println("**New File is created**");
                System.out.println("Name of the File: "+objFile.getName());
            }
            else{
                System.out.println("File already exists.");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    //FileWriter
    public void fileWriteHandler(String fileName, String updateFile){
        try{
            FileWriter objFileWriter = new FileWriter(fileName, true);
            objFileWriter.write(updateFile);
            objFileWriter.close();
            System.out.println("File is updated");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    //FileReader
    public void fileReadHandler(String fileName){
        try{
            File objFile = new File(fileName);
            Scanner obj1 = new Scanner(objFile);
            while (obj1.hasNextLine()) {
                String obj2 = obj1.nextLine();
                System.out.println(obj2);
            }
            if(objFile.canWrite()) System.out.println("File is writable");
            obj1.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    //FileCopying
    public void fileCopyHandler(String fileName, String copyName){
        try {
            File objCopyFile = new File(copyName);
            FileInputStream aFile = new FileInputStream(fileName);
            FileOutputStream bFile = new FileOutputStream(objCopyFile);
            int length;
            byte buffer[] = new byte[1024];
            int count=1;
            while((length=aFile.read(buffer))>0){
                System.out.println("Iteration: "+count++);
                bFile.write(buffer, 0, length);
            }
            aFile.close();
            bFile.close();
            System.out.println("File copied successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //FilePermissions
    public void filePermissionhandler(String fileName){
        File objFile = new File(fileName);
        if(objFile.exists()){
            System.out.println("Executable: "+objFile.canExecute());
            System.out.println("Readable: "+objFile.canRead());
            System.out.println("Writable: "+objFile.canWrite());
        }
        else{
            System.out.println("File Not Found....");
        }
    }
    //FileInformation
    public void fileInformationHandler(String fileName){
        File objFile = new File(fileName);
        if(objFile.exists()) {
            System.out.println("File Name: "+objFile.getName());
            System.out.println("Absolute path: "+objFile.getAbsolutePath());
            System.out.println("File size in bytes: "+objFile.length());
        }
        else System.out.println("File not Found.....");
    }
    //FileDelete
    public void fileDeleteHandler(String fileName){
        File objFile = new File(fileName);
        if(objFile.delete()) System.out.println("File deleted successfully.....");
        else System.out.println("Failed to Delete");
    }
}
