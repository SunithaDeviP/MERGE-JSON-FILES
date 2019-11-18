# MERGE-JSON-FILES
Assignment1 : Merge Json files 

TO RUN THE PROJECT IN COMMAND PROMPT (WINDOWS) :

  1) Open the command prompt
  
  2) Move to the folder where project is located
        cd C:\Users\DELL\Desktop\Merge_Json_Objects
        
  3)  TO RUN THE PROJECT 
        java -jar Merge_Json_Objects.jar
  
  4)  INPUT THE FOLDER PATH WHERE THE INPUT JSON FILES LOCATED
        (FORMAT): C:\Users\DELL\Desktop\JsonFiles\
  
  5)  INPUT FILE BASE NAME (FORMAT): json
  
  6)  OUTPUT FILE BASE NAME (FORMAT): out
  
  7)  MAXIMUM INPUT FILE SIZE BYTES(FORMAT): 1000
  
  8)  FILES MERGED SUCCESSFULLY
  
NON FUNCTIONAL REQUIREMENTS :
ALGORITHM:

<------LOGIC : TO READ AND WRITE THE JSON FOLDER------>
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
            
<------LOGIC : MERGE JSON OBJECTS------>

         STEP1 : CREATE A NEW JSON OBJECT TO STORE THE RESULT OF MERGE
         STEP2 : COPY JSON1 TO MERGED JSON
         STEP3 : LOOPING 
 
                LOOP (UNTIL THERE ARE ANY KEY IN THE JSON2 OBJECT)
                COPY THE KEY VALUES TO THE STRING
                CONVERT THE STRING TO JSONARRAY OBJECT
                      LOOP(UNTIL THERE ARE ANY OBJECTS IN THE JSONARRAY)
                            APPEND THE OBJECT THE MERGED_JSON OBJECT
                      END LOOP
                END LOOP
<------ALGORITHM COMPLEXITY :------>

BEST CASE : O(n2) 
AVERAGE CASE : O(n2) 
WORST CASE : O(n2)
    
    
