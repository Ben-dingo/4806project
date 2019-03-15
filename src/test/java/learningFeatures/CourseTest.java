package learningFeatures;

import junit.framework.TestCase;

import java.util.ArrayList;

public class CourseTest extends TestCase {

    private Course course;
    private LearningObjective lo;
    private LearningObjective newLo;
    private ArrayList<LearningObjective> addLo;

    protected void setUp() {
        course = new Course("Course1");
        lo = new LearningObjective("currLo", "currDesc");
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
        assertEquals(lo, course.getLearningObjectives().get(0));
        course.removeObjective(lo);
        assertTrue(course.getLearningObjectives().isEmpty());
    }

    public void testSetGetEntries() {
        course.setLearningObjectives(addLo);
        assertEquals(addLo, course.getLearningObjectives());
    }

    public void testToString() {
        course.setLearningObjectives(addLo);
        assertEquals("Course1 (currLo: currDesc, newLo: newDesc)", course.toString());
    }
}