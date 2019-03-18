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

	@ManyToMany(mappedBy="entries")
	private List<Category> categories;

	public LearningObjective() {
		this("new", "new");
	}

	public LearningObjective(String name, String description) {
		this.name =  name;
		this.description = description;
		this.courses = new ArrayList<Course>();
		this.categories = new ArrayList<Category>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourse(List<Course> courses) {
		this.courses = courses;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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

	public String toString(){
		String returning = name + ": " + description;
		return returning;
	}
}
