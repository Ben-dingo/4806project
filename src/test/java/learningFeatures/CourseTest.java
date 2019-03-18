package learningFeatures;

import junit.framework.TestCase;

import java.util.ArrayList;

public class CourseTest extends TestCase {

    private Course course;
    private LearningObjective lo;
    private LearningObjective newLo;
    private ArrayList<LearningObjective> addLo;

    protected void setUp() {
        course = new Course("Course1", 1);
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

    public void testGetYear() {
        assertEquals(1, course.getYear());
    }

    public void testSetYear() {
        course.setYear(2);
        assertEquals(2, course.getYear());
    }
    
    public void testAddRemoveObjective() {
        course.addObjective(lo);
        assertEquals(lo, course.getEntries().get(0));
        course.removeObjective(lo);
        assertTrue(course.getEntries().isEmpty());
    }

    public void testSetGetEntries() {
        course.setEntries(addLo);
        assertEquals(addLo, course.getEntries());
    }

    public void testToString() {
        course.setEntries(addLo);
        assertEquals("Course1 (currLo: currDesc, newLo: newDesc)", course.toString());
    }
}