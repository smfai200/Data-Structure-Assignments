package assigment_1;

public class Q2_Find_neg_no_sum_and_large_in_each_Row_nd_Col {

	public static void main(String[] args) {
		
		int arr[][] = {
				{-34, 56, 20, 33,-18},
				{89,  35, 67,-2,- 54},
				{44,  -10, 56,-76, 90},
				{-56, 78,-14, 79, 11},
				{-10, 78,-18, 79, 11}
					 };
		int sum1=0 , sum2=0;
		int Row_Large=0;
		int Col_Large =0 , j;
		
		for(int i = 0 ; i < 5 ; i++)
		{
		sum1=0;
		
		for( j = 0 ; j < 5 ; j++)
		{
		
		if(arr[i][j]<0)
		{
		
			sum1 += arr[i][j];
			Row_Large = arr[i][j];
			if(arr[i][j]>Row_Large)
			{
				Row_Large = arr[i][j];	
			}
			
		
		}
		}
		System.out.println("Sum of Row "+(i+1)+" Negative Numbers Are " + sum1);
		System.out.println("Large Negative Number of Row "+(i+1)+" is " + Row_Large);
		
		System.out.println("------------------------------------------------------");
		}
		
		System.out.println("==================================================");
		
		for(int i = 0 ; i < 5 ; i++)
		{
		sum2=0;
		for(  j = 0 ; j < 5 ; j++)
		{
		if(arr[j][i]<0)
		{
			Col_Large = arr[j][i];
			if(arr[j][i]>Col_Large)
			{
				Col_Large = arr[j][i];
			}
		sum2 += arr[j][i];
		
		}
		}
		System.out.println("Sum of Column "+(i+1)+" Negative Numbers Are " + sum2);
		System.out.println("Large Negative Number of Column "+(i+1)+" is " + Col_Large);
		System.out.println("------------------------------------------------------");
		
		}
	}
}
