package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


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

    public void getExcercises(){
        int week =Integer.parseInt(weekNo.getText());
        double hoursExercised = Double.parseDouble(hoursWorkedOut.getText());
        DB.insertSQL("INSERT INTO tblHealthRecord (fldWeek, fldExercisedHours)VALUES("+week+","+hoursExercised+")");
        displayExcercises();
    }
    public void displayExcercises(){
        DB.selectSQL("SELECT fldRecordId FROM tblHealthRecord");
        do{
            String recordId = DB.getData();
            if (recordId.equals(DB.NOMOREDATA)){
                break;
            }else{
                System.out.println(recordId);
                textAreaScrollPane.setText(recordId);
            }
        } while(true);

        DB.selectSQL("SELECT fldWeek FROM tblHealthRecord");
        do{
            String week = DB.getData();
            if (week.equals(DB.NOMOREDATA)){
                break;
            }else{
                System.out.println(week);
                textAreaScrollPane.setText(week);
            }
        } while(true);

        DB.selectSQL("SELECT fldExercisedHours FROM tblHealthRecord");
        do{
            String exercisedHours = DB.getData();
            if (exercisedHours.equals(DB.NOMOREDATA)){
                break;
            }else{
                System.out.println(exercisedHours);
                textAreaScrollPane.setText(exercisedHours);
            }
        } while(true);

    }

    public void displayAverageExerciseHours(){

    }
    public void setGoodOrBadEffort(){

    }
}
