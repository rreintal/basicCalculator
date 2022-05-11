package com.example.kalkulaatornuppudega;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class calculatorController {
    @FXML
    private Label answerPrompt;

    private long longValue = 0;
    private double doubleValue = 0.0;

    private String lastOperation = "";
    private boolean lastClickEquals = false;
    private boolean operationRunning = false;

    @FXML
    protected void resetData(){
        answerPrompt.setText("0.0");
        longValue = 0;
        doubleValue = 0.0;
        operationRunning = false;
    }

    @FXML
    protected void equalsButton() {
        // kui operationRunning, siis decode mis oli viimane tehe!
        if (operationRunning) {
            lastOperationDecoder(lastOperation);
        }
        lastClickEquals = true;
        operationRunning = false;
        // Tee siia kontroll, kui üks double/long on 0, siis kuva teine!
        if (doubleValue == Double.parseDouble("0.0")) {
            answerPrompt.setText(String.valueOf(longValue));
        }
        if (longValue == Long.parseLong("0")) {
            answerPrompt.setText(String.valueOf(doubleValue));
        }
        longValue = 0;
        //doubleValue = 0.0;
    }

    @FXML
    protected void lastOperationDecoder(String symbol) {
        switch (symbol) {
            case "+" -> longValue += Long.parseLong(answerPrompt.getText());
            case "-" -> longValue -= Long.parseLong(answerPrompt.getText());
            case "/" -> doubleValue /= Double.parseDouble(answerPrompt.getText());
            case "*" -> doubleValue *= Double.parseDouble(answerPrompt.getText());
        }
    }


    @FXML
    protected void clickOnNumberButton(ActionEvent event) {
        if (lastClickEquals) {
            answerPrompt.setText("0.0");
            lastClickEquals = false;
        }
        Button btn = (Button) event.getSource();
        if (answerPrompt.getText().equals("0.0")) {
            answerPrompt.setText(btn.getText());
        }
        else if (!operationRunning && !answerPrompt.getText().equals("0.0")) {
            answerPrompt.setText(answerPrompt.getText() + btn.getText());
        }
        else if (operationRunning && !answerPrompt.getText().equals("0.0")) {
            answerPrompt.setText(answerPrompt.getText() + btn.getText());
        }
    }

    @FXML
    protected void add() {
        operationRunning = true;
        longValue += Long.parseLong(answerPrompt.getText());
        answerPrompt.setText("0.0"); // Resets calculator text field.
        lastOperation = "+";
    }

    @FXML
    protected void subtract() {
        operationRunning = true;
        if (longValue == Long.parseLong("0")) {
            longValue = Long.parseLong(answerPrompt.getText());
        }
        else {
            longValue -= Long.parseLong(answerPrompt.getText());
        }
        answerPrompt.setText("0.0");
        lastOperation = "-";
    }

    @FXML
    protected void divide() {
        operationRunning = true;
        if (doubleValue == Double.parseDouble("0.0")) {
            doubleValue = Double.parseDouble(answerPrompt.getText());
        }
        else {
            doubleValue /= Double.parseDouble(answerPrompt.getText());
        }
        answerPrompt.setText("0.0");
        lastOperation = "/";
    }

    @FXML
    protected void multiply() {
        operationRunning = true;
        if (doubleValue == Double.parseDouble("0.0")) {
            doubleValue = Double.parseDouble(answerPrompt.getText());
        }
        else {
            doubleValue *= Double.parseDouble(answerPrompt.getText());
        }
        answerPrompt.setText("0.0");
        lastOperation = "*";
    }

}