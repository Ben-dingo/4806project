package learningFeatures;

import junit.framework.TestCase;

public class CalendarYearTest extends TestCase {

    private CalendarYear calendarYear;
    private LearningObjective learningObjective;

    protected void setUp() {
        calendarYear = new CalendarYear();
        learningObjective = new LearningObjective("name", "description");
    }

    protected void tearDown() {
        calendarYear = null;
        learningObjective = null;
    }

    public void testGetYear() {
        assertEquals(0, calendarYear.getYear());
    }

    public void testSetYear() {
        calendarYear.setYear(2019);
        assertEquals(2019, calendarYear.getYear());
    }

    public void testAddRemoveObjectives() {
        calendarYear.addObjective(learningObjective);
        assertTrue(learningObjective.calendarYears.contains(calendarYear));
        assertTrue(calendarYear.learningObjectives.contains(learningObjective));
        calendarYear.removeObjective(learningObjective);
        assertTrue(learningObjective.calendarYears.isEmpty());
        assertTrue(calendarYear.learningObjectives.isEmpty());
    }
}
