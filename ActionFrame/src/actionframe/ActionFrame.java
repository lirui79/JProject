/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionframe;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class ActionFrame extends JFrame{

    private JPanel buttonPanel ;
    private static final int DEFAULT_WIDTH  = 300 ;
    private static final int DEFAULT_HEIGHT = 300 ;
    
    public ActionFrame()
    {
        setSize(DEFAULT_WIDTH , DEFAULT_HEIGHT) ;
        buttonPanel = new JPanel() ;
        
        Action yellowAction = new ColorAction("yellow" , new ImageIcon("icon/yellow-ball.gif") , Color.YELLOW) ;
        Action redAction = new ColorAction("red" , new ImageIcon("icon/red-ball.gif") , Color.RED) ;   
        Action blueAction = new ColorAction("blue" , new ImageIcon("icon/blue-ball.gif") , Color.BLUE) ;   
        
        buttonPanel.add(new JButton(yellowAction)) ;
        buttonPanel.add(new JButton(redAction)) ;
        buttonPanel.add(new JButton(blueAction)) ;
        
        add(buttonPanel) ;
        
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT) ;
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        
        ActionMap amap = buttonPanel.getActionMap() ;
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.red", redAction);
        amap.put("panel.blue", blueAction);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
        EventQueue.invokeLater(new Runnable(){
            public void run()
            {           
               ActionFrame frame = new ActionFrame() ;
               frame.setTitle("Action Frame test");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
        });       
    }
    
    public class ColorAction extends AbstractAction{
        public ColorAction(String name , Icon icon , Color c)
        {
            putValue(Action.NAME , name) ;
            putValue(Action.SMALL_ICON , icon) ;
            putValue(Action.SHORT_DESCRIPTION , "Set panel color to " + name.toLowerCase()) ;
            putValue("color" , c) ;
        }
        
        public void actionPerformed(ActionEvent event)
        {
            Color c = (Color) getValue("color") ;
            buttonPanel.setBackground(c);
        }
    }
    
    
}
