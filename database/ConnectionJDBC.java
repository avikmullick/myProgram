/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author avik
 */
public class ConnectionJDBC {
    
     private static Connection con;
     
    public static Connection connectDataBase()
    {
                
        try{
        String userName,password,url;
        FileInputStream connFile=new FileInputStream("DB.properties");
        Properties p=new Properties();
        p.load(connFile);
        userName=p.getProperty("userName");
        password=p.getProperty("password");
        url=p.getProperty("uri");
         if(con==null)   
            con= DriverManager.getConnection(url,userName,password);
        }
        catch(SQLException e)
        {
            System.out.println("Exception caught for connection : "+e.getMessage());
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found : "+e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("IO Exception : "+e.getMessage());
        }
        
        return con;
    }
    
}
