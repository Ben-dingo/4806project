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
	List<String> objectiveNames;
	List<String> objectiveDescriptions;
	List<String> objectiveAssocs;

	List<String> courseNames;
	List<String> courseAssocs;

	List<String> categoryNames;
	List<String> categoryAssocs;
	ArrayList<Integer> courseYears;

	List<String> academicYearNames;
	List<String> academicYearAssocs;

	List<String> programNames;
	List<String> programAssocs;

	List<Integer> calendarYearYears;	List<String> calendarYearAssocs;

	private int getNextID() {
		counter++;
		return counter;
	}

	@Test
	public void objectiveCourseTest() throws Exception {
		objectiveNames = new ArrayList<String>();
		objectiveDescriptions = new ArrayList<String>();
		objectiveAssocs = new ArrayList<String>();
		courseNames = new ArrayList<String>();
		courseAssocs = new ArrayList<String>();

		objectiveNames.add("Negotiate with Demons");
		objectiveDescriptions.add("Student is capable of negotiating favourable terms with demons.");
		objectiveAssocs.add("/objective/" + getNextID());

		objectiveNames.add("Identify Items");
		objectiveDescriptions.add("Can identify items");
		objectiveAssocs.add("/objective/" + getNextID());

		objectiveNames.add("Pointer Arithmetic");
		objectiveDescriptions.add("Can use C Arrays");
		objectiveAssocs.add("/objective/" + getNextID());

		objectiveNames.add("Writing Requirements");
		objectiveDescriptions.add("Can write well defined requirements");
		objectiveAssocs.add("/objective/" + getNextID());

		courseNames.add("Magic 101");
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Software Engineering 101");
		courseAssocs.add("/course/" + getNextID());

		for (int n = 0; n < objectiveNames.size(); n++) {
			postObjective(n);
		}

		for (int n = 0; n < courseNames.size(); n++) {
			postCourse(n);
		}

		associateCourseObjective(0, 0);
		associateCourseObjective(0, 1);

		associateCourseObjective(1, 2);
		associateCourseObjective(1, 3);

		testCourseObjective(0, 0);
		testCourseObjective(0, 1);

		testCourseObjective(1, 2);
		testCourseObjective(1, 3);
	}

	@Test
	public void objectiveCategoryTest() throws Exception {
		objectiveNames = new ArrayList<String>();
		objectiveDescriptions = new ArrayList<String>();
		objectiveAssocs = new ArrayList<String>();
		categoryNames = new ArrayList<String>();
		categoryAssocs = new ArrayList<String>();

		objectiveNames.add("Negotiate with Demons");
		objectiveDescriptions.add("Student is capable of negotiating favourable terms with demons.");
		objectiveAssocs.add("/objective/" + getNextID());

		objectiveNames.add("Identify Items");
		objectiveDescriptions.add("Can identify items");
		objectiveAssocs.add("/objective/" + getNextID());

		objectiveNames.add("Pointer Arithmetic");
		objectiveDescriptions.add("Can use C Arrays");
		objectiveAssocs.add("/objective/" + getNextID());

		objectiveNames.add("Writing Requirements");
		objectiveDescriptions.add("Can write well defined requirements");
		objectiveAssocs.add("/objective/" + getNextID());

		objectiveNames.add("Lambda Functions");
		objectiveDescriptions.add("Knows when to use lambda functions");
		objectiveAssocs.add("/objective/" + getNextID());

		categoryNames.add("Communication Skills");
		categoryAssocs.add("/category/" + getNextID());

		categoryNames.add("Technical Skills");
		categoryAssocs.add("/category/" + getNextID());

		for (int n = 0; n < objectiveNames.size(); n++) {
			postObjective(n);
		}

		for (int n = 0; n < categoryNames.size(); n++) {
			postCategory(n);
		}

		associateCategoryObjective(0, 0);
		associateCategoryObjective(0, 3);

		associateCategoryObjective(1, 1);
		associateCategoryObjective(1, 2);
		associateCategoryObjective(1, 4);

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

		associateProgramAcademicYear(1, 2);

		testProgramAcademicYear(1, 2);
	}

	@Test
	public void calendarYearCourseTest() throws Exception {
		courseNames = new ArrayList<String>();
		courseAssocs = new ArrayList<String>();

		calendarYearYears = new ArrayList<>();
		calendarYearAssocs = new ArrayList<>();

		courseNames.add("Magic 101");
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Software Engineering 101");
		courseAssocs.add("/course/" + getNextID());

		courseNames.add("Software Engineering 101");
		courseAssocs.add("/course/" + getNextID());

		calendarYearYears.add(2015);
		calendarYearAssocs.add("/calendaryear/" + getNextID());

		calendarYearYears.add(2016);
		calendarYearAssocs.add("/calendaryear/" + getNextID());

		calendarYearYears.add(2017);
		calendarYearAssocs.add("/calendaryear/" + getNextID());

		for (int n = 0; n < courseNames.size(); n++) {
			postCourse(n);
		}

		for (int n = 0; n < calendarYearYears.size(); n++) {
			postCalendarYear(n);
		}

		associateCourseCalendarYear(0, 0);
		associateCourseCalendarYear(0, 1);
		associateCourseCalendarYear(0, 2);

		associateCourseCalendarYear(1, 0);
		associateCourseCalendarYear(1, 1);

		associateCourseCalendarYear(2, 2);

		testCourseCalendarYear(0, 0);
		testCourseCalendarYear(0, 1);
		testCourseCalendarYear(0, 2);

		testCourseCalendarYear(1, 0);
		testCourseCalendarYear(1, 1);
		testCourseCalendarYear(2, 2);
	}

	@Test
	public void calendarYearProgramTest() throws Exception {
		programNames = new ArrayList<String>();
		programAssocs = new ArrayList<String>();

		calendarYearYears = new ArrayList<>();
		calendarYearAssocs = new ArrayList<>();

		programNames.add("Applied Magic");
		programAssocs.add("/program/" + getNextID());

		programNames.add("Software Engineering");
		programAssocs.add("/program/" + getNextID());

		programNames.add("Software Engineering");
		programAssocs.add("/program/" + getNextID());

		calendarYearYears.add(2015);
		calendarYearAssocs.add("/calendaryear/" + getNextID());

		calendarYearYears.add(2016);
		calendarYearAssocs.add("/calendaryear/" + getNextID());

		calendarYearYears.add(2017);
		calendarYearAssocs.add("/calendaryear/" + getNextID());

		for (int n = 0; n < programNames.size(); n++) {
			postProgram(n);
		}

		for (int n = 0; n < calendarYearYears.size(); n++) {
			postCalendarYear(n);
		}

		associateProgramCalendarYear(0, 0);
		associateProgramCalendarYear(0, 1);
		associateProgramCalendarYear(0, 2);

		associateProgramCalendarYear(1, 0);
		associateProgramCalendarYear(1, 1);

		associateProgramCalendarYear(2, 2);

		testProgramCalendarYear(0, 0);
		testProgramCalendarYear(0, 1);
		testProgramCalendarYear(0, 2);

		testProgramCalendarYear(1, 0);
		testProgramCalendarYear(1, 1);
		testProgramCalendarYear(2, 2);
	}

	private void postObjective(int objID) throws Exception {
		String retVal = "{";
		retVal += "\"name\" : \"" + objectiveNames.get(objID) + "\",";
		retVal += "\"description\" : \"" + objectiveDescriptions.get(objID) + "\"";
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

	private void postCalendarYear(int calendarYearID) throws Exception {
		String retVal = "{";
		retVal += "\"year\" : " + calendarYearYears.get(calendarYearID);
		retVal += "}";

		this.mockMvc.perform(post("/calendaryear").contentType(MediaType.APPLICATION_JSON_UTF8).content(retVal)).andExpect(status().is2xxSuccessful());
	}

	private void associateCourseObjective(int courseID, int objectiveID) throws Exception {
		this.mockMvc.perform(post(courseAssocs.get(courseID) + "/learningObjectives").contentType("text/uri-list").content(objectiveAssocs.get(objectiveID))).andExpect(status().is2xxSuccessful());
	}

	private void associateCategoryObjective(int categoryID, int objectiveID) throws Exception {
		this.mockMvc.perform(post(categoryAssocs.get(categoryID) + "/learningObjectives").contentType("text/uri-list").content(objectiveAssocs.get(objectiveID))).andExpect(status().is2xxSuccessful());
	}

	private void associateCourseAcademicYear(int courseID, int academicYearID) throws Exception {
		this.mockMvc.perform(post(courseAssocs.get(courseID) +"/academicYears").contentType("text/uri-list").content(academicYearAssocs.get(academicYearID))).andExpect(status().is2xxSuccessful());
	}

	private void associateProgramAcademicYear(int programID, int academicYearID) throws Exception {
		this.mockMvc.perform(put(academicYearAssocs.get(academicYearID) +"/program").contentType("text/uri-list").content(programAssocs.get(programID))).andExpect(status().is2xxSuccessful());
	}

	private void associateCourseCalendarYear(int courseID, int calendarYearID) throws Exception {
		this.mockMvc.perform(post(courseAssocs.get(courseID) +"/calendarYears").contentType("text/uri-list").content(calendarYearAssocs.get(calendarYearID))).andExpect(status().is2xxSuccessful());
	}

	private void associateProgramCalendarYear(int programID, int calendarYearID) throws Exception {
		this.mockMvc.perform(post(programAssocs.get(programID) +"/calendarYears").contentType("text/uri-list").content(calendarYearAssocs.get(calendarYearID))).andExpect(status().is2xxSuccessful());
	}

	private void testCourseObjective(int courseID, int objectiveID) throws Exception {
		String nameTest = "\"name\" : \"" + objectiveNames.get(objectiveID) + "\"";
		String descTest = "\"description\" : \"" + objectiveDescriptions.get(objectiveID) + "\"";

		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/learningObjectives")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/learningObjectives")).andExpect(status().isOk()).andExpect(content().string(containsString(descTest)));
	}

	private void testCategoryObjective(int categoryID, int objectiveID) throws Exception {
		String nameTest = "\"name\" : \"" + objectiveNames.get(objectiveID) + "\"";
		String descTest = "\"description\" : \"" + objectiveDescriptions.get(objectiveID) + "\"";

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

	private void testCourseCalendarYear(int courseID, int calendarYearID) throws Exception {
		String nameTest = "\"year\" : " + calendarYearYears.get(calendarYearID);

		this.mockMvc.perform(get(courseAssocs.get(courseID) +"/calendarYears")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
	}

	private void testProgramCalendarYear(int programID, int calendarYearID) throws Exception {
		String nameTest = "\"year\" : " + calendarYearYears.get(calendarYearID);

		this.mockMvc.perform(get(programAssocs.get(programID) +"/calendarYears")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
	}
}
