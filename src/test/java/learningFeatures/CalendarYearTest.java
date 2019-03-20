package learningFeatures;

import junit.framework.TestCase;

public class CalendarYearTest extends TestCase {

    private CalendarYear calendarYear;
    private Course course;
    private Program program;

    protected void setUp() {
        calendarYear = new CalendarYear();
        course = new Course("name");
        program = new Program("programName");
    }

    protected void tearDown() {
        calendarYear = null;
        course = null;
        program = null;
    }

    public void testGetYear() {
        assertEquals(0, calendarYear.getYear());
    }

    public void testSetYear() {
        calendarYear.setYear(2019);
        assertEquals(2019, calendarYear.getYear());
    }

    public void testAddRemoveObjectives() {
        calendarYear.addCourse(course);
        assertTrue(course.calendarYears.contains(calendarYear));
        assertTrue(calendarYear.courses.contains(course));
        calendarYear.removeCourse(course);
        assertTrue(course.calendarYears.isEmpty());
        assertTrue(calendarYear.courses.isEmpty());
    }

    public void testAddRemoveProgram() {
        calendarYear.addProgram(program);
        assertTrue(program.calendarYears.contains(calendarYear));
        assertTrue(calendarYear.programs.contains(program));
        calendarYear.removeProgram(program);
        assertTrue(program.calendarYears.isEmpty());
        assertTrue(calendarYear.programs.isEmpty());
    }
}
