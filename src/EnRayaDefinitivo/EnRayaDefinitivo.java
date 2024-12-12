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
				
				 boolean hayGanador = false; // Para comprobar si alguien gana	
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

		            // Cambiar al siguiente jugador
		            jugadorRandom = (jugadorRandom + 1) % 2;
		           
		            
		            for (int i = 0; i < fichas.length; i++) { //bucle para comprobar si el tablero esta lleno 
		            	//o si algun jugador ha ganado
						for (int j = 0; j < fichas[i].length; j++) {
							if (fichas[i][j] != '-' || ){ 
								 System.out.println(jugadores[jugadorRandom] +", " + "Quieres revancha? (si/no)");		           
						            revanchaJ1 = f.next();
						            jugadorRandom = (jugadorRandom + 1) % 2;
						            System.out.println(jugadores[jugadorRandom] +", " + "Quieres revancha? (si/no");
						            revanchaJ2 = f.next();
							}							
						}
						} 
		        }
				}while (revanchaJ1.contentEquals("si") && revanchaJ2.contentEquals("si"));
				
				if (revanchaJ1.contentEquals("no") && revanchaJ2.contentEquals("no")){
		        System.out.println("¡Juego terminado!"); //mensaje de juego terminado
				}
				
				/*
				for (int i = 0; i < fichas.length; i++) {
					System.out.println("Introduce la fila en la que quieres poner tu ficha: ");
					int fila = f.nextInt() -1;
					System.out.println("Introduce la columna en la que quieres poner tu ficha: ");
					int columna = f.nextInt() -1;
					fichaColocada[fila][columna] = 'x';	  
					
				//	fichas[fila][columna] = (jugadorRandom == 0) ? 'x' : 'o';	
					
				}
				 
				for (int i = 0; i < fichas.length; i++) {
		            for (int j = 0; j < fichas[i].length; j++) {
		                System.out.print(fichas[i][j] + " ");
		            }
		            System.out.println();
		        }
				jugadorRandom = (jugadorRandom + 1) % 2;
		    

		    System.out.println("¡Juego terminado!");
			*/
				
			

		
	}

}
