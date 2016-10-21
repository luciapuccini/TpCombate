package datos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import logica.Controlador;
import logica.Turno;

public class Tabla extends JFrame{
    
    static String  nombrePersonaje = new String();


     
    public static String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public static void setNombrePersonaje(String nombrePersonaje) {
		Tabla.nombrePersonaje = nombrePersonaje;
	}

	private static final long serialVersionUID = 210601883990408438L;
    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet resultados = null;
    private JTable tabla = null;
    DefaultTableModel modelo = null;
    JScrollPane desplazamiento = null;
    private JTextField txtP1;
    private JTextField txtP2;
    
    /**
     * Obtenemos todos los datos de la tabla juegos;
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    private void leerDatos() throws ClassNotFoundException, SQLException 
    {
        String usuario = "root";
        String passwd = "root";
        String instruccion = "SELECT * FROM tbc.personajes";

        Class.forName("com.mysql.jdbc.Connection");
        conexion = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/tbc" + "?" + "user=" + usuario + "&" + "password=" + passwd + "");
        if (conexion != null)
        {
        	System.out.println("Conexion a base de datos  . . . Ok ");
        };
        comando = conexion.createStatement();
        resultados = comando.executeQuery(instruccion);
    }
    
    /**
     * Cierra la conexion con base de datos
     * @throws SQLException
     */
    private void cerrar() throws SQLException 
    {
        conexion.close();        
    }    
    
    public Tabla() 
    {
        // Nombre de las columnas como apareceran en la tabla
        String[] columnas = { "nombre", "energia","vida","defensa","evasion","puntos_totales"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);
        int energia, vida,defensa,evasion,puntos;
        String nombre;
        
        // Parametros de la ventana
        this.setTitle("Tabla de personajes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout()); 
        
        // Modelo de la tabla
        modelo.setColumnIdentifiers(columnas);
        
        // Barras de desplazamiento
        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        // Propiedades de la tabla
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);        
        
        tabla.setModel(modelo);
        
        // Agregando elementos a la ventana
        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        desplazamiento.setRowHeaderView(panel);
        //---------------------------------------------------------------
       
        
        txtP1 = new JTextField();
        txtP1.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		
        		  	     
          	}
        });
        txtP1.setColumns(10);
        
        JButton btnPersonaje1 = new JButton("Personaje 1");
        btnPersonaje1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        	String nombrePersonaje = txtP1.getText();
    		
        	Controlador controladorBusca = new Controlador();
    			controladorBusca.buscarPersonaje(nombrePersonaje);  
        	}
        });
        
        JButton btnPersonaje2 = new JButton("Personaje2");
        btnPersonaje2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{	String nombrePersonaje = txtP2.getText();
        	Controlador controladorBusca = new Controlador();
			controladorBusca.buscarPersonaje(nombrePersonaje);  
        	}
        });
        
        txtP2 = new JTextField();
        txtP2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        	}
        });
        txtP2.setColumns(10);
        
        JButton button = new JButton("JUGAR");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		Turno.main(null);
        	}
        });
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnPersonaje1)
        				.addComponent(txtP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnPersonaje2)
        				.addComponent(txtP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(button))
        			.addContainerGap(37, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btnPersonaje1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnPersonaje2)
        			.addGap(18)
        			.addComponent(txtP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(59)
        			.addComponent(button)
        			.addContainerGap(179, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        this.pack();
        
        // Ponemos los datos en la tabla
        
        try {
            // Obtener datos de la tabla
            this.leerDatos();
            
            while(resultados.next() == true) 
            {
                
               
                nombre = resultados.getString("nombre");
                energia = resultados.getInt("energia");
                vida = resultados.getInt("vida");
                defensa = resultados.getInt("defensa");
                evasion= resultados.getInt("evasion");
               puntos= resultados.getInt("puntos_totales");
                modelo.addRow( new Object[] {nombre, energia,vida,defensa,evasion,puntos} );                
            }
            
            this.cerrar();
            
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error de lectura de BD\n\n");
            
            e.printStackTrace();
        } 
    }

}
