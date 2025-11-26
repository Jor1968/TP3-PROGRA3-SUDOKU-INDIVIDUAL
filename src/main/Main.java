package main;

import model.TableroSudokuModelo;
import view.ViewMenu;

public class Main {

	public static void main(String[] args) {
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
		
		TableroSudokuModelo t = new TableroSudokuModelo(tableroTemp);
		
		ViewMenu vistaMenu = new ViewMenu(t);
		vistaMenu.mostrar();
		
		

	}

}
