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
	protected List<LearningObjective> entries;

	public Category() {
		this("new");
	}

	public Category(String name) {
		this.name = name;
		entries = new ArrayList<LearningObjective>();
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

	public String toString()
	{
		String returning = name + " (";
		for(LearningObjective objectives : entries){
			returning += objectives.toString() + ", ";
		}
		returning = returning.substring(0, returning.length()-2);
		returning += ")";
		return returning;
	}
}
