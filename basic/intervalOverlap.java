/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author avik
 */
public class intervalOverlap {
    
    ArrayList<Interval> intervalList;
    
    intervalOverlap(ArrayList<Interval> intervalList)
    {
        this.intervalList=intervalList;
    }
    

    
    public boolean intervalCalc()
    {
        boolean overLap=false;
        Interval prev=null,next=null;
        System.out.println("Before :"+intervalList);
        Collections.sort(intervalList);
        
        System.out.println("After :"+intervalList);
        Iterator<Interval> itr=intervalList.iterator();
        if(itr.hasNext())
            prev=itr.next();
        while(itr.hasNext())
        {
            next=itr.next();
            if(next.getStartNbr()<=prev.getEndNbr())
            {
                overLap=true;
                break;
            }
                
            prev=next;
        }
        return overLap;
        
    }
    
}

    class Interval implements Comparable<Interval>
    {
        private int startNbr;
        private int endNbr;
        
        Interval(int sNbr,int eNbr)
        {
            startNbr=sNbr;
            endNbr=eNbr;
        }
        
        public int getStartNbr()
        {
            return startNbr;
        }
        public int getEndNbr()
        {
            return endNbr;
        }

    @Override
    public int compareTo(Interval o) {
        if(startNbr>o.startNbr)
            return 1;
        else if(startNbr<o.startNbr)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "{" + "" + startNbr + ", " + endNbr + '}';
    }
    
    
        
    }
