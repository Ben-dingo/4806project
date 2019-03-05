package learningFeatures;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_buddy",
			joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "obj_id", referencedColumnName = "id"))
	protected List<learningFeatures.LearningObjective> entries;


	public Course() {
		this("new");
	}

	public Course(String name) {
		this.name = name;
		entries = new ArrayList<learningFeatures.LearningObjective>();
	}

	public void removeObjective(LearningObjective obj) {
		entries.remove(obj);
	}

	public void addObjective(LearningObjective obj) {
		entries.add(obj);
	}

	public List<LearningObjective> getEntries() {
		return entries;
	}

	public void setEntries(List<LearningObjective> entries) {
		this.entries = entries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}