package learningFeatures;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "calendaryear", path = "calendaryear")
public interface CalendarYearRepository extends PagingAndSortingRepository<CalendarYear, Long> {
}
