package aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length = 0;
    private float cost = 0;
    private int id;

    private static int nbDigitalVideoDiscs = 0;


    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }


    public DigitalVideoDisc(String title) {
        this.title = title;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.director = director;
        this.category = category;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        String dvd_print = this.title;

        if(this.category != null){
            dvd_print += " - ";
            dvd_print += this.category;
        }

        if(this.director != null){
            dvd_print += " - ";
            dvd_print += this.director;
        }

        if(this.length != 0){
            dvd_print += " - ";
            dvd_print += this.length;
        }
        return dvd_print + ": " + this.cost + "$";
    }
}
