package learningFeatures;

import junit.framework.TestCase;

import java.util.ArrayList;

public class LearningObjectivesTest extends TestCase {

    private LearningObjective lo;
    private Course course1;
    private Course course2;
    private Course course3;
    private Category category1;
    private Category category2;
    private ArrayList<Course> courses;
    private ArrayList<Category> categories;

    protected void setUp() {
        lo = new LearningObjective("loName", "loDesc");
        course1 = new Course("Course1");
        category1 = new Category("Category1");
    }

    protected void tearDown() {
        lo = null;
        course1 = null;
        course2 = null;
        course3 = null;
        courses = null;
        categories = null;
        category1 = null;
        category2 = null;
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
        lo.removeCourse(course1);
        assertTrue(lo.courses.isEmpty());
    }

    public void testAddRemoveCategories() {
        lo.addCategory(category1);
        assertTrue(lo.categories.contains(category1));
        lo.removeCategory(category1);
        assertTrue(lo.categories.isEmpty());
    }
}
