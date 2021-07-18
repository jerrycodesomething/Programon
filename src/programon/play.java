/**
 * This class is where all the game functions are
 */

package programon;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;


public class play extends JFrame{
    private static JOptionPane frame;
    protected static String[] name = new String[12];//Will be used in POKEMON JList in actionpanel class
    protected static Object[] p1name = new Object[3], p2name = new Object[3];//Selected pokemon
    protected static Object[] p1item = new Object[3], p2item = new Object[3];//Selected items
    protected static String[] move = new String[4], movep1=new String[4], movep2=new String[4];
    protected static String[] item;//Will be used in BAG JList in actionpanel class
    protected static Object selectedPokemon1, selectedPokemon2;
    protected static Object selectedMove1, selectedMove2; // ADDED by J
    protected static Object selectedItem1, selectedItem2;// ADDED by J
    protected static pokemon[] p = new pokemon[12];
    protected static int[] pokeindex= new int []{0,0};  // update value of index of pokemon hp
    protected static int[] moveindex= new int []{0,0};
    protected static int[] itemindex= new int []{0,0};
    protected static int[] moveAtkp1= new int[4], moveAtkp2= new int[4]; //ADDED by J
    protected static int[] moveAccp1= new int[4], moveAccp2= new int[4]; //ADDED by J 
    protected static boolean[] moveIsType1 = new boolean[4], moveIsType2 = new boolean[4];
    protected static pokemon[] pplayer1= new pokemon[12], pplayer2= new pokemon[12];
    
    //(DATA LOADED)     GAME MODE PLAYER METHODS
    
    //SCRAPPED CODE//
    /*
    public static void singleplayer(){
        pokemonData();
        getAllPokemonNames();
        selection(false);//calls the itemselection method to open the item selection window
    }
    */
    
    public static void multiplayer(){
        pokemonData();
        getAllPokemonNames();
        selection(true);
    }
    
