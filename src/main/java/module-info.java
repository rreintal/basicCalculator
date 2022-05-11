module com.example.kalkulaatornuppudega {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.kalkulaatornuppudega to javafx.fxml;
    exports com.example.kalkulaatornuppudega;
}