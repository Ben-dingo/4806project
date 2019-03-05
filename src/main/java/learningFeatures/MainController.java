package learningFeatures;

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
	LearningObjectiveRepository repo;

	@GetMapping("/")
	public String home(Model model) {
		return "homePage";
	}

}
