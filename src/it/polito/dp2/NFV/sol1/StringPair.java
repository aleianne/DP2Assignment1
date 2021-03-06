package it.polito.dp2.NFV.sol1;

import java.util.Objects;

// this class is used to create an object with two keys for the hashmap lookup
public class StringPair{
	
	private String key1;
	private String key2;
	
	public StringPair(String key1,String key2) {
		this.key1 = key1;
		this.key2 = key2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StringPair that = (StringPair) o;
		return Objects.equals(key1, that.key1) &&
				Objects.equals(key2, that.key2);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key1, key2);
	}

	/*@Override
	public int hashCode() {								// for the hashcode generation is used the concatenation of the two keys and then the hashcode on the result
		String cat = key1.concat(key2);			
		return cat.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {					// return true only if the two keys are equal					
		StringPair pair2 = (StringPair) obj;
		
		if (pair2.key1.equals(this.key1) && pair2.key2.equals(this.key2))  return true;
		
		return false;
	}*/
}
