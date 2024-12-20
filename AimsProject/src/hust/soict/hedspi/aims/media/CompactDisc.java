package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, director,0);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track tracksInput){
       for(Track tmp :tracks){
           if(tmp != null) {
               if (tmp.getTitle() == tracksInput.getTitle()) {
                   if(tmp.getLength() == tracksInput.getLength()) {
                       System.out.println("track da ton tai");
                       return;
                   }
               }
           }
       }
       tracks.add(tracksInput);
    }

    public void removeTrack(Track tracksInput){
        for(Track tmp :tracks){
            if(tmp != null) {
                if (tmp.getTitle() == tracksInput.getTitle()) {
                    tracks.remove(tmp);
                    return;
                }
            }
        }
        System.out.println("track khong ton tai");
    }


    @Override
    public int getLength(){
        int count_length =0;
        for(Track tmp :tracks) {
            if (tmp != null) {
                count_length += tmp.getLength();
            }
        }
        return count_length;
    }

    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            JOptionPane.showMessageDialog(null,"ERROR: CD length is invalid! Length must be greater than 0.","ERROR",JOptionPane.ERROR_MESSAGE);
            throw new PlayerException("CD length is invalid! Length must be greater than 0.");
        }else {

            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("artist: " + artist);
            System.out.println("Number track in CD: " + tracks.size());

            System.out.println("CD length: " + this.getLength());


            //play each tracks
            for (Track tmp : tracks) {
                if (tmp != null) {
                    try {
                        tmp.play();
                    } catch (PlayerException e) {
                        JOptionPane.showMessageDialog(null,"ERROR: An error occurred while playing the track in CD","ERROR",JOptionPane.ERROR_MESSAGE);
                        System.err.println("An error occurred while playing the track in CD: " + e.getMessage());
                    }
                }
            }
        }
    }


    public String toString() {
        String CD_print = this.getTitle();

        if(this.getCategory() != null){
            CD_print += " - ";
            CD_print += this.getCategory();
        }

        if(this.getDirector() != null){
            CD_print += " - ";
            CD_print += this.getDirector();
        }

        if(this.getLength() != 0){
            CD_print += " - ";
            CD_print += this.getLength();
        }

        if(this.artist != null){
            CD_print += " - ";
            CD_print += this.artist;
        }

        return "CD - " + CD_print + ": " + this.getCost() + "$";
    }

}