    //POKEMON TEXT FILE READER
    public static void pokemonData(){
        //Input method from text file
       
        try{
            Scanner s = new Scanner(new FileInputStream("pokemondata.txt"));
            boolean[] movetype = new boolean[4];
            int[] moveatk = new int[4], moveacc = new int[4];
            //input goes here
        while(s.hasNextLine()){
            for (int i=0; i<12; i++) {
                p[i] = new pokemon();
                p[i].setName(s.nextLine());
                p[i].setType(s.nextLine());
                p[i].setAttack(Integer.parseInt(s.nextLine()));
                p[i].setDefence(Integer.parseInt(s.nextLine()));
                p[i].setFullHP(Integer.parseInt(s.nextLine()));
                p[i].setCurrentHP(p[i].getFullHP());
                p[i].setSpeed(Integer.parseInt(s.nextLine()));
                for(int j=0; j<4; j++){
                    move[j] = s.nextLine();
                    if(s.nextLine().equalsIgnoreCase("Normal"))
                        movetype[j] = false;
                    else
                        movetype[j] = true;
                    moveatk[j] = Integer.parseInt(s.nextLine());
                    moveacc[j] = Integer.parseInt(s.nextLine());
                }
                p[i].setMoves(move);
                p[i].setMovetype(movetype);
                p[i].setMoveatk(moveatk);
                p[i].setMoveacc(moveacc);
                if(s.hasNextLine())
                    s.nextLine();
            }
            for (int i=0; i<12;i++){
                pplayer1[i]=p[i];
                pplayer2[i]=p[i];
            }
        
        }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(frame, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }              
    }
    
    public static void selection(boolean multi){//true if multiplayer
        selectionpanel sel = new selectionpanel(multi);
        sel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sel.setLocationRelativeTo(null);
        if(!multi)
            sel.setSize(400,220);
        else if(multi)
            sel.setSize(330,450);
        sel.setResizable(false);
        sel.setVisible(true);
        sel.addWindowListener(new WindowListener() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //music.soundtrack("opening", "stop");
                    System.exit(-1);
                }
                @Override 
                public void windowOpened(WindowEvent e) {}
                @Override 
                public void windowClosed(WindowEvent e) {}
                @Override 
                public void windowIconified(WindowEvent e) {}
                @Override 
                public void windowDeiconified(WindowEvent e) {}
                @Override 
                public void windowActivated(WindowEvent e) {}
                @Override 
                public void windowDeactivated(WindowEvent e) {}

            });
        }
    
    public static void actionWindow(boolean multi){//called from selectionpanel class
        if(!multi){/* //SCRAPPED CODE//
            actionpanel p1 = new actionpanel(false, 1);
            p1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            int x,y;
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
            Rectangle display = defaultScreen.getDefaultConfiguration().getBounds();
            
            x=(int) ((display.getMaxX()-p1.getWidth())*0.5);
            y=(int) ((display.getMaxY()-p1.getHeight())*0.6);
            
            p1.setLocation(x,y);
            p1.setSize(330,270);
            p1.setResizable(false);
            p1.setVisible(true);
            p1.addWindowListener(new WindowListener() {
                @Override
                public void windowClosing(WindowEvent e) {
                    music.soundtrack("battle", "stop");
                    System.exit(-1);
                }
                @Override 
                public void windowOpened(WindowEvent e) {}
                @Override 
                public void windowClosed(WindowEvent e) {}
                @Override 
                public void windowIconified(WindowEvent e) {}
                @Override 
                public void windowDeiconified(WindowEvent e) {}
                @Override 
                public void windowActivated(WindowEvent e) {}
                @Override 
                public void windowDeactivated(WindowEvent e) {}

            });
            */
        }
        else if(multi){
            actionpanel p1 = new actionpanel(true, 1);
            actionpanel p2 = new actionpanel(true, 2);
            //action disp = new displaypanel(); //Refers to a class that opens a window to display ongoing battle (not yet created)
            p1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            p2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
            int x1,x2,y;
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
            Rectangle display = defaultScreen.getDefaultConfiguration().getBounds();
        
            x1=0;
            x2=(int) ((display.getMaxX()-p2.getWidth())*0.75);
            y=(int) ((display.getMaxY()-p1.getHeight())*0.6);
        
            p1.setLocation(x1,y);
            p2.setLocation(x2,y);
            p1.setSize(330,270);
            p2.setSize(330,270);
            p1.setResizable(false);
            p2.setResizable(false);
            p1.setVisible(true);
            p2.setVisible(true);
            p1.addWindowListener(new WindowListener() {
                @Override
                public void windowClosing(WindowEvent e) {
                    p2.dispose();
                    //music.soundtrack("battle", "stop");
                    System.exit(-1);
                }
                @Override 
                public void windowOpened(WindowEvent e) {}
                @Override 
                public void windowClosed(WindowEvent e) {}
                @Override 
                public void windowIconified(WindowEvent e) {}
                @Override 
                public void windowDeiconified(WindowEvent e) {}
                @Override 
                public void windowActivated(WindowEvent e) {}
                @Override 
                public void windowDeactivated(WindowEvent e) {}

            });
            p2.addWindowListener(new WindowListener() {
                @Override
                public void windowClosing(WindowEvent e) {
                    p1.dispose();
                    //music.soundtrack("battle", "stop");
                    System.exit(-1);
                }
                @Override 
                public void windowOpened(WindowEvent e) {}
                @Override 
                public void windowClosed(WindowEvent e) {}
                @Override 
                public void windowIconified(WindowEvent e) {}
                @Override 
                public void windowDeiconified(WindowEvent e) {}
                @Override 
                public void windowActivated(WindowEvent e) {}
                @Override 
                public void windowDeactivated(WindowEvent e) {}
            });
        }
    }
    
    public static String[] getAllPokemonNames(){
        //Transfers all pokemon names into a single array
        for(int i=0;i<12;i++){
            name[i]=p[i].getName();
        }
        return name;
    }
    
    //SCRAPPED CODE//
    /*
    public static void setPokemonSingle(Object[] p1p, Object[] p1i){
        //Retrieves the selected pokemon/items from selectionpanel class
        p1name = p1p;
        p1item = p1i;
    }
    */
    
    public static void setPokemonMulti(Object[] p1p, Object[] p1i, Object[] p2p, Object[] p2i){
        //Retrieves the selected pokemon/items from selectionpanel class
        p1name = p1p;
        p1item = p1i;
        p2name = p2p;
        p2item = p2i;
    }
    
    public static String[] getpokemonnames(){//for use in selectionpanel
        return name;
    }
    //HIGHLIGHT and select POKEMON from list
    public static void selectPokemon(Object pokemon, int player){//have a variable for the currently selected pokemon

        if(player==1){
            selectedPokemon1=pokemon;
        }
        else if(player==2){
            selectedPokemon2=pokemon;
            
        }    
    }
        //HIGHLIGHT and select MOVE from list
    public static void selectMove(Object selmove, int player){//have a variable for the currently selected pokemon

        if(player==1){
            selectedMove1=selmove;    
        }
        else if(player==2){
            selectedMove2=selmove;
        }    
    }
    
    //HIGHLIGHT AND CHOOSE ITEM
    public static void selectItem(Object selitem, int player){//have a variable for the currently selected pokemon

        if(player==1){
            selectedItem1=selitem;
        }
        else if(player==2){
            selectedItem2=selitem; 
        }
    }        
    
    //  SELECT POKEMON move
    public static Object[] usePokemon(int player){//gets the selected Pokemon's moves when clicking FIGHT -- ALSO ASSIGNS POKEINDEX
        if(player==1){
            for(pokeindex[0]=0; pokeindex[0]<p.length; pokeindex[0]++){
                if(p[pokeindex[0]].getName().equalsIgnoreCase(selectedPokemon1.toString())){
                    movep1=p[pokeindex[0]].getMoves();
                    break;
                }
            }
            return movep1;
        }
        else if(player==2){
            for(pokeindex[1]=0; pokeindex[1]<p.length; pokeindex[1]++){
                if(p[pokeindex[1]].getName().equalsIgnoreCase(selectedPokemon2.toString())){
                    movep2=p[pokeindex[1]].getMoves();
                    break;            
                }
            }
            return movep2;
        }
        return move;
        }
    
    //Move ATK TYPE ACCURACY Assign
    public static void useMove(int player){
        if(player==1){
            for(moveindex[0]=0; moveindex[0]<movep1.length; moveindex[0]++){
                if(movep1[moveindex[0]].equalsIgnoreCase(selectedMove1.toString())){  
                    moveAtkp1=pplayer1[moveindex[0]].getMoveatk();
                    moveIsType1=pplayer1[moveindex[0]].getMovetype();
                    moveAccp1=pplayer1[moveindex[0]].getMoveacc();
                    break;
                }
            }
        }
        else if(player==2){
            for(moveindex[1]=0; moveindex[1]<movep2.length; moveindex[1]++){
                if(movep2[moveindex[1]].equalsIgnoreCase(selectedMove2.toString())){    
                    moveAtkp2=pplayer2[moveindex[1]].getMoveatk();      
                    moveIsType2=pplayer2[moveindex[1]].getMovetype();
                    moveAccp2=pplayer2[moveindex[1]].getMoveacc();
                    break;            
                }
            }
        }
    }
    public static void useItem(int player){//Using selected items on the Pokemon
        if(player==1){
            for(itemindex[0]=0; itemindex[0]<p1item.length; itemindex[0]++){
                if(selectedItem1.equals(p1item[itemindex[0]]) && p1item[itemindex[0]].equals("Potion")){
                    pplayer1[pokeindex[0]].setCurrentHP(pplayer1[pokeindex[0]].getCurrentHP()+20);
                    if(pplayer1[pokeindex[0]].getCurrentHP()>pplayer1[pokeindex[0]].getFullHP()){
                        pplayer1[pokeindex[0]].setCurrentHP(pplayer1[pokeindex[0]].getFullHP());
                        System.out.println("HP is now full!");
                    }
                    System.out.println("HP Restored by 20");
                    break;
                }
                else if(selectedItem1.equals(p1item[itemindex[0]]) && p1item[itemindex[0]].equals("HP Up")){
                    pplayer1[pokeindex[0]].setCurrentHP(pplayer1[pokeindex[0]].getFullHP());
                    System.out.println("HP Restored to full!");
                    break;
                }
                else if(selectedItem1.equals(p1item[itemindex[0]]) && p1item[itemindex[0]].equals("X Speed")){
                    pplayer1[pokeindex[0]].setSpeed(pplayer1[pokeindex[0]].getSpeed()+10);
                    System.out.println("Speed increased!");
                    break;
                }
                else if(selectedItem1.equals(p1item[itemindex[0]]) && p1item[itemindex[0]].equals("X Attack")){
                    pplayer1[pokeindex[0]].setAttack(pplayer1[pokeindex[0]].getAttack()+10);
                    System.out.println("Attack increased!");
                    break;
                }
                else if(selectedItem1.equals(p1item[itemindex[0]]) && p1item[itemindex[0]].equals("X Defence")){
                    pplayer1[pokeindex[0]].setDefence(pplayer1[pokeindex[0]].getDefence()+10);
                    System.out.println("Defence increased!");
                    break;
                }
                
            }
        }
        else if(player==2){
            for(itemindex[1]=0; itemindex[1]<p2item.length; itemindex[1]++){
                if(selectedItem2.equals(p2item[itemindex[1]]) && p2item[itemindex[1]].equals("Potion")){
                    pplayer2[pokeindex[1]].setCurrentHP(pplayer2[pokeindex[1]].getCurrentHP()+20);
                    if(pplayer2[pokeindex[1]].getCurrentHP()>pplayer2[pokeindex[1]].getFullHP()){
                        pplayer2[pokeindex[1]].setCurrentHP(pplayer2[pokeindex[1]].getFullHP());
                        System.out.println("HP is now full!");
                    }
                    System.out.println("HP Restored by 20");
                    break;
                }
                else if(selectedItem2.equals(p2item[itemindex[1]]) && p2item[itemindex[1]].equals("HP Up")){
                    pplayer2[pokeindex[1]].setCurrentHP(pplayer2[pokeindex[1]].getFullHP());
                    System.out.println("HP Restored to full!");
                    break;
                }
                else if(selectedItem2.equals(p2item[itemindex[1]]) && p2item[itemindex[1]].equals("X Speed")){
                    pplayer2[pokeindex[1]].setSpeed(pplayer2[pokeindex[1]].getSpeed()+10);
                    System.out.println("Speed increased!");
                    break;
                }
                else if(selectedItem2.equals(p2item[itemindex[1]]) && p2item[itemindex[1]].equals("X Attack")){
                    pplayer2[pokeindex[1]].setAttack(pplayer2[pokeindex[1]].getAttack()+10);
                    System.out.println("Attack increased!");
                    break;
                }
                else if(selectedItem2.equals(p2item[itemindex[1]]) && p2item[itemindex[1]].equals("X Defence")){
                    pplayer2[pokeindex[1]].setDefence(pplayer2[pokeindex[1]].getDefence()+10);
                    System.out.println("Defence increased!");
                    break;
                }
            }
        }
    }
    public static double getSelectedPokemonHP(int player){//Return the HP of the selected pokemon
            if(player==1){
                return pplayer1[pokeindex[0]].getCurrentHP();
            }
            else if(player==2)
                return pplayer2[pokeindex[1]].getCurrentHP();
            return 0;
        }
}