package learningFeatures;

import junit.framework.TestCase;

public class ProgramTest extends TestCase {

	private Program newProgram;
	private AcademicYear academicYear;

	protected void setUp() {
		newProgram = new Program("Xtreme Programming");
		academicYear = new AcademicYear("First Year");
	}

	protected void tearDown() {
		newProgram = null;
		academicYear = null;
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
}