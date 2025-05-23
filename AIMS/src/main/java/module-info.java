module aims {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens aims to javafx.fxml;
    exports aims;
}