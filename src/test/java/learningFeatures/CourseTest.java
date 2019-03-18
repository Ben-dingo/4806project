package learningFeatures;

import junit.framework.TestCase;

import java.util.ArrayList;

public class CourseTest extends TestCase {

    private Course course;
    private LearningObjective lo;
    private LearningObjective newLo;
    private ArrayList<LearningObjective> addLo;
    private AcademicYear academicYear;

    protected void setUp() {
        course = new Course("Course1");
        lo = new LearningObjective("currLo", "currDesc");
        academicYear = new AcademicYear();
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
}