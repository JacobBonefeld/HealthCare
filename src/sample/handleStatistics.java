package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class handleStatistics {

    public void addStatistics(TableView<Statistics> tableView, TableColumn<Statistics, String> colWeekNumber, TableColumn<Statistics, String> colExerciseHours) {
        colWeekNumber.setCellValueFactory(new PropertyValueFactory<Statistics, String>("weekNumber"));
        colExerciseHours.setCellValueFactory(new PropertyValueFactory<Statistics, String>("exerciseHours"));

        tableView.setItems(getStatistics());
    }

    public  ObservableList<Statistics> getStatistics() {
        ObservableList<Statistics> statistics = FXCollections.observableArrayList();
        int recordId;
        String weekNumber ="";
        String exerciseHours;

        DB.selectSQL("SELECT fldRecordID from tblHealthRecord");
        recordId = Integer.parseInt(DB.getData());
        //int recordIdInt = Integer.parseInt(recordId);
        while (true) {
            DB.selectSQL("SELECT fldWeek from tblHealthRecord where fldRecordID = " + (recordId));
            weekNumber = DB.getData();

            DB.selectSQL("SELECT fldExercisedHours from tblHealthRecord where fldRecordID = " + recordId);
            exerciseHours = DB.getData();
            System.out.println(exerciseHours);
            statistics.add(new Statistics(weekNumber, exerciseHours));



            if (weekNumber.equals(DB.NOMOREDATA)) {
                break;
            } else {
                recordId ++;
              // recordId = weekNumberString;
                System.out.println(recordId);
            }
        }
        return statistics;
    }
}
