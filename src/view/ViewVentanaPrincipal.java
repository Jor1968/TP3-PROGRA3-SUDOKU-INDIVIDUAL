package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.TableroSudokuModelo;
import javax.swing.JButton;
import java.awt.Color;

public class ViewVentanaPrincipal {

	private JFrame frame;
	private int anchoVentana = 700;
	private int altoVentana = 700;


	/**
	 * Create the application.
	 */
	public ViewVentanaPrincipal(TableroSudokuModelo t) {
		initialize(t);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(TableroSudokuModelo t) {
		frame = new JFrame("Sudoku");
		frame.setVisible(true);
		frame.setBounds(100, 100, anchoVentana, altoVentana);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(50, 50, 500, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 3, 5, 5));
		


		
		//int cont = 0;
		JLabel[][] tableroVisualLabel =  new JLabel[9][9];
		
		for(int i = 0; i < 9; i++) {
			JPanel panel2 = new JPanel();
			panel2.setBackground(SystemColor.inactiveCaptionBorder);
			panel2.setBounds(50, 50, 500, 500);
			panel2.setLayout(new GridLayout(3, 3, 5, 5));
			
			for(int j = 0; j < 9; j++) {
				String numeroString = String.valueOf(t.tablero[i][j]);
				
				JLabel lblNewLabel = new JLabel(numeroString);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(SystemColor.textHighlight);
				lblNewLabel.setBackground(SystemColor.info);
				tableroVisualLabel[i][j] = lblNewLabel;
				panel2.add(lblNewLabel);
				
			}
			panel.add(panel2);
		}
		
		//tablero.imprimirTablero();
		
		//System.out.println(tablero.verificarNumeroEnFila_Columna(0,0, 3));
		//System.out.println(tablero.verificarNumeroEncaja3x3(0,0, 3));
		//System.out.println(tablero.verificarSiEsPosicionValida(0,0, 5));
		
		JButton resolverButton = new JButton("Resolver");
		resolverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(t.empezarResolucion());
				
				 for (int filas = 0; filas < tableroVisualLabel.length; filas++) {
			            for (int columnas = 0; columnas < tableroVisualLabel[filas].length; columnas++) {
			            	int numeroCasilla = t.getTablero()[filas][columnas];
			            	tableroVisualLabel[filas][columnas].setText(String.valueOf(numeroCasilla));
			            	
			                }
			            }
				 t.imprimirTablero();
				
			}
		});
		resolverButton.setBounds(566, 290, 89, 23);
		frame.getContentPane().add(resolverButton);
		

	}
	
	public void mostrar() {
		this.frame.setVisible(true);
	}
}
