package entidades;

import java.util.Random;

import javax.swing.JOptionPane;

public class Personaje 
	{
//-----------Attributes--------------//
	 int energia;
	 int evasion;
	 int vida;
	 int defensa;
	 int puntos;
	 String nombre;
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
	

	
	
	public void recibirAtaque(int valorAtaque)
	{
		Random numAleatorio= new Random();
		if ((numAleatorio.nextInt()*100) < this.getEvasion())
		{
			this.setVida(this.getVida()-valorAtaque);
			if(this.getVida()== 0)
			{
				JOptionPane.showMessageDialog(null, "Perdio");
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
		return 0;
	};
	
	
	
	}//fin personaje
