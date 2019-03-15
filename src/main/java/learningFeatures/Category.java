package learningFeatures;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "category_objective",
			joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "obj_id", referencedColumnName = "id"))
	protected List<LearningObjective> learningObjectives;

	public Category() {
		this("new");
	}

	public Category(String name) {
		this.name = name;
		learningObjectives = new ArrayList<LearningObjective>();
	}

	public void removeObjective(LearningObjective obj) {
		learningObjectives.remove(obj);
	}

	public void addObjective(LearningObjective obj) {
		learningObjectives.add(obj);
	}

	public List<LearningObjective> getLearningObjectives() {
		return learningObjectives;
	}

	public void setLearningObjectives(List<LearningObjective> entries) {
		this.learningObjectives = entries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
