package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddItemToStoreScreen extends JFrame {
    private Store store;

    public AddItemToStoreScreen(Store store,String SetMediaType) {
        super();

        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Update Store");
        this.setSize(new Dimension(600, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Platform.runLater (new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/updateStore.fxml"));
                    UpdateStoreController controller = new UpdateStoreController(store);

                    loader.setController(controller);
                    Parent root = loader.load(); // phai bat dau khoi (load) dong moi duoc gan mac dinh

                    controller.handleMediaType(SetMediaType);//gan mac dinh 1 type

                    Scene scene = new Scene(root);
                    fxPanel.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
