package com.freshworks.InputUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputFile {
    
    File folder ;
    File[] listOfFiles;
    String folderPath;
    String baseName;
    
    //CONSTRUCTOR TO INITIALIZE THE FOLDER PATH AND BASE NAME OF INPUT FILE
    public InputFile(String folderPath,String baseName){
        this.folderPath = folderPath;
        this.baseName = baseName;
        
        //TO GET THE NO OF INPUT FILE IN A FOLDER
        folder = new File(folderPath);
        listOfFiles = folder.listFiles();
    }
    
    //RETURN THE SIZE OF A SPECIFIC FILE
    public long getSize(int index){    
        long size=listOfFiles[index].length();
        return size;
    }
    
    //RETURNS THE COMPLETE INPUT FILE URL
    public String getFileName(int index){
        String fileName=listOfFiles[index].getName();
        return folderPath+fileName;
    } 
    
    //READ THE FILE AND CONVERT IT TO STRING
    public String readFile(int index) throws IOException{
        String fileName = getFileName(index); 
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return content;
    }
    
    //RETURN THE NO OF FILES IN A FOLDER
    public int getNoOfFiles(){
        int fileCount=0;
        File file = new File(folderPath);
        fileCount=file.listFiles().length;
        return fileCount;
    }
}
