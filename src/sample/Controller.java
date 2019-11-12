package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


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

    /**
     * displays average exerciseHours and state of thumbup/down
     */
    public void displayAverageExerciseHours(){
   DB.selectSQL("SELECT AVG(fldExercisedHours) FROM tblHealthRecord");
   String avg = DB.getData();
    averageDisplay.setText(avg);
    if (Double.parseDouble(avg)>3){
        thumbsDown.setVisible(false);
        thumbsUp.setVisible(true);
    }
    else {
        thumbsUp.setVisible(false);
        thumbsDown.setVisible(true);
    }
    }

}
