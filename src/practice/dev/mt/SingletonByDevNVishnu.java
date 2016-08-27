package practice.dev.mt;

/**
 * 
 * @author dev
 *
Perfect Thread safe and Secure Singleton
 *
 */
public class SingletonByDevNVishnu {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    //instance holder of this singleton class
    private static SingletonByDevNVishnu singleton = MySingleton.INSTANCE;

    //It'll be lazily loaded
    private static class MySingleton {
        private static final SingletonByDevNVishnu INSTANCE = new SingletonByDevNVishnu();
    }

    //To prevent reflection instance creation
    private SingletonByDevNVishnu() {
        if (singleton != null) {
            throw new RuntimeException("Can't instantiate singleton twice");
        }
    }

    public static SingletonByDevNVishnu getInstance() {
        return singleton;
    }

    //To handle Deserialization properly
    protected Object readResolve() {
        return getInstance();
    }
    
    //To prevent Clone of this object
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
} 