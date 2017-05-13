/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicProgramming;

/**
 * Uses bottom Up appraoch
 * Decesion Problem
 * @author avik
 */
public class SubsetSum {
    
    private boolean[][] subsetTable;
    private int[] set;
    private int maxSum;
    private int setSize;
    SubsetSum(int[] set,int maxSum)
    {
        this.set=set;
        this.maxSum=maxSum+1;
        setSize=set.length+1;
        subsetTable=new boolean[setSize][this.maxSum];
    }

    public void print() {
        
        int i,j;
        for(i=0;i<setSize;i++)
        {
            for(j=0;j<maxSum;j++)
            {
                System.out.print("\t"+subsetTable[i][j]);
            }
            System.out.println();
        }
    }
    
    
    
    public boolean calcSubsetSum()
    {
        int i,j;
        subsetTable[0][0]= true;
        //maxSum=0
        for(i=1;i<maxSum;i++)
            subsetTable[0][i]=false;
        //maxSum!=0, i=0
        for(i=1;i<setSize;i++)
        {
            subsetTable[i][0]=true;
        }
        
        for(i=1;i<setSize;i++)
        {
            for(j=1;j<maxSum;j++)
            {
                if(j<set[i-1])
                  subsetTable[i][j]=subsetTable[i-1][j];
                else
                  subsetTable[i][j]=subsetTable[i-1][j-set[i-1]] || subsetTable[i-1][j];
            }
        }
        return subsetTable[setSize-1][maxSum-1];
    }
}

class Main
{
    public static void main(String args[])
    {
        int[] set={6,3,2,1};
        SubsetSum ss=new SubsetSum(set,1);
        
        System.out.println("Subset Sum Exists: "+ss.calcSubsetSum());
        
        ss.print();
        
    }
}
