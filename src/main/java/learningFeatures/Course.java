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
	@JoinTable(name = "course_objective",
			joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "obj_id", referencedColumnName = "id"))
	protected List<learningFeatures.LearningObjective> learningObjectives;


	public Course() {
		this("new");
	}

	public Course(String name) {
		this.name = name;
		learningObjectives = new ArrayList<learningFeatures.LearningObjective>();
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

	public String toString()
	{
		String returning = name + " (";
		for(LearningObjective objectives : learningObjectives){
			returning += objectives.toString() + ", ";
		}
		returning = returning.substring(0, returning.length()-2);
		returning += ")";
		return returning;
	}
}