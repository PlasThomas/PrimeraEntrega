module org.eqcatorce.primeraentrega {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.eqcatorce.primeraentrega to javafx.fxml;
    exports org.eqcatorce.primeraentrega;
}