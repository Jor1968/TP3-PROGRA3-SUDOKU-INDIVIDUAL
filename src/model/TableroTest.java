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

}
