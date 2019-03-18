package learningFeatures;

import javax.persistence.*;
import java.util.List;

@Entity
public class Program {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	@OneToMany(mappedBy = "program")
	protected List<AcademicYear> academicYears;
}
