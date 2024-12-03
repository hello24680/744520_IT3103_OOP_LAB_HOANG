package hust.soict.hedspi.aims.media;

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

    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
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