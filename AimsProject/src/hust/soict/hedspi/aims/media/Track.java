package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title,int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            JOptionPane.showMessageDialog(null,"ERROR: Track length is invalid! Length must be greater than 0.","ERROR",JOptionPane.ERROR_MESSAGE);
            throw new PlayerException("Track length is invalid! Length must be greater than 0.");
        }else {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
    }


    boolean equals(Track trackCheck){
        if(trackCheck == null){
            return false;
        }

        if(this.title == trackCheck.title){
            if(this.length == trackCheck.length){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}
