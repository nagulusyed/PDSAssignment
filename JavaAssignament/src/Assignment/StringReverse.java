package Assignment;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String originalString = "Hello World";
        String reversedString = reverseString(originalString);
        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
	}
	
	public static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

}
