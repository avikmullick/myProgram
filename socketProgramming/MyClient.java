/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketProgramming;

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
public class MyClient {
    
    public static void main(String args[])
    {
        try{
            //TCPIP
            Socket ss=new Socket("localhost",6666);
            String str="",str1="";
            DataInputStream dis=new DataInputStream(ss.getInputStream());
            DataOutputStream dout=new DataOutputStream(ss.getOutputStream());
            BufferedReader w=new BufferedReader(new InputStreamReader(System.in));
            
            while(!str.equals("stop"))
            {
               str=w.readLine();
               dout.writeUTF(str);
               dout.flush();
               str1=dis.readUTF();
               System.out.println("Server Says :"+str1);
            }
            
            dout.close();
            dis.close();
            w.close();
            ss.close();
            
        }catch(Exception e)
        {
            System.out.println("Exception :"+e.getMessage());
        }
    }
    
}

