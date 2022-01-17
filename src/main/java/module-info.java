module com.example.lab4fix {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;

    opens com.example.lab4fix to javafx.fxml;
    exports com.example.lab4fix;
}