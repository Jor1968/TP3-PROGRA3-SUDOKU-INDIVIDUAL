package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroTest {

	@Test
	void numeroEnColumna() {
		int[][] tableroTemp = {
				{0,0,0,0,0,0,0,0,0},
				{1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
		};
		
		TableroSudokuModelo t = new TableroSudokuModelo(tableroTemp);
		
		boolean estaEnColumna = t.verificarNumeroEnColumna(0, 1);
		
		assertTrue(estaEnColumna);
	}
	
	@Test
	void numeroEnFila() {
		int[][] tableroTemp = {
				{0,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
		};
		
		TableroSudokuModelo t = new TableroSudokuModelo(tableroTemp);
		
		boolean estaEnFila = t.verificarNumeroEnFila(0, 1);
		
		assertTrue(estaEnFila);
	}
	
	
	
	@Test
	void numeroEncaja3x3() {
		int[][] tableroTemp = {
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
		};
		
		TableroSudokuModelo t = new TableroSudokuModelo(tableroTemp);
		
		boolean estaEnCaja = t.verificarNumeroEncaja3x3(0, 0, 1);
		
		assertTrue(estaEnCaja);
	}
	
	@Test
	void resolverDevuelveFalseConRepetidos() {
		int[][] tableroTemp = {
				{0,1,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
		};
		
		TableroSudokuModelo t = new TableroSudokuModelo(tableroTemp);
		
		boolean sinRepetidos = t.empezarResolucion();
		
		assertFalse(sinRepetidos);
	}
	
	@Test
	void resolverDevuelveTrueSinRepetidos() {
		int[][] tableroTemp = {
				{0,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
		};
		
		TableroSudokuModelo t = new TableroSudokuModelo(tableroTemp);
		
		boolean sinRepetidos = t.empezarResolucion();
		
		assertTrue(sinRepetidos);
	}

}
