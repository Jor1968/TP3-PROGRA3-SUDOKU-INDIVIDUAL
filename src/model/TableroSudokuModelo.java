package model;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.random.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class TableroSudokuModelo {
	public int[][] tablero =  new int[9][9];


	private List<Integer> numeros = new ArrayList<Integer>();
	/*
	public TableroSudokuModelo() {
		numeros.addAll(Arrays.asList(1, 2, 3, 4, 5 , 6 , 7 , 8 , 9));
		//numeros.addAll(Arrays.asList(1, 2, 2, 2, 2 , 2 , 2 , 2 , 2));
		//Random r= new Random();
		Collections.shuffle(numeros);
		 for (int filas = 0; filas < tablero.length; filas++) {
			 Collections.shuffle(numeros);
			 System.out.println(numeros);
	            for (int columnas = 0; columnas < tablero[filas].length; columnas++) {
	            	//tablero[filas][columnas] = r.nextInt(10);
	            	tablero[filas][columnas] = numeros.get(columnas);
	            	
	                }
	            }
		
		
	}
	*/
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
	
	public boolean verificarNumeroEnFila_Columna(int fila, int columna, int numero) {
		return verificarNumeroEnFila(fila,numero) || verificarNumeroEnColumna(columna,numero);
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
	
	
	
	

		
	
/*
	public boolean recorrer() {
		
		
		 for (int filas = 0; filas < tablero.length; filas++) {
	            for (int columnas = 0; columnas < tablero[filas].length; columnas++) {
	            	
	                }
	            }
	        return true;
	}
	*/
	
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
				
				if(tablero[fila][columna] == 0) {
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
	
	
	public boolean resolver2() {
		
		for(int fila = 0; fila < this.tablero.length; fila++) {
			for(int columna = 0; columna <  this.tablero[fila].length; columna++) {
				
				tablero[fila][columna] = 5;
			}
		}
		return true;
	}
	
	
	
}
