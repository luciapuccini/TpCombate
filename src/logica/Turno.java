package logica;

import java.awt.EventQueue;
/**/
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Turno extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtEnergiaAtaque1;
	private JTextField txtEnergiaAtaque2;
	private JTextField txtEnergiaDisponible1;
	private JTextField txtVidaActual1;
	private JTextField txtVidaActual2;
	private JTextField txtEnergiaDisponible2;
	private JTextField textField;

	
	public JTextField getTxtEnergiaAtaque1() {
		return txtEnergiaAtaque1;
	}

	public void setTxtEnergiaAtaque1(JTextField txtEnergiaAtaque1) {
		this.txtEnergiaAtaque1 = txtEnergiaAtaque1;
	}

	public JTextField getTxtEnergiaAtaque2() {
		return txtEnergiaAtaque2;
	}

	public void setTxtEnergiaAtaque2(JTextField txtEnergiaAtaque2) {
		this.txtEnergiaAtaque2 = txtEnergiaAtaque2;
	}

	public JTextField getTxtEnergiaDisponible1() {
		return txtEnergiaDisponible1;
	}

	public void setTxtEnergiaDisponible1(JTextField txtEnergiaDisponible1) {
		this.txtEnergiaDisponible1 = txtEnergiaDisponible1;
	}

	public JTextField getTxtVidaActual1() {
		return txtVidaActual1;
	}

	public void setTxtVidaActual1(JTextField txtVidaActual1) {
		this.txtVidaActual1 = txtVidaActual1;
	}

	public JTextField getTxtVidaActual2() {
		return txtVidaActual2;
	}

	public void setTxtVidaActual2(JTextField txtVidaActual2) {
		this.txtVidaActual2 = txtVidaActual2;
	}

	public JTextField getTxtEnergiaDisponible2() {
		return txtEnergiaDisponible2;
	}

	public void setTxtEnergiaDisponible2(JTextField txtEnergiaDisponible2) {
		this.txtEnergiaDisponible2 = txtEnergiaDisponible2;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Turno frame = new Turno();
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
	public Turno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblP1 = new JLabel("Personaje 1:");
		
		JLabel lblP2 = new JLabel("Personaje 2:");
		
		JButton btnAtaque1 = new JButton("Ataque");
		btnAtaque1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		
		JButton btnDefensa1 = new JButton("Defensa");
		btnDefensa1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		JLabel lblVida1 = new JLabel("Vida Actual:");
		
		JLabel lblEnergia1 = new JLabel("Energia Disponible:");
		
		JLabel lblVida2 = new JLabel("Vida Actual:");
		
		JLabel lblEnergia2 = new JLabel("Energia Disponible:");
		
		JLabel lblEnergiaAtaque1 = new JLabel("Ingrese Energia: ");
		
		txtEnergiaAtaque1 = new JTextField();
		txtEnergiaAtaque1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int a=Integer.parseInt(txtEnergiaAtaque1.getText());
				//actualiza energia
			//	Controlador.ataque(a);
				
			}
		});
		txtEnergiaAtaque1.setColumns(10);
		
		txtEnergiaAtaque2 = new JTextField();
		txtEnergiaAtaque2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		txtEnergiaAtaque2.setColumns(10);
		
		JLabel lblEnergiaAtaque2 = new JLabel("Ingrese Energia:");
		
		txtEnergiaDisponible1 = new JTextField();
		txtEnergiaDisponible1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		txtEnergiaDisponible1.setEditable(false);
		txtEnergiaDisponible1.setColumns(10);
		
		txtVidaActual1 = new JTextField();
		txtVidaActual1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		txtVidaActual1.setEditable(false);
		txtVidaActual1.setColumns(10);
		
		txtVidaActual2 = new JTextField();
		txtVidaActual2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		txtVidaActual2.setEditable(false);
		txtVidaActual2.setColumns(10);
		
		txtEnergiaDisponible2 = new JTextField();
		txtEnergiaDisponible2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		txtEnergiaDisponible2.setEditable(false);
		txtEnergiaDisponible2.setColumns(10);
		
		JButton btnAtaque2 = new JButton("Ataque");
		btnAtaque2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		JButton btnDefensa2 = new JButton("Defensa");
		btnDefensa2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Controlador controladorNombre= new Controlador();
				//falta agregar el nombre elegido
				
			}
		});
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAtaque1)
							.addGap(12)
							.addComponent(btnDefensa1)
							.addContainerGap(262, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblP1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblVida1)
									.addGap(18)
									.addComponent(txtVidaActual1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnergia1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtEnergiaDisponible1, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnergiaAtaque1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtEnergiaAtaque1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblP2)
									.addGap(126))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblEnergiaAtaque2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtEnergiaAtaque2, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnAtaque2)
											.addGap(18)
											.addComponent(btnDefensa2))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblVida2)
												.addComponent(lblEnergia2))
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtEnergiaDisponible2, 0, 0, Short.MAX_VALUE)
												.addComponent(txtVidaActual2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
									.addGap(77)))
							.addGap(53))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblP2)
						.addComponent(lblP1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVida2)
						.addComponent(txtVidaActual2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtVidaActual1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVida1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnergia1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtEnergiaDisponible1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEnergia2)
							.addComponent(txtEnergiaDisponible2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnergiaAtaque1)
						.addComponent(lblEnergiaAtaque2)
						.addComponent(txtEnergiaAtaque1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEnergiaAtaque2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDefensa1)
						.addComponent(btnAtaque1)
						.addComponent(btnAtaque2)
						.addComponent(btnDefensa2))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
