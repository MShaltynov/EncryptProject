module com.example.stage1project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stage1project to javafx.fxml;
    exports com.example.stage1project;
}