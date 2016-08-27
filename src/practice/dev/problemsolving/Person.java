package practice.dev.problemsolving;

public class Person {
	  String name;

	    public Person(String personName) {
	            name = personName;
	    }

	    public String greet(String yourName) {
	    	System.out.println("Greeting... ");
	            return String.format("Hi %s, my name is %s", name, yourName);
	    }
	    
	    public static void main(String[] args) {
	    	Person p = new Person("Dev");
	    	System.out.println(p.greet("Dharm"));
	    }
	}
 