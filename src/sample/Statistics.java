package sample;

public class Statistics {
    private String weekNumber;
    private String exerciseHours;

    public Statistics(String weekNumber, String exerciseHours) {
        this.weekNumber = weekNumber;
        this.exerciseHours = exerciseHours;
    }

    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getWeekNumber() {
        return weekNumber;
    }

    public void setExerciseHours(String exerciseHours) {
        this.exerciseHours = exerciseHours;
    }

    public String getExerciseHours() {
        return exerciseHours;
    }
}
