package bookFeatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {

	@Autowired
	BookRepository repo;

	@GetMapping("/")
	public String addressBook(@RequestParam(name="bookID") String bookID, Model model) {
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

	@GetMapping("/")
	public String homePage(Model model) {
		return "homePage";
	}
}
