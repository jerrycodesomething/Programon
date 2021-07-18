/**
 * This class is for the window that contains all the players actions.
 */
package programon;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class actionpanel extends JFrame{
    private JButton fight, bag, pokemon, run, select;
    private JList list;
    private int state=0;
    private JScrollPane scrollpane;
    private state st = new state();
    private int player,/*opponent,*/ lastselectedpokemon;
    private boolean multi;
    //private Object selectedPokemon;
    private Object[] MoveList, ItemList, PokemonList;
    private DefaultListModel 
            M_MoveList = new DefaultListModel(),
            M_ItemList = new DefaultListModel(),
            M_PokemonList = new DefaultListModel();

    public actionpanel(boolean multi, int player){
        this.multi=multi;
        this.player = player;
        
        /*Unused code. Might need it later
        if(player==1)
            opponent=2;
        else if(player==2)
            opponent=1;
        */
        
        ItemList = st.bag(player);
        PokemonList = st.pokemon(player);
        
        for(int i=0;i<ItemList.length;i++)
            M_ItemList.addElement(ItemList[i]);
        for(int i=0;i<PokemonList.length;i++)
            M_PokemonList.addElement(PokemonList[i]);
        setLayout(new FlowLayout());
        //state st = new state();
        if(player==1)
            setTitle("Player 1");
        else
            setTitle("Player 2");
        fight = new JButton("FIGHT");
        bag = new JButton("BAG");
        pokemon = new JButton("POKEMON");
        run = new JButton("RUN"); //run button will trigger a surrender, player automatically loses.
        select = new JButton("SELECT"); //used to select a different pokemon/items.
        //pokemonList = new JList(st.pokemon(player));
        scrollpane = new JScrollPane(list);
        scrollpane.setPreferredSize(new Dimension(250, 150));
        scrollpane.setAlignmentX(LEFT_ALIGNMENT);
        list = new JList(st.empty());
        scrollpane.setViewportView(list);
        
        add(fight);
        add(bag);
        add(pokemon);
        add(run);
        add(scrollpane);
        //add(list);
        add(select);
        
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        
        handler action = new handler();
        fight.addActionListener(action);
        bag.addActionListener(action);
        pokemon.addActionListener(action);
        run.addActionListener(action);
        select.addActionListener(action);
    }
    
    public Object selected(){ //returns the value of the selected item in the list
        return list.getSelectedValue();
    }
    
    //action LISTENER
    private class handler implements ActionListener{ //Subclass (class in a class)
        public void actionPerformed(ActionEvent event) throws ArrayIndexOutOfBoundsException{ //what to do when either button is pressed
            if(event.getSource()==fight){
                M_MoveList.removeAllElements();
                //listitems = st.attack(player);
                MoveList = st.attack(player);
                for(int i=0;i<MoveList.length;i++)
                    M_MoveList.addElement(MoveList[i]);
                list = new JList(M_MoveList);
                scrollpane.setViewportView(list);
            }
            else if(event.getSource()==bag){
                //M_List.removeAllElements();
                //listitems = st.bag(player);
                st.bag(player);
                list = new JList(M_ItemList);
                scrollpane.setViewportView(list);
            }
            else if(event.getSource()==pokemon){
                //M_List.removeAllElements();
                //listitems = st.pokemon(player);
                try{
                if(play.getSelectedPokemonHP(player)<=0)
                    M_PokemonList.remove(lastselectedpokemon);
                if(M_PokemonList.getSize()==0){
                    if(player==1)
                        System.out.println("All of Player 1's Pokemon have fainted. Player 2 wins!");
                    else{
                        System.out.println("All of Player 2's Pokemon have fainted. Player 1 wins!");
                    }
                }
                st.pokemon(player);
                list = new JList(M_PokemonList);
                scrollpane.setViewportView(list);
                }catch(ArrayIndexOutOfBoundsException e){}
            }
            else if(event.getSource()==run){
                dispose();
                if(player==1)
                        System.out.println("Player 1 forfeits. Player 2 wins!");
                    else{
                        System.out.println("Player 2 forfeits. Player 1 wins!");
                }
            }
            // SELECTING BUTTON TO PROMPT
            else if(event.getSource()==select){
                if(st.getState(player)==1){//fight call new function on battle class
                    if(player==1 && battle.turnIs()==2){}
                    else if(player==2 && battle.turnIs()==1){}
                    else{
                        if(list.getSelectedIndex()<0){}
                        else{
                            play.selectMove(list.getSelectedValue(),player);
                            System.out.println("Player " + player + " used " + list.getSelectedValue());
                            play.useMove(player);
                            if(!multi){
                            //Insert single player battle method calls
                            }
                            else{
                            battle.accDet(player);                    
                            battle.multiplier(player);
                            battle.dmg(player);
                            }
                        }
                    }
                    //M_List.remove(list.getSelectedIndex());
                }
                else if(st.getState(player)==2){//bag 
                    if(player==1 && battle.turnIs()==2){}
                    else if(player==2 && battle.turnIs()==1){}
                    else{
                        if(list.getSelectedIndex()<0){}
                        else{
                            play.selectItem(list.getSelectedValue(),player);  
                            System.out.println("Player " + player + " used item " + list.getSelectedValue());
                            play.useItem(player);
                            M_ItemList.remove(list.getSelectedIndex());
                        }
                    }
                }
                else if(st.getState(player)==3){//pokemon call new function on play class
                    if(player==1 && battle.turnIs()==2){}
                    else if(player==2 && battle.turnIs()==1){}
                    else{
                        if(list.getSelectedIndex()<0){}
                        else{
                            play.selectPokemon(list.getSelectedValue(), player);
                            System.out.println("Player " + player + " chose " + list.getSelectedValue());
                            lastselectedpokemon=list.getSelectedIndex();
                            play.usePokemon(player);
                            battle.playerallselect(player);
                        }
                    }
                }
            }
        }
    }
}