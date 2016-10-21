package logica;

import javax.swing.JOptionPane;

import datos.MyDataAcces1;

public class Controlador 
{

	public void buscarPersonaje  (String nomb)
	{
		Personaje per =MyDataAcces1.getByNombre(nomb);
		JOptionPane.showMessageDialog(null, "Muestro que encontro: " +per.getNombre()); 
		this.cargaNombre(nomb);
	};
	
	public String cargaNombre(String nom)
	{
		String nomb= nom;
		return nomb;
	}
}
