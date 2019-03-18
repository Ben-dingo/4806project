package learningFeatures;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "academicYear", path = "academicYear")
public interface AcademicYearRepository extends PagingAndSortingRepository<Course, Long> {
}