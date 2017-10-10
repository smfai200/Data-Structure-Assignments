package assigment_1;

public class Q6_Find_Multiplication {

	public static void main(String[] args) {
		
		int a[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
		};
		
		int b[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
		};
		
		int mult[][] = new int[3][3];
		
		
		System.out.println("Multiplication of Matrices is...");
        for (int i = 0; i <3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
            
                for (int k = 0; k < 3; k++)
                {
                	mult[i][j] = mult[i][j] + a[i][k] * b[k][j];
                }
                }
                }
        
        
        
        System.out.println("The product is:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(mult[i][j] + " ");
            }
            System.out.println();
        }

	}

}
