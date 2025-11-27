package view;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.TableroSudokuModelo;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

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
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setVisible(true);
		frame.setBounds(100, 100, anchoVentana, altoVentana);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/NEGRO.jpg")));
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setBackground(SystemColor.desktop);
		lblNewLabel_1.setBounds(214, 50, 3, 500);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/NEGRO.jpg")));
		lblNewLabel_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_1_1.setBackground(SystemColor.desktop);
		lblNewLabel_1_1.setBounds(382, 50, 3, 500);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/NEGRO.jpg")));
		lblNewLabel_1_2.setForeground(SystemColor.desktop);
		lblNewLabel_1_2.setBackground(SystemColor.desktop);
		lblNewLabel_1_2.setBounds(50, 214, 500, 3);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("New label");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/NEGRO.jpg")));
		lblNewLabel_1_2_1.setForeground(SystemColor.desktop);
		lblNewLabel_1_2_1.setBackground(SystemColor.desktop);
		lblNewLabel_1_2_1.setBounds(50, 382, 500, 3);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		
		
		JPanel panelMensaje = new JPanel();
		panelMensaje.setBackground(SystemColor.activeCaption);
		panelMensaje.setBounds(50, 563, 500, 69);
		frame.getContentPane().add(panelMensaje);
		
		JLabel mensajeSolucion = new JLabel("??????");
		panelMensaje.add(mensajeSolucion);
		mensajeSolucion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mensajeSolucion.setForeground(SystemColor.window);
		mensajeSolucion.setBackground(SystemColor.info);
		
		
		JLabel michi = new JLabel("michi");
		michi.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/GATTU2.jpg")));
		michi.setBounds(566, 536, 89, 96);
		frame.getContentPane().add(michi);
		michi.setVisible(false);
		
		
		JLabel disco = new JLabel("disco");
		disco.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/DISCO.gif")));
		disco.setBounds(474, 484, 200, 200);
		frame.getContentPane().add(disco);
		disco.setVisible(false);
		
		JLabel titulo = new JLabel("SUDOKU SOLVER 2005");
		titulo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		titulo.setForeground(new Color(255, 0, 0));
		titulo.setBackground(new Color(240, 240, 240));
		titulo.setBounds(50, 11, 500, 29);
		frame.getContentPane().add(titulo);
		
		
		
		JLabel[][] tableroVisualLabel =  new JLabel[9][9];
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(50, 50, 500, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(9, 9, 5, 5));
		
		
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				JPanel separador = new JPanel();
				separador.setBackground(SystemColor.info);
				
				String numeroString = String.valueOf(t.tablero[i][j]);
				
				JLabel lblNewLabel = new JLabel(numeroString);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(SystemColor.textHighlight);
				lblNewLabel.setBackground(SystemColor.info);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				tableroVisualLabel[i][j] = lblNewLabel;
				separador.add(lblNewLabel);
				
				panel.add(separador);
				
			}
		}
		
		//tablero.imprimirTablero();

		JButton resolverButton = new JButton("Resolver");
		resolverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.empezarResolucion()) {
					System.out.println("SE ENCONTRO UNA SOLUCION");
					mensajeSolucion.setText("SE ENCONTRO UNA SOLUCION ✓");
					mensajeSolucion.setForeground(Color.green);
					disco.setVisible(true);
				}
				else {
					System.out.println("NO SE ENCONTRO UNA SOLUCION");
					mensajeSolucion.setText("NO SE ENCONTRO UNA SOLUCION X");
					mensajeSolucion.setForeground(Color.red);
					michi.setVisible(true);
					
					
				}
				
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
		
		JButton volverAlMenu = new JButton("Volver al Menu");
		volverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMenu menu = new ViewMenu(t);
				menu.mostrar();
				frame.dispose();
				
			}
			});
		volverAlMenu.setBounds(566, 324, 108, 23);
		frame.getContentPane().add(volverAlMenu);
		

		

	}
	
	public void mostrar() {
		this.frame.setVisible(true);
	}
}
