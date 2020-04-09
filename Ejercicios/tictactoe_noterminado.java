import java.util.Scanner;

/* In this stage, you should analyze a Tic-Tac-Toe field. 

Note. In this stage either 'X' or 'O' can start the game.

After printing the field, you need to find the state in which the game is at the moment. Possible states:

"Game not finished" - when no side has a three in a row but the field has empty cells;
"Draw" - when no side has a three in a row and the field has no empty cells;
"X wins" - when the field has three X in a row;
"O wins" - when the field has three O in a row;
"Impossible" - when the field has three X in a row as well as three O in a row. Or the field has a lot more X's that O's or vice versa (if the difference is 2 or more, should be 1 or 0).
Also, you can use ' ' or '_' to print empty cells - it's up to you. 
input examples: 

Enter cells: XXXOO__O_
Enter cells: XOXOXOXXO

*/
class Main {

    static String inputUsuario;
    static char[][] array = new char[3][3];
    static int count = 0;
    static char[] auxArray = new char[3];
    static int countX = 0;
    static int countO = 0;
    static boolean isFoundEmpty = false;
    static char[] arrAux1 = new char[3];
    static char[] arrAux2 = new char[3];
    static char[] arrAux3 = new char[3];
	static boolean isTrue = false;
	static char winner = ' ';
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        
        
        inputUsuario = sc.next();
        
        dibujaMatriz();
        
        
        if(impossibleFilas()) {
        	
        } else if(impossibleColumnas()) {
        	
        } else if(revisaFilas()) {
        	
        } else if(revisaColumnas()) {
        	
        } else if(revisaDiagonal()) {
        	
        } else if(revisaDiagonalReves()) {       	
        	
        } else if(revisaEmpty()) {
        	
        } else {
        	System.out.println("Draw");       	
        }
        
    
    }
     
       



public static void dibujaMatriz() {
	for(int i = 0; i < 3; i++) {
    	for(int j = 0; j < 3; j++) {
    		array[i][j] = inputUsuario.charAt(count);
    		count ++;
    	}
    }
    
    System.out.println("---------");
    for(int i = 0; i < 3; i++) {
    	System.out.print("| ");
    	for(int j = 0; j < 3; j++) {
    		System.out.print(array[i][j] + " ");
    	}
    	System.out.println("|");
    }
    System.out.println("---------");
}



public static boolean impossibleFilas() {
	//Revisa las filas para ver si hay filas iguales que da resultado imposible
    
    for(int i = 0; i < 3; i++) {
    	for(int j = 0; j < 3; j++) {
    		if(i == 0) {
    			arrAux1[j] = array[i][j];
    		} else if(i == 1) {
    			arrAux2[j] = array[i][j];
    		} else {
    			arrAux3[j] = array[i][j];
    		}
    		
    		if(array[i][j] == 'X') {
    			countX++;
    			
    		} else if (array[i][j] == 'O') {
    			countO++;
    		}
    		
    	}
    }
    
    if( (countX - countO >= 2) || (countO - countX >= 2) ) {
    	System.out.println("Impossible");  
    	return true;
    } else if( ((arrAux1[0] == arrAux1[1] && arrAux1[1] == arrAux1[2])  &&  
                (arrAux2[0] == arrAux2[1] && arrAux2[1] == arrAux2[2]))  ||
               ((arrAux2[0] == arrAux2[1] && arrAux2[1] == arrAux2[2])  &&
                (arrAux3[0] == arrAux3[1] && arrAux3[1] == arrAux3[2])) ) {
    	
    	System.out.println("Impossible");  
    	return true;
    }
    return false;
}



public static boolean impossibleColumnas() {
	
	//Revisa las columnas para ver si hay columnas iguales que da resultado imposible
	for(int i = 0; i < 3; i++) {
		for(int j = 0; j < 3; j++) {
			if(i == 0) {
				arrAux1[j] = array[j][i];
			} else if(i == 1) {
				arrAux2[j] = array[j][i];
			} else {
				arrAux3[j] = array[j][i];
			}
			
		}
	}

	if( ((arrAux1[0] == arrAux1[1] && arrAux1[1] == arrAux1[2])  &&  
	    (arrAux2[0] == arrAux2[1] && arrAux2[1] == arrAux2[2]))  ||
	    ((arrAux2[0] == arrAux2[1] && arrAux2[1] == arrAux2[2])  &&
	    (arrAux3[0] == arrAux3[1] && arrAux3[1] == arrAux3[2])) ) {
		
		System.out.println("Impossible");  
		return true;
	}
	
	return false;
}


public static boolean revisaFilas() {
	//Revisar filas
    for(int i = 0; i < 3; i ++) {
    	for(int j = 0; j < 3; j++) {
        	auxArray[j] = array[i][j];
        }
    	
    	if(auxArray[0] == auxArray[1] && auxArray[1] == auxArray[2]) {
    		System.out.println(auxArray[0] + " Wins");
    		winner = auxArray[0];
    		return true;
    	}
    }
    return false;
}


public static boolean revisaColumnas() {
	//Revisar columnas
    for(int i = 0; i < 3; i ++) {
    	for(int j = 0; j < 3; j++) {
        	auxArray[j] = array[j][i];
        }
    	
    	if(auxArray[0] == auxArray[1] && auxArray[1] == auxArray[2]) {
    		System.out.println(auxArray[0] + " Wins");
    		winner = auxArray[0];
    		return true;
    	}
    }
    return false;
}


public static boolean revisaDiagonal() {
	//Diagonal normal
    count = 0;
    for(int j = 0; j < 3; j++) {
    	auxArray[count] = array[count][j];
    	count++;
    }
    
    if(auxArray[0] == auxArray[1] && auxArray[1] == auxArray[2]) {
    	System.out.println(auxArray[0] + " Wins");
    	winner = auxArray[0];
		return true;
    	
    }
    return false;
}


public static boolean revisaDiagonalReves() {
	//Diagonal reversa
    count = 0;
    for(int j = 2; j >= 0; j--) {
    	auxArray[count] = array[count][j];
    	count++;
    }
    
    if(auxArray[0] == auxArray[1] && auxArray[1] == auxArray[2]) {
    	System.out.println(auxArray[0] + " Wins");
    	winner = auxArray[0];
		return true;
    	
    }
    return false;
}


public static boolean revisaEmpty() {
	 //Revisa si hay empty cells para game not finished, y si no entonces es Draw.
      for(int i = 0; i < 3; i ++) {
      	for(int j = 0; j < 3; j++) {
          	if(array[i][j] == ' ' || array[i][j] == '_') {
          		System.out.println("Game not finished");
          		isFoundEmpty = true;
          		return true;
          }
        }
      	if(isFoundEmpty) {
      		return true;
      	}

      }
      
      return false;
  }
}