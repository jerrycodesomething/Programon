/**
 * POKEMON BATTLE SIMULATOR
 * Created by Team Roti Canai
 */

package programon;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import javax.swing.JFrame;

public class Programon {

    public static void main(String[] args) { //A window to select game mode
        //music.soundtrack("opening","play");
        try{
            Scanner s = new Scanner(new FileInputStream("title.txt"));
            while(s.hasNextLine()){
                System.out.println(s.nextLine());
            }
        }catch(FileNotFoundException e){
            System.out.println("Error: Title file not found.");
        }
        play.multiplayer();
        
    }
}