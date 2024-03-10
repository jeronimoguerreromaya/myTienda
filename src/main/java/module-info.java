module com.example.mytienda {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mytienda to javafx.fxml;
    exports com.example.mytienda;
    exports myTienda to javafx.base;
}