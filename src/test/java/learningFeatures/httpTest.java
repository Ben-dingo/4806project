package learningFeatures;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class httpTest {
	@Autowired
	private MockMvc mockMvc;
	int counter = 0;
	List<String> objectNames;
	List<String> descriptions;
	List<String> objAssocs;

	List<String> courseNames;
	List<String> courseAssocs;

	List<String> categoryNames;
	List<String> categoryAssocs;

	private int getNextID() {
		counter++;
		return counter;
	}

	@Test
	public void objectiveCourseTest() throws Exception {
		objectNames = new ArrayList<String>();
		descriptions = new ArrayList<String>();
		objAssocs = new ArrayList<String>();
		courseNames = new ArrayList<String>();
		courseAssocs = new ArrayList<String>();
		categoryNames = new ArrayList<String>();
		categoryAssocs = new ArrayList<String>();

		objectNames.add("Negotiate with Demons");
		descriptions.add("Student is capable of negotiating favourable terms with demons.");
		objAssocs.add("/objective/" + getNextID());

		objectNames.add("Identify Items");
		descriptions.add("Can identify items");
		objAssocs.add("/objective/" + getNextID());

		objectNames.add("Pointer Arithmetic");
		descriptions.add("Can use C Arrays");
		objAssocs.add("/objective/" + getNextID());

		objectNames.add("Writing Requirements");
		descriptions.add("Can write well defined requirements");
		objAssocs.add("/objective/" + getNextID());

		courseNames.add("Magic 101");
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Software Engineering 101");
		courseAssocs.add("/course/" + getNextID());

		for (int n = 0; n < objectNames.size(); n++) {
			postObjective(n);
		}

		for (int n = 0; n < courseNames.size(); n++) {
			postCourse(n);
		}

		associateObjectiveCourse(0, 0);
		associateObjectiveCourse(0, 1);

		associateObjectiveCourse(1, 2);
		associateObjectiveCourse(1, 3);

		testCourseObjective(0, 0);
		testCourseObjective(0, 1);

		testCourseObjective(1, 2);
		testCourseObjective(1, 3);
	}

	@Test
	public void objectiveCategoryTest() throws Exception {
		objectNames = new ArrayList<String>();
		descriptions = new ArrayList<String>();
		objAssocs = new ArrayList<String>();
		courseNames = new ArrayList<String>();
		courseAssocs = new ArrayList<String>();
		categoryNames = new ArrayList<String>();
		categoryAssocs = new ArrayList<String>();

		objectNames.add("Negotiate with Demons");
		descriptions.add("Student is capable of negotiating favourable terms with demons.");
		objAssocs.add("/objective/" + getNextID());

		objectNames.add("Identify Items");
		descriptions.add("Can identify items");
		objAssocs.add("/objective/" + getNextID());

		objectNames.add("Pointer Arithmetic");
		descriptions.add("Can use C Arrays");
		objAssocs.add("/objective/" + getNextID());

		objectNames.add("Writing Requirements");
		descriptions.add("Can write well defined requirements");
		objAssocs.add("/objective/" + getNextID());

		objectNames.add("Lambda Functions");
		descriptions.add("Knows when to use lambda functions");
		objAssocs.add("/objective/" + getNextID());

		categoryNames.add("Communication Skills");
		categoryAssocs.add("/category/" + getNextID());

		categoryNames.add("Technical Skills");
		categoryAssocs.add("/category/" + getNextID());

		for (int n = 0; n < objectNames.size(); n++) {
			postObjective(n);
		}

		for (int n = 0; n < categoryNames.size(); n++) {
			postCategory(n);
		}

		associateObjectiveCategory(0, 0);
		associateObjectiveCategory(0, 3);

		associateObjectiveCategory(1, 1);
		associateObjectiveCategory(1, 2);
		associateObjectiveCategory(1, 4);

		testCategoryObjective(0, 0);
		testCategoryObjective(0, 3);

		testCategoryObjective(1, 1);
		testCategoryObjective(1, 2);
		testCategoryObjective(1, 4);
	}

	private void postObjective(int objID) throws Exception {
		String retVal = "{";
		retVal += "\"name\" : \"" + objectNames.get(objID) + "\",";
		retVal += "\"description\" : \"" + descriptions.get(objID) + "\"";
		retVal += "}";

		this.mockMvc.perform(post("/objective").contentType(MediaType.APPLICATION_JSON_UTF8).content(retVal)).andExpect(status().is2xxSuccessful());
	}

	private void postCourse(int courseID) throws Exception {
		String retVal = "{";
		retVal += "\"name\" : \"" + courseNames.get(courseID) + "\"";
		retVal += "}";

		this.mockMvc.perform(post("/course").contentType(MediaType.APPLICATION_JSON_UTF8).content(retVal)).andExpect(status().is2xxSuccessful());
	}

	private void postCategory(int categoryID) throws Exception {
		String retVal = "{";
		retVal += "\"name\" : \"" + categoryNames.get(categoryID) + "\"";
		retVal += "}";

		this.mockMvc.perform(post("/category").contentType(MediaType.APPLICATION_JSON_UTF8).content(retVal)).andExpect(status().is2xxSuccessful());
	}

	private void associateObjectiveCourse(int courseID, int objID) throws Exception {
		this.mockMvc.perform(post(courseAssocs.get(courseID) + "/entries").contentType("text/uri-list").content(objAssocs.get(objID))).andExpect(status().is2xxSuccessful());
	}

	private void associateObjectiveCategory(int categoryID, int objID) throws Exception {
		this.mockMvc.perform(post(categoryAssocs.get(categoryID) + "/entries").contentType("text/uri-list").content(objAssocs.get(objID))).andExpect(status().is2xxSuccessful());
	}

	private void testCourseObjective(int courseID, int objID) throws Exception {
		String nameTest = "\"name\" : \"" + objectNames.get(objID) + "\"";
		String descTest = "\"description\" : \"" + descriptions.get(objID) + "\"";

		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/entries")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/entries")).andExpect(status().isOk()).andExpect(content().string(containsString(descTest)));
	}

	private void testCategoryObjective(int categoryID, int objID) throws Exception {
		String nameTest = "\"name\" : \"" + objectNames.get(objID) + "\"";
		String descTest = "\"description\" : \"" + descriptions.get(objID) + "\"";

		this.mockMvc.perform(get(categoryAssocs.get(categoryID) +"/entries")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
		this.mockMvc.perform(get(categoryAssocs.get(categoryID) +"/entries")).andExpect(status().isOk()).andExpect(content().string(containsString(descTest)));
	}
}
