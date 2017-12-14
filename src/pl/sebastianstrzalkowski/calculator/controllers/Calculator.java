package pl.sebastianstrzalkowski.calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import pl.sebastianstrzalkowski.calculator.enums.Operations;
import pl.sebastianstrzalkowski.calculator.models.Complex;

import java.net.URL;
import java.util.ResourceBundle;

import static pl.sebastianstrzalkowski.calculator.models.Complex.*;

public class Calculator implements Initializable {
    public TextField fieldCalculate1;
    public TextField fieldCalculate;
    public TextField fieldResult;
    public Button calculateButton;
    public ComboBox choseComboBox;
    public RadioButton radioPlot;


    public void initialize(URL location, ResourceBundle resources) {
        choseComboBox.getItems().addAll(Operations.values());
    }

    public void calculateButton(ActionEvent actionEvent) {

        Complex complex1 = new Complex(0,0);
        Complex complex2 = new Complex(0,0);
        complex1 = complex1.readComplex(fieldCalculate1.getText());
        complex2 = complex2.readComplex(fieldCalculate.getText());
        Complex result = new Complex(0,0);

        if(choseComboBox.getValue() == Operations.DODAWANIE){
            result = result.addComplex(complex1,complex2);
        }else if(choseComboBox.getValue() == Operations.ODEJMOWANIE){
            result = result.subtractionComplex(complex1,complex2);
        }else if(choseComboBox.getValue() == Operations.MNOŻENIE){
            result = result.multiplicationComplex(complex1,complex2);
        }else if(choseComboBox.getValue() == Operations.DZIELENIE && fieldCalculate.getText() != "0"){
            result = result.divisionComplex(complex1,complex2);
        }

        fieldResult.setText(result.toString());
    }

    public void choseComboBox(ActionEvent actionEvent) {
    }
}
