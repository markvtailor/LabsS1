module com.example.lab3fix {
    requires javafx.controls;
    requires javafx.fxml;

        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires validatorfx;
    requires decimal4j;

    opens com.example.lab3fix to javafx.fxml;
    exports com.example.lab3fix;
}