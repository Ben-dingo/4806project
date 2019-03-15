package learningFeatures;

import junit.framework.TestCase;

import java.util.ArrayList;

public class CategoryTest extends TestCase {

    private Category category;
    private LearningObjective lo;
    private LearningObjective newLo;
    private ArrayList<LearningObjective> list;



    protected void setUp() {
        category = new Category("categoryName");
        lo = new LearningObjective("loName", "loDesc");
        newLo = new LearningObjective("newLoName", "newLoDesc");
        list = new ArrayList<>();
        list.add(lo);
        list.add(newLo);
    }

    protected void tearDown() {
        category = null;
        lo = null;
        newLo = null;
        list = null;
    }

    public void testGetName() {
        assertEquals("categoryName", category.getName());
    }

    public void testSetName() {
        category.setName("newName");
        assertEquals("newName", category.getName());
    }

    public void testAddRemoveObjective() {
        category.addObjective(lo);
        assertEquals(lo, category.getLearningObjectives().get(0));
        category.removeObjective(lo);
        assertTrue(category.getLearningObjectives().isEmpty());
    }

    public void testSetGetEntries() {
        category.setLearningObjectives(list);
        assertEquals(list, category.getLearningObjectives());
    }
}
