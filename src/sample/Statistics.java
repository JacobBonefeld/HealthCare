package sample;

public class Statistics {
    private String weekNumber;
    private String exerciseHours;

    /**
     * Used to assign statistics
     * @param weekNumber
     * @param exerciseHours
     */
    public Statistics(String weekNumber, String exerciseHours) {
        this.weekNumber = weekNumber;
        this.exerciseHours = exerciseHours;
    }

    /**
     * used to set weekNumb
     * @param weekNumber
     */
    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    /**
     * used to get weekNumb
     * @return
     */
    public String getWeekNumber() {
        return weekNumber;
    }

    /**
     * used to set exerciseHours
     * @param exerciseHours
     */
    public void setExerciseHours(String exerciseHours) {
        this.exerciseHours = exerciseHours;
    }

    /**
     * used to get exerciseHours
     * @return
     */
    public String getExerciseHours() {
        return exerciseHours;
    }
}
