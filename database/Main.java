/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author avik
 */
public class Main {
    
    public static void main(String args[]) throws SQLException
    {
        Connection conn=ConnectionJDBC.connectDataBase();
        System.out.println("Database connected");
        
        Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        
        ResultSet result= stmt.executeQuery("SELECT * FROM device");
        
        while(result.next())
        {
            System.out.println();
            System.out.print(result.getInt("deviceId")+ "\t"+result.getString("deviceName"));
        }
   
    }
}