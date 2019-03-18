package learningFeatures;

import junit.framework.TestCase;

public class AcademicYearTest extends TestCase {

	private Course course;
	private Program oldProgram;
	private Program newProgram;
	private AcademicYear academicYear;

	protected void setUp() {
		course = new Course("Course1");
		oldProgram = new Program("Software Engineering");
		newProgram = new Program("Xtreme Programming");
		academicYear = new AcademicYear("First Year");
	}

	protected void tearDown() {
		course = null;
		academicYear = null;
	}

	public void testGetName() {
		assertEquals("First Year", academicYear.getName());
	}

	public void testSetName() {
		academicYear.setName("Second Year");
		assertEquals("Second Year", academicYear.getName());
	}

	public void testAddRemoveCourse() {
		academicYear.addCourse(course);
		assertTrue(course.academicYears.contains(academicYear));
		assertTrue(academicYear.courses.contains(course));
		academicYear.removeCourse(course);
		assertTrue(course.academicYears.isEmpty());
		assertTrue(academicYear.courses.isEmpty());
	}

	public void testSetGetProgram() {
		academicYear.setProgram(oldProgram);
		assertTrue(academicYear.getProgram().equals(oldProgram));
		assertTrue(oldProgram.academicYears.contains(academicYear));
		academicYear.setProgram(newProgram);
		assertTrue(academicYear.getProgram().equals(newProgram));
		assertTrue(oldProgram.academicYears.isEmpty());
		assertTrue(newProgram.academicYears.contains(academicYear));
	}
}