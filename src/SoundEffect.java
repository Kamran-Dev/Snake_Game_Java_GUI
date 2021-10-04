import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffect {

    Clip clip01;

    public void setFile(String soundFileName) throws UnsupportedAudioFileException, IOException {
        try{
            File file = new File(soundFileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip01 = AudioSystem.getClip();
            clip01.open(sound);

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play(){
        clip01.setFramePosition(0);
        clip01.start();

    }

}
