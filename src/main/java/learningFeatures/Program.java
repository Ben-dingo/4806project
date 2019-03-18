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

	@OneToMany(mappedBy = "program")
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

	public void addCalendarYear(CalendarYear year, boolean b) {
		calendarYears.add(year);
		if (b) {
			year.setProgram(this, false);
		}
	}

	public void addCalendarYear(CalendarYear year) {
		addCalendarYear(year, true);
	}

	public void removeCalendarYear(CalendarYear year, boolean b) {
		calendarYears.remove(year);
		if (b) {
			year.setProgram(null, false);
		}
	}

	public void removeCalendarYear(CalendarYear year) {
		removeCalendarYear(year, true);
	}
}
