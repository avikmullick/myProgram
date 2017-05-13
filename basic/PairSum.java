/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import sort.MergeSort;

/**
 *
 * @author avik
 */
public class PairSum {
    
    public static void main(String args[])
    {
        int[] a={-8,6,4,9,1};
        int sum=3;
        int up=0;
        int down=a.length-1;
        MergeSort mergeSort=new MergeSort();
        mergeSort.mergeSort(a, 0, a.length-1);
        while(up<down)
        {
            if(a[up]+a[down]==sum){
               System.out.println("Pair : "+a[up]+","+a[down]);
               down--;
            }
            else if(a[up]+a[down]>sum)
                down--;
            else if(a[up]+a[down]<sum)
                up++;
        }        
        
    }
    
}
