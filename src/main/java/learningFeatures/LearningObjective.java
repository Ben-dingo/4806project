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

	@ManyToMany(mappedBy= "learningObjectives")
	protected List<Course> courses;

	@ManyToMany(mappedBy= "learningObjectives")
	protected List<Category> categories;

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

	@Deprecated
	public String toString(){
		String returning = name + ": " + description;
		return returning;
	}

	public void addCourse(Course course, boolean b) {
		courses.add(course);
		if (b) {
			course.addObjective(this, false);
		}
	}

	public void addCourse(Course course) {
		addCourse(course, true);
	}

	public void removeCourse(Course course, boolean b) {
		courses.remove(course);
		if (b) {
			course.removeObjective(this, false);
		}
	}

	public void removeCourse(Course course) {
		removeCourse(course, true);
	}

	public void addCategory(Category category, boolean b) {
		categories.add(category);
		if (b) {
			category.addObjective(this, false);
		}
	}

	public void addCategory(Category category) {
		addCategory(category, true);
	}

	public void removeCategory(Category category, boolean b) {
		categories.remove(category);
		if (b) {
			category.removeObjective(this, false);
		}
	}

	public void removeCategory(Category category) {
		removeCategory(category, true);
	}

}
