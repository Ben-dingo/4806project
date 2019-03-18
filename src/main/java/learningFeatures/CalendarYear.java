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

    @ManyToMany(mappedBy= "calendarYears")
    protected List<Course> courses;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="program_id")
    private Program program;

    public CalendarYear() {
        this(0);
    }

    public CalendarYear(int year) {
        this.year = year;
        this.program = null;
        courses = new ArrayList<>();
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void removeCourse(Course course, boolean b) {
        courses.remove(course);
        if (b) {
            course.removeCalendarYear(this, false);
        }
    }

    public void removeCourse(Course course) {
        removeCourse(course, true);
    }

    public void addCourse(Course course, boolean b) {
        courses.add(course);
        if (b) {
            course.addCalendarYear(this, false);
        }
    }

    public void addCourse(Course course) {
        addCourse(course, true);
    }

    public void setProgram(Program program, boolean b) {
        if (this.program != null) {
            this.program.removeCalendarYear(this, false);
        }
        this.program = program;
        if (b && this.program != null) {
            program.addCalendarYear(this, false);
        }
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        setProgram(program, true);
    }
}