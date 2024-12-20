package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import static hust.soict.hedspi.test.Screen.StoreScreenTest.cartTest;


public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {

        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        //add
        JButton buttonAdd = new JButton("Add to cart");
        buttonAdd.addActionListener(new ButtonListener());
        container.add(buttonAdd);

        //play
        if (media instanceof Playable) {
            JButton buttonPlay = new JButton("Play");
            buttonPlay.addActionListener(new ButtonListener());
            container.add(buttonPlay);
        }


        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Add to cart")) {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(null, "Added to cart: " + media.getTitle() + "\n" + media.toString());

            }else if(button.equals("Play")){
                try {
                    ((Playable) media).play();
                }catch (PlayerException ex){
                    JOptionPane.showMessageDialog(null,"ERROR: An error occurred while playing in store","ERROR",JOptionPane.ERROR_MESSAGE);
                    System.err.println("An error occurred while playing in store: " + ex.getMessage());
                }

                JOptionPane.showMessageDialog(MediaStore.this, "Playing: " + media.getTitle() );
            }
        }
    }
}