package learningFeatures;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CalendarYear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int year;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "calendarYear",
            joinColumns = @JoinColumn(name = "calendarYear_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "obj_id", referencedColumnName = "id"))
    protected List<LearningObjective> learningObjectives;

    public CalendarYear() {
        this(0);
    }

    public CalendarYear(int year) {
        this.year = year;
        learningObjectives = new ArrayList<>();
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void removeObjective(LearningObjective obj, boolean b) {
        learningObjectives.remove(obj);
        if (b) {
            obj.removeCalendarYear(this, false);
        }
    }

    public void removeObjective(LearningObjective obj) {
        removeObjective(obj, true);
    }

    public void addObjective(LearningObjective obj, boolean b) {
        learningObjectives.add(obj);
        if (b) {
            obj.addCalendarYear(this, false);
        }
    }

    public void addObjective(LearningObjective obj) {
        addObjective(obj, true);
    }
}