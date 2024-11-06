module org.iesch.ad.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.iesch.ad.demo to javafx.fxml;
    exports org.iesch.ad.demo;
}