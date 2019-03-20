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
			joinColumns = @JoinColumn(name = "cat_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "obj_id", referencedColumnName = "id"))
	protected List<LearningObjective> learningObjectives;

	public Category() {
		this("new");
	}

	public Category(String name) {
		this.name = name;
		learningObjectives = new ArrayList<LearningObjective>();
	}

	public void removeObjective(LearningObjective obj, boolean b) {
		learningObjectives.remove(obj);
		if (b) {
			obj.removeCategory(this, false);
		}
	}

	public void removeObjective(LearningObjective obj) {
		removeObjective(obj, true);
	}

	public void addObjective(LearningObjective obj, boolean b) {
		learningObjectives.add(obj);
		if (b) {
			obj.addCategory(this, false);
		}
	}

	public void addObjective(LearningObjective obj) {
		addObjective(obj, true);
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
