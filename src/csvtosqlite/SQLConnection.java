/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtosqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SQLConnection {
    public Connection con;
    public Statement   st;
    
    
    public Statement connection(){
        try {
            //Class.forName("orig.sqlite.JBDC");
            String url = "jdbc:sqlite:csvtosqlite.db";
            con = DriverManager.getConnection(url);
            st  = con.createStatement();
            System.out.println("Connected Succesfully...");
        }catch(Exception ex){
            System.out.println("Connection Failed...");
        }
        
        return st;
    }

  
 
}
