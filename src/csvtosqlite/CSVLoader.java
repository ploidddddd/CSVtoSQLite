/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtosqlite;

import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class CSVLoader {
  
    public static void ReadFromCSV(String csvFile) throws IOException, SQLException {
        CSVLoader csvLoad = new CSVLoader();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        boolean HeadRowExists = true;
        boolean bol = false;
        int AcceptedNumberofColumns = 10;
        int IncorrectRecords = 0;
        String[] person = null;
        
        
        List<Person> PerList = new ArrayList<Person>();
        List<String[]> csvData = new ArrayList<String[]>();
        
        String[] header="A,B,C,D,E,F,G,H,I,J".split(",");
        csvData.add(header);
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            
            if(HeadRowExists){
                String HeadRow = br.readLine();
                
                if(HeadRow == null || HeadRow.isEmpty()){
                    throw new FileNotFoundException(
	        	"No columns defined in given CSV file." +
	        	"Please check the CSV file format.");
                }
            } 
            
            while((line = br.readLine()) != null ){
                person = line.split(cvsSplitBy);
                bol = csvLoad.isEmpty(person);
               
                if (bol != false){
                    if(person.length > 0 && person.length == AcceptedNumberofColumns){
                     Person per = new Person(person[0],person[1],person[2],person[3],
		                            person[4],person[5],person[6],Boolean.parseBoolean(person[7]),Boolean.parseBoolean(person[8]),person[9]);
		                    PerList.add(per);
                    }
                } else {
                    person = line.split(cvsSplitBy);
                    csvData.add(person);
                    
                    IncorrectRecords++;
                }
            } 
            csvLoad.LoadCSVtoDB(PerList);
            csvLoad.writeToCSV(csvData);
        }catch (FileNotFoundException e) {	
            e.printStackTrace();
        } catch (IOException e) {    
            e.printStackTrace();
        }
        int all = PerList.size() + IncorrectRecords;
        csvLoad.logFile(all, PerList.size(), IncorrectRecords);
                
//        System.out.println("Following are the statistics :\n#"+
//                            all+" of records received.\n#"+
//                            PerList.size()+" of records processed.\n#"+
//                            IncorrectRecords+" of records failed.");
    }
    
    
    
    private static void LoadCSVtoDB(List<Person> perlist) throws SQLException {
        try {
           SQLConnection sql = new SQLConnection();
           sql.connection();
            		
           
        
                        
            PreparedStatement stmt = sql.con.prepareStatement("insert into table1 (COL_A, COL_B, COL_C, COL_D, COL_E, COL_F, COL_G, COL_H, COL_I, COL_J) values (?,?,?,?,?,?,?,?,?,?)");
        
            for(Person p : perlist ) {
                stmt.setString(1, p.getfName());
                stmt.setString(2, p.getlName());
                stmt.setString(3, p.getGender());
                stmt.setString(4, p.getEmail());
                stmt.setString(5, p.getPicpath());
                stmt.setString(6, p.getAcct());
                stmt.setString(7, p.getSalary());
                stmt.setBoolean(8, p.getQ1());
                stmt.setBoolean(9, p.getQ2());
                stmt.setString(10, p.getCity());

                stmt.executeUpdate();
            }
        
        }catch(SQLException E){
            E.printStackTrace();
        }
           
    }
    
    public static boolean isEmpty(String[] S){
        int x = 0; 
        int len = S.length;
        boolean ret = true;
        
        while (x < len && ret == true){
            ret = (S[x].length() == 0)? false : true;
            x++;
        }
        
        return ret;
    }
    
    
    public static void writeToCSV(List<String[]> csvData) throws IOException{
        String path = "C:/Users/floyd/Documents/CSVtoSQLite/data-bad.csv";
        File file = new File(path);
        
        try {
            FileWriter outputfile = new FileWriter(file);
            
            BufferedWriter bwr = new BufferedWriter(outputfile);
            CSVWriter writer = new CSVWriter(outputfile);
           
            writer.writeAll(csvData);
          
            writer.close(); 
            System.out.println("CSV bad file created succesfully.");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    
    public static void logFile(int a, int b, int c){
        Logger logger = Logger.getLogger("CSVtoSQLite");
        FileHandler fh;
        String path = "C:/Users/floyd/Documents/CSVtoSQLite/csvlogs.log";
        try{
            fh = new FileHandler(path);  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  

   
            logger.info("Following are the statistics :\n#"+
                            a+" of records received.\n#"+
                            b+" of records processed.\n#"+
                            c+" of records failed.");  
            System.out.println("Log file created succesfully.");
        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
    
}
