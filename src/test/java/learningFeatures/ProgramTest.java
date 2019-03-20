package learningFeatures;

import junit.framework.TestCase;

public class ProgramTest extends TestCase {

	private Program newProgram;
	private AcademicYear academicYear;
	private CalendarYear calendarYear;

	protected void setUp() {
		newProgram = new Program("Xtreme Programming");
		academicYear = new AcademicYear("First Year");
		calendarYear = new CalendarYear(2019);
	}

	protected void tearDown() {
		newProgram = null;
		academicYear = null;
		calendarYear = null;
	}

	public void testGetName() {
		assertEquals("Xtreme Programming", newProgram.getName());
	}

	public void testSetName() {
		newProgram.setName("Software Engineering");
		assertEquals("Software Engineering", newProgram.getName());
	}

	public void testAddRemoveAcademicYear() {
		newProgram.addAcademicYear(academicYear);
		assertTrue(newProgram.academicYears.contains(academicYear));
		assertTrue(academicYear.getProgram().equals(newProgram));
		newProgram.removeAcademicYear(academicYear);
		assertTrue(newProgram.academicYears.isEmpty());
		assertTrue(academicYear.getProgram() == null);
	}

	public void testAddRemoveCalendarYear() {
		newProgram.addCalendarYear(calendarYear);
		assertTrue(newProgram.calendarYears.contains(calendarYear));
		assertTrue(calendarYear.programs.contains(newProgram));
		newProgram.removeCalendarYear(calendarYear);
		assertTrue(newProgram.calendarYears.isEmpty());
		assertTrue(calendarYear.programs.isEmpty());
	}
}