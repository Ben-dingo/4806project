package learningFeatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRest {

    @Autowired
    CourseRepository courses;

    @Autowired
    CategoryRepository categories;

    @Autowired
    LearningObjectiveRepository objectives;

    @GetMapping("/newCourse")
    public String newCourse(@RequestParam(name="id") String id) {
        courses.save(new Course(id));
        return "Success";
    }

    @GetMapping("/addCourseOutcome")
    public String addCourseOutcome(@RequestParam(name="id") String id, @RequestParam(name="name") String name) {

        for (Course courses: courses.findAll()) {
            if(courses.getName().equals(id)) {
                for (LearningObjective objectives: objectives.findByName(name)) {
                    courses.addObjective(objectives);
                    return "Success";
                }
            }
        }
        return "Failure";
    }

    @GetMapping("/viewCourse")
    public String viewCourse(@RequestParam(name="id") String id) {
        for (Course courses : courses.findAll()) {
            if(courses.getName().equals(id)) {
                return courses.toString();
            }
        }
        return "Nothing";
    }

    @GetMapping("/viewCourses")
    public String viewCourse() {
        String returning = "";
        for (Course courses : courses.findAll()) {
                returning += courses.toString() + " ";
        }
        return returning;
    }

    @GetMapping("/newCat")
    public String newCategory(@RequestParam(name="id") String id) {
        categories.save(new Category(id));
        return "Success";
    }

    @GetMapping("/addCatOutcome")
    public String addCatOutcome(@RequestParam(name="id") String id, @RequestParam(name="name") String name) {

        for (Category categories: categories.findAll()) {
            if(categories.getName().equals(id)) {
                for (LearningObjective objectives: objectives.findByName(name)) {
                    categories.addObjective(objectives);
                    return "Success";
                }
            }
        }
        return "Failure";
    }

    @GetMapping("/viewCat")
    public String viewCat(@RequestParam(name="id") String id) {
        for (Category categories: categories.findAll()) {
            if(categories.getName().equals(id)) {
                return categories.toString();
            }
        }
        return "Nothing";
    }

    @GetMapping("/viewCats")
    public String viewCats() {
        String returning = "";
        for (Category categories: categories.findAll()) {
            returning += categories.toString() + " ";
        }
        return returning;
    }


    @GetMapping("/newObjective")
    public String newObjective(@RequestParam(name="id") String name, @RequestParam(name="name") String desc) {
        objectives.save(new LearningObjective(name,desc));
        return "Success";
    }

    @GetMapping("/viewObjective")
    public String viewObjective(@RequestParam(name="id") String id) {
        for (LearningObjective objectives: objectives.findAll()) {
            if(objectives.getName().equals(id)) {
                return objectives.toString();
            }
        }
        return "Nothing";
    }

    @GetMapping("/viewObjectives")
    public String viewObjectives() {
        String returning = "";
        for (LearningObjective objectives: objectives.findAll()) {
            returning += objectives.toString() + " ";
        }
        return returning;
    }

}
