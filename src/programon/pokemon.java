/**
 * This class stores the Pokemon data.
 */

package programon;

//POKEMON CLASS TEMPLATE
public class pokemon { //Only a template. Can be edited to fit with the algorithm
    private String name, type;
    private int attack, defence, speed;
    private int fullHP; 
    private double currentHP; //HP when full, HP during battle
    private String[] move; //move names
    private boolean[] movetype;
    private int[] moveatk;
    private int[] moveacc;
    //private int[][] moveeffect; //move effects
    //private boolean naturemove; //"normal" is false

    //private int[][] moveeffect; //move effects
    //private boolean naturemove; //"normal" is false
    
    //POKEMON DATA METHOD
    public pokemon() {
        this.name = "";
        this.type = "";
        this.attack = 0;
        this.defence = 0;
        this.speed = 0;
        this.fullHP = 0;
        this.currentHP = 0;
        this.move = new String[4];
        this.movetype = new boolean[4];
        this.moveatk = new int[4];
        this.moveacc = new int[4];
        //this.moveeffect = new int[4][2];
 
       // this.moveeffect = new int[4][2];
    }
    //POKEMON DATA SETTER
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setFullHP(int fullHP) {/**ONLY USED DURING FILEINPUTSTREAM. */
        this.fullHP = fullHP;
    }
    
    public void setCurrentHP(double currentHP) {/**currentHP cannot be more than FullHP. */
        this.currentHP = currentHP;
    }
    
    public void setMoves(String[] move) {
        for(int i=0;i<move.length;i++){
            this.move[i] = move[i];
        }
    }

    public void setMovetype(boolean[] movetype) {
        for(int i=0;i<movetype.length;i++){
            this.movetype[i] = movetype[i];
        }
    }

    public void setMoveatk(int[] moveatk) {
        for(int i=0;i<moveatk.length;i++){
            this.moveatk[i] = moveatk[i];
        }
    }

    public void setMoveacc(int[] moveacc) {
        for(int i=0;i<moveacc.length;i++){
            this.moveacc[i] = moveacc[i];
        }
    }
    
    //POKEMON DATA GETTER
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFullHP() {
        return fullHP;
    }

    public double getCurrentHP() {
        return currentHP;
    }
    
    public String[] getMoves() {
        return move;
    }

    public String[] getMove() {
        return move;
    }

    public boolean[] getMovetype() {
        return movetype;
    }

    public int[] getMoveatk() {
        return moveatk;
    }

    public int[] getMoveacc() {
        return moveacc;
    }
    
    //SCRAPPED CODE//
    /*
    //ITEM EFFECTS
    public void itemEffect(String item){//used during combat, applies the effect of items when used
        if(item.equalsIgnoreCase("Potion"))//Restores 20 HP
            if(currentHP>0)
                currentHP+=20;
        else if(item.equalsIgnoreCase("HP Up"))//Restores full HP
            currentHP=fullHP;
        else if(item.equalsIgnoreCase("X Attack"))//Increases attack
            speed+=10;
        else if(item.equalsIgnoreCase("X Defence"))//Increases defence
            defence+=10;
        else if(item.equalsIgnoreCase("X Speed"))//Increases Speed
            speed+=10;
    }
    
    public void moveEffects(){//Sets the move effect for each move of a pokemon
        for(int i=0;i<move.length;i++){
            if(move[i].equalsIgnoreCase("Tackle") || move[i].equalsIgnoreCase("Scratch")){
                naturemove=false;
                moveeffect[i][0]=40;
                moveeffect[i][1]=70;
            }
        }
    }
    
    //naturelogic for pokemon
    //currentHP1 and pokemon1 for player 1, currentHP2 and pokemon2 for player 2
    String pokemon1,pokemon2; //just temporary
    public void natureLogic(int currentHp1, int currentHp2){
            if(pokemon1.equals("nature") && pokemon2.equals("water")){
                // pokemon1 attack or skill accuracy is more effective than pokemon2
                currentHp2 =-10;
        }
          
            else if(pokemon1.equals("water") && pokemon2.equals("fire")){
                // pokemon1 attack or skill accuracy is more effective than pokemon2
                 currentHp2 =-10;
        }
    
           else if(pokemon1.equals("fire") && pokemon2.equals("nature")){
                // pokemon1 attack or skill accuracy is more effective than pokemon2
                 currentHp2 =-10;
        }
          else if(pokemon1.equals("water") && pokemon2.equals("nature")){
                // pokemon1 attack or skill accuracy is more effective than pokemon2
                currentHp2 =+10;
        }
               
          else if(pokemon1.equals("fire") && pokemon2.equals("water")){
                // pokemon1 attack or skill accuracy is more effective than pokemon2
                currentHp2 =+10;
        }
                
          else if(pokemon1.equals("nature") && pokemon2.equals("fire")){
                // pokemon1 attack or skill accuracy is more effective than pokemon2
               currentHp2 =+10;
        }
    }
    */
}