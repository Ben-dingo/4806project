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
	private int year;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_objective",
			joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "obj_id", referencedColumnName = "id"))
	protected List<learningFeatures.LearningObjective> entries;


	public Course() {
		this("new", 0);
	}

	public Course(String name, int year) {
		this.name = name;
		this.year = year;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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