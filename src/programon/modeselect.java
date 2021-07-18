/**
 *[THIS CLASS IS NO LONGER USED -- FEATURE SCRAPPED]
 *
 *This class is used to display a window that
 *prompts the player to choose between a battle
 *between the player and a computer (single player
 *or the player with another player (PvP).
 
package programon;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class modeselect extends JFrame{ //Code for the mode selection window
    private JLabel question;
    private JButton single, multi;
    
    public modeselect(){
        super("Mode Selection");
        setLayout(new FlowLayout());
        
        question = new JLabel("Which mode would you like to play in?");
        single = new JButton("Single Player");
        multi = new JButton("Multiplayer");
        add(question); //adds the text into the window
        add(single); //adds the buttons into the window
        add(multi);

        handler action = new handler(); //refers to the handler subclass
        single.addActionListener(action);
        multi.addActionListener(action);
    }
    private class handler implements ActionListener{ //Subclass (class in a class)
        public void actionPerformed(ActionEvent event){ //what to do when either button is pressed
            dispose();
            if(event.getSource()==single)
                play.singleplayer();
            else if(event.getSource()==multi){
                play.multiplayer();
            }
        }
    }
}
*/