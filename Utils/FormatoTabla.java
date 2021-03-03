package Utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class FormatoTabla implements TableCellRenderer{
	public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
	Font normal = new Font( "Arial",Font.PLAIN,14 );
    Font negrilla = new Font( "Helvetica",Font.BOLD,14 );
    Font cursiva = new Font( "Times new roman",Font.ITALIC,14 );


	  public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column) {
	    Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
	        table, value, isSelected, hasFocus, row, column);
	    Color foreground = null, background = null;
	    renderer.setEnabled(table == null || table.isEnabled()); 	 
	    ((JLabel) renderer). setHorizontalAlignment(0);
	    table.setFont(normal);   
	    
	    if (isSelected) {
	      foreground = Color.BLACK;
	      background = Color.YELLOW;
	    } else {
	      if (row % 2 == 0) {
	        foreground = Color.BLACK;
	        background = Color.LIGHT_GRAY;
	      } else {
	        foreground = Color.BLACK;
	        background = Color.WHITE;
	      }
	    	  /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("No Alcohólica")){
	        	foreground = Color.WHITE;
	            background = Color.RED;               
	        }                        
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Alcohólica")){
	        	foreground = Color.WHITE;
	        	 background = Color.BLUE;              
	        }       
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Etiquetas")){
	        	foreground = Color.WHITE;
	        	 background = Color.BLUE;              
	        }        
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Cinturones")){
	        	foreground = Color.WHITE;
	        	 background = Color.RED;              
	        }        
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Estuches")){
	        	foreground = Color.BLACK;
	        	 background = Color.GREEN;              
	        }   
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Madera")){
	        	foreground = Color.BLACK;
	        	 background = Color.CYAN;              
	        }   
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Librito")){
	        	foreground = Color.BLACK;
	        	 background = Color.ORANGE;              
	        }   
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Cordones Elásticos Plateados")){
	        	foreground = Color.BLACK;
	        	 background = Color.PINK;              
	        }   
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Separadores")){
	        	foreground = Color.WHITE;
	        	 background = Color.MAGENTA;              
	        }  
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Cajas")){
	        	foreground = Color.WHITE;
	        	 background = Color.BLACK;   
	        	 }  
	        /*--------*/
	        if(String.valueOf(table.getValueAt(row,column)).equals("Botellas")){
	        	foreground = Color.BLACK;
	        	 background = Color.YELLOW;              
	        }  
	    }
	    renderer.setForeground(foreground);
	    renderer.setBackground(background);
	    return renderer;
	  }
	

}
