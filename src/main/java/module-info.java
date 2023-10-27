module com.fns.melordi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires java.logging;

    opens com.fns.melordi to javafx.fxml;
    exports com.fns.melordi;
    exports com.fns.melordi.view;
    opens com.fns.melordi.view to javafx.fxml;
}