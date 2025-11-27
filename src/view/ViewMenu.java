package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.TableroSudokuModelo;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

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
		frame.getContentPane().setBackground(new Color(191, 197, 186));
		frame.setVisible(false);
		frame.setBounds(100, 100, anchoVentana, altoVentana);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel SeparadorVertical1 = new JLabel("New label");
		SeparadorVertical1.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/NEGRO.jpg")));
		SeparadorVertical1.setForeground(SystemColor.desktop);
		SeparadorVertical1.setBackground(SystemColor.desktop);
		SeparadorVertical1.setBounds(214, 50, 3, 500);
		frame.getContentPane().add(SeparadorVertical1);
		
		JLabel SeparadorVertical2 = new JLabel("New label");
		SeparadorVertical2.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/NEGRO.jpg")));
		SeparadorVertical2.setForeground(SystemColor.desktop);
		SeparadorVertical2.setBackground(SystemColor.desktop);
		SeparadorVertical2.setBounds(382, 50, 3, 500);
		frame.getContentPane().add(SeparadorVertical2);
		
		JLabel SeparadorHorizontal1 = new JLabel("New label");
		SeparadorHorizontal1.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/NEGRO.jpg")));
		SeparadorHorizontal1.setForeground(SystemColor.desktop);
		SeparadorHorizontal1.setBackground(SystemColor.desktop);
		SeparadorHorizontal1.setBounds(50, 214, 500, 3);
		frame.getContentPane().add(SeparadorHorizontal1);
		
		JLabel SeparadorHorizontal2 = new JLabel("New label");
		SeparadorHorizontal2.setIcon(new ImageIcon(ViewVentanaPrincipal.class.getResource("/Imagenes/NEGRO.jpg")));
		SeparadorHorizontal2.setForeground(SystemColor.desktop);
		SeparadorHorizontal2.setBackground(SystemColor.desktop);
		SeparadorHorizontal2.setBounds(50, 382, 500, 3);
		frame.getContentPane().add(SeparadorHorizontal2);
		
		
		
		JTextField[][] tableroVisual =  new JTextField[9][9];
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(50, 50, 500, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(9, 9, 5, 5));

		
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				String numeroString = String.valueOf(t.tablero[i][j]);
				textField = new JTextField(numeroString);
				textField.setColumns(10);
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setForeground(SystemColor.textHighlight);
				textField.setBackground(SystemColor.info);
				textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
				tableroVisual[i][j] = textField;
				panel.add(textField);
			
				
			}
		}

		
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
		
		
		
		JButton testValueButton = new JButton("Valores Testeo");
		testValueButton.setBounds(416, 588, 113, 23);
		testValueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTablero(tableroVisual);
                t.ponerValoresTesteo();
				actualizarVista(tableroVisual);

				
			}
		});
		frame.getContentPane().add(testValueButton);
		
		
		JButton limpiar = new JButton("Limpiar Celdas");
		limpiar.setBounds(416, 560, 113, 23);
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTablero(tableroVisual);
                t.limpiarTablero();
				actualizarVista(tableroVisual);
						
					
				
				
			}
		});
		frame.getContentPane().add(limpiar);
		
		
		
		
		JButton openMainViewButton = new JButton("Empezar");
		openMainViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTablero(tableroVisual);
				ViewVentanaPrincipal ventanaPrincipal = new ViewVentanaPrincipal(t);
				frame.dispose();
				
			}
		});
		openMainViewButton.setBounds(106, 588, 89, 23);
		frame.getContentPane().add(openMainViewButton);
		
		JLabel titulo = new JLabel("SUDOKU SOLVER 2005");
		titulo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		titulo.setForeground(new Color(255, 0, 0));
		titulo.setBackground(new Color(240, 240, 240));
		titulo.setBounds(50, 11, 500, 29);
		frame.getContentPane().add(titulo);
		
		JLabel lblAsignarValoresDe = new JLabel("Asigne valores de 1 al 9 a los casilleros, y despues cliquee resolver.");
		lblAsignarValoresDe.setForeground(Color.RED);
		lblAsignarValoresDe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblAsignarValoresDe.setBackground(UIManager.getColor("Button.background"));
		lblAsignarValoresDe.setBounds(288, 12, 396, 29);
		frame.getContentPane().add(lblAsignarValoresDe);

		
	}

	
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
