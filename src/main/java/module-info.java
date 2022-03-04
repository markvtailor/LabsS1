module com.example.lab5fix {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;


    opens com.example.lab5fix to javafx.fxml;
    exports com.example.lab5fix;
}