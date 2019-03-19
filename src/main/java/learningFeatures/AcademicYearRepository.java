package learningFeatures;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "academicyear", path = "academicyear")
public interface AcademicYearRepository extends PagingAndSortingRepository<AcademicYear, Long> {
}