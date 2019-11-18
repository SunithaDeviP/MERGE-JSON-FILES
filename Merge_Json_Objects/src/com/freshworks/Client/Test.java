package com.freshworks.Client;

import com.freshworks.HelperUtility.HelperClass;
import com.freshworks.InputUtility.InputFile;
import com.freshworks.OutputUtility.OutputFile;
import java.util.Scanner;

/*NOTE :
  -  PLEASE COMMENT THE SCANNER SECTION TO GET THE DEFAULT RESULT

  -  SAMPLE INPUT FILES ARE IN THE PACKAGE  src/com/freshworks/JsonFiles/
    
  -  IF JSON INPUT FILE FOLDER IS OUTSIDE THE PACKAGE
            EXPECTED INPUT FOLDER PATH FORMAT :    C:/Users/DELL/Desktop/jsonFiles/

  -  IF JSON INPUT FILE FOLDER IS INSIDE THE PACKAGE 
            EXPECTED INPUT FOLDER PATH FORMAT :   src/com/freshworks/JsonFiles/
*/

public class Test {     
    public static void main(String[] args)throws Exception{
        
        //DEFAULT VALUES PROVIDED TO GET THE SAMPLE EXAMPLE RESULT 
        String folderPath="src/com/freshworks/JsonFiles/";
        String inputFileBaseName="json";
        String outputFileBaseName="out";
        int maxFileSize=1000;  
                 
        //PLEASE COMMENT THIS SCANNER SECTION TO GET THE SAMPLE OUTPUT RESULT
        
        //---> SCANNER SECTION STARTS 
        Scanner in = new Scanner(System.in);
        System.out.println("ENTER THE FOLDER PATH (please enter the symbol  /  at the end of the path):  ");
        folderPath = in.nextLine();
        System.out.println("ENTER THE INPUT FILE BASE NAME :  ");
        inputFileBaseName = in.nextLine();
        System.out.println("ENTER THE OUTPUT FILE BASE NAME :  ");
        outputFileBaseName =in.nextLine();
        System.out.println("ENTER THE MAX FILE SIZE : ");
        maxFileSize = in.nextInt();
        //<--- SCANNER SECTION ENDS
        
        //CREATING OBJECTS FOR THE INPUT, OUTPUT, AND HELPER UTILITY CLASSES 
        HelperClass helper = new HelperClass();
        InputFile input = new InputFile(folderPath,inputFileBaseName);
        OutputFile output = new OutputFile(folderPath,outputFileBaseName,input.getNoOfFiles());
        
        //INITIALISING THE INPUT AND OUTPUT FILE NAME SUFFIX
        int outputSuffix = 1;
        int inputSuffix = 0;
        
        //INITIALISING THE INPUT AND OUTPUT FILE SIZE
        long outputFileSize = 0;
        long inputFileSize = 0;
        long size =0;
       
        //INPUT FILE LENGTH CONSIST OF ONLY THE NO OF INPUT FILES IN THEE SPECIFIED FOLDER 
        int inputFileLength = input.getNoOfFiles();
       
        /*NOTE :
            LOGIC:-
                //INITIAL SETUP 
                STEP1 : CREATE A OUTPUT FILE
                STEP2 : COPY THE FIRST FILE CONTENT TO THE OUTPUT FILE
                STEP3 : INCREMENT THE INPUTSUFFIX
        
                //LOOPING 
                WHILE ( THE NO OF INPUT FILES IN THE FOLDER)
                    DO
                        IF (INPUT_FILE_SIZE + OUTPUT_FILE_SIZE  <  MAX_FILE_SIZE) 
                           MERGE(INPUT_FILE,OUTPUT_FILE)
                        ELSE
                            INCREMENT THE OUTPUT SUFFIX
                            GENERATE THE NEW OUTPUT FILE 
                            COPY THE CURRENT INPUT_FILE TO NEWLY CREATED OUTPUT FILE
                            INCREMENT THE INPUT SUFFIX
                            MERGE(INPUT_FILE,OUTPUT_FILE)
                    INCREMENT THE INPUTSUFFIX
                END WHILE
        */
        
        //INITIAL SETUP
        String inputFileName= input.getFileName(inputSuffix);
        String outputFileName=output.getFileName(outputSuffix);
        output.copyContents(inputFileName, outputFileName);
        inputSuffix++;
        
        //LOOPING
         while(inputSuffix<inputFileLength){
             
             inputFileSize = input.getSize(inputSuffix);
             outputFileSize= output.getSize(outputSuffix);
             size = inputFileSize+outputFileSize;
            
             if((size<maxFileSize) &&(inputSuffix<inputFileLength)){    
                inputFileName= input.getFileName(inputSuffix);
                outputFileName=output.getFileName(outputSuffix);
                helper.merge( outputFileName,inputFileName);
             }
             else{
                 outputSuffix++;
                 inputFileName= input.getFileName(inputSuffix);
                 outputFileName=output.getFileName(outputSuffix);
                 output.copyContents(inputFileName, outputFileName);
                 inputSuffix++;
                   
                 if(inputSuffix<inputFileLength){
                   inputFileName= input.getFileName(inputSuffix);
                   helper.merge( outputFileName,inputFileName);
                   }
             } 
             inputSuffix++;
         }
         
         System.out.println("INPUT FILES MERGED SUCCESSFULLY!!!");
    }
}
