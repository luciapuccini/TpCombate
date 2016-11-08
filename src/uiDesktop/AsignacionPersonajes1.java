package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.MyDataAccess;
import entidades.Personaje;
import logica.Controlador;
import utils.ApplicationException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
//import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;

@SuppressWarnings("serial")
public class AsignacionPersonajes1 extends JFrame 
{

	////////////////////////////VARIABLES////////////////////////////
	private JPanel contentPane;
	private JTextField txtPuntos;
	private JTextField txtEvasion;
	private JTextField txtEnergia;
	private JTextField txtVida;
	private JTextField txtDefensa;
	private JTextField txtNombre;
	Personaje p =new Personaje();
	/////////////////////////////////////////////////////////////////

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
{
			public void run() {
				try 
				{
					AsignacionPersonajes1 frame = new AsignacionPersonajes1();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AsignacionPersonajes1()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPuntos = new JLabel("Puntos totales");
		
		JLabel lblEvasion = new JLabel("Evasion");
		
		JLabel lblEnergia = new JLabel("Energia");
		
		JLabel lblVida = new JLabel("Vida");
		
		JLabel lblDefensa = new JLabel("Defensa");
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtPuntos = new JTextField();
		txtPuntos.setEditable(true);
		txtPuntos.setText("200");
		txtPuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				p.setPuntos(200);
			}
		});
		txtPuntos.setColumns(10);
		
		txtEvasion = new JTextField();
		txtEvasion.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				int a=Integer.parseInt(txtEvasion.getText());
				p.setEvasion(a);
				
			}	
		});
		txtEvasion.setColumns(10);
		
		txtEnergia = new JTextField();
		txtEnergia.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{	
			int a=Integer.parseInt(txtEnergia.getText());
			p.setEnergia(a);
			
			}
		});
		txtEnergia.setColumns(10);
		
		txtVida = new JTextField();
		txtVida.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int a=Integer.parseInt(txtVida.getText());
				p.setVida(a);
				
			}
		});
		txtVida.setColumns(10);
		
		txtDefensa = new JTextField();
		txtDefensa.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int a=Integer.parseInt(txtDefensa.getText());
				p.setDefensa(a);
				
			}
			
		});
		txtDefensa.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String a= txtNombre.getText();
				p.setNombre(a);
				
			}
		});
		txtNombre.setText("");
		txtNombre.setColumns(10);
//////////////////////////////AGREGAR PERSONAJE/////////////////////////////////////////		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int opc =JOptionPane.showConfirmDialog(null, "va a agregar un nuevo registro,�Esta seguro?", null, 2);
				if (opc==0)
				{
				//faltaria validar que los campos no esten vacios en controlador...
				System.out.println("insertando nuevo registro...");
				Controlador ctrl = new Controlador();
				try {
					ctrl.insertarPersonaje(p);
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				
				}
				else
				{
				}
			};
			
		});
		
		JTextArea txtrNota = new JTextArea();
		txtrNota.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		txtrNota.setBackground(SystemColor.menu);
		txtrNota.setForeground(new Color(255, 0, 0));
		txtrNota.setText("NOTA: enter para realizar cada ingreso");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPuntos)
						.addComponent(lblEvasion)
						.addComponent(lblEnergia)
						.addComponent(lblVida)
						.addComponent(lblDefensa))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPuntos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtrNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNombre)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnContinuar)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)))
					.addGap(65))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPuntos)
								.addComponent(txtPuntos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEvasion)
								.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnergia)
								.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVida)
								.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(txtrNota, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDefensa)
						.addComponent(lblNombre)
						.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addComponent(btnContinuar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}//FIN CONSTRUCTOR
}
