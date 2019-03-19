package learningFeatures;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Program {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	@OneToMany(mappedBy = "program")
	protected List<AcademicYear> academicYears;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "program_calendarYear",
			joinColumns = @JoinColumn(name = "program_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "calendarYear_id", referencedColumnName = "id"))
	protected List<CalendarYear> calendarYears;

	public Program() {
		this("new");
	}

	public Program(String name) {
		this.name = name;
		academicYears = new ArrayList<>();
		calendarYears = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addAcademicYear(AcademicYear year, boolean b) {
		academicYears.add(year);
		if (b) {
			year.setProgram(this, false);
		}
	}

	public void addAcademicYear(AcademicYear year) {
		addAcademicYear(year, true);
	}

	public void removeAcademicYear(AcademicYear year, boolean b) {
		academicYears.remove(year);
		if (b) {
			year.setProgram(null, false);
		}
	}

	public void removeAcademicYear(AcademicYear year) {
		removeAcademicYear(year, true);
	}

	public void removeCalendarYear(CalendarYear calendarYear, boolean b) {
		calendarYears.remove(calendarYear);
		if (b) {
			calendarYear.removeProgram(this, false);
		}
	}

	public void removeCalendarYear(CalendarYear calendarYear) {
		removeCalendarYear(calendarYear, true);
	}

	public void addCalendarYear(CalendarYear calendarYear, boolean b) {
		calendarYears.add(calendarYear);
		if (b) {
			calendarYear.addProgram(this, false);
		}
	}

	public void addCalendarYear(CalendarYear calendarYear) {
		addCalendarYear(calendarYear, true);
	}

}
