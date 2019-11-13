package sample;


import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Controller {
@FXML
    TextField weekNo;
@FXML
    TextField hoursWorkedOut;
@FXML
    TextField averageDisplay;
@FXML
    ScrollPane scrollPane;
@FXML
    Button insertDataButton;
@FXML
    Button queryDataButton;
@FXML
    TextArea textAreaScrollPane;
@FXML
    ImageView thumbsUp;
@FXML
    ImageView thumbsDown;
@FXML
    TextField heightInput;
@FXML
    TextField weightInput;
@FXML
    Label bmiOutput;
@FXML
    Label bmiTipOutput;
@FXML
    TableColumn weekNO;
@FXML
    TableColumn hoursExercised;
@FXML
    TableView <Statistics> tableView;
@FXML
    TableColumn<Statistics, String> colWeekNumber;
@FXML
    TableColumn<Statistics, String> colExerciseHours;
    /**
     * gets exercises from user input, and places them in database
     */
    public void getExcercises(){
        int week =Integer.parseInt(weekNo.getText());
        double hoursExercised = Double.parseDouble(hoursWorkedOut.getText());
        DB.insertSQL("INSERT INTO tblHealthRecord (fldWeek, fldExercisedHours)VALUES("+week+","+hoursExercised+")");
        displayExcercises();
        displayAverageExerciseHours();
    }

    /**
     * Displays exercise history
     */
    public void displayExcercises(){
        handleStatistics statistics = new handleStatistics();
        statistics.addStatistics(tableView,colWeekNumber,colExerciseHours);
    }

    /**
     * displays average exerciseHours and state of thumbs up/down
     */
    public void displayAverageExerciseHours(){
   DB.selectSQL("SELECT AVG(fldExercisedHours) FROM tblHealthRecord");
   NumberFormat formatter = new DecimalFormat("#0.00");
   double avg = Double.parseDouble(DB.getData());
    averageDisplay.setText(formatter.format(avg));
    if (avg>3){
        thumbsDown.setVisible(false);
        thumbsUp.setVisible(true);
    }
    else {
        thumbsUp.setVisible(false);
        thumbsDown.setVisible(true);
    }
    DB.pendingData=false;
    }

    public void handleButtonBMI(){
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
