package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.Aims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu ("Update Store");


        JMenuItem item;
        smUpdateStore.add(item = new JMenuItem("Add Book"));
        item.addActionListener(new MenuListener());

        smUpdateStore.add(item = new JMenuItem("Add CD"));
        item.addActionListener(new MenuListener());

        smUpdateStore.add(item = new JMenuItem("Add DVD"));
        item.addActionListener(new MenuListener());

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(item = new JMenuItem("View cart"));
        item.addActionListener(new MenuListener());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout (header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground (Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize (new Dimension (100, 50));
        cart.setMaximumSize(new Dimension(100, 50));
        cart.addActionListener(new MenuListener());

        header.add(Box.createRigidArea (new Dimension (10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea (new Dimension (10, 10)));

        return header;
    }

    JPanel createCenter() {

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            if (i >= mediaInStore.size()) {
                break;
            }
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store,Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setVisible(true);

    }


    private class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Add Book":
                    Aims.closeStoreScreen();
                    Aims.openAddBookToStoreScreen();
                    break;
                case "Add CD":
                    Aims.closeStoreScreen();
                    Aims.openAddCompactDiscToStoreScreen();
                    break;
                case "Add DVD":
                    Aims.closeStoreScreen();
                    Aims.openAddDigitalVideoDiscToStoreScreen();
                    break;
                case "View cart":
                    Aims.closeStoreScreen();
                    Aims.openCartScreen();
                    break;
            }

        }

    }
}
