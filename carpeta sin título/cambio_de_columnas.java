import java.util.Scanner;

// Recibe n y m para formar una matriz y luego cambia las columnas que le indiques.
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        
        int[][] array = new int[row][col];
        int  aux1;
        int aux2;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length + (col - row); j++) {
            	array[i][j] = sc.nextInt();
            }
        }
        
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length + (col - row); j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        
        int colSwap1 = sc.nextInt();
        int colSwap2 = sc.nextInt();
        
        for(int i = 0; i < row; i++) {
        	aux1 = array[i][colSwap1];
        	aux2 = array[i][colSwap2];
        	
        	array[i][colSwap1] = aux2;
        	array[i][colSwap2] = aux1;
        }
        
        System.out.println();
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length + (col - row); j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        
        

	}
}