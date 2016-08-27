package practice.dev.designpatterns.singleton.alternativetodcl;

/* Inner classes are not loaded until and unless they are referenced.
 * This fact can be used to utilize inner classes for lazy initialization
 * 
 * This Singleton Generator class is guaranteed to be correct because of the Initialization guarantees for static fields;
 * if a field is set in a static initializer, it is guaranteed to be made visible, correctly, 
 * to any thread that accesses that class
 */
public class SingletonLazyInitializationWithInnerClass {
	
	private SingletonLazyInitializationWithInnerClass() {
		
	}

	public static SingletonLazyInitializationWithInnerClass getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	private static class LazyHolder {
		private static final SingletonLazyInitializationWithInnerClass INSTANCE = new SingletonLazyInitializationWithInnerClass();
	}
	
}
