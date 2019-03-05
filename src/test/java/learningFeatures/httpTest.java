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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class httpTest {
	@Autowired
	private MockMvc mockMvc;
	List<String> objectNames;
	List<String> descriptions;
	List<String> objAssocs;

	List<String> courseNames;
	List<String> courseAssocs;

	@Test
	public void addBooksAndCheck() throws Exception {
		objectNames = new ArrayList<String>();
		descriptions = new ArrayList<String>();
		objAssocs = new ArrayList<String>();
		courseNames = new ArrayList<String>();
		courseAssocs = new ArrayList<String>();

		objectNames.add("Summon Demons");
		descriptions.add("Able to summon demons using various techniques");
		objAssocs.add("/objective/1");

		objectNames.add("Identify Items");
		descriptions.add("Can identify items");
		objAssocs.add("/objective/2");

		objectNames.add("Pointer Arithmetic");
		descriptions.add("Can use C Arrays");
		objAssocs.add("/objective/3");

		courseNames.add("Magic 101");
		courseAssocs.add("/course/4");

		courseNames.add("Pointless Hard Things 101");
		courseAssocs.add("/course/5");

		for (int n = 0; n < objectNames.size(); n++) {
			postObjective(n);
		}

		for (int n = 0; n < courseNames.size(); n++) {
			postCourse(n);
		}

		associateObjectiveCourse(0, 0);
		associateObjectiveCourse(0, 1);

		associateObjectiveCourse(1, 0);
		associateObjectiveCourse(1, 2);

		getTestInfo(0, 0);
		getTestInfo(0, 1);

		getTestInfo(1, 0);
		getTestInfo(1, 2);
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

	private void associateObjectiveCourse(int courseID, int objID) throws Exception {
		this.mockMvc.perform(post(courseAssocs.get(courseID) + "/entries").contentType("text/uri-list").content(objAssocs.get(objID))).andExpect(status().is2xxSuccessful());
	}

	private void getTestInfo(int courseID, int objID) throws Exception {
		String nameTest = "\"name\" : \"" + objectNames.get(objID) + "\"";
		String descTest = "\"description\" : \"" + descriptions.get(objID) + "\"";

		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/entries")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/entries")).andExpect(status().isOk()).andExpect(content().string(containsString(descTest)));
	}
}
