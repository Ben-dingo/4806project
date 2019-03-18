package learningFeatures;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AcademicYear {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	@ManyToMany(mappedBy= "academicYears")
	protected List<Course> courses;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="program_id")
	private Program program;

	public AcademicYear() {
		this("new");
	}

	public AcademicYear(String name) {
		this.name = name;
		this.program = null;
		courses = new ArrayList<Course>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addCourse(Course course, boolean b) {
		courses.add(course);
		if (b) {
			course.addAcademicYear(this, false);
		}
	}

	public void addCourse(Course course) {
		addCourse(course, true);
	}

	public void removeCourse(Course course, boolean b) {
		courses.remove(course);
		if (b) {
			course.removeAcademicYear(this, false);
		}
	}

	public void removeCourse(Course course) {
		removeCourse(course, true);
	}

	public void setProgram(Program program, boolean b) {
		if (this.program != null) {
			this.program.removeAcademicYear(this, false);
		}
		this.program = program;
		if (b && this.program != null) {
			program.addAcademicYear(this, false);
		}
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		setProgram(program, true);
	}
}
