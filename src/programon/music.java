/**
 * This class manages the music playback
 */
package programon;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class music {
    private static Media
            opening = new Media(new File("opening.mp3").toURI().toString()),
            battle = new Media(new File("battle.mp3").toURI().toString());
    private static final JFXPanel fxPanel = new JFXPanel();
    private static MediaPlayer
            track1 = new MediaPlayer(opening),
            track2 = new MediaPlayer(battle);
    public void music(){}
    
    public static void soundtrack(String track, String control){
        if(track.equalsIgnoreCase("opening")){
            if(control.equalsIgnoreCase("play")){
                track1.setCycleCount(MediaPlayer.INDEFINITE);
                track1.play();
            }
            else if(control.equalsIgnoreCase("stop")){
                track1.stop();
            }
        }
        else if(track.equalsIgnoreCase("battle")){
            if(control.equalsIgnoreCase("play")){
                track1.stop();
                track2.setCycleCount(MediaPlayer.INDEFINITE);
                track2.play();
            }
            else if(control.equalsIgnoreCase("stop"))
                track2.stop();
        }
    }
}