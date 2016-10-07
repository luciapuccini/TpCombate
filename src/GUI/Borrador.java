package GUI;
import javax.swing.*;

		public class Borrador
	{ 
			private JLabel  elej; 
			public void setElej(JLabel elej)
			{ 
			this.elej = elej; 
			} 
			public JLabel getElej()
			{ 
			return this.elej; 
			}

	} 

			class menu{ 
			Borrador a=new Borrador(); 
			JLabel elej = a.getElej(); 
			
	}
		/*	ImageIcon imagen = new ImageIcon("Logo.gif");
			JLabel etiqueta = new JLabel(imagen);
		*/
