package edu.ilstu.app;

import edu.ilstu.app.StudentInformation;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OutputAdapter {
        
        ArrayList<String> keys = new ArrayList<>();
        
        public OutputAdapter()
        {
                    
        }
        
	public void exportData(List<StudentInformation> data){
		// TODO: Export
                
	}
        
        // Accepts ArrayList from other file for use here
        public ArrayList getArrayList(ArrayList CSVList)
        {
            keys = CSVList;
            return keys;
        }
        
        // Asks for a file name from the user and saves it
        public void askFile()
        {
            Scanner myIn = new Scanner(System.in);
            
            System.out.println("Please print file name.");
            String file = myIn.next();
            
            String myFile = System.getProperty("user.home") + "/Documents/" + file + ".csv";
            saveToCSV(myFile);
            System.out.println("File " + file + " saved to Documents folder.");
            
        }
        
        public void saveToCSV(String FileName)
        {
            
            try
            {
                // Use other class to input a Export.saveToCSV (~name of file~)
                FileWriter writing = new FileWriter(FileName);
                
                for(int i = 0; i < keys.size(); i++)
                {
                    writing.append(keys.get(i));
                    writing.append(',');
                }
                
                writing.flush();
                writing.close();
                
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
}
