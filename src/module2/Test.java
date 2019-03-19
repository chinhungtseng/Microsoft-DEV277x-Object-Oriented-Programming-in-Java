package module2;
import java.util.Scanner;

public class Test {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		// int i = 59;
		// int j = 24;
		// toLowestTerms(i, j);

		// System.out.print("type the key: ");

		// String key = input.nextLine();
		// String aaa = getOperation(key);

		// System.out.println(aaa);

		System.out.println(isNumber("12345"));
		System.out.println(isNumber(""));
		System.out.println(isNumber("-12345"));
		System.out.println(isNumber("123/4)5"));
		System.out.println(isNumber("0.2"));

		String a = "1232/5";
		System.out.println(a.indexOf("/"));

		System.out.println("------");
		System.out.println(validFraction("8000000/9#"));
		System.out.print("type a or a/b: ");
		String something = input.nextLine();
		System.out.println(getFraction(something));

	}

	public static boolean isNumber(String str) {
		boolean isNumeric = str.chars().allMatch(Character::isDigit);
		if (str.equals("")) {
			return false;
		} else {
			return isNumeric;
		}
	}

	public static boolean validFraction(String str) {

		if (isNumber(str)) { // check whether the input String just only a number.
			return true;
		} else if (!str.contains("/")) {
			if (str.substring(0, 1).equals("-") && isNumber(str.substring(1, str.length()))) {
				if ((str.substring(1, str.length()).equals("0"))) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {
			if (str.length() < 3) {
				return false;
			} else { // if not, then check is a "a/b" type(fractions)? int
				int indexOfSlach = str.indexOf("/");
				boolean isContainSlash = str.contains("/");
				boolean isContainDash = (str.substring(0, 1)).equals("-");
				boolean a = isNumber(str.substring(0, indexOfSlach));
				boolean negA = isNumber(str.substring(1, indexOfSlach));
				boolean b = isNumber(str.substring((indexOfSlach + 1), str.length()));

				if ((str.substring((indexOfSlach + 1), str.length())).equals("0")) {
					return false;
				} else if (isContainSlash && a && b) {
					return true;
				} else if (isContainSlash && isContainDash && negA && b) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	public static Fraction getFraction(String str) {
		System.out.print("Please enter a fraction (a/b) or ingeger (a): ");
		while (str.equals("Q") == false && str.equals("Q") == false && validFraction(str) == false) {
			System.out.print(
					"Invalid fraction . Please enter (a/b) ro (a), where a and b are integers and b is not zero: ");
			str = input.nextLine();
		}
		int a; // numerator.
		int b; // denominator.
		if (isNumber(str)) {
			// if is (a)...
			a = Integer.parseInt(str.substring(0, str.length())); // "Ingeger.parseInt()" convert string to integer.
			Fraction fraction = new Fraction(a);
			System.out.println(Integer.toString(a));
			return fraction;
		} else {
			// if is (a/b)...
			int indexOfSlash = str.indexOf("/");
			a = Integer.parseInt(str.substring(0, indexOfSlash));
			b = Integer.parseInt(str.substring((indexOfSlash + 1), str.length()));

			Fraction fraction = new Fraction(a, b);
			System.out.println(Integer.toString(a) + ", " + Integer.toString(b));
			return fraction;
		}

	}

	public static void toLowestTerms(int a, int b) {
		// To convert a fraction to lowest terms
		int aa = a; // a is the GCD of two number.
		int bb = b;
		int remainder;
		while (aa != 0 && bb != 0) {
			remainder = aa % bb;
			aa = bb;
			bb = remainder;
		}
		a /= aa;
		b /= aa;

		System.out.println(a + "," + b);
	}

	public static String getOperation(String str) {
		System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
		while (!str.equals("+") && !str.equals("-") && !str.equals("/") && !str.equals("*") && !str.equals("=")
				&& !str.equals("Q") && !str.equals("q")) {
			str = input.nextLine();
			System.out.print("Invalid intput (+, -, /, *, = or Q to quit): ");
		}
		System.out.println("123");
		return str;
	}

}
