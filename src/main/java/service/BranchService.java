package service;

import model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IBranchRepo;

import java.util.Optional;

public class BranchService implements IBranchService {

    @Autowired
    private IBranchRepo iBranchRepo;

    @Override
    public Iterable<Branch> findAll() {
        return iBranchRepo.findAll();
    }

    @Override
    public Optional<Branch> findById(Integer id) {
        return iBranchRepo.findById(id);
    }

    @Override
    public void save(Branch branch) {
        iBranchRepo.save(branch);
    }

    @Override
    public void delete(Integer id) {
        iBranchRepo.deleteById(id);
    }
}
