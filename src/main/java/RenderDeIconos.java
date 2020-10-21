
import java.awt.Component;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zer0
 */
public class RenderDeIconos 
	extends DefaultListCellRenderer {

	private Map<Object, ImageIcon> icons = null;
	
	public RenderDeIconos(Map<Object, ImageIcon> icons) {
		this.icons = icons;
	}
	
        @Override
	public Component getListCellRendererComponent(
		JList list, Object value, int index, 
		boolean isSelected, boolean cellHasFocus) {
		
		// Get the renderer component from parent class
		
		JLabel label = 
			(JLabel) super.getListCellRendererComponent(list, 
				value, index, isSelected, cellHasFocus);
		
		// Get icon to use for the list item value
		
		Icon icon = icons.get(value);
		
		// Set icon to display for value
		
		label.setIcon(icon);
		return label;
	}
}
