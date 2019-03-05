package bookFeatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@EnableAutoConfiguration
public class MainController {

	@Autowired
	BookRepository repo;

	@GetMapping("/")
	public String home(Model model) {
		return "homePage";
	}

	@GetMapping("/viewBook")
	public String viewBook(@RequestParam(name="bookID", required=false, defaultValue="") String bookID, Model model) {
		if (bookID.equals("")) {
			model.addAttribute("errMess", "No Book ID Found!");
			return "error";
		}

		Long id;
		try {
			id = Long.parseLong(bookID);
		} catch (NumberFormatException e) {
			model.addAttribute("errMess", "Invalid bookID format!");
			return "error";
		}

		Optional<AddressBook> book = repo.findById(id);
		if (book.isPresent()) {
			model.addAttribute("list", book.get().getEntries());
			model.addAttribute("id", id);
			return "addressBook";
		} else {
			model.addAttribute("errMess", bookID + " does not exist.");
			return "error";
		}
	}

	@GetMapping("/addBook")
	public String viewBook(Model model) {
		AddressBook createdBook = new AddressBook();
		repo.save(createdBook);
		model.addAttribute(createdBook.getId());
		return "addressBook";
	}
}
