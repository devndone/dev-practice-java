package practice.dev.designpatterns.singleton.alternativetodcl;

//Class that generates the Singleton instance of the required class, here, Util class
public class SingletonWithFinalWrapper {
	
	private FinalWrapper<Util> finalWrapper; 
	
	public Util getInstance() {
		
		//The local wrapper var is required for correctness
		FinalWrapper<Util> wrapper = finalWrapper;
		
		if(wrapper == null) {
			synchronized (this) {
				if(finalWrapper == null) {
					finalWrapper = new FinalWrapper<Util>(new Util());
				}
				wrapper = finalWrapper;
			}
		}
		
		return wrapper.value;
	}//End of getInstance function
	
}

//Class which wraps the Singleton class we want to generate Singleton instance of
class FinalWrapper<T> {
	public final T value;
	public FinalWrapper(T v) {
		this.value = v;
	}
}

//Class for which we want to generate Singleton instance
class Util {
	Util() {
		
	}
}
