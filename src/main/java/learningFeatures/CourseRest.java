package learningFeatures;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CourseRest {

    private ArrayList<Course> courses = new ArrayList<Course>();

    @GetMapping("/newCourse")
    public String newCourse(@RequestParam(name="id") String id) {
        courses.add(new Course(id));
        return "Success";
    }

    @GetMapping("/newOutcome")
    public String newOutcome(@RequestParam(name="id") String id, @RequestParam(name="name") String name, @RequestParam(name="desc") String desc) {

        for (Course courses: courses) {
            if(courses.getName().equals(id)) {
                LearningObjective newLearn = new LearningObjective(name,desc);
                courses.addObjective(newLearn);
                return "Success";
            }
        }
        return "Failure";
    }

    @GetMapping("/viewCourse")
    public String viewCourse(@RequestParam(name="id") String id) {
        for (Course courses : courses) {
            if(courses.getName().equals(id)) {
                return courses.toString();
            }
        }
        return "Nothing";
    }

    @GetMapping("/viewCourses")
    public String viewCourse() {
        String returning = "";
        for (Course courses : courses) {
                returning += courses.toString() + " ";
        }
        return returning;
    }

}
