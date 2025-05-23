package aims.screen.manager;

import aims.media.Book;
import aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextArea tfAuthors;
    
    public AddBookToStoreScreen(Store store) {
        super(store);
        buildForm();
        setTitle("Add Book to Store");
    }
    
    @Override
    protected void buildForm() {
        JPanel formPanel = createFormPanel();
        
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfAuthors = new JTextArea(5, 20);
        tfAuthors.setLineWrap(true);
        JScrollPane authorsScrollPane = new JScrollPane(tfAuthors);
        
        addFormField(formPanel, "Title", tfTitle);
        addFormField(formPanel, "Category", tfCategory);
        addFormField(formPanel, "Cost", tfCost);
        JLabel authorsLabel = new JLabel("Authors (one per line): ");
        formPanel.add(authorsLabel);
        formPanel.add(authorsScrollPane);
        
        JButton btnAdd = new JButton("Add Book");
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
            float cost = Float.parseFloat(tfCost.getText());
            
            Book book = new Book(title, category, cost);

            String[] authors = tfAuthors.getText().split("\n");
            ArrayList<String> authorList = new ArrayList<>();
            for (String author : authors) {
                if (!author.trim().isEmpty()) {
                    authorList.add(author.trim());
                }
            }
            book.setAuthors(authorList);

            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            
            // Clear form fields
            tfTitle.setText("");
            tfCategory.setText("");
            tfCost.setText("");
            tfAuthors.setText("");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid cost value.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}