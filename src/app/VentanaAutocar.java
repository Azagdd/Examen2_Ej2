package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAutocar extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtKilometros;
	private JLabel lbl4;
	private JLabel lbl5;
	private JSpinner spinnerPlazas;
	private JTextField txtModelo;
	private JButton btnInsertar;
	private JButton btnMostrarDatos;
	private JTextArea textArea;
	private JLabel lblTitulo;

	
	private ArrayList<VentanaAutocar> Autocar;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAutocar frame = new VentanaAutocar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAutocar() {
		
		this.Autocar = new ArrayList<VentanaAutocar>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[52.00][110.00][191.00]", "[35.00][30.00][][][43.00][grow]"));
		
		lblTitulo = new JLabel("Gestión Autocares");
		lblTitulo.setOpaque(true);
		lblTitulo.setBackground(new Color(128, 128, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblTitulo, "cell 0 0 3 1,grow");
		
		JLabel lbl1 = new JLabel("Matrícula:");
		contentPane.add(lbl1, "cell 0 1,alignx trailing");
		
		txtMatricula = new JTextField();
		contentPane.add(txtMatricula, "cell 1 1,growx");
		txtMatricula.setColumns(10);
		
		JLabel lbl2 = new JLabel("Marca:");
		contentPane.add(lbl2, "cell 0 2,alignx trailing");
		
		txtMarca = new JTextField();
		contentPane.add(txtMarca, "flowx,cell 1 2,growx");
		txtMarca.setColumns(10);
		
		lbl4 = new JLabel("Modelo:");
		contentPane.add(lbl4, "flowx,cell 2 2");
		
		JLabel lbl3 = new JLabel("Kilometros:");
		contentPane.add(lbl3, "cell 0 3,alignx trailing");
		
		txtKilometros = new JTextField();
		contentPane.add(txtKilometros, "flowx,cell 1 3,growx");
		txtKilometros.setColumns(10);
		
		lbl5 = new JLabel("Plazas:");
		contentPane.add(lbl5, "flowx,cell 2 3");
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerdatos();
			}
		});
		contentPane.add(btnInsertar, "flowx,cell 1 4,alignx center");
		
		txtModelo = new JTextField();
		contentPane.add(txtModelo, "cell 2 2,growx");
		txtModelo.setColumns(10);
		
		spinnerPlazas = new JSpinner();
		spinnerPlazas.setModel(new SpinnerNumberModel(30, 1, 80, 1));
		contentPane.add(spinnerPlazas, "cell 2 3");
		
		btnMostrarDatos = new JButton("Mostrar Datos");
		btnMostrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mostrardatos();
			}
		});
		contentPane.add(btnMostrarDatos, "cell 1 4");
		
		textArea = new JTextArea();
		contentPane.add(textArea, "cell 0 5 3 1,grow");
		
	}

	protected void recogerdatos() {
		String matricula = txtMatricula.getText();
		String marca = txtMarca.getText();
		String modelo = txtModelo.getText();
		
		int kilometros = Integer.parseInt(txtKilometros.getText());
		
		if (matricula==null || matricula.isBlank() ||
				marca==null || marca.isBlank() ||
				modelo==null || modelo.isBlank()) {
				JOptionPane.showMessageDialog(contentPane, 
						"Debe introducir la matricula, la marca y el modelo"
						, "Datos requeridos",
						JOptionPane.WARNING_MESSAGE);
				return;
}
		
		VentanaAutocar autocar = new VentanaAutocar(matricula,marca,modelo,kilometros);
	}
	
	protected void Mostrardatos() {
		textArea.setText("");

		for (VentanaAutocar autocar : Autocar) {
			textArea.setText(textArea.getText()+autocar+"\n");
		}
		
		this.Autocar.add(autocar);
	}
}