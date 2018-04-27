package resource_handling;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class RHCustomerSessionBean {

	public List<RHName> getCustomerNames() {
        List<RHName> names = new ArrayList<>();

        names.add(new RHName("Penny", "TBBT"));
        names.add(new RHName("Sheldon", "TBBT"));
        names.add(new RHName("Amy", "TBBT"));
        names.add(new RHName("Leonard", "TBBT"));
        names.add(new RHName("Bernadette", "TBBT"));
        names.add(new RHName("Raj", "TBBT"));
        names.add(new RHName("Priya", "TBBT"));
        names.add(new RHName("Howard", "TBBT"));

        return names;
    }
}
