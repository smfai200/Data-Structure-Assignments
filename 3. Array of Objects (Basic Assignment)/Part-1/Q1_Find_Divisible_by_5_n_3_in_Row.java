package assigment_1;

public class Q1_Find_Divisible_by_5_n_3_in_Row {

	public static void main(String[] args) {
		
		int arr[][] = {
				{34,56,15,33,30},
				{60,35,67,23,54},
				{67,54,75,76,90},
				{56,78,14,79,30},
				 };
		//FINDING DIVISIBLE BY 5 AND 3 IN EACH ROW
		
		for(int i = 0 ; i < 4 ; i++)
		{
			System.out.println("Divible by 5 and 3 in Row " + (i+1) + " is " );
			for( int j = 0 ; j < 5 ; j++)
			{
				if(arr[i][j] % 3 == 0  && arr[i][j] % 5 == 0 )
				{
					System.out.println( arr[i][j]);	
				}
			}
			
			
		}
	
		
		
				
		
		
	}

}
