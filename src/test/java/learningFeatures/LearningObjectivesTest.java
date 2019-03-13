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
        course2 = new Course("Course2");
        course3 = new Course("Course3");
        category1 = new Category("Category1");
        category2 = new Category("Category2");
        courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        categories = new ArrayList<>();
        categories.add(category1);
        categories.add(category2);
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

    public void testSetGetCourses() {
        lo.setCourse(courses);
        assertEquals(courses, lo.getCourses());
    }

    public void testSetGetCategories() {
        lo.setCategories(categories);
        assertEquals(categories, lo.getCategories());
    }

    public void testToString(){
        lo.setName("loName");
        lo.setDescription("loDesc");
        assertEquals("loName: loDesc", lo.toString());
    }
}
