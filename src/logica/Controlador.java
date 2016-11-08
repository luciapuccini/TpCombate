package logica;

import datos.DataPersonaje;
import entidades.Personaje;
import utils.ApplicationException;

public class Controlador 
{

	
	private datos.DataPersonaje dataPer;
	private Personaje p1= new Personaje() ;
	private Personaje p2 =new Personaje();
	
	
	public Controlador()
	{
		dataPer=new DataPersonaje();
	};
	
	/*public void add(Personaje p) throws ApplicationException {
		dataPer.add(p);
		
		if(!personajes.contains(p)){
			personajes.add(p);
		} else {
			throw new ApplicationException("La Persona ya existe");
		}}
	}*/

	
	public void setP1(Personaje p1) {
		this.p1 = p1;
	
	}

	public void setP2(Personaje p2) {
		this.p2 = p2;
	}

	public void update(Personaje p) throws ApplicationException{
		if( p1==p || p2==p )
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

public Personaje damePersonaje1(){
System.out.println(p1.getNombre());
	return this.p1;
	
}

public Personaje damePersonaje2(){
	return this.p2;
}
public void insertarPersonaje(Personaje pnew)throws ApplicationException
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
	
	
	

