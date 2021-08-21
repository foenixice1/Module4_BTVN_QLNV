package formatter;


import model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import service.IBranchService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class BranchFormatter implements Formatter<Branch> {
    private IBranchService iBranchService;

    @Autowired
    public BranchFormatter(IBranchService branchService) {
        this.iBranchService = branchService;
    }

    @Override
    public Branch parse(String text, Locale locale) throws ParseException {
        Optional<Branch> branchOptional = iBranchService.findById(Integer.parseInt(text));
        return branchOptional.orElse(null);
    }

    @Override
    public String print(Branch object, Locale locale) {
        return "[" + object.getId() + "," + object.getName() + "]";
    }
}
