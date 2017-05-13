import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static HashMap<Integer,Integer> output;
    public static void main(String[] args) throws InterruptedException{
        
        
        HashMap<Character,ArrayList<String>> alphabets=new HashMap<Character,ArrayList<String>>(); 
        ArrayList<String> words=new ArrayList<String>(); 
        
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if(op.equals("add"))
            {
                   if(alphabets.containsKey(contact.charAt(0)))
                   {
                       words=new ArrayList<String>();
                       //alphabets.put(contact.charAt(0),words.add(contact));
                   }
                   else
                   {
                        alphabets.get(contact.charAt(0));
                   }
                       
            }
            
        }
        
        
        
        
        ChainChar root=new ChainChar('*');
        int count=0;
        ChainChar traverse=root;
        int i=0;

        
            ContactThread cc;
            Thread thd;
        
        ArrayList<Thread> threadsInput=new ArrayList<Thread>(); 
        ArrayList<Thread> threadsFind=new ArrayList<Thread>();
        output=new  HashMap<Integer,Integer>();
        int j=0;
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            traverse=root;
            count=0;
            boolean noMatch=false;
            
            
            if(op.equals("add"))
            {
                cc=new ContactThread(op,contact,root);
                thd=new Thread(cc);
                threadsInput.add(thd);
                thd.start();
            }
            else
            {
                Iterator<Thread> itr=threadsInput.iterator();
                while(itr.hasNext())
                    itr.next().join();
                
                cc=new ContactThread(op,contact,root);
                thd=new Thread(cc);
                thd.setName(String.valueOf(j++));
                threadsFind.add(thd);
               
                thd.start();

                
            }
        }
               Iterator<Thread> itr=threadsFind.iterator();
                while(itr.hasNext())
                    itr.next().join();
        
        for(int k=0;k<j;k++)
        {
            System.out.println(output.get(k).intValue());   
        }    
        
    }
}

class ContactThread implements Runnable
{
    String op;
    String contact;
    ChainChar root;
    
    ContactThread(String op,String contact,ChainChar root)
    {
        this.op=op;
        this.contact=contact;
        this.root=root;
    }
        @Override
    public void run() {
        
            ChainChar traverse=root;
            int count=0;
            boolean noMatch=false;
            if(op.equals("add"))
            {
                
                for(int i=0;i<contact.length();i++)
                        traverse=traverse.findAndAddChar(contact.charAt(i));
                traverse.word=true;
            }
            else  if(op.equals("find")){
        
                for(int i=0;i<contact.length();i++)
                {
                        traverse=traverse.findChar(contact.charAt(i));
                        if(traverse==null)
                        {
                            noMatch=true;
                            count=0;
                            break;
                        }
                }
                if(!noMatch)
                    count=traverse.countChar(traverse,0);
                //System.out.println("COUNT "+count);
                synchronized(this){
                    //System.out.println("COUNT "+count);
                    Solution.output.put(Integer.valueOf(Thread.currentThread().getName()),count);
                }
            }
        
    }
}


class ChainChar
{
    char ch;
    HashMap<Character,ChainChar> chList;
    boolean word;
    
    ChainChar(char ch)
    {
        word=false;
        this.ch=ch;
        chList=new HashMap<Character,ChainChar>();
    }
    
    
    ChainChar findAndAddChar(char chr)
    {
        if(!chList.containsKey(chr))
            chList.put(chr,new ChainChar(chr));      
        return chList.get(chr);
    }
    
    ChainChar findChar(char chr)
    {
        if(chList.containsKey(chr))       
            return chList.get(chr);
        
        return null;
    }
    
    int countChar(ChainChar cList,int count)
    {
        ChainChar nextList;
        int size=cList.chList.size();
                
        if(cList.word)
            count+=1;

        if(size == 0)
            return count;
        
        Map.Entry next;
        Iterator itr=cList.chList.entrySet().iterator();
        while(itr.hasNext())
        {
            next=(Map.Entry)itr.next();
            nextList=(ChainChar)next.getValue();
            count=countChar(nextList,count);
        }
        return count;
    }
    

    
}

