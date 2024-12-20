package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.Aims;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class CartScreenController {
    private Cart cart;
    private Store store;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController (Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        tblMedia.setItems(this.cart.getItemsOrdered());
        updateCost();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue,
                                Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed (ObservableValue<? extends String> observable, String oldValue,
                                 String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    void updateCost(){
        lblCost.setText(String.format("%.2f $", cart.totalCost()) + "$");
    }

    void updateButtonBar (Media media)
    {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed (ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia (media);
        updateCost();
    }

    void showFilteredMedia(String filter){
        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());
        if(filter == ""){
            tblMedia.setItems(cart.getItemsOrdered());
        }

        if (filter != null && !filter.isEmpty()) {
            if (radioBtnFilterId.isSelected()) {
                filteredList.setPredicate((it) -> it.getId() == Integer.parseInt(filter));
            }else if(radioBtnFilterTitle.isSelected()){
                filteredList.setPredicate((it) -> it.getTitle().contains(filter));
            }
            tblMedia.setItems(filteredList);
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure want to order ? \n Total:" + cart.totalCost() + "$", "Place Order", JOptionPane.YES_NO_OPTION);
            if(confirm == 0) {
                JOptionPane.showMessageDialog(null, "Your order is now pending!");
                cart.empty();
                updateCost();
            }
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            ((Playable) media).play();
        }catch (PlayerException e){
            JOptionPane.showMessageDialog(null,"ERROR: An error occurred while playing in cart","ERROR",JOptionPane.ERROR_MESSAGE);
            System.err.println("An error occurred while playing in cart: " + e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Playing: " + tblMedia.getSelectionModel().getSelectedItem().getTitle());
    }


    @FXML
    void menuAddBook(ActionEvent event) {
        Aims.closeCartScreen();
        Aims.openAddBookToStoreScreen();
    }

    @FXML
    void menuAddCd(ActionEvent event) {
        Aims.closeCartScreen();
        Aims.openAddCompactDiscToStoreScreen();
    }

    @FXML
    void menuAddDvd(ActionEvent event) {
        Aims.closeCartScreen();
        Aims.openAddDigitalVideoDiscToStoreScreen();
    }

    @FXML
    void menuViewStore(ActionEvent event) {
        Aims.closeCartScreen();
        Aims.openStoreScreen();
    }

    int toggel = 0;
    @FXML
    void btnSortTitlePressed(ActionEvent event) {
        if(toggel == 0) {
            tblMedia.getItems().sort((m1, m2) -> m1.getTitle().compareTo(m2.getTitle()));
            toggel = 1;
        }else{
            tblMedia.getItems().sort((m1, m2) -> m2.getTitle().compareTo(m1.getTitle()));
            toggel = 0;
        }

    }

    int toggel2 = 0;
    @FXML
    void btnSortCostPressed(ActionEvent event) {
        if(toggel2 == 0) {
            tblMedia.getItems().sort((m1, m2) -> Float.compare(m1.getCost(), m2.getCost()));
            toggel2 = 1;
        }else{
            tblMedia.getItems().sort((m1, m2) -> Float.compare(m2.getCost(), m1.getCost()));
            toggel2 = 0;
        }
    }


    @FXML
    void btnDetailsPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if(media != null) {
            JOptionPane.showMessageDialog(null, media.toString());
        }else{
            JOptionPane.showMessageDialog(null, "Please select a media to view details!");
        }
    }
}
