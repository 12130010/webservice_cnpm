package test;

public class Test {
	public static void main(String[] args) {
		String message = "fadsfsa+123:fbaskjbc";
		long idacc = Long.parseLong(message.substring(message.indexOf('+')+1, message.indexOf(':')));
		message = message.substring(message.indexOf(':')+1);
		System.out.println(idacc);
		System.out.println(message);
	}
}
