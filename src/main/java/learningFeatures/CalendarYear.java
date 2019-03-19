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

    @ManyToMany(mappedBy = "calendarYears")
    protected List<Program> programs;

    public CalendarYear() {
        this(0);
    }

    public CalendarYear(int year) {
        this.year = year;
        programs = new ArrayList<>();
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

    public void addProgram(Program program, boolean b) {
        programs.add(program);
        if (b) {
            program.addCalendarYear(this, false);
        }
    }

    public void addProgram(Program program) {
        addProgram(program, true);
    }

    public void removeProgram(Program program, boolean b) {
        programs.remove(program);
        if (b) {
            program.removeCalendarYear(this, false);
        }
    }

    public void removeProgram(Program program) {
        removeProgram(program, true);
    }
}