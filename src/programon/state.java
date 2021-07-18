/*
 * This class manages the state at which changes the JList in the action window
 */
package programon;

public class state extends play{
    private int state, state1, state2;
    
    public state() {
        state = 0;
    }

    public state(int x) {
        this.state = x;
    }

    public int getState(int player) {
        if(player==1){
            return state1;
        }
        else
            return state2;
    }
    
    public Object[] attack(int player){
        if(player==1){
            state1=1;
        }
        else if(player==2){
            state2=1;
        }
        Object[] non = new Object[]{};
        if(player==1 && selectedPokemon1==null)
                return non;
        else if(player==2 && selectedPokemon2==null)
                return non;
        else
            return usePokemon(player);
    }
    
    public Object[] bag(int player){
        if(player==1){
            state1=2;
            return p1item;
        }
        else{
            state2=2;
            return p2item;
        }
    }
    
    public Object[] pokemon(int player){
        if(player==1){
            state1=3;
            return p1name;
        }
        else{
            state2=3;
            return p2name;
        }
    }
    
    public String[] empty(){
        String[] a = new String[]{""};
        return a;
    }
}