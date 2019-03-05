package learningFeatures;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LearningObjective {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;

	@ManyToMany(mappedBy="entries")
	private List<Course> courses;

	public LearningObjective() {
		this("new", "new");
	}

	public LearningObjective(String name, String description) {
		this.name =  name;
		this.description = description;
		this.courses = new ArrayList<Course>();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourse(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof LearningObjective)) {
			return false;
		}

		LearningObjective obj =  (LearningObjective)o;

		return (obj.hashCode() == hashCode());
	}

	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}
}
