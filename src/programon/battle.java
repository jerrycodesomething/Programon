/**
 * This class is where all the battle logic are.
 */

package programon;

import java.util.Random;
import java.util.Scanner;


public class battle extends play{
    //  DECLARATION OF INSTANCE VARIABLES
    private static int accumulator1=0, accumulator2=0;   //speed accumulator for turn selection
    private static boolean p1pokeselect=false, p2pokeselect=false;
    private static double p1doesdmg, p2doesdmg;
    private static double multiplier1, multiplier2;
    private static int acc, turn;
    private static Scanner s=new Scanner(System.in);
    //ACCURACY Determminer
    public static void accDet(int player){    
        if(player==1){    
            if(moveAccp1[moveindex[0]]==50){
                acc=accuracy50();        
            }
            else if(moveAccp1[moveindex[0]]==60){
                acc=accuracy60();   
            }
            else if(moveAccp1[moveindex[0]]==65){
                acc=accuracy65();   
            }
            else if(moveAccp1[moveindex[0]]==70){
                acc=accuracy70();   
            }  
            else if(moveAccp1[moveindex[0]]==100){
                acc=accuracy100();
            }
        }
        if(player==2){               
            if(moveAccp2[moveindex[1]]==50){
                acc=accuracy50();        
            }
            else if(moveAccp2[moveindex[1]]==60){
                acc=accuracy60();   
            }
            else if(moveAccp2[moveindex[1]]==65){
                acc=accuracy65();   
            }
            else if(moveAccp2[moveindex[1]]==70){
                acc=accuracy70();   
            }  
            else if(moveAccp2[moveindex[1]]==100){
            acc=accuracy100();
            }
        }    
    }
    //MOVE TYPE MULTIPLIER DETERMINER
    public static void multiplier(int player){
        if(player==1){
            if(moveIsType1[moveindex[0]]==false){
                multiplier1=1;
            }
            else{
                if(pplayer1[pokeindex[0]].getType().equalsIgnoreCase(pplayer2[pokeindex[1]].getType())){
                    multiplier1=1;
                }
                if(pplayer1[pokeindex[0]].getType().equalsIgnoreCase("water")  &&   
                        pplayer2[pokeindex[1]].getType().equalsIgnoreCase("fire")){
                    multiplier1=2;
                }
                if(pplayer1[pokeindex[0]].getType().equalsIgnoreCase("fire")  &&   
                        pplayer2[pokeindex[1]].getType().equalsIgnoreCase("grass")){
                    multiplier1=2;   
                }
                if(pplayer1[pokeindex[0]].getType().equalsIgnoreCase("grass")  &&   
                        pplayer2[pokeindex[1]].getType().equalsIgnoreCase("water")){
                    multiplier1=2;         
                }
                if(pplayer1[pokeindex[0]].getType().equalsIgnoreCase("fire")  &&   
                        pplayer2[pokeindex[1]].getType().equalsIgnoreCase("water")){
                    multiplier1=0.5;
                }
                if(pplayer1[pokeindex[0]].getType().equalsIgnoreCase("grass")  &&   
                        pplayer2[pokeindex[1]].getType().equalsIgnoreCase("fire")){
                    multiplier1=0.5;          
                }
                if(pplayer1[pokeindex[0]].getType().equalsIgnoreCase("water")  &&   
                        pplayer2[pokeindex[1]].getType().equalsIgnoreCase("grass")){
                    multiplier1=0.5;   
                }
            }
        }
        else if(player==2){
            if(moveIsType2[moveindex[1]]==false){
        multiplier2=1;
            }
            else{
                if(pplayer2[pokeindex[1]].getType().equalsIgnoreCase(pplayer1[pokeindex[0]].getType()))
                    multiplier2=1;
                if(pplayer2[pokeindex[1]].getType().equalsIgnoreCase("water")  &&   
                        pplayer1[pokeindex[0]].getType().equalsIgnoreCase("fire")){
                    multiplier2=2;
                }
                if(pplayer2[pokeindex[1]].getType().equalsIgnoreCase("fire")  &&   
                        pplayer1[pokeindex[0]].getType().equalsIgnoreCase("grass")){
                    multiplier2=2;      
                }
                if(pplayer2[pokeindex[1]].getType().equalsIgnoreCase("grass")  &&   
                        pplayer1[pokeindex[0]].getType().equalsIgnoreCase("water")){
                    multiplier2=2;   
                }
                if(pplayer2[pokeindex[1]].getType().equalsIgnoreCase("fire")  &&   
                        pplayer1[pokeindex[0]].getType().equalsIgnoreCase("water")){
                    multiplier2=0.5;
                }
                if(pplayer2[pokeindex[1]].getType().equalsIgnoreCase("grass")  &&   
                        pplayer1[pokeindex[0]].getType().equalsIgnoreCase("fire")){
                    multiplier2=0.5;     
                }
                if(pplayer2[pokeindex[1]].getType().equalsIgnoreCase("water")  &&   
                        pplayer1[pokeindex[0]].getType().equalsIgnoreCase("grass")){
                    multiplier2=0.5;    
                }
            }
        }
    }
    //WHERE THE SETTING OF Current Hp and damage occurs MAIN PART!!!
    public static void dmg(int player){//called when player 1 selects move to fight
        // if(pplayer1[pokeindex[0]].getMove)
        if(player==1){
            if(acc==1){
                p1doesdmg=(((pplayer1[pokeindex[0]].getAttack() * moveAtkp1[moveindex[0]]/ pplayer2[pokeindex[1]].getDefence()) / 20) + 2) * multiplier1;     
                pplayer2[pokeindex[1]].setCurrentHP(pplayer2[pokeindex[1]].getCurrentHP()-p1doesdmg);

                if(multiplier1==2){
                System.out.println("It's super effective!");
                }
                else if(multiplier1==0.5){
                    System.out.println("It's not very effective");
                }        
                if(pplayer2[pokeindex[1]].getCurrentHP()>0){
                    System.out.println("\n"+pplayer1[pokeindex[0]].getName()+" HP= "+pplayer1[pokeindex[0]].getCurrentHP()+"       "+pplayer2[pokeindex[1]].getName()+" HP= "+pplayer2[pokeindex[1]].getCurrentHP());
                }
                //if pokemon faints
                if(pplayer2[pokeindex[1]].getCurrentHP()<=0){
                    System.out.println("\n"+pplayer1[pokeindex[0]].getName()+" HP= "+pplayer1[pokeindex[0]].getCurrentHP()+"        P2's POKEMON FAINTED!  ");
                    System.out.println("\nplayer 2's "+pplayer2[pokeindex[1]].getName()+" has fainted.");
                    System.out.println("Player 2 must choose another pokemon!");
                }
                turnAccumulator();
            }
            else{
                System.out.println("Attack Missed!");
                turnAccumulator();
            }
        }
        else if(player==2){
            if(acc==1){
                p2doesdmg=(((pplayer2[pokeindex[1]].getAttack() *moveAtkp2[moveindex[1]] / pplayer1[pokeindex[0]].getDefence()) / 20) + 2) * multiplier2;
                pplayer1[pokeindex[0]].setCurrentHP(pplayer1[pokeindex[0]].getCurrentHP()-p2doesdmg);
                
                if(multiplier2==2){
                System.out.println("It's super effective!");
                }
                else if(multiplier2==0.5){
                    System.out.println("It's not very effective");
                }                
                if(pplayer1[pokeindex[0]].getCurrentHP()>0){
                    System.out.println("\n"+pplayer1[pokeindex[0]].getName()+" HP= "+pplayer1[pokeindex[0]].getCurrentHP()+"       "+pplayer2[pokeindex[1]].getName()+" HP= "+pplayer2[pokeindex[1]].getCurrentHP());
                }
                //IF POKEMON FAINTS
                if(pplayer1[pokeindex[0]].getCurrentHP()<=0){
                    System.out.println("\nP1's POKEMON FAINTED!        "+pplayer1[pokeindex[0]].getName()+" HP= "+pplayer1[pokeindex[0]].getCurrentHP());   
                    System.out.println("player 1's "+pplayer2[pokeindex[0]].getName()+" has fainted.");
                    System.out.println("Player 1 must choose another pokemon!");
                }
                turnAccumulator();
            }
            else{
                System.out.println("Attack Missed!");
                turnAccumulator();
            }
        }
    }
    //PLAYER POKEMON SELLECTOR METHOD- to ensure if all the players have selected their pokemon before calling speed acummulator
    //ALSO TO TESTS OUTPUTS 
    public static void playerallselect(int player){
        if(player==1){
           p1pokeselect=true;
        }
        if(player==2){   
           p2pokeselect=true;
        }
        if(p1pokeselect && p2pokeselect){      
            System.out.println("\n"+pplayer1[pokeindex[0]].getName()+" HP= "+pplayer1[pokeindex[0]].getCurrentHP()+"      "+pplayer2[pokeindex[1]].getName()+" HP= "+pplayer2[pokeindex[1]].getCurrentHP());
            turnAccumulator();
        }
    }  
    //SPEED ACCUMULATOR FOR TURN method to determine who's turn it is
    public static void turnAccumulator(){   
        while (accumulator1<100 || accumulator2<100){
            while(accumulator1<100){
                accumulator1+=pplayer1[pokeindex[0]].getSpeed();
                break;
            }
            while(accumulator2<100){
                accumulator2+=pplayer2[pokeindex[1]].getSpeed();
                break;
            }
            if (accumulator1>=100){
                accumulator1-=100;
                System.out.println("\n\nPlayer 1's turn to attack! ");
                turn=1;
                break;         
            }
            else if (accumulator2>=100){
                accumulator2-=100;
                System.out.println("\n\nPlayer 2's turn to attack! ");
                turn=2;
                break;
            }
            else if(accumulator1>100 && accumulator2>100){
                if(accumulator1>accumulator2){
                accumulator1-=100;
                accumulator2-=100;
                System.out.println("\n\nPlayer 1's turn to attack!");
                turn=1;
                break;          
                }
                else if(accumulator2>accumulator1){
                accumulator1-=100;
                accumulator2-=100;
                System.out.println("\n\nPlayer 2's turn to attack!");
                turn=2;
                break;                
                }
            }
        }
    }
 
//THIS SECTION CONTAINS THE DAMAGE MULTIPLIER METHODS FOR TYPE EFFECTIVENESS
    public static double multihalf(){
        double multihalf=0.5;
        return multihalf;
    }
    public static int multiplier1x(){
        int multi1x=1;
        return multi1x;
    }
    public static int multiplier2x(){
        int multi2x=2;
        return multi2x;   
    }
    
//THIS SECTION IS FOR ACCURACY METHODS
//accfix=variable for acc             acc10= temp array variable
    public static int accuracy50(){
        int acc50[]= {1,0};      
        int acc50fix=acc50[new Random().nextInt(acc50.length)];
        return acc50fix;
    }
    public static int accuracy60(){
        int acc60[]= {1,1,1,0,0};      
        int acc60fix=acc60[new Random().nextInt(acc60.length)];
        return acc60fix;
    }
    public static int accuracy65(){
        int acc65[]= {1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0};      
        int acc65fix=acc65[new Random().nextInt(acc65.length)];
        return acc65fix;
    }
    public static int accuracy70(){
        int acc70[]= {1,1,1,1,1,1,1,0,0,0};      
        int acc70fix=acc70[new Random().nextInt(acc70.length)];
        return acc70fix;
    }
    public static int accuracy100(){  
        int acc100fix=1;  
        return acc100fix; 
    }
    //Tells actionpanel which player's turn is it
    public static int turnIs(){
        return turn;
    }
}