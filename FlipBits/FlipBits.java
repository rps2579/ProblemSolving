package FlipBits;

import java.util.*;

public class FlipBits {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int count=0;
        int count1=0;
        int result=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]==1 ) 
                count=0;
            else
            {
                count++;
                result = Math.max(result, count);
            }
                
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]==1)
            {
                count1++;
            }
        }
        System.out.println(result+count1);

        sc.close();
    }
}
