package learningFeatures;

import junit.framework.TestCase;

import java.util.ArrayList;

public class LearningObjectivesTest extends TestCase {

    private LearningObjective lo;
    private Course course1;
    private Category category1;
    private CalendarYear calendarYear;

    protected void setUp() {
        lo = new LearningObjective("loName", "loDesc");
        course1 = new Course("Course1");
        category1 = new Category("Category1");
        calendarYear = new CalendarYear(2019);
    }

    protected void tearDown() {
        lo = null;
        course1 = null;
        category1 = null;
        calendarYear = null;
    }

    public void testGetName() {
        assertEquals("loName", lo.getName());
    }

    public void testSetName() {
        lo.setName("newName");
        assertEquals("newName", lo.getName());
    }

    public void testGetDescription() {
        assertEquals("loDesc", lo.getDescription());
    }

    public void testSetDescription() {
        lo.setDescription("newDesc");
        assertEquals("newDesc", lo.getDescription());
    }

    public void testAddRemoveCourses() {
        lo.addCourse(course1);
        assertTrue(lo.courses.contains(course1));
        assertTrue(course1.learningObjectives.contains(lo));
        lo.removeCourse(course1);
        assertTrue(lo.courses.isEmpty());
        assertTrue(course1.learningObjectives.isEmpty());
    }

    public void testAddRemoveCategories() {
        lo.addCategory(category1);
        assertTrue(lo.categories.contains(category1));
        assertTrue(category1.learningObjectives.contains(lo));
        lo.removeCategory(category1);
        assertTrue(lo.categories.isEmpty());
        assertTrue(category1.learningObjectives.isEmpty());
    }

    public void testAddRemoveCalendarYear() {
        lo.addCalendarYear(calendarYear);
        assertTrue(lo.calendarYears.contains(calendarYear));
        assertTrue(calendarYear.learningObjectives.contains(lo));
        lo.removeCalendarYear(calendarYear);
        assertTrue(lo.calendarYears.isEmpty());
        assertTrue(calendarYear.learningObjectives.isEmpty());
    }
}
