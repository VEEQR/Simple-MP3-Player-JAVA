/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

/**
 *
 * @author VIQRI
 */
public class MusicPlayer {

    public MusicPlayer(){
        FormMusic fmusik = new FormMusic();
        fmusik.setVisible(true);
        fmusik.setSize(100, 200);
        fmusik.pack();
    }

    public static void main(String[] args) {
        new MusicPlayer();
    }
}
