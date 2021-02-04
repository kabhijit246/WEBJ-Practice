package webj;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@interface Marker{}                  // Since it has no methods therefore this annotation is called Marker annotation.

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface SingleValue              // Since it has 1 method therefore this annotation is called Single-Value annotation.
{
	int monthlySalary();
}

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MultiValue              // Since it has more than 1 methods so this is called Multi-Value annotation.
{
	int id();
	String name();
	int age();
}

@MultiValue(age = 24, id = 101, name = "Mark Taylor")
class Employee
{
	@Marker
	@SingleValue(monthlySalary = 50000)
	public void annualSalary()
	{  
		System.out.println("Annual salary calculated");
	}
}

class Address extends Employee  //in this subclass 'Address' of superclass 'Employee', MultiValue annotation is inherited from superclass
{
	@Marker   
	public void address()
	{
		System.out.printf("Address: %s\n", "Bangalore");
	}
}

public class Annotations 
{
	@SuppressWarnings({"rawtypes", "unchecked" })     //Built-in annotation which suppress the warning given by compiler
	public static void main(String args[]) throws Exception
	{
		//accessing multi-value annotation with the help of built-in annotations(retention, target)
		Employee e = new Employee();
		Class c = e.getClass();
		MultiValue employee = (MultiValue)c.getAnnotation(MultiValue.class);
		System.out.println("Id: " + employee.id());
		System.out.println("Name: " + employee.name());
		System.out.println("Age: " + employee.age());
		
		//accessing single-value annotation with the help of built-in annotations(target, retention)
		Method m = e.getClass().getMethod("annualSalary");
		SingleValue salary = m.getAnnotation(SingleValue.class);
		e.annualSalary();
		System.out.println("Annual Salary: " + salary.monthlySalary()*12);
		
		//accessing multi-value annotation with the help of built-in annotations(target, retention and inherited)
		Address add = new Address();
		Class cl = add.getClass();
		MultiValue emp = (MultiValue)cl.getAnnotation(MultiValue.class);
		System.out.println("Id: " + emp.id());
		System.out.println("Name: " + emp.name());
		System.out.println("Age: " + emp.age());
		add.address();
	}
}
