package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTrackToCDScreen {
    private JFrame frame;
    private JTextField titleField;
    private JTextField lengthField;
    private JTextArea resultArea;
    int screenIndex = 1;
    int TrackNumberInput;

    //private List<Track> trackList = trackList = new ArrayList<>();
    private CompactDisc cd;

    public AddTrackToCDScreen(int TrackNumber, CompactDisc cd) {

            this.cd = cd;
            TrackNumberInput = TrackNumber;

            frame = new JFrame("Add track " + screenIndex);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 137);
            frame.setLayout(new BorderLayout());


            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridLayout(3, 2, 10, 10));


            JLabel titleLabel = new JLabel("Title:");
            titleField = new JTextField();


            JLabel lengthLabel = new JLabel("Length:");
            lengthField = new JTextField();


            inputPanel.add(titleLabel);
            inputPanel.add(titleField);
            inputPanel.add(lengthLabel);
            inputPanel.add(lengthField);


            JButton addButton = new JButton("Add Track");
            addButton.addActionListener(new AddButtonListener());

            inputPanel.add(new JLabel());
            inputPanel.add(addButton);


            resultArea = new JTextArea();
            resultArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(resultArea);


            frame.add(inputPanel, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);


            frame.setVisible(true);


            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            // WindowListener xu ly nhan dau X
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                // Mo AddCompactDiscToStoreScreen
                Aims.openAddCompactDiscToStoreScreen();

                // Dong UI hien tai
                frame.dispose();
            }
            });
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String lengthText = lengthField.getText();


            if (title.isEmpty() || lengthText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in both fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int length = Integer.parseInt(lengthText);
                if (length < 0) throw new NumberFormatException();

                // add track vao cd
                Track track = new Track(title, length);
                cd.addTrack(track);
                //trackList.add(track);


            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Length must be a positive integer!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(screenIndex != TrackNumberInput) {
                reset();
            }else {
                //exit UI
                Aims.openAddCompactDiscToStoreScreen();
                frame.dispose();
            }
        }
    }

    private void reset() {
        titleField.setText("");
        lengthField.setText("");
        screenIndex++;
        frame.setTitle("Add track " + screenIndex);
        //setVisible(true);
    }



}

