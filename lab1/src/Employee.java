public class Employee extends Person {
    // An Employee IS A Person. It contains all of the data from Person, but a
    // little bit more.
    private long salary;

    /* YOUR CODE HERE 
     * It would make sense to record the company that this person
     * works for as well. Under this comment, declare a new String field called
     * "employer", and update the constructor below so that we can set it when
     * we construct a new Employee object.
     *
     * Make your new employer parameter the LAST parameter in the constructor.
     */
    private String employer;

    public Employee(String name, int age, long salary, String employer) {
        super(name, age);
        this.salary = salary;
        this.employer = employer;
        /* ... more code here! */
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
    
    // Getters and setters for the new "employer" field.
    public String getEmployer() {
        return this.employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }
   
    /* YOUR CODE HERE
     * Create a new toString that prints in the following format:
     * "<name> is <age> years old. They make $<salary> a year at <employer>"
     * Try to use super.toString().
     */
    public String toString() {
    	super.toString();
    	return getName() + " " + getAge() + " years old. They make " + getSalary() + " a year at " + getEmployer(); 
    }

    public static void main(String[] args) {
        Employee e = new Employee("Samir", 28, 120000, "Initech");
        System.out.println(e.toString());
    }
}
