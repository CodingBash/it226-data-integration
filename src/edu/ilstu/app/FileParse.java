package edu.ilstu.app;

//import static csv.CSV.CSVtoArrayList;
import edu.ilstu.app.InputObject;
import edu.ilstu.app.StudentInformation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParse {
	public List<StudentInformation> readData(InputObject input) {
		return null;
	}
//          String file = "380-Fall-2002";
//          String myStr = System.getProperty("user.home") + "/Documents/" + file + ".csv";
        
        public void buffRead(String CSVFile)
        {
            BufferedReader buff = null;
		
                
		try 
                {
			String line;
                        // Not sure if there's a better way to throw in all 3
			buff = new BufferedReader(new FileReader(CSVFile));
			
			while ((line = buff.readLine()) != null) 
                        {       
                                // Data as ArrayList
				System.out.println("Converted data: " + CSVList(line) + "\n");
			}
			
		} catch (IOException e) 
                {
			e.printStackTrace();
		} finally 
                {
			try 
                        {
				if (buff != null) buff.close();
			} catch (IOException ex) 
                        {
				ex.printStackTrace();
			}
		}
        }
        
        // Converts CSV to ArrayList
	public ArrayList<String> CSVList(String CSV) 
        {
		ArrayList<String> result = new ArrayList<String>();
		
		if (CSV != null) 
                {
                        // Uses split to read CSV
			String[] splitData = CSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) 
                        {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) 
                                {
					result.add(splitData[i].trim());
				}
			}
		}
		
		return result;
	}
}
