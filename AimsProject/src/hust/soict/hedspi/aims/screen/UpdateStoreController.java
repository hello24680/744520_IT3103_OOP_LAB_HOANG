package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.Aims;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;

public class UpdateStoreController {
    private Store store;

    @FXML
    private TextField id;

    @FXML
    private TextField title;

    @FXML
    private TextField category;

    @FXML
    private TextField director;

    @FXML
    private TextField cost;

    @FXML
    private TextField length;

    @FXML
    private TextField artist;


    @FXML
    private ComboBox<String> mediaTypes;


    @FXML
    public void initialize() {
        mediaTypes.getItems().addAll("BOOK", "CD", "DVD");

        director.visibleProperty().bind(mediaTypes.valueProperty().isEqualTo("CD").or(mediaTypes.valueProperty().isEqualTo("DVD")));
        artist.visibleProperty().bind(mediaTypes.valueProperty().isEqualTo("CD"));
        length.visibleProperty().bind(mediaTypes.valueProperty().isEqualTo("DVD"));
    }

    public UpdateStoreController(Store store) {
        super();
        this.store = store;
    }


    @FXML
    void btAddPressed(ActionEvent event) {
        try {
            String selectedType = mediaTypes.getValue();

            int mediaId = Integer.parseInt(id.getText());
            String mediaTitle = title.getText();
            String mediaCategory = category.getText();
            String mediaDirector = director.getText();
            String mediaArtist = artist.getText();
            float mediaCost = (float) Double.parseDouble(cost.getText());

            if (selectedType == null || mediaTitle.isEmpty() || mediaCategory.isEmpty() || mediaCost <= 0 || mediaId <= 0) {
                JOptionPane.showMessageDialog(null,"Please fill all required fields and select a media type.","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedType == "CD" && mediaArtist.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please fill Artist.","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedType == "DVD" && mediaDirector.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please fill Director.","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedType == "CD" && mediaDirector.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please fill Director.","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            switch (selectedType) {
                case "BOOK":
                    Book book = new Book(mediaId, mediaTitle, mediaCategory, mediaCost);
                    store.addMedia(book);
                    JOptionPane.showMessageDialog(null," Book added successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                    break;
                case "CD":
                    CompactDisc cd = new CompactDisc(mediaId, mediaTitle, mediaCategory, mediaCost, mediaDirector, mediaArtist);
                    store.addMedia(cd);
                    //showAlert("Success", selectedType + " added successfully!", Alert.AlertType.INFORMATION);
                    JOptionPane.showMessageDialog(null," CD added successfully!","Success",JOptionPane.INFORMATION_MESSAGE);

                    String trackNumberInput = JOptionPane.showInputDialog(null, "Enter number of Tracks:", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
                    try {
                        // Kiểm tra nếu người dùng nhấn Cancel hoặc để trống
                        if (trackNumberInput == null || trackNumberInput.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No input provided. Operation cancelled.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Chuyển chuỗi sang số
                        int trackNumber = Integer.parseInt(trackNumberInput);

                        // Kiểm tra nếu số nhập vào phải lớn hơn 0
                        if (trackNumber > 0) {
                                new AddTrackToCDScreen(trackNumber,cd);// Gọi màn hình thêm Track
                                Aims.closeItemToStoreScreen(); // close o day va mo lai khi xong addTrack
                        }
                    } catch (NumberFormatException e) {
                        // Hiển thị thông báo lỗi khi nhập không phải số
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    clearFields();

                    break;
                case "DVD":
                    int dvdLength = Integer.parseInt(length.getText());
                    DigitalVideoDisc dvd = new DigitalVideoDisc(mediaId, mediaTitle, mediaCategory, mediaCost, mediaDirector, dvdLength);
                    store.addMedia(dvd);
                    JOptionPane.showMessageDialog(null," DVD added successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                    break;
                default:
                    JOptionPane.showMessageDialog(null," Unsupported media type!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Invalid input. Please enter valid numeric values for cost and length.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void btMediaTypePressed(ActionEvent event) {
        String selectedType = mediaTypes.getValue();
        if (selectedType == null) {
            JOptionPane.showMessageDialog(null,"Please select a media type.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void handleMediaType(String mediaType) {
        mediaTypes.setValue(mediaType);
    }

    private void clearFields() {
        title.clear();
        category.clear();
        director.clear();
        cost.clear();
        length.clear();
        artist.clear();
        id.clear();
    }


    @FXML
    void menuAddBook(ActionEvent event) {
        mediaTypes.setValue("BOOK");
    }

    @FXML
    void menuAddCd(ActionEvent event) {
        mediaTypes.setValue("CD");
    }

    @FXML
    void menuAddDvd(ActionEvent event) {
        mediaTypes.setValue("DVD");
    }

    @FXML
    void menuViewStore(ActionEvent event) {
        Aims.closeItemToStoreScreen();
        Aims.openStoreScreen();
    }

    @FXML
    void menuViewCart(ActionEvent event) {
        Aims.closeItemToStoreScreen();
        Aims.openCartScreen();
    }
}
