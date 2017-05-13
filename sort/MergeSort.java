/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author avik
 */
public class MergeSort {
       
    //Already Sorted left and right
    public void merging(int[] elements,int start,int middle,int end)
    {
        int left,right,indexL=0,indexR=0;
        int[] leftElements,rightElements;
        
        left=(middle-start)+1;
        right=end - middle;
        
        leftElements=new int[left];
        rightElements=new int[right];
        
        for(int i=0;i<left;i++)
            leftElements[i]=elements[i+start];
        for(int i=0;i<right;i++)
            rightElements[i]=elements[i+(middle+1)];
        int i=start;
        
        while (indexL < left && indexR < right)
        {
            if(leftElements[indexL]<=rightElements[indexR])
                elements[i++]=leftElements[indexL++];
            else
                elements[i++]=rightElements[indexR++];
        }
        while(indexL<left)
            elements[i++]=leftElements[indexL++];
        while(indexR<right)
            elements[i++]=rightElements[indexR++];    
        
    }
    
    public void mergeSort(int[] elements,int start,int end)
    {
        int middle=(start+(end-1))/2;
        
        if(start<end)
        {
        mergeSort(elements,start,middle);
        mergeSort(elements,middle+1,end);
        merging(elements,start,middle,end);
        }
    }
    
    
    
}
