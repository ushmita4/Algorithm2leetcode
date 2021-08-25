public class Solution {
    int maxSize = Integer.MAX_VALUE;
    boolean isSumTrue(int []A,int size,int target)
    {
        int start = 0;
        int end = size;
        int n = A.length;
        long []prefix = new long [n+1];

        prefix[0] = 0;
        long sum = 0;
        for(int i = 1;i<=n;i++)
        {
            sum = sum+A[i-1];
            prefix[i] = sum;
        }
        long s = 0;
        while(end < n+1)
        {
            s= prefix[end] - prefix[start];
            if(s>=target)
            {
                return true;
            }
            end++;
            start++;
        }
        return false;
    }
    
    int bs(int start,int end,int []A,int target)
    {
        int index = -1;
        int mid = (start+end)/2;
        if(start>end)
        {
            if(maxSize == Integer.MAX_VALUE)
                maxSize = 0;
            return maxSize;
        }
            
        else if(isSumTrue(A,mid,target) == true)
        {
            maxSize = Math.min(mid,maxSize);
            index =  bs(start,mid-1,A,target);
        }
        else if (isSumTrue(A,mid,target) == false)
            index =  bs(mid+1,end,A,target);
        return index;
            
    }
    
    public int minSubArrayLen(int B,int[] A ) {
        int n = A.length;
        return bs(0,n,A,B);
    }
}
