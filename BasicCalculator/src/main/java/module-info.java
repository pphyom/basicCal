module com.pyaephyom.basiccalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pyaephyom.basiccalculator to javafx.fxml;
    exports com.pyaephyom.basiccalculator;
}