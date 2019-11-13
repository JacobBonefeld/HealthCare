package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Controller {

    @FXML TextField heightInput;
    @FXML TextField weightInput;
    @FXML Label bmiOutput;
    @FXML Label bmiTipOutput;


    @FXML public void handleButtonBMI(){
        NumberFormat formatter = new DecimalFormat("#0.00");
        Double bMI = calculateBMI(Double.parseDouble(heightInput.getText()),Double.parseDouble(weightInput.getText()));
        bmiOutput.setText(formatter.format(bMI) + " BMI");
        bmiTipOutput.setText(bMICategorization(bMI));
    }

    public static double calculateBMI(double height, double weight){
        double bmi;
        bmi =weight / Math.pow(height,2);
        return bmi;
    }

    public static String bMICategorization(double bMI){
        String categoryBmi ="";
        if (bMI <15){
            categoryBmi = "Very Severely underweight";
        }else if (bMI >15 && bMI <=16 ){
            categoryBmi = "Severely underweight";
        }else if (bMI >16 && bMI <=18.5){
            categoryBmi = "Underweight";
        } else if (bMI >18.5 && bMI <= 25){
            categoryBmi = "Normal";
        } else if (bMI >25 && bMI <= 30){
            categoryBmi = "Overweight";
        } else if (bMI > 30 && bMI <=35){
            categoryBmi = "Slightly Obese";
        } else if (bMI > 35 && bMI <= 40){
            categoryBmi = "Severely Obese";
        } else {
            categoryBmi = "Very Severely Obese";
        }
        return categoryBmi;
    }


}
