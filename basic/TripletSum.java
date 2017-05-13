/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import sort.MergeSort;

/**
 *
 * @author avik
 */
public class TripletSum {
    
        
    public static void main(String args[])
    {
        int[] a={-8,6,4,9,1};
        int sum=19;
        int up=0;
        int down=a.length-1;
        int mid=a.length-2;
        int sumVal=0;
        
        MergeSort mergeSort=new MergeSort();
        mergeSort.mergeSort(a, 0, a.length-1);
        while(up<down)
        {
            if(up==mid)
            {
                mid=down-1;
                down--;
            }
            sumVal=a[up]+a[mid]+a[down];
            if(sumVal==sum){
               System.out.println("Pair : "+a[up]+","+a[mid]+","+a[down]);
               mid--;
            }
            else if(sumVal>sum)
            {
                mid--;
            }
            else if(sumVal<sum)
                up++;
        }        
        
    }
    
    
}
