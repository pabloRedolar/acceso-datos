module org.iesch.di.ejerbootstrap {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.iesch.di.ejerbootstrap to javafx.fxml;
    exports org.iesch.di.ejerbootstrap;
}