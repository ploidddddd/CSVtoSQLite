/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtosqlite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CSVtoSQLite {
    
    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here
       String path = "C:/Users/floyd/Documents/CSVtoSQLite/data1.csv";
       CSVLoader load = new CSVLoader();
       load.ReadFromCSV(path);
    }
    
}
