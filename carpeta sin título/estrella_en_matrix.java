import java.util.Scanner;

// Dado un numero impar n, forma una matriz nxn y forma una estrella con asteriscos
class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        String[][] array = new String[n][n];
        
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
            	array[i][j] = ".";
            }
        }
        
        
        for (int i = n/2; i <= n/2; i++) {
            for (int j = 0; j < array.length; j++) {
            	array[i][j] = "*";
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            for (int j = n/2; j <= n/2; j++) {
            	array[i][j] = "*";
            }
        }
        
        int auxDiag1 = 0;
        for (int i = 0; i < array.length; i++) {
            array[i][auxDiag1] = "*";
            auxDiag1++;
        }
        
        int auxDiag2 = n -1;
        for (int i = 0; i < array.length; i++) {
            array[i][auxDiag2] = "*";
            auxDiag2--;
        }
        
       
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
       
	}
}