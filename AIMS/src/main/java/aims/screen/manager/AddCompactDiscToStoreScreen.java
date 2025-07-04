package aims.screen.manager;

import aims.media.CompactDisc;
import aims.media.Track;
import aims.media.Media;
import aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfArtist;
    private JTextField tfCost;
    private JTextArea tfTracks;
    
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        buildForm();
        setTitle("Add CD to Store");
    }
    
    @Override
    protected void buildForm() {
        JPanel formPanel = createFormPanel();
        
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfDirector = new JTextField();
        tfArtist = new JTextField();
        tfCost = new JTextField();
        tfTracks = new JTextArea(5, 20);
        tfTracks.setLineWrap(true);
        JScrollPane tracksScrollPane = new JScrollPane(tfTracks);
        
        addFormField(formPanel, "Title", tfTitle);
        addFormField(formPanel, "Category", tfCategory);
        addFormField(formPanel, "Director", tfDirector);
        addFormField(formPanel, "Artist", tfArtist);
        addFormField(formPanel, "Cost", tfCost);
        
        JLabel tracksLabel = new JLabel("Tracks (format: title,length on each line): ");
        formPanel.add(tracksLabel);
        formPanel.add(tracksScrollPane);
        
        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> submitForm());
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(formPanel, BorderLayout.CENTER);
        centerPanel.add(btnAdd, BorderLayout.SOUTH);
        
        center.setLayout(new BorderLayout());
        center.add(centerPanel, BorderLayout.CENTER);
    }
    
    @Override
    protected void submitForm() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            String artist = tfArtist.getText();
            float cost = Float.parseFloat(tfCost.getText());
            
            // Parse and add tracks
            String[] trackLines = tfTracks.getText().split("\n");
            ArrayList<Track> tracks = new ArrayList<>();
            for (String line : trackLines) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length >= 2) {
                        String trackTitle = parts[0].trim();
                        int trackLength = Integer.parseInt(parts[1].trim());
                        Track track = new Track(trackTitle, trackLength);
                        tracks.add(track);
                    }
                }
            }
            Media media = new CompactDisc(title, category, artist, tracks, cost);
            store.addMedia(media);
            JOptionPane.showMessageDialog(this, "CD added successfully!");
            
            // Clear form fields
            tfTitle.setText("");
            tfCategory.setText("");
            tfDirector.setText("");
            tfArtist.setText("");
            tfCost.setText("");
            tfTracks.setText("");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}