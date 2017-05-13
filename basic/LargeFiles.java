/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author avik
 */
public class LargeFiles implements Runnable {

    private HashMap<String, Integer> occurence;
    private HashMap<String, Integer> occurenceMap;
    private int length;
    private int startIndex;
    private String fileName;
    
    LargeFiles(String fileName,int startIndex,int endIndex,HashMap<String, Integer> occurenceMap)
    {
        this.fileName=fileName;
        occurence=new HashMap<String, Integer>();
        this.length=endIndex;
        this.startIndex=startIndex;
        this.occurenceMap=occurenceMap;
        
    }
    
    public HashMap<String, Integer> getOccurenceMap()
    {
        return occurence;
    }

    @Override
    public void run() {
        
        StringBuilder word=new StringBuilder("");
        int len=0;
        try {
            len=length-startIndex+1;
            BufferedReader bb = new BufferedReader(new FileReader(fileName));
            bb.skip(startIndex);        
            char[] cbuf = new char[len];
           // System.out.println("**StartIndex "+startIndex+"Len "+len);
            bb.read(cbuf,0,len);
            
            for(int i=0;i<len;i++)
            {
                if((cbuf[i]>=65 && cbuf[i]<=90))
                    word.append((char)(cbuf[i]+32));
                else if(cbuf[i]>=97 && cbuf[i]<=122)
                    word.append(cbuf[i]);
                else{
                if(!word.toString().equals(""))
                {
                    if(!occurence.containsKey(word.toString()))
                        occurence.put(word.toString(), Integer.valueOf(1));
                    else
                    {
                        occurence.replace(word.toString(), occurence.get(word.toString()).intValue()+1);
                 
                    }
                           word=new StringBuilder("");
                }
                }
            }
            
            Map.Entry next;
            Set map = occurence.entrySet();
            //String next="";
            Iterator itr= map.iterator();
            synchronized(this) {
            while(itr.hasNext())
            {
                next=(Map.Entry)itr.next();    
                //System.out.println(Thread.currentThread().getId()+" Map "+next.getKey()+" Count: "+next.getValue());
                if(!occurenceMap.containsKey(next.getKey()))
                        occurenceMap.put((String)next.getKey(), Integer.valueOf(occurence.get(next.getKey()).intValue()));
                else
                        occurenceMap.replace((String)next.getKey(), occurence.get((String)next.getKey()).intValue()+occurenceMap.get((String)next.getKey()).intValue());
                
            }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LargeFiles.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LargeFiles.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
