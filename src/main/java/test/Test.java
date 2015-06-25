package test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<A, String> map = new LinkedHashMap<A, String>();
		
		A a0 = new A(0);
		A a1 = new A(1);
		A a2 = new A(2);
		A a3 = new A(3);
		A a4 = new A(4);
		
		map.put(a0, "0");
		map.put(a1, "1");
		map.put(a2, "2");
		map.put(a3, "3");
		map.put(a4, "4");
		
		
	}
}
class A {
	int i;

	public A(int i) {
		this.i = i;
	}

	@Override
	public int hashCode() {
		return i%3;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (i != other.i)
			return false;
		return true;
	}
	
	
}
