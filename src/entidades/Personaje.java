package entidades;

import java.util.Random;

import javax.swing.JOptionPane;

import datos.DataPersonaje;

public class Personaje 
	{
//-----------Attributes--------------//
	 int energia;
	 int evasion;
	 int vida;
	 int defensa;
	 int puntos;
	 String nombre;
	 int energiaOriginal;
	 int vidaOriginal;
//----------getters y setters----------------------//	
	public  int getEnergia() {
		return energia;
	}
	public  void setEnergia(int energia) {
		this.energia = energia;
	}
	public  int getEvasion() {
		return evasion;
	}
	public  void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	public  int getVida() {
		return vida;
	}
	public  void setVida(int vida) {
		this.vida = vida;
	}
	public  int getDefensa() {
		return defensa;
	}
	public  void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public  int getPuntos() {
		return puntos;
	}
	public  void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public int getEnergiaOriginal() {
		return energiaOriginal;
	}
	public void setEnergiaOriginal(int energiaOriginal) {
		this.energiaOriginal = energiaOriginal;
	}
	public int getVidaOriginal() {
		return vidaOriginal;
	}
	public void setVidaOriginal(int vidaOriginal) {
		this.vidaOriginal = vidaOriginal;
	}
	
	
	
	
	public void recibirAtaque(int valorAtaque)
	{
		Random numAleatorio= new Random();
		
	
		if ((numAleatorio.nextInt()*100) < this.getEvasion())
		{
			JOptionPane.showMessageDialog(null, "ATAQUE OK");
			this.setVida(this.getVida()-valorAtaque);
		
			
			if(this.getVida() <= 0)
			{ System.out.println("this.vida  "+this.getVida());
				JOptionPane.showMessageDialog(null, this.getNombre()+"PERDIO");
				
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "SE EVADIO EL ATAQUE");
		}
	};
	public int atacar(int valorAtaque,Personaje pAtacado)
	{
		this.setEnergia(this.getEnergia()-valorAtaque);
		
		pAtacado.recibirAtaque(valorAtaque);
		if (pAtacado.getVida()<=0)
		{this.gano();}
		return 0;
	};
	
	public void defender(int defensa)
	{
		int energiaARecuperar = energiaOriginal * defensa / 100 ;
		int vidaARecuperar = vidaOriginal * defensa / 250 ;
		
		if(this.getEnergia() + energiaARecuperar < energiaOriginal)
		{this.setEnergia(this.getEnergia() + energiaARecuperar);}
		if(this.getVida() + vidaARecuperar<vidaOriginal)
		{this.setVida(this.getVida() + vidaARecuperar);}
	};
	
	DataPersonaje data = new DataPersonaje();
	public void gano()
	{
		
	};
	
	}//fin personaje
