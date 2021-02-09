/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangle;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import javax.swing.JPanel;

/**
 *
 * @author asus
 */
public class PanelRespuesta extends JPanel {
    
    TextArea respuesta=new TextArea("Respuesta",9,40);
    
    public PanelRespuesta(){
        setBackground(Color.yellow);
        add(respuesta);
    }
    
}
