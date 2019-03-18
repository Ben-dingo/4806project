package learningFeatures;

import junit.framework.TestCase;

public class CalendarYearTest extends TestCase {

    private CalendarYear calendarYear;
    private Course course;

    protected void setUp() {
        calendarYear = new CalendarYear();
        course = new Course("name");
    }

    protected void tearDown() {
        calendarYear = null;
        course = null;
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
}
