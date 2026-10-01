package exercises.exercise2.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/** Treats employees and departments through one organization component. */
public final class CompositeDemo {

    private CompositeDemo() {
    }

    public static void run() {
        Department engineering = new Department("Engineering");
        engineering.add(new Employee("Ada", 5000));
        engineering.add(new Employee("Grace", 4500));
        Department sales = new Department("Sales");
        sales.add(new Employee("Linus", 4000));

        Department headOffice = new Department("Head Office");
        headOffice.add(engineering);
        headOffice.add(sales);
        headOffice.showDetails("");
        System.out.println("Total salary: " + headOffice.getSalary());
    }

    private interface EmployeeComponent {
        String getName();
        double getSalary();
        void add(EmployeeComponent component);
        void remove(EmployeeComponent component);
        void showDetails(String indentation);
    }

    private record Employee(String getName, double getSalary) implements EmployeeComponent {
        public void add(EmployeeComponent component) { throw new UnsupportedOperationException("Employee has no reports"); }
        public void remove(EmployeeComponent component) { throw new UnsupportedOperationException("Employee has no reports"); }
        public void showDetails(String indentation) {
            System.out.println(indentation + "Employee: " + getName + ", salary: " + getSalary);
        }
    }

    private static final class Department implements EmployeeComponent {
        private final String name;
        private final List<EmployeeComponent> members = new ArrayList<>();

        private Department(String name) { this.name = name; }
        public String getName() { return name; }
        public double getSalary() { return members.stream().mapToDouble(EmployeeComponent::getSalary).sum(); }
        public void add(EmployeeComponent component) { members.add(component); }
        public void remove(EmployeeComponent component) { members.remove(component); }
        public void showDetails(String indentation) {
            System.out.println(indentation + "Department: " + name);
            members.forEach(member -> member.showDetails(indentation + "  "));
        }
    }
}
