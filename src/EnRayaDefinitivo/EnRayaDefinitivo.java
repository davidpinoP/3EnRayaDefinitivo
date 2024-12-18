package EnRayaDefinitivo;

import java.util.Random;
import java.util.Scanner;		
public class EnRayaDefinitivo {

		public static void main(String[] args) {
				// TODO Auto-generated method stub

				Scanner f = new Scanner(System.in); //creamos nuevo scanner
				
				String[] jugadores = new String[2]; //variable para los nombres de los jugadores
				char[][] fichas = new char[3][3]; //variable para el tablero
				int jugadorRandom = ((int)Math.random()*2); // variable para los jugadores random
				char[][] fichaColocada = new char[0][0]; //variable para la ficha que colocan los jugadores
				String revanchaJ1 = new String();
				String revanchaJ2 = new String();
				
				
				for (int i = 0; i < jugadores.length; i++) { //bucle for para introducir los nombres de los jugadores
					System.out.println("Jugador " + i + ", introduce tu nombre: ");//pregunta los nombres
					jugadores[i] = f.nextLine();//guarda los nombres en la variable de jugadores
				}
			
				do{	
				
				System.out.println("Lanzemos la moneda..."); //mensaje para empezar
				//mensaje para ver que jugador empieza de manera aleatoria
				System.out.println("Bien! empezará el jugador " + jugadorRandom + ", " + jugadores[jugadorRandom]);
				
				for (int i = 0; i < fichas.length; i++) { //bucle para que el tablero se vea completo con guiones bajos
					for (int j = 0; j < fichas[i].length; j++) {
						fichas[i][j] = '-';
						System.out.print(fichas[i][j]); //muestra el tablero
					}
					System.out.println();
				}
				
				     boolean hayGanador = false; // Creamos boolean para comprobar si alguien gana iniciado en falso
			    for (int turnos = 0; turnos < 9; turnos++) { // Máximo 9 turnos para llenar el tablero
		            System.out.println(jugadores[jugadorRandom] + ", " + "Introduce la fila en la que quieres poner la ficha: "); //mensaje para la fila
		            int fila = f.nextInt() - 1;  //guarda la fila en la variable fila
		            System.out.println(jugadores[jugadorRandom] + ", " + "Introduce la columna en la que quieres poner la ficha : "); //mensaje para la columna
		            int columna = f.nextInt() - 1; //guarda la columna en la variable columna

		            // Validar que la posición esté dentro del tablero y no esté ocupada
		            if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || fichas[fila][columna] != '-') { //parametros para mirar error
		                System.out.println("Error en la posición. Intenta de nuevo."); //mensaje de error
		                turnos--; // No contar el turno inválido
		                continue; //sigue con el codigo
		            }

		            // Colocamos la ficha del jugador que esta jugando en este momento
		            fichas[fila][columna] = (jugadorRandom == 0) ? 'x' : 'o'; //pone x para el jugador 0 y o para el jugador 1

		            // Mostramos el tablero actual con un bucle for
		            for (int i = 0; i < fichas.length; i++) {
		                for (int j = 0; j < fichas[i].length; j++) {
		                    System.out.print(fichas[i][j] + " ");
		                }
		                System.out.println();
		            }
		            
		       
		            //creammos un bucle para revisar las filas para ver si hay ganador o no
		              for (int i = 0; i < 3; i++) {
		            	  //mira que los huecos no esten vacios y mira hueco por hueco de cada fila comparando los caracteres
			            if (fichas[i][0] != '-' && fichas[i][0] == fichas[i][1] && fichas[i][1] == fichas[i][2]) {
			                hayGanador = true;
			            }
			        }

		            //creammos un bucle para revisar las columnas para ver si hay ganador o no
			        for (int i = 0; i < 3; i++) {
			        	 //mira que los huecos no esten vacios y mira hueco por hueco de cada columna comparando los caracteres
			            if (fichas[0][i] != '-' && fichas[0][i] == fichas[1][i] && fichas[1][i] == fichas[2][i]) {
			                hayGanador = true;
			            }
			        }

			        // Creamos un if para revisar las diagonales
			        //mira que los huecos no esten vacios y mira hueco por hueco de manera diagonal
			        if (fichas[0][0] != '-' && fichas[0][0] == fichas[1][1] && fichas[1][1] == fichas[2][2]) {
			            hayGanador = true;
			        }
			        if (fichas[0][2] != '-' && fichas[0][2] == fichas[1][1] && fichas[1][1] == fichas[2][0]) {
			            hayGanador = true;
			        }
			        
		            
		           //if para mostrar el mensaje si hay ganador y pedir la revancha
		            if (hayGanador){		            	
		            	System.out.println("Ha ganado el jugador: " + jugadorRandom +" " + jugadores[jugadorRandom]);
	            
		            	// pide la revancha a los dos jugadores						
								 System.out.println(jugadores[0] +", " + "Quieres revancha? (si/no)");		           
						            revanchaJ1 = f.next(); //guarda la respuesta en la variable
						            jugadorRandom = (jugadorRandom + 1) % 2;
						            System.out.println(jugadores[1] +", " + "Quieres revancha? (si/no");
						            revanchaJ2 = f.next();	//guarda la respuesta en la variable				
								
		            } else {
		            // Cambiar al siguiente jugador
		            jugadorRandom = (jugadorRandom + 1) % 2; //si no ha ganado ningun jugador aun pues se cambia
		            //de jugador para seguir jugando
		            }
		        }
			    //el bucle sigue mientras que los dos jugadores quieran revancha
				}while (revanchaJ1.contentEquals("si") && revanchaJ2.contentEquals("si"));
				//si alguno de los dos jugadores no quiere revancha se acaba el juego
				if (!revanchaJ1.contentEquals("si") || !revanchaJ2.contentEquals("si")){
		        System.out.println("¡Juego terminado!"); //mensaje de juego terminado
				}
									
	}

}
