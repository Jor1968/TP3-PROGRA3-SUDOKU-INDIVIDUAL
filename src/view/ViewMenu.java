package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.TableroSudokuModelo;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class ViewMenu {
	
	private int anchoVentana = 700;
	private int altoVentana = 700;
	private TableroSudokuModelo t;
	private JFrame frame;
	private JTextField textField;
	private List<Integer> numeros = new ArrayList<Integer>();
	private JTextField CantDeRandoms;


	/**
	 * Create the application.
	 * @param t 
	 */
	public ViewMenu(TableroSudokuModelo t) {
		this.t = t;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		numeros.addAll(Arrays.asList(1, 2, 3, 4, 5 , 6 , 7 , 8 , 9));
		Collections.shuffle(numeros);
		
		frame = new JFrame("Sudoku");
		frame.setVisible(false);
		frame.setBounds(100, 100, anchoVentana, altoVentana);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		/*
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(50, 50, 500, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(9, 9, 5, 5));
*/
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(50, 50, 500, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 3, 5, 5));
		


		
		//int cont = 0;
		JTextField[][] tableroVisual =  new JTextField[9][9];
		
		for(int i = 0; i < 9; i++) {
			JPanel panel2 = new JPanel();
			panel2.setBackground(SystemColor.inactiveCaptionBorder);
			panel2.setBounds(50, 50, 500, 500);
			panel2.setLayout(new GridLayout(3, 3, 5, 5));
			
			for(int j = 0; j < 9; j++) {
				String numeroString = String.valueOf(t.tablero[i][j]);
				textField = new JTextField(numeroString);
				textField.setColumns(10);
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setForeground(SystemColor.textHighlight);
				textField.setBackground(SystemColor.info);
				tableroVisual[i][j] = textField;
				panel2.add(textField);
				
			}
			panel.add(panel2);
		}
		
		
		

		
		
		
		
		
		/*
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				String numeroString = String.valueOf(t.tablero[i][j]);
				textField = new JTextField(numeroString);
				textField.setColumns(10);
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setForeground(SystemColor.textHighlight);
				textField.setBackground(SystemColor.info);
				tableroVisual[i][j] = textField;
				panel.add(textField);
			
				
			}
		}
		*/
		
		CantDeRandoms = new JTextField();
		CantDeRandoms.setBounds(266, 561, 86, 20);
		CantDeRandoms.setText("1");
		frame.getContentPane().add(CantDeRandoms);
		CantDeRandoms.setColumns(10);

		
		JButton randomValuesButton = new JButton("Aleatorios");
		randomValuesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizarTablero(tableroVisual);

				t.tableroRandom(Integer.valueOf(CantDeRandoms.getText()));
				actualizarVista(tableroVisual);
						
				
			}
		});
		randomValuesButton.setBounds(239, 588, 143, 23);
		frame.getContentPane().add(randomValuesButton);
		
		
		/*
		JButton testValueButton = new JButton("Valores Testeo");
		testValueButton.setBounds(416, 588, 113, 23);
		testValueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j < 9; j++) {
						t.tablero[i][j] = tableroTemp[i][j];
						tableroVisual[i][j].setText(String.valueOf(tableroTemp[i][j]) );

					
						
					}
				}
				
			}
		});
		frame.getContentPane().add(testValueButton);
		*/
		
		JButton openMainViewButton = new JButton("Empezar");
		openMainViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTablero(tableroVisual);
				ViewVentanaPrincipal i = new ViewVentanaPrincipal(t);
				
			}
		});
		openMainViewButton.setBounds(106, 588, 89, 23);
		frame.getContentPane().add(openMainViewButton);

		
	}
	/*
	public int[][] sacarValorTableroTexto(JTextField[][] tab){
		int[][] tableroTemp = new int[9][9];
		
			 for (int fila = 0; fila < tab.length; fila++) {
				 for (int column = 0; column < tab[fila].length; column++) {
					 String numtext = tab[fila][column].getText();
					 tableroTemp[fila][column] = Integer.valueOf(numtext);
		            		
		            	}
		            
		            }

		
		return tableroTemp;
		
	}
	*/
	
	public void mostrar() {
		this.frame.setVisible(true);
	}
	
	public void actualizarVista(JTextField[][] tableroVisual) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				String numeroTablero = String.valueOf(t.getTablero()[i][j]);
				tableroVisual[i][j].setText(numeroTablero);
				

			
				
			}
		}
	}
	
	public void actualizarTablero(JTextField[][] tableroVisual) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				String numeroNuevoTexto = tableroVisual[i][j].getText();
				Integer numeroNuevo = Integer.valueOf(numeroNuevoTexto);
                t.getTablero()[i][j] = numeroNuevo;

			
				
			}
		}
	}
	
	
	
	
	
	
}
