package datos;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logica.Personaje;


//import resources.AsignacionPersonajes; CUANDO LA TRAIGA DE OTRO PACK//

public class MyDataAcces1
{
////////////////datos conexion////////////////
	static private String _usuario="root";
	static private String _pwd= "root";
	static private  String _bd="tbc";
	 static String _url = "jdbc:mysql://localhost/"+_bd;
	 static Connection conn = null;
//////////////////////////////////////////////////	 
	 
	public  void main(String[] args) 
		{
			
		};
		
	
	public ResultSet getQuery(String _query)
	{
		Statement state = null;
		ResultSet resultado = null;
		
		try{
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(_query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		
		}
		return resultado;
	}
	
	public void setQuery(String _query)

	{
		Statement state = null;
		
		try{			
			state=(Statement) conn.createStatement();
			state.execute(_query);

         } catch (SQLException e){
            e.printStackTrace();
       }
	}
	
	
	public static  void insertarRegistro(Personaje p)

	{
		try
		{
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
			if(conn != null)
			{
			System.out.println("Conexion a base de datos "+_url+" . . . Ok");
			};
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO personajes VALUES (?,?,?,?,?,?)");
		
				//	AsignacionPersonajes.main(null);
	
	
			stmt.setString(1,p.getNombre());
			stmt.setInt(2,p.getEnergia());
			stmt.setInt(3,p.getVida());
			stmt.setInt(4,p.getDefensa());
			stmt.setInt(5,p.getEvasion());
			stmt.setInt(6,p.getPuntos());
			int retorno = stmt.executeUpdate();      
			 if (retorno>0)
			 {
		           System.out.println("Insertado correctamente");
			 }
	
		  } catch(SQLException ex)
			 {
			  System.out.println("Hubo un problema al intentar conectarse a la base de datos"+_url);
			 }
			catch(ClassNotFoundException ex)
			{
			System.out.println(ex);
			}	
		

	}
	public void update(Personaje p)//rev
	{
		PreparedStatement stmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
			if(conn != null)
			{
			System.out.println("Conexion a base de datos "+_url+" . . . Ok");
			};
			 stmt = conn.prepareStatement("UPDATE personajes SET nombre=?, vida=?, energia=?, defensa=?"+
					", evasion = ?, puntos_totales = ? WHERE nombre=?");
			
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPuntos());
			stmt.setString(7, p.getNombre());// pero el nuevo si no existe
			int retorno = stmt.executeUpdate();      
			 if (retorno>0)
			 {
		           System.out.println("Insertado correctamente");
			 }
	
		  } catch(SQLException ex)
			 {
			  System.out.println("Hubo un problema al intentar conectarse a la base de datos"+_url);
			 }
			catch(ClassNotFoundException ex)
			{
			System.out.println(ex);
			}	
		}
		
	
	
	public void delete(Personaje p)//rev pero por las dudas
	{
		PreparedStatement stmt=null;
		try
		{
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
			if(conn != null)
			{
			System.out.println("Conexion a base de datos "+_url+" . . . Ok");
			};
			 stmt = conn.prepareStatement("DELETE FROM personajes WHERE nombre=?");
	
			 stmt.setString(1,p.getNombre());
			
			int retorno = stmt.executeUpdate();      
			 if (retorno>0)
			 {
		           System.out.println("Insertado correctamente");
			 }
	
		  } catch(SQLException ex)
			 {
			  System.out.println("Hubo un problema al intentar conectarse a la base de datos"+_url);
			 }
			catch(ClassNotFoundException ex)
			{
			System.out.println(ex);
			}
		
		
		
	}
	
	public static Personaje getByNombre(String per)//busqueda!!!
	{
		Personaje p=null;
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
			if(conn != null)
			{
			System.out.println("Conexion a base de datos "+_url+" . . . Ok");
			};
			 stmt = conn.prepareStatement("SELECT nombre, vida, puntos_totales,energia,defensa,evasion FROM personajes WHERE nombre=?");
					
			stmt.setString(1, per);
			
			rs= stmt.executeQuery();
			if(rs!=null && rs.next())// no me cierra
			{
				p=new Personaje();
				p.setVida(rs.getInt("vida"));
				p.setDefensa(rs.getInt("defensa"));
				p.setPuntos(rs.getInt("puntos_totales"));
				p.setEvasion(rs.getInt("evasion"));
				p.setEnergia(rs.getInt("energia"));
				p.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("hubo un problema al conectar con la bd..");
			e.printStackTrace();
		} catch(ClassNotFoundException e)
			{
			System.out.println(e);
			}
		
		
		
		return p;
	}
	
}//fin class
