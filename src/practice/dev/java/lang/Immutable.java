package practice.dev.java.lang;

import java.lang.reflect.Field;

public class Immutable {
	
	// This field is a constant, and cannot be changed using Reflection
	private final int value = Integer.MIN_VALUE;

	/*public Immutable(int value) {
        this.value = value;
    }*/
	
	/*{
		this.value = Integer.MIN_VALUE;
	}*/
	
	public int getValue() {
		return value;
	}

	public static void main(String[] args) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		
		//final Immutable immutable = new Immutable(Integer.MIN_VALUE);
		final Immutable immutable = new Immutable();

		final Field f = Immutable.class.getDeclaredField("value");
		f.setAccessible(true);

		System.out.println(immutable.getValue());
		f.set(immutable, Integer.MAX_VALUE);
		System.out.println(immutable.getValue());
	}

}
