package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class TableroSudokuModelo {
	public int[][] tablero =  new int[9][9];
	private List<Integer> numeros = new ArrayList<Integer>();

	public TableroSudokuModelo(int[][] tablerotemp) {
		 for (int filas = 0; filas < tablero.length; filas++) {
			// System.out.println(numeros);
	            for (int columnas = 0; columnas < tablero[filas].length; columnas++) {
	            	tablero[filas][columnas] = tablerotemp[filas][columnas];
	            	
	                }
	            }
		
		
	}

	public boolean imprimirTablero() {
		
		
		 for (int filas = 0; filas < tablero.length; filas++) {
	            for (int columnas = 0; columnas < tablero[filas].length; columnas++) {
	            	System.out.println(tablero[filas][columnas] + " ");
	            	
	                }
	            
	            System.out.println();
	            }
	        return true;
	}
	

	
	public boolean verificarNumeroEnFila(int fila, int numero) {
		 for (int i = 0; i < tablero.length; i++) {
	            	if(this.tablero[fila][i] == numero) {
	            		return true;
	            		
	            	}
	            
	            }
	        return false;
	}
	
	public boolean verificarNumeroEnColumna(int columna, int numero) {
		 for (int i = 0; i < tablero.length; i++) {
	            	if(this.tablero[i][columna] == numero) {
	            		return true;
	            		
	            	}
	            
	            }
	        return false;
	}

	
	public boolean verificarNumeroEncaja3x3(int fila, int columna, int numero) {
		int primeraCasillaFila = fila - fila % 3;
		int primeraCasillaColumna = columna - columna % 3;
		
		for(int i = primeraCasillaFila; i < primeraCasillaFila +3; i++) {
			for(int j = primeraCasillaColumna; j < primeraCasillaColumna +3; j++) {
				if(tablero[i][j] == numero) {
					return true;
				}
				
			}
		}
		
		
		return false;
		
	}
	
	public boolean verificarSiEsPosicionValida(int fila, int columna, int numero) {
		return !verificarNumeroEncaja3x3(fila,columna,numero) &&
			   !verificarNumeroEnFila(fila,numero)            &&
			   !verificarNumeroEnColumna(columna,numero);
	}
	

	
	public void setTablero(int fila,int columna,int numero) {
		this.tablero[fila][columna] = numero;
	}
	public int[][] getTablero() {
		return this.tablero;
	}
	
	
	public boolean empezarResolucion() {
		return resolver(this.tablero);
		
	}
	
	public boolean resolver(int[][] tablero) {
		
		for(int fila = 0; fila < this.tablero.length; fila++) {
			for(int columna = 0; columna <  this.tablero[fila].length; columna++) {
				
				if(tablero[fila][columna] != 0) {
					int num_aux = tablero[fila][columna];
					tablero[fila][columna] = 0;
					
					if(verificarSiEsPosicionValida(fila,columna,num_aux) == false) {
					//System.out.println("NO TIENE SOLUCION");
					tablero[fila][columna] = num_aux;
					return false;
					}
					tablero[fila][columna] = num_aux;
				}
				else {
				//if(tablero[fila][columna] == 0) {
					for(int numeroCandidato = 1; numeroCandidato <= this.tablero.length; numeroCandidato++ ) {
						if(verificarSiEsPosicionValida(fila,columna,numeroCandidato)) {
							tablero[fila][columna] = numeroCandidato;
							
							if(resolver(tablero)) {
								return true;
							}
							else{
								tablero[fila][columna] = 0;
								
							}
							
						}
					}
					return false;
					
					
				}
				
				}
				
			}
		return true;
		
	}
	
	public boolean tableroRandom(int num) {
		return crearValoresAleatorios(this.tablero, num);
		
	}

	
	public boolean crearValoresAleatorios(int[][] tablero, int cantidadDeIntentos) {
		numeros.addAll(Arrays.asList(1, 2, 3, 4, 5 , 6 , 7 , 8 , 9));
		Collections.shuffle(numeros);
		
		Random ElegirCasilla = new Random();
		
		for(int fila = 0; fila < this.tablero.length; fila++) {
			for(int columna = 0; columna <  this.tablero[fila].length; columna++) {
				if(cantidadDeIntentos == 0) {
					return true;
				}
				ElegirCasilla.nextInt(2);
				
				if(tablero[fila][columna] == 0 && ElegirCasilla.nextInt(2) == 0) {
					for(Integer numeroCandidato : numeros) {
						if(verificarSiEsPosicionValida(fila,columna,numeroCandidato) && !(tablero[fila][columna] == numeroCandidato)) {
							tablero[fila][columna] = numeroCandidato;
							break;
					
						}
						
					}

						
				}
				cantidadDeIntentos--;

			}
			
		}
			

		return true;	
	}
	
	public boolean limpiarTablero() {
		int[][] tableroTemp = {
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
		};
		
		this.tablero = tableroTemp;
		return true;
	}
	
	
	
	public boolean ponerValoresTesteo() {
		int[][] tableroTemp = {
				{7,0,2,0,5,0,6,0,0},
				{0,0,0,0,0,3,0,0,0},
				{1,0,0,0,0,9,5,0,0},
				{8,0,0,0,0,0,0,9,0},
				{0,4,3,0,0,0,7,5,0},
				{0,9,0,0,0,0,0,0,8},
				{0,0,9,7,0,0,0,0,5},
				{0,0,0,2,0,0,0,0,0},
				{0,0,7,0,4,0,2,0,3}
		};
		
		this.tablero = tableroTemp;
		return true;
	}
	
	

	
	
	
	/*
	else if(numeroCandidato == 9){
		  System.out.print(fila + ":" + columna + "No es solucion valida");	
		}
		*/
	
	
	
/*
	public boolean recorrer() {
		 for (int filas = 0; filas < tablero.length; filas++) {
	            for (int columnas = 0; columnas < tablero[filas].length; columnas++) {
	            	
	                }
	            }
	        return true;
	}
	*/
	
	
}
