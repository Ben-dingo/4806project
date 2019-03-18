package learningFeatures;

import junit.framework.TestCase;

import java.util.ArrayList;

public class CourseTest extends TestCase {

    private Course course;
    private LearningObjective lo;
    private LearningObjective newLo;
    private ArrayList<LearningObjective> addLo;
    private AcademicYear academicYear;
    private CalendarYear calendarYear;

    protected void setUp() {
        course = new Course("Course1");
        lo = new LearningObjective("currLo", "currDesc");
        academicYear = new AcademicYear();
        calendarYear = new CalendarYear();
        addLo = new ArrayList<>();
        newLo = new LearningObjective("newLo", "newDesc");
        addLo.add(lo);
        addLo.add(newLo);
    }

    protected void tearDown() {
        course = null;
        lo = null;
        addLo = null;
        newLo = null;
        academicYear = null;
        calendarYear = null;
    }

    public void testGetName() {
        assertEquals("Course1", course.getName());
    }

    public void testSetName() {
        course.setName("newName");
        assertEquals("newName", course.getName());
    }

    public void testAddRemoveObjective() {
        course.addObjective(lo);
        assertTrue(course.learningObjectives.contains(lo));
        assertTrue(lo.courses.contains(course));
        course.removeObjective(lo);
        assertTrue(course.learningObjectives.isEmpty());
        assertTrue(lo.courses.isEmpty());
    }

    public void testAddRemoveAcademicYear() {
        course.addAcademicYear(academicYear);
        assertTrue(course.academicYears.contains(academicYear));
        assertTrue(academicYear.courses.contains(course));
        course.removeAcademicYear(academicYear);
        assertTrue(course.academicYears.isEmpty());
        assertTrue(academicYear.courses.isEmpty());
    }

    public void testAddRemoveCalendarYear() {
        course.addCalendarYear(calendarYear);
        assertTrue(course.calendarYears.contains(calendarYear));
        assertTrue(calendarYear.courses.contains(course));
        course.removeCalendarYear(calendarYear);
        assertTrue(course.calendarYears.isEmpty());
        assertTrue(calendarYear.courses.isEmpty());
    }
}