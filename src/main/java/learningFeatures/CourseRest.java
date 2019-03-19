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
    LearningObjectiveRepository objectives; //setting up the repositories for the controller

    @GetMapping("/newCourse")//adds a new course to the repository, starts out empty
    public String newCourse(@RequestParam(name="id") String id) {
        courses.save(new Course(id));
        return "Success";
    }

    @GetMapping("/addCourseOutcome")//adds a learning outcome to a course
    public String addCourseOutcome(@RequestParam(name="id") String id, @RequestParam(name="name") String name) {

        for (Course course: courses.findAll()) {
            if(course.getName().equals(id)) {
                Course found = course;
                courses.delete(course);//course has to be removed from the repository and re-added for the changes to persist. I'm not sure why
                for (LearningObjective objectives: objectives.findByName(name)) {
                    found.addObjective(objectives);
                    courses.save(found);
                    return "Success: " + found.toString(); //prints the updated course, mostly for bug testing
                }
            }
        }
        return "Failure";
    }

    @GetMapping("/viewCourse")//prints the name and contents of a specific course
    public String viewCourse(@RequestParam(name="id") String id) {
        for (Course courses : courses.findAll()) {
            if(courses.getName().equals(id)) {
                return courses.toString();
            }
        }
        return "Nothing";
    }

    @GetMapping("/viewCourses")//prints all courses, will get messy in larger repositories
    public String viewCourses() {
        String returning = "";
        for (Course courses : courses.findAll()) {
                returning += courses.toString() + " ";
        }
        return returning;
    }

    @GetMapping("/viewCourseNames")//gets a string of all course names, used for the search dropdown menu later
    public String viewCourseNames() {
        String returning = "";
        for (Course courses : courses.findAll()) {
            returning += courses.getName() + ",";
        }
        return returning;
    }

    @GetMapping("/newCat")//adds a new category to the repository, starts out empty
    public String newCategory(@RequestParam(name="id") String id) {
        categories.save(new Category(id));
        return "Success";
    }

    @GetMapping("/addCatOutcome")//adds a learning outcome to a category
    public String addCatOutcome(@RequestParam(name="id") String id, @RequestParam(name="name") String name) {

        for (Category category: categories.findAll()) {
            if(category.getName().equals(id)) {
                Category found = category;
                categories.delete(category);//category has to be removed from the repository and re-added for the changes to persist. I'm not sure why
                for (LearningObjective objectives: objectives.findByName(name)) {
                    found.addObjective(objectives);
                    categories.save(found);
                    return "Success" + found.toString();
                }
            }
        }
        return "Failure";
    }

    @GetMapping("/viewCat")//prints the name and contents of a specific category
    public String viewCat(@RequestParam(name="id") String id) {
        for (Category categories: categories.findAll()) {
            if(categories.getName().equals(id)) {
                return categories.toString();
            }
        }
        return "Nothing";
    }

    @GetMapping("/viewCats")//prints all categories, will get messy in larger repositories
    public String viewCats() {
        String returning = "";
        for (Category categories: categories.findAll()) {
            returning += categories.toString() + " ";
        }
        return returning;
    }

    @GetMapping("/viewCatNames")//gets a string of all category names, used for the search dropdown menu later
    public String viewCatNames() {
        String returning = "";
        for (Category cats : categories.findAll()) {
            returning += cats.getName() + ",";
        }
        return returning;
    }

    @GetMapping("/newObjective")//makes a new objective with name and description, not related to courses or categories yet
    public String newObjective(@RequestParam(name="id") String name, @RequestParam(name="name") String desc) {
        objectives.save(new LearningObjective(name,desc));
        return "Success";
    }

    @GetMapping("/viewObjective")//views an objective, searches by name
    public String viewObjective(@RequestParam(name="id") String id) {
        for (LearningObjective objectives: objectives.findAll()) {
            if(objectives.getName().equals(id)) {
                return objectives.toString();
            }
        }
        return "Nothing";
    }

    @GetMapping("/viewObjectiveCourses")//searches for a list of courses that contain this objective
    public String viewObjectiveCourses(@RequestParam(name="id") String id) {
        for (LearningObjective objectives: objectives.findAll()) {
            if(objectives.getName().equals(id)) {
                return objectives.getCourses().toString();
            }
        }
        return "Nothing";
    }

    @GetMapping("/viewObjectives")//views all objectives, it will be messy for larger repositories
    public String viewObjectives() {
        String returning = "";
        for (LearningObjective objectives: objectives.findAll()) {
            returning += objectives.toString() + " ";
        }
        return returning;
    }

    @GetMapping("/viewObjectNames")//gets a string of all course names, used for the search dropdown menu later
    public String viewObjectNames() {
        String returning = "";
        for (LearningObjective objectives : objectives.findAll()) {
            returning += objectives.getName() + ",";
        }
        return returning;
    }

}
