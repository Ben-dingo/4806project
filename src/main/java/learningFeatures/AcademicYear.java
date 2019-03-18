package learningFeatures;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AcademicYear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String academicYear;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "academic_year",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "obj_id", referencedColumnName = "id"))
    protected List<learningFeatures.LearningObjective> entries;

    public AcademicYear() {
        this("newAcademicYear");
    }

    public AcademicYear(String academicYear) {
        this.academicYear = academicYear;
        entries = new ArrayList<>();
    }

    public List<LearningObjective> getEntries() {
        return entries;
    }

    public void setEntries(List<LearningObjective> entries) {
        this.entries = entries;
    }

    public void removeObjective(LearningObjective obj) {
        entries.remove(obj);
    }

    public void addObjective(LearningObjective obj) {
        entries.add(obj);
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }


}
