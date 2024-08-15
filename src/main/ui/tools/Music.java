package ui.tools;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

public class Music {
    private AudioStream bgm;
    private AudioStream newBgm;

    public Music(String wav) {
        try {
            InputStream data = new FileInputStream(wav);
            newBgm = new AudioStream(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Music music = (Music) o;
        return Objects.equals(bgm, music.bgm)
                && Objects.equals(newBgm, music.newBgm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bgm, newBgm);
    }

    //MODIFIES: this
    //EFFECTS: if the new Music != the old Music, replace the old music with the most updated version then play;
    // else do nothing
    public void playMusic() {
        if (!newBgm.equals(bgm)) {
            bgm = newBgm;
            AudioPlayer.player.start(bgm);
        }
    }

    //MODIFIES: this
    //EFFECTS: stop playing the Music that's in track
    public void stopPlayingMusic() {
        AudioPlayer.player.stop(bgm);
        bgm = null;
    }
}
