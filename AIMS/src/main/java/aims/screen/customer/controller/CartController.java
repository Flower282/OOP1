package aims.screen.customer.controller;

import aims.cart.Cart;
import aims.media.Media;
import aims.media.Playable;
import aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {

    }

    private Cart cart;
    private Store store;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }


    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<>("cost"));
        // Inside the initialize() method
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)
                -> updateButtonBar(newValue));
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

}
