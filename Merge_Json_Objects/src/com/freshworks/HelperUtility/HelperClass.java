package com.freshworks.HelperUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONException;
import org.json.JSONObject;

public class HelperClass {
    
   String outputLocation ;
   String inputContent1;
   String inputContent2;
   
   //PERFORM MERGE OPERATION ON TWO FILES
   public void merge(String outputLocation,String inputLocation) throws IOException{
      
       //READ THE FILE AND CONVERT IT TO STRING
      inputContent1 = new String(Files.readAllBytes(Paths.get(outputLocation)));
      inputContent2 = new String(Files.readAllBytes(Paths.get(inputLocation)));
      //CREATING A JSON OBJECT
      JSONObject[] jsonObject = new JSONObject[2];
      
       //CONVERT STRING TO JSON OBJECT
       try {
           jsonObject[0] = new JSONObject(inputContent1);
           jsonObject[1] = new JSONObject(inputContent2);
       } catch (JSONException ex) {
           System.out.println("SORRY");
       }
       
       //MERGE THE TWO JSON OBJECTS
       String str = new String(mergeJSONObjects(jsonObject[0],jsonObject[1]).toString());
       //WRITE THE MERGED DATA TO THE FILE
       writeDataToFile(outputLocation,str);
  }  
  
  //WRITE THE MERGED DATA TO THE FILE
  public void writeDataToFile(String outputLocation,String Jsondata) throws FileNotFoundException, IOException{
    FileWriter fw = new FileWriter(outputLocation,false);
    FileReader fr = new FileReader(outputLocation);
    fw.write(Jsondata);
    fw.close(); 
  }
  
  /*
    MERGING JSON OBJECT LOGIC:
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
  */
  
  public static JSONObject mergeJSONObjects(JSONObject json1, JSONObject json2) {
    JSONObject mergedJSON = new JSONObject();
    try {
  	mergedJSON = new JSONObject(json1, JSONObject.getNames(json1));
        //ITERATE THROUGH THE KEY ELEMENTS
  	for (String crunchifyKey : JSONObject.getNames(json2)) {
                String str = new String( json2.get(crunchifyKey).toString());              
                JSONArray jss = new JSONArray(str);
                JSONObject newJ = new JSONObject(jss);
                //ITERATE THROUGH THE VALUES OF KEY ELEMENTS
                for(int i=0;i<jss.length();i++){
                    JSONObject js1 = jss.getJSONObject(i);
                    mergedJSON.append(crunchifyKey, js1);
                }
        } 
    } 
    catch (JSONException e) {
	throw new RuntimeException("JSON Exception" + e);
    }
    return mergedJSON; 
  }
}
