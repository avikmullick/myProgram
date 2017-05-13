/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author avik
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        
        HashMap<String, Integer> occurenceMap;
        occurenceMap=new HashMap<String, Integer>();
        
        String fileName="phrack.29.phk";
        ArrayList<Thread> arrayList=new ArrayList<Thread>();
        int threads=8,actThrd=0,i=0;
        int size,start=0,end=0;
        FileInputStream fileStream=new FileInputStream(fileName);
        
        LargeFiles largeFiles;
        Thread thd = null;
        size=fileStream.available();
        if(size>0)
        {
            end=size/threads;
            for(i=0;i<threads;i++){
                
                end=(start+end)<size?start+end:size;
                if(start>end) break;
                //System.out.println("File Name "+fileName+"start "+start+"end "+end+" Size "+size);
                largeFiles=new LargeFiles(fileName, start, end,occurenceMap);
                thd=new Thread(largeFiles);
                arrayList.add(thd);
                thd.start();
                start=end+1;
            }
            System.out.println("No of threads "+i);
            for(int j=0;j<arrayList.size();j++)
            {
                arrayList.get(j).join();
            }
            
            Map.Entry next;
            Set map = occurenceMap.entrySet();
            //String next="";
            Iterator itr= map.iterator();
            while(itr.hasNext())
            {
                next=(Map.Entry)itr.next();    
                System.out.println(Thread.currentThread().getId()+" Main Map "+next.getKey()+" Count: "+next.getValue());
            }
            
            
        }      
    }
    
}
