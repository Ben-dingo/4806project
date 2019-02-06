package bookFeatures;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
	List<String> names;
	List<String> phones;
	List<String> assocs;

	@Test
	public void addBooksAndCheck() throws Exception {
		names = new ArrayList<String>();
		phones = new ArrayList<String>();
		assocs = new ArrayList<String>();

		names.add("Steve");
		phones.add("Is Cat");
		assocs.add("/buddy/1");

		names.add("Captain Cool");
		phones.add("888-8888");
		assocs.add("/buddy/2");

		names.add("Cutthroat");
		phones.add("Phone Booth, West 8th Street");
		assocs.add("/buddy/3");

		String defaultBook = "{}";

		for (int n = 0; n < names.size(); n++) {
			makeTestInfo(n);
		}

		this.mockMvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON_UTF8).content(defaultBook)).andExpect(status().is2xxSuccessful());
		this.mockMvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON_UTF8).content(defaultBook)).andExpect(status().is2xxSuccessful());

		associateBuddyBook(4, 0);
		associateBuddyBook(4, 1);

		associateBuddyBook(5, 0);
		associateBuddyBook(5, 2);

		getTestInfo(4, 0);
		getTestInfo(5, 0);
		getTestInfo(4, 1);
		getTestInfo(5, 2);
	}

	private void makeTestInfo(int buddyId) throws Exception {
		String retVal = "{";
		retVal += "\"name\" : \"" + names.get(buddyId) + "\",";
		retVal += "\"phone\" : \"" + phones.get(buddyId) + "\"";
		retVal += "}";

		this.mockMvc.perform(post("/buddy").contentType(MediaType.APPLICATION_JSON_UTF8).content(retVal)).andExpect(status().is2xxSuccessful());
	}

	private void associateBuddyBook(int bookId, int buddyId) throws Exception {
		this.mockMvc.perform(post("/book/" + bookId + "/entries").contentType("text/uri-list").content(assocs.get(buddyId))).andExpect(status().is2xxSuccessful());
	}

	private void getTestInfo(int bookId, int buddyId) throws Exception {
		String nameTest = "\"name\" : \"" + names.get(buddyId) + "\"";
		String phoneTest = "\"phone\" : \"" + phones.get(buddyId) + "\"";

		this.mockMvc.perform(get("/book/"+ bookId +"/entries")).andExpect(status().isOk()).andExpect(content().string(containsString(nameTest)));
		this.mockMvc.perform(get("/book/"+ bookId +"/entries")).andExpect(status().isOk()).andExpect(content().string(containsString(phoneTest)));
	}
}
