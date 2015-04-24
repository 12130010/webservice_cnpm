package test;

public class Test {
	public static void main(String[] args) {
		String s = "ab%sde%s";
		System.out.println(String.format(s, "c","f"));
	}
}
