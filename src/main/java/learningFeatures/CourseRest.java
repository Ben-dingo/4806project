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
    ProgramRepository programs;

    @Autowired
    CalendarYearRepository CYears;

    @Autowired
    AcademicYearRepository AYears;

    @Autowired
    LearningObjectiveRepository objectives; //setting up the repositories for the controller

    //Courses section\\
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

    //Categories section\\
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

    //Program section\\
    @GetMapping("/newProg")//adds a new program to the repository, starts out empty
    public String newProgram(@RequestParam(name="id") String id) {
        programs.save(new Program(id));
        return "Success";
    }

    @GetMapping("/delProg")//removes a program
    public String delProgram(@RequestParam(name="id") String id) {
        for (Program program: programs.findAll()) {
            if (program.getName().equals(id)) {
                programs.delete(program);
                return "Success";
            }
        }
        return "Failure";
    }

    @GetMapping("/addProgCalender")//adds a Calendar year to a program
    public String addProgCalender(@RequestParam(name="id") String id, @RequestParam(name="name") Long name) {

        for (Program program: programs.findAll()) {
            if(program.getName().equals(id)) {
                Program found = program;
                programs.delete(program);//program has to be removed from the repository and re-added for the changes to persist. I'm not sure why
                if(CYears.findById(name).isPresent())
                {
                    CalendarYear calendar = CYears.findById(name).get();
                    found.addCalendarYear(calendar);
                    programs.save(found);
                    return "Success" + found.toString();
                }
                else
                {
                    programs.save(found);
                    return "Failure";
                }
            }
        }
        return "Failure";
    }

    @GetMapping("/addProgAcademic")//adds an academic year to a program
    public String addProgAcademic(@RequestParam(name="id") String id, @RequestParam(name="name") Long name) {

        for (Program program: programs.findAll()) {
            if(program.getName().equals(id)) {
                Program found = program;
                programs.delete(program);//program has to be removed from the repository and re-added for the changes to persist. I'm not sure why
                if(AYears.findById(name).isPresent())
                {
                    AcademicYear academic = AYears.findById(name).get();
                    found.addAcademicYear(academic);
                    programs.save(found);
                    return "Success" + found.toString();
                }
                else
                {
                    programs.save(found);
                    return "Failure";
                }
            }
        }
        return "Failure";
    }

    @GetMapping("/viewProg")//prints the name and contents of a specific program
    public String viewProg(@RequestParam(name="id") String id) {
        for (Program program: programs.findAll()) {
            if(program.getName().equals(id)) {
                return program.toString();
            }
        }
        return "Nothing";
    }

    @GetMapping("/viewProgs")//prints all programs, will get messy in larger repositories
    public String viewProgs() {
        String returning = "";
        for (Program program: programs.findAll()) {
            returning += program.toString() + " ";
        }
        return returning;
    }

    @GetMapping("/viewProgNames")//gets a string of all program names, used for the search dropdown menu later
    public String viewProgNames() {
        String returning = "";
        for (Program program: programs.findAll()) {
            returning += program.getName() + ",";
        }
        return returning;
    }

    //Learning Objective section\\
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
