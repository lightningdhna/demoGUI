module com.example.demogui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    
    opens dhung.view to javafx.fxml;
    exports dhung.view;
    opens dhung.model to javafx.fxml;
    exports dhung.model;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires com.jfoenix;


}