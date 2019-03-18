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
	private List<Course> courses;

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
}
