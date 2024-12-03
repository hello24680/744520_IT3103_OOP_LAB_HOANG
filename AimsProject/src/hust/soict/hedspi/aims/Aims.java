package hust.soict.hedspi.aims;


import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;


public class Aims {
    //Create a new cart
    private static Cart cart = new Cart();

    //Create a new store
    private static Store store = new Store();

    //tao 1 scanner lay input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        dataInStore();
        System.out.println("\n");
        showMenu();
    }

    public static void dataInStore() {
        // DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Inception", "Science Fiction", 22.95f, "Christopher Nolan", 148);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Dark Knight", "Action", 19.50f, "Christopher Nolan", 152);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Forrest Gump", "Drama", 18.75f, "Robert Zemeckis", 142);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // CD + Track
        CompactDisc cd4 = new CompactDisc(4, "The Wall", "Rock", 13.99f, "Pink Floyd", "PF");
        Track track41 = new Track("Another Brick in the Wall", 214);
        Track track42 = new Track("Comfortably Numb", 384);
        Track track43 = new Track("Hey You", 274);
        cd4.addTrack(track41);
        cd4.addTrack(track42);
        cd4.addTrack(track43);

        CompactDisc cd5 = new CompactDisc(5, "Abbey Road", "Rock", 14.50f, "The Beatles", "TB");
        Track track51 = new Track("Come Together", 259);
        Track track52 = new Track("Here Comes the Sun", 185);
        cd5.addTrack(track51);
        cd5.addTrack(track52);

        CompactDisc cd6 = new CompactDisc(6, "Back in Black", "Rock", 12.99f, "AC/DC", "A/D");
        Track track61 = new Track("Back in Black", 255);
        Track track62 = new Track("You Shook Me All Night Long", 210);
        Track track63 = new Track("Hells Bells", 312);
        cd6.addTrack(track61);
        cd6.addTrack(track62);
        cd6.addTrack(track63);

        store.addMedia(cd4);
        store.addMedia(cd5);
        store.addMedia(cd6);

        // Book
        Book book7 = new Book(7, "1984", "Dystopian Fiction", 7.99f);
        book7.addAuthor("George Orwell");
        Book book8 = new Book(8, "Brave New World", "Dystopian Fiction", 8.49f);
        book8.addAuthor("Aldous Huxley");
        Book book9 = new Book(9, "Dune", "Science Fiction", 10.75f);
        book9.addAuthor("Frank Herbert");
        store.addMedia(book7);
        store.addMedia(book8);
        store.addMedia(book9);
    }


    public static void showMenu() {
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            String option = scanner.nextLine();

            switch (option) {
                case "1" -> {
                    System.out.println("\n");
                    store.printStore();
                    storeMenu();
                }
                case "2" -> {
                    System.out.println("\n");
                    updateStore();
                }
                case "3" -> {
                    System.out.println("\n");
                    cart.printCart();
                    cartMenu();
                }
                case "0" -> {
                    System.out.println("\n");
                    System.out.println("Exit and completed");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("\n");
                    System.out.println("nhap sai cu phap,yeu cau nhap lai:0-1-2-3.");
                }
            }
        }
    }

    public static void storeMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            String option = scanner.nextLine();
            switch (option) {
                case "0" -> {
                    System.out.println("\n");
                    return;
                }
                case "1" -> {
                    while (true) {
                        System.out.print("nhap title (0 de dung nhap): ");

                        String titleInput = scanner.nextLine();
                        if (titleInput.equals("0")) break;

                        Media foundMedia = store.searchByTitle(titleInput);
                        if (foundMedia == null) {
                            System.out.println(titleInput + " khong ton tai. yeu cau nhap lai title:");
                        } else {
                            System.out.println(foundMedia.toString());
                            mediaDetailsMenu(foundMedia);
                        }
                    }
                }
                case "2" -> {
                    while (true) {
                        System.out.print("nhap title cho vao cart (0 de dung nhap): ");

                        String titleInput = scanner.nextLine();
                        if (titleInput.equals("0")) break;

                        Media foundMedia = store.searchByTitle(titleInput);
                        if (foundMedia == null) {
                            System.out.println(titleInput + " khong ton tai. yeu cau nhap lai title:");
                        } else {
                            cart.addMedia(foundMedia);
                        }
                    }
                }
                case "3" -> {
                    while (true) {
                        System.out.print("nhap title de play (0 de dung nhap): ");

                        String titleInput = scanner.nextLine();
                        if (titleInput.equals("0")) break;

                        Media foundMedia = store.searchByTitle(titleInput);
                        if (foundMedia == null) {
                            System.out.println(titleInput + " khong ton tai. yeu cau nhap lai title:");
                        } else {
                            if (foundMedia instanceof CompactDisc) {
                                CompactDisc mediaCD = (CompactDisc) foundMedia;
                                System.out.println("\n");
                                mediaCD.play();
                            } else if (foundMedia instanceof DigitalVideoDisc) {
                                DigitalVideoDisc mediaDVD = (DigitalVideoDisc) foundMedia;
                                System.out.println("\n");
                                mediaDVD.play();
                            } else {
                                System.out.println(foundMedia.getTitle() + " khong the play,xin nhap title khac:");
                            }
                        }
                    }
                }
                case "4" -> {
                    System.out.println("\n");
                    cart.printCart();
                    cartMenu();
                }
                default -> {
                    System.out.println("\n");
                    System.out.println("nhap sai cu phap,yeu cau nhap lai: 0-1-2-3-4.");
                }
            }
        }
    }

    public static void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            String option = scanner.nextLine();
            switch (option) {
                case "0" -> {
                    System.out.println("\n");
                    return;
                }
                case "1" -> {
                    cart.addMedia(media);
                }
                case "2" -> {
                    if (media instanceof CompactDisc) {
                        CompactDisc mediaCD = (CompactDisc) media;
                        System.out.println("\n");
                        mediaCD.play();
                    } else if (media instanceof DigitalVideoDisc) {
                        DigitalVideoDisc mediaDVD = (DigitalVideoDisc) media;
                        System.out.println("\n");
                        mediaDVD.play();
                    } else {
                        System.out.println(media.getTitle() + " khong the play media nay.");
                    }
                }
                default -> {
                    System.out.println("\n");
                    System.out.println("nhap sai cu phap,yeu cau nhap lai: 0-1-2.");
                }
            }
        }
    }

    public static void cartMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            String option = scanner.nextLine();
            switch (option) {
                case "0" -> {
                    System.out.println("\n");
                    return;
                }
                case "1" -> {
                    System.out.println("Filter by: ");
                    System.out.println("1-> Title");
                    System.out.println("2-> Id");

                    int filterOption = scanner.nextInt();
                    scanner.nextLine();

                    while (true) {
                        Media foundMedia = null;
                        if (filterOption == 1) {
                            System.out.print("nhap title de filter (0 de dung): ");
                            String title = scanner.nextLine();
                            if (title.equals("0")) break;
                            foundMedia = cart.searchByTitle(title);
                        } else if (filterOption == 2) {
                            System.out.print("nhap id de filter (0 de dung): ");
                            int id = scanner.nextInt();
                            if (id == 0) break;
                            foundMedia = cart.searchById(id);
                        } else {
                            System.out.println("\n");
                            System.out.println("Invalid Input.");
                        }

                        if (foundMedia == null) {
                            System.out.println("\n");
                            System.out.println("no matched items in cart.");
                        } else {
                            System.out.println("\n");
                            if (filterOption == 1) {
                                System.out.println("Result: " + foundMedia.toString());
                            } else if (filterOption == 2) {
                                System.out.println("Result: " + foundMedia.toString());
                            }
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Sort media in cart by:");
                    System.out.println("1 -> title ");
                    System.out.println("2 -> cost ");

                    int sortOption = scanner.nextInt();
                    scanner.nextLine();

                    if (sortOption == 1) {
                        cart.sortByTitle();
                    } else if (sortOption == 2) {
                        cart.sortByCost();
                    } else {
                        System.out.println("Invalid option.");
                    }
                }
                case "3" -> {
                    while (true) {
                        System.out.print("nhap title de remove from cart (0 de dung): ");

                        String title = scanner.nextLine();
                        if (title.equals("0")) break;

                        Media foundMedia = cart.searchByTitle(title);
                        if (foundMedia == null) {
                            System.out.println(title + " khong ton tai. yeu cau nhap lai title:");
                        } else {
                            cart.removeMedia(foundMedia);
                            System.out.println(title + " remove thanh cong.");
                            System.out.println("Current cart: ");
                            cart.printCart();
                        }
                    }
                }
                case "4" -> {
                    while (true) {
                        System.out.print("nhap title de play (0 de dung nhap): ");

                        String title = scanner.nextLine();
                        if (title.equals("0")) break;

                        Media foundMedia = cart.searchByTitle(title);
                        if (foundMedia == null) {
                            System.out.println(title + " khong ton tai. yeu cau nhap lai title:");
                        } else {
                            if (foundMedia instanceof CompactDisc) {
                                CompactDisc mediaCD = (CompactDisc) foundMedia;
                                System.out.println("\n");
                                mediaCD.play();
                            } else if (foundMedia instanceof DigitalVideoDisc) {
                                DigitalVideoDisc mediaDVD = (DigitalVideoDisc) foundMedia;
                                System.out.println("\n");
                                mediaDVD.play();
                            } else System.out.println(foundMedia.getTitle() + " khong the play,xin nhap title khac:");
                        }
                    }
                }
                case "5" -> {
                    System.out.println("\n");
                    System.out.println("an order is created, empty the current cart.");
                    cart.empty();
                }
                default -> {
                    System.out.println("nhap sai cu phap,yeu cau nhap lai: 0-1-2-3-4-5.");
                }
            }
        }
    }

    public static void updateStore() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            String option = scanner.nextLine();
            switch (option) {
                case "0" -> {
                    System.out.println("\n");
                    return;
                }
                case "1" -> {
                    boolean back = false;
                    while (!back) {
                        System.out.println("Enter the category of the media:");
                        System.out.println("1 -> book");
                        System.out.println("2 -> CD");
                        System.out.println("3 -> DVD");
                        System.out.println("0 -> Back");
                        String choice = scanner.nextLine();
                        switch (choice) {
                            case "0" -> {
                                System.out.println("\n");
                                back = true;
                            }
                            case "1" -> {
                                //scan cac phan tu
                                System.out.println("Enter the id of the book: ");
                                int bookId = scanner.nextInt();
                                System.out.println("Enter the title of the book: ");
                                String bookTitle = scanner.nextLine();
                                System.out.println("Enter the category of the book: ");
                                String bookCategory = scanner.nextLine();
                                System.out.println("Enter the cost of the book: ");
                                float bookCost = scanner.nextFloat();

                                scanner.nextLine();

                                //scan phan tu author dang list
                                Book book = new Book(bookId, bookTitle, bookCategory, bookCost);
                                System.out.println("Enter the List of author(s) of the book (Press 0 to stop): ");
                                while (true) {
                                    String bookAuthor = scanner.nextLine();
                                    if (bookAuthor.equals("0")) break;
                                    book.addAuthor(bookAuthor);
                                }

                                //add vao store
                                store.addMedia(book);
                                System.out.println();

                                //print current store
                                System.out.println("Current store: ");
                                store.printStore();
                                System.out.println();
                            }
                            case "2" -> {
                                //scan cac phan tu
                                System.out.println("\n");
                                System.out.println("Enter the id of the CD: ");
                                int cdId = scanner.nextInt();
                                System.out.println("Enter the title of the CD: ");
                                String cdTitle = scanner.nextLine();
                                System.out.println("Enter the category of the CD: ");
                                String cdCategory = scanner.nextLine();
                                System.out.println("Enter the cost of the CD: ");
                                float cdCost = scanner.nextFloat();
                                System.out.println("Enter the director of the CD: ");
                                String cdDirector = scanner.nextLine();
                                System.out.println("Enter the artist of the CD: ");
                                String cdArtist = scanner.nextLine();

                                scanner.nextLine();

                                //scan phan tu track dang list
                                CompactDisc cd = new CompactDisc(cdId, cdTitle, cdCategory, cdCost, cdDirector, cdArtist);
                                System.out.println("input the number of track of the CD (Press 0 to stop): ");
                                int numTracks = scanner.nextInt();
                                scanner.nextLine();

                                if (numTracks != 0) {
                                    for (int i = 1; i <= numTracks; i++) {
                                        System.out.println("Enter the title of track " + i + ": ");
                                        String trackTitle = scanner.nextLine();
                                        System.out.println("Enter the length of track " + i + ": ");
                                        int trackLength = scanner.nextInt();
                                        scanner.nextLine();

                                        cd.addTrack(new Track(trackTitle, trackLength));
                                    }
                                }

                                //add vao store
                                store.addMedia(cd);
                                System.out.println();

                                //print current store
                                store.printStore();
                                System.out.println("Current store: ");
                                store.printStore();
                                System.out.println();
                            }

                            case "3" -> {
                                //scan cac phan tu
                                System.out.println("\n");
                                System.out.println("Enter the id of the DVD: ");
                                int dvdId = scanner.nextInt();
                                System.out.println("Enter the title of the DVD: ");
                                String dvdTitle = scanner.nextLine();
                                System.out.println("Enter the category of the DVD: ");
                                String dvdCategory = scanner.nextLine();
                                System.out.println("Enter the cost of the DVD: ");
                                float dvdCost = scanner.nextFloat();
                                System.out.println("Enter the director of the DVD: ");
                                String dvdDirector = scanner.nextLine();
                                System.out.println("Enter the length of the DVD: ");
                                int dvdLength = scanner.nextInt();

                                scanner.nextLine();

                                DigitalVideoDisc dvd = new DigitalVideoDisc(dvdId, dvdTitle, dvdCategory, dvdCost, dvdDirector, dvdLength);


                                //add vao store
                                store.addMedia(dvd);
                                System.out.println();


                                //print current store
                                System.out.println("Current store: ");
                                store.printStore();
                                System.out.println();
                            }


                            default -> {
                                System.out.println("\n");
                                System.out.println("Invalid option. Please choose a number: 0-1-2.");
                            }
                        }
                    }
                }

                case "2" -> {
                    System.out.println("\n");
                    while (true) {
                        System.out.print("nhap title de remove from store (0 de dung): ");

                        String title = scanner.nextLine();
                        if (title.equals("0")) break;

                        Media foundMedia = store.searchByTitle(title);
                        if (foundMedia == null) {
                            System.out.println(title + " khong ton tai. yeu cau nhap lai title:");
                        } else {
                            store.removeMedia(foundMedia);
                            System.out.println(title + " remove thanh cong.");
                            System.out.println("Current store: ");
                            store.printStore();
                        }
                    }
                }
                default -> {
                    System.out.println("\n");
                    System.out.println("nhap sai cu phap,yeu cau nhap lai: 0-1-2.");
                }
            }
        }
    }
}

