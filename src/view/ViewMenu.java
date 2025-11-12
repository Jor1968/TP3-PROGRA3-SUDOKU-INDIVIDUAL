package view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMenu {
	
	private int anchoVentana = 700;
	private int altoVentana = 700;

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenu window = new ViewMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sudoku");
		frame.setVisible(false);
		frame.setBounds(100, 100, anchoVentana, altoVentana);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(50, 50, 500, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(9, 9, 5, 5));
		

		
		JTextField[][] tableroVisual =  new JTextField[9][9];
		
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				
				textField = new JTextField("0");
				textField.setColumns(10);
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setForeground(SystemColor.textHighlight);
				textField.setBackground(SystemColor.info);
				tableroVisual[i][j] = textField;
				panel.add(textField);
			
				
			}
		}

		
		JButton randomValuesButton = new JButton("Aleatorios");
		randomValuesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		randomValuesButton.setBounds(239, 588, 143, 23);
		frame.getContentPane().add(randomValuesButton);
		
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
						tableroVisual[i][j].setText(String.valueOf(tableroTemp[i][j]) );

					
						
					}
				}
				
			}
		});
		
		
		
		frame.getContentPane().add(testValueButton);
		
		
		JButton openMainViewButton = new JButton("Empezar");
		openMainViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewVentanaPrincipal i = new ViewVentanaPrincipal(sacarValorTableroTexto(tableroVisual));
				
			}
		});
		openMainViewButton.setBounds(106, 588, 89, 23);
		frame.getContentPane().add(openMainViewButton);
		
	}
	
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
	
	public void mostrar() {
		this.frame.setVisible(true);
	}
}
