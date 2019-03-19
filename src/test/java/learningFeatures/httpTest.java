package learningFeatures;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
	ArrayList<Integer> courseYears;

	List<String> academicYearNames;
	List<String> academicYearAssocs;

	List<String> programNames;
	List<String> programAssocs;

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

	@Test
	public void courseAcademicYearTest() throws Exception {
		courseNames = new ArrayList<String>();
		courseYears = new ArrayList<Integer>();
		courseAssocs = new ArrayList<String>();

		academicYearNames = new ArrayList<String>();
		academicYearAssocs = new ArrayList<String>();

		courseNames.add("Introduction to Imperative Programming");
		courseYears.add(0);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Fundamentals of Computer Systems");
		courseYears.add(0);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Discrete Math I");
		courseYears.add(0);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Calculus and Differential Equations");
		courseYears.add(0);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Newtonian Mechanics & Maxwell's Equations");
		courseYears.add(0);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Introduction to Object-Oriented Programming");
		courseYears.add(1);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Digital Electronics & Verilog");
		courseYears.add(1);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Discrete Math II");
		courseYears.add(1);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Calculus and Differential Equations IN 3D!");
		courseYears.add(1);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Quantum Physics & Relativity");
		courseYears.add(1);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Introduction to Conjuration");
		courseYears.add(2);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Introduction to Summoning");
		courseYears.add(2);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Discreet Math");
		courseYears.add(2);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Inapplicable Mathematics");
		courseYears.add(2);
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Metaphysics & Thyme Manipulation");
		courseYears.add(2);
		courseAssocs.add("/course/" + getNextID());

		academicYearNames.add("First Year");
		academicYearAssocs.add("/academicyear/" + getNextID());

		academicYearNames.add("Second Year");
		academicYearAssocs.add("/academicyear/" + getNextID());

		academicYearNames.add("Sixth Form");
		academicYearAssocs.add("/academicyear/" + getNextID());

		for (int n = 0; n < courseNames.size(); n++) {
			postCourse(n);
		}

		for (int n = 0; n < academicYearNames.size(); n++) {
			postAcademicYear(n);
		}

		for (int n = 0; n < courseNames.size(); n++) {
			associateCourseAcademicYear(n, courseYears.get(n));
		}

		for (int n = 0; n < courseNames.size(); n++) {
			testCourseAcademicYear(n, courseYears.get(n));
		}
	}

	@Test
	public void academicYearProgramTest() throws Exception {
		academicYearNames = new ArrayList<String>();
		academicYearAssocs = new ArrayList<String>();

		programNames = new ArrayList<String>();
		programAssocs = new ArrayList<String>();

		academicYearNames.add("First Year");
		academicYearAssocs.add("/academicyear/" + getNextID());

		academicYearNames.add("Second Year");
		academicYearAssocs.add("/academicyear/" + getNextID());

		academicYearNames.add("Sixth Form");
		academicYearAssocs.add("/academicyear/" + getNextID());

		programNames.add("Software Engineering");
		programAssocs.add("/program/" + getNextID());

		programNames.add("Applied Magic");
		programAssocs.add("/program/" + getNextID());

		for (int n = 0; n < academicYearNames.size(); n++) {
			postAcademicYear(n);
		}

		for (int n = 0; n < programNames.size(); n++) {
			postProgram(n);
		}

		associateProgramAcademicYear(0, 0);
		associateProgramAcademicYear(0, 1);
		associateProgramAcademicYear(0, 2);

		testProgramAcademicYear(0, 0);
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

	private void postAcademicYear(int academicYearID) throws Exception {
		String retVal = "{";
		retVal += "\"name\" : \"" + academicYearNames.get(academicYearID) + "\"";
		retVal += "}";

		this.mockMvc.perform(post("/academicyear").contentType(MediaType.APPLICATION_JSON_UTF8).content(retVal)).andExpect(status().is2xxSuccessful());
	}

	private void postProgram(int courseID) throws Exception {
		String retVal = "{";
		retVal += "\"name\" : \"" + programNames.get(courseID) + "\"";
		retVal += "}";

		this.mockMvc.perform(post("/program").contentType(MediaType.APPLICATION_JSON_UTF8).content(retVal)).andExpect(status().is2xxSuccessful());
	}

	private void associateObjectiveCourse(int courseID, int objID) throws Exception {
		this.mockMvc.perform(post(courseAssocs.get(courseID) + "/learningObjectives").contentType("text/uri-list").content(objAssocs.get(objID))).andExpect(status().is2xxSuccessful());
	}

	private void associateObjectiveCategory(int categoryID, int objID) throws Exception {
		this.mockMvc.perform(post(categoryAssocs.get(categoryID) + "/learningObjectives").contentType("text/uri-list").content(objAssocs.get(objID))).andExpect(status().is2xxSuccessful());
	}

	private void associateCourseAcademicYear(int courseID, int academicYearID) throws Exception {
		this.mockMvc.perform(post(courseAssocs.get(courseID) +"/academicYears").contentType("text/uri-list").content(academicYearAssocs.get(academicYearID))).andExpect(status().is2xxSuccessful());
	}

	private void associateProgramAcademicYear(int programID, int academicYearID) throws Exception {
		this.mockMvc.perform(put(academicYearAssocs.get(academicYearID) +"/program").contentType("text/uri-list").content(programAssocs.get(programID))).andExpect(status().is2xxSuccessful());
	}

	private void testCourseObjective(int courseID, int objID) throws Exception {
		String nameTest = "\"name\" : \"" + objectNames.get(objID) + "\"";
		String descTest = "\"description\" : \"" + descriptions.get(objID) + "\"";

		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/learningObjectives")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/learningObjectives")).andExpect(status().isOk()).andExpect(content().string(containsString(descTest)));
	}

	private void testCategoryObjective(int categoryID, int objID) throws Exception {
		String nameTest = "\"name\" : \"" + objectNames.get(objID) + "\"";
		String descTest = "\"description\" : \"" + descriptions.get(objID) + "\"";

		this.mockMvc.perform(get(categoryAssocs.get(categoryID) +"/learningObjectives")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
		this.mockMvc.perform(get(categoryAssocs.get(categoryID) +"/learningObjectives")).andExpect(status().isOk()).andExpect(content().string(containsString(descTest)));
	}

	private void testCourseAcademicYear(int courseID, int academicYearID) throws Exception {
		String nameTest = "\"name\" : \"" + academicYearNames.get(academicYearID) + "\"";

		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/academicYears")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
	}

	private void testProgramAcademicYear(int programID, int academicYearID) throws Exception {
		String nameTest = "\"name\" : \"" + academicYearNames.get(academicYearID) + "\"";

		this.mockMvc.perform(get(programAssocs.get(programID) +"/academicYears")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
	}
}
