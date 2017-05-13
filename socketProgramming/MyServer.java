/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketProgramming;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author avik
 */
public class MyServer {
    
    public static void main(String args[])
    {
        try{
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept(); //establishing connection For each request there will be different socket
            String str="",str1="";
            
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            BufferedReader w=new BufferedReader(new InputStreamReader(System.in));
            
            while(!str.equals("stop"))
            {
               str=dis.readUTF();
               System.out.println("Client Says :"+str);
               str1=w.readLine();
               dout.writeUTF(str1);
               dout.flush();
            }
            
            dout.close();
            dis.close();
            s.close();
            ss.close();
            
        }catch(Exception e)
        {
            System.out.println("Exception :"+e.getMessage());
        }
    }
    
}
