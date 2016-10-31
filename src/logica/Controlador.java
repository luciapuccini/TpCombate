package logica;

import java.util.ArrayList;

import datos.DataPersonaje;
import entidades.Personaje;
import utils.ApplicationException;

public class Controlador 
{
private ArrayList<Personaje> Personajes;
	
	private datos.DataPersonaje dataPer;
	
	
	public Controlador()
	{
		Personajes = new ArrayList<Personaje>();
		dataPer=new DataPersonaje();
	};
	
	public void add(Personaje p) throws ApplicationException {
		dataPer.add(p);
		
		if(!Personajes.contains(p)){
			Personajes.add(p);
		} else {
			throw new ApplicationException("La Personajeje ya existe");
		}
	}
	
	public void update(Personaje p) throws ApplicationException{
		if(Personajes.contains(p))
		{
			Personaje perEnc=this.getPersonaje(p);
			
			perEnc.setNombre(p.getNombre());
			perEnc.setVida(p.getVida());
			perEnc.setDefensa(p.getDefensa());
			perEnc.setEnergia(p.getEnergia());
			perEnc.setPuntos(p.getPuntos());
			perEnc.setEvasion(p.getEvasion());
			
		}
		else
		{
			throw new ApplicationException("El Personaje no existe");
		}
		
		dataPer.update(p);
	}
	
	public void delete(Personaje p){
		dataPer.delete(p);;
	}
	
	public Personaje getPersonaje(Personaje p)
	{
		/*
		 * Personaje perEnc=null;
		/*int i=Personajes.indexOf(p);
		if(i>=0){
			perEnc=Personajes.get(i);
		}
		return perEnc;*/
		return dataPer.getByNombre(p.getNombre());
	}

	
public Personaje buscaPersonaje(String nomb)

	{
		Personaje p;
		p=dataPer.getByNombre(nomb);
		return p;
	}

public void insertarPersonaje(Personaje pnew)
	{
		if(pnew.getNombre() != null)  //COMPLETAR IFS ANIDADOS
			
		{
		dataPer.add(pnew);
		}
		};
	
}
/*	
 * public Personaje buscarPersonaje  (String nomb)
	{
		Personaje per =MyDataAcces1.getByNombre(nomb);
		JOptionPane.showMessageDialog(null, "Muestro que encontro: " +per.getNombre()); 
		//this.cargaNombre(nomb);
		return per;
		
};
*/
	
	
	

