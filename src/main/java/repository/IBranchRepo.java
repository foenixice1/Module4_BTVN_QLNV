package repository;

import model.Branch;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBranchRepo extends PagingAndSortingRepository<Branch , Integer> {
}
