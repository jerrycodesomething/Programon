/**
This class is used for the item/pokemon selection window.
*/
package programon;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class selectionpanel extends JFrame{
    private boolean multi;
    private final String[] names=play.getpokemonnames();
    private final String[] items= new String[]{"Potion","HP Up","X Speed","X Attack", "X Defence"};
    private JButton addp1, addi1, addp2, addi2, done;
    private JList pokemonlist1, pokemonlist2, itemlist1, itemlist2;
    private int count1=3, count2=3, i=0,j=0,k=0,l=0;
    private JLabel p1label, p2label,/* p1itemslabel, p2itemslabel,*/ bigspace;
    //private JTextField counter1, counter2;
    private JScrollPane S_pokemonlist1, S_itemlist1, S_pokemonlist2, S_itemlist2;
    private DefaultListModel
            M_pokemonlist1=new DefaultListModel(),
            M_itemlist1=new DefaultListModel(),
            M_pokemonlist2=new DefaultListModel(),
            M_itemlist2=new DefaultListModel();
    
    //Arrays to hold the selected pokemon and items
    private Object[] p1p = new String[3], p1i = new String[3], p2p = new String[3], p2i = new String[3];
    
    public selectionpanel(boolean multi) {
        super("Choose your Pokemon");
        System.out.println();
        setLayout(new FlowLayout());
        this.multi = multi;
        if(!multi){
            for(int i=0;i<names.length;i++)
                M_pokemonlist1.addElement(names[i]);
            pokemonlist1 = new JList(M_pokemonlist1);

            S_pokemonlist1 = new JScrollPane(pokemonlist1);
            S_pokemonlist1.setPreferredSize(new Dimension(150, 150));
            S_pokemonlist1.setAlignmentX(LEFT_ALIGNMENT);
        
            S_pokemonlist1.setViewportView(pokemonlist1);
            
            for(int i=0;i<items.length;i++)
                M_itemlist1.addElement(items[i]);
            itemlist1 = new JList(M_itemlist1);
        
            S_itemlist1 = new JScrollPane(itemlist1);
            S_itemlist1.setPreferredSize(new Dimension(150, 150));
            S_itemlist1.setAlignmentX(LEFT_ALIGNMENT);
        
            S_itemlist1.setViewportView(itemlist1);
            
            addp1 = new JButton("ADD POKEMON");
            addi1 = new JButton("ADD ITEM");
            done = new JButton("DONE");
            
            add(S_pokemonlist1);
            bigspace = new JLabel("    ");
            add(bigspace);
            p1label = new JLabel("Items:");
            add(p1label);
            add(S_itemlist1);
            
            add(addp1);
            bigspace = new JLabel("    ");
            add(bigspace);
            //add(bigspace);
            add(done);
            bigspace = new JLabel("    ");
            add(bigspace);
            add(addi1);
            
            
            //List parameters
            pokemonlist1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            pokemonlist1.setLayoutOrientation(JList.VERTICAL);
            pokemonlist1.setVisibleRowCount(-1);
        
            itemlist1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            itemlist1.setLayoutOrientation(JList.VERTICAL);
            itemlist1.setVisibleRowCount(-1);
        
            handler action = new handler();
            addp1.addActionListener(action);
            addi1.addActionListener(action);
            done.addActionListener(action);
        }
        else if(multi){
            //Top labels for players
            p1label = new JLabel("Player 1");
            bigspace = new JLabel("                                  ");
            p2label = new JLabel("Player 2");
        
            add(p1label);
            add(bigspace);
            add(p2label);

            //List of Pokemon for Player 1 to select
            //pokemonlist1 = new JList(names);
            for(int i=0;i<names.length;i++)
                M_pokemonlist1.addElement(names[i]);
            pokemonlist1 = new JList(M_pokemonlist1);

            S_pokemonlist1 = new JScrollPane(pokemonlist1);
            S_pokemonlist1.setPreferredSize(new Dimension(150, 150));
            S_pokemonlist1.setAlignmentX(LEFT_ALIGNMENT);
        
            S_pokemonlist1.setViewportView(pokemonlist1);
            //add(pokemonlist1);
            //add(S_pokemonlist1);
        
            //List of items for Player 1 to select
            //itemlist1 = new JList(items);
            for(int i=0;i<items.length;i++)
                M_itemlist1.addElement(items[i]);
            itemlist1 = new JList(M_itemlist1);
        
            S_itemlist1 = new JScrollPane(itemlist1);
            S_itemlist1.setPreferredSize(new Dimension(150, 150));
            S_itemlist1.setAlignmentX(LEFT_ALIGNMENT);
        
            S_itemlist1.setViewportView(itemlist1);
            //add(itemlist1);
            //add(S_itemlist1);
        
            //Add Pokemon and items button for Player 1
            addp1 = new JButton("ADD POKEMON");
            addi1 = new JButton("ADD ITEM");
        
            //List of Pokemon for Player 2 to select
            for(int i=0;i<names.length;i++)
                M_pokemonlist2.addElement(names[i]);
            pokemonlist2 = new JList(M_pokemonlist2);
            //pokemonlist2 = new JList(names);
        
            S_pokemonlist2 = new JScrollPane(pokemonlist2);
            S_pokemonlist2.setPreferredSize(new Dimension(150, 150));
            S_pokemonlist2.setAlignmentX(LEFT_ALIGNMENT);
        
            S_pokemonlist2.setViewportView(pokemonlist2);
            //add(pokemonlist2);
            //add(S_pokemonlist2);
        
            //List of items for Player 2 to select
            for(int i=0;i<items.length;i++)
                M_itemlist2.addElement(items[i]);
            itemlist2 = new JList(M_itemlist2);
            //itemlist2 = new JList(items);
        
            S_itemlist2 = new JScrollPane(itemlist2);
            S_itemlist2.setPreferredSize(new Dimension(150, 150));
            S_itemlist2.setAlignmentX(LEFT_ALIGNMENT);
        
            S_itemlist2.setViewportView(itemlist2);
            //add(itemlist2);
            //add(S_itemlist2);
        
            //Add Pokemon and items button for Player 2
            addp2 = new JButton("ADD POKEMON");
            addi2 = new JButton("ADD ITEM");
        
            //Done button transfers the selected Pokemon & items to the play class and closes the panel
            done = new JButton("DONE");
        
            //Adding the GUI elements
            add(S_pokemonlist1);
            add(S_pokemonlist2);
        
            p1label = new JLabel("Items:");
            bigspace = new JLabel("                                      ");
            p2label = new JLabel("Items:");
        
            add(p1label);
            add(bigspace);
            add(p2label);
        
            //add(p1label);
            //add(bigspace);
            //add(p2label);
            add(S_itemlist1);
            add(S_itemlist2);
            add(addp1);
            bigspace = new JLabel(" ");
            add(bigspace);
            add(addp2);
            add(addi1);
            add(done);
            add(addi2);
        
            //List parameters
            pokemonlist1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            pokemonlist1.setLayoutOrientation(JList.VERTICAL);
            pokemonlist1.setVisibleRowCount(-1);
        
            itemlist1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            itemlist1.setLayoutOrientation(JList.VERTICAL);
            itemlist1.setVisibleRowCount(-1);
        
            pokemonlist2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            pokemonlist2.setLayoutOrientation(JList.VERTICAL);
            pokemonlist2.setVisibleRowCount(-1);
        
            itemlist2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            itemlist2.setLayoutOrientation(JList.VERTICAL);
            itemlist2.setVisibleRowCount(-1);
        
            handler action = new handler();
            addp1.addActionListener(action);
            addi1.addActionListener(action);
            addp2.addActionListener(action);
            addi2.addActionListener(action);
            done.addActionListener(action);
        }
        
    }
    
    private class handler implements ActionListener{ //Subclass (class in a class)
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==addp1){
                if(pokemonlist1.getSelectedIndex()<0){}
                else{
                    if(i<3){
                        p1p[i] = pokemonlist1.getSelectedValue();
                        M_pokemonlist2.remove(pokemonlist1.getSelectedIndex());
                        M_pokemonlist1.remove(pokemonlist1.getSelectedIndex());
                    }
                i++;   
                }
            }
            else if(event.getSource()==addi1){
                if(itemlist1.getSelectedIndex()<0){}
                else{
                    if(j<3){
                        p1i[j] = itemlist1.getSelectedValue();
                        M_itemlist1.remove(itemlist1.getSelectedIndex());
                    }
                j++;
                }
            }
            else if(event.getSource()==addp2){
                if(pokemonlist2.getSelectedIndex()<0){}
                else{
                    if(k<3){
                        p2p[k] = pokemonlist2.getSelectedValue();
                        M_pokemonlist1.remove(pokemonlist2.getSelectedIndex());
                        M_pokemonlist2.remove(pokemonlist2.getSelectedIndex());
                    }
                k++;
                }
                
            }
            else if(event.getSource()==addi2){
                if(itemlist2.getSelectedIndex()<0){}
                else{
                    if(l<3){
                        p2i[l] = itemlist2.getSelectedValue();
                        M_itemlist2.remove(itemlist2.getSelectedIndex());
                    }
                l++;
                }
            }
            else if(event.getSource()==done){
                if(!multi){}/* //SCRAPPED CODE//
                    play.setPokemonSingle(p1p, p1i);
                    */
                else if(multi)
                    play.setPokemonMulti(p1p,p1i,p2p,p2i);
                //music.soundtrack("battle", "play");
                play.actionWindow(multi);
                dispose();
            }
        }
    }
}