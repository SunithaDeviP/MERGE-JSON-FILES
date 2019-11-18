package com.freshworks.OutputUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputFile {
        
    private String folderPath;
    private String baseName;
    private String extension = ".json"; 
   
    //CONSTRUCTOR TO INITIALIZE THE FOLDER_PATH AND BASE_NAME 
    public OutputFile(String folderName, String baseName,int noOfFiles){
      this.folderPath = folderName;
      this.baseName = baseName;
      
       //CHECK IF THERE ALREADY EXISTS ANY OUTPUT FILE
       //IF EXISTS DELETE THAT FILE
       int suffix =1; 
       File f = null;
       while(noOfFiles!=0){
         f= new File(folderPath+baseName+suffix+extension);
         if(f.exists()){
             f.delete();
         }
         else{
             break;
         }
         suffix++;
         noOfFiles--;
       }
    }

    //RETURNS THE SIZE OF OUTPUT FILE    
     public long getSize(int index){
        long size=0;
        String fileName =folderPath+baseName+index+extension;
        File temp = new File(fileName);
        size =temp.length();
        return size;
    }
     
    //RETURNS THE OUTPUT_FILE URL      
     public String getFileName(int index){
        String fileName=folderPath+baseName+index+extension; 
        return fileName;
    } 

    //COPY THE CONTENTS OF ONE FILE TO ANOTHER FILE
    public void copyContents(String inputFileLocation,String outputFileLocation) throws FileNotFoundException, IOException{
      FileOutputStream fos = new FileOutputStream(outputFileLocation);
      FileInputStream fis = new FileInputStream(inputFileLocation);
      int b;
      while((b=fis.read())!=-1){
            fos.write(b);
       }
       fos.close();
       fis.close();
    }
}
