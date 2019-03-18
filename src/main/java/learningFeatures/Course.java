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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_academicYear",
			joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "academicYear_id", referencedColumnName = "id"))
	protected List<learningFeatures.AcademicYear> academicYears;


	public Course() {
		this("new");
	}

	public Course(String name) {
		this.name = name;
		learningObjectives = new ArrayList<learningFeatures.LearningObjective>();
	}

	public void removeObjective(LearningObjective obj, boolean b) {
		learningObjectives.remove(obj);
		if (b) {
			obj.removeCourse(this, false);
		}
	}

	public void removeObjective(LearningObjective obj) {
		removeObjective(obj, true);
	}

	public void addObjective(LearningObjective obj, boolean b) {
		learningObjectives.add(obj);
		if (b) {
			obj.addCourse(this, false);
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

	@Deprecated
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