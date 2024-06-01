public interface Department {
    void printDepartmentName();
}


public class FinancialDepartment implements Department {
    // Implementation details (e.g., id, name)
    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}

public class SalesDepartment implements Department {
    // Implementation details (e.g., id, name)
    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}


public class HeadDepartment implements Department {
    private Integer id;
    private String name;
    private List<Department> childDepartments;

    public HeadDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.childDepartments = new ArrayList<>();
    }

    public void printDepartmentName() {
        childDepartments.forEach(Department::printDepartmentName);
    }

    public void addDepartment(Department department) {
        childDepartments.add(department);
    }

    public void removeDepartment(Department department) {
        childDepartments.remove(department);
    }
}


public class Composite{
    public static void main(String[] args) {
        // Create leaf departments
        Department finance = new FinancialDepartment();
        Department sales = new SalesDepartment();

        // Create a composite (head) department
        Department head = new HeadDepartment(1, "Head Office");
        head.addDepartment(finance);
        head.addDepartment(sales);

        // Print department names
        head.printDepartmentName();
    }
}
