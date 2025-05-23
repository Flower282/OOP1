package aims.screen.customer.controller;

import aims.cart.Cart;
import aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ViewStoreController {

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {

    }
    private Store store;
    private Cart cart;

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }


    @FXML
    public void initialize() {
        final String ITEM_FXML = "aims/screen/customer/item.fxml";
        int column = 0;
        int row = 1;
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ITEM_FXML));
                ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = new AnchorPane();
                anchorPane = fxmlLoader.load();
                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
