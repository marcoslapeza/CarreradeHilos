module com.example.carreradehilos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.carreradehilos to javafx.fxml;
    exports com.example.carreradehilos;
}