package module2;

import java.util.Scanner;

public class FractionCalculator {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		introduction();

		while (true) {
			String operation = getOperation();

			Fraction input1 = getFraction();
			Fraction input2 = getFraction();

			Fraction output = new Fraction();
			if (operation.equals("=")) {
				boolean isEqual = input1.equals(input2);
				System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + isEqual);
			} else if (operation.equals("+")) {
				output = input1.add(input2);
			} else if (operation.equals("-")) {
				output = input1.subtract(input2);
			} else if (operation.equals("*")) {
				output = input1.multiply(input2);
			} else {
				output = input1.divide(input2);
			}
			output.toLowestTerms();

			if (output.getDenominator() == 1) {
				int outint = output.getNumerator();
				System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + outint);
			} else {
				System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + output);
			}

		}

	}

	public static void introduction() {
		System.out.println("This program is a fraction calcutator.");
		System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
		System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
		System.out.println("-------------------------------------------------------------------------------");
	}

	public static String getOperation() {

		System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
		String str = input.nextLine();
		while (!str.equals("+") && !str.equals("-") && !str.equals("/") && !str.equals("*") && !str.equals("=")
				&& !str.equals("Q") && !str.equals("q")) {
			System.out.print("Invalid intput (+, -, /, *, = or Q to quit): ");
			str = input.nextLine();
		}
		return str;
	}

	public static Fraction getFraction() {
		System.out.print("Please enter a fraction (a/b) or ingeger (a): ");
		String str = input.nextLine();

		while (str.equals("Q") == false && str.equals("q") == false && validFraction(str) == false) {
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
			return fraction;
		} else {
			// if is (a/b)...
			int indexOfSlash = str.indexOf("/");
			a = Integer.parseInt(str.substring(0, indexOfSlash));
			b = Integer.parseInt(str.substring((indexOfSlash + 1), str.length()));
			Fraction fraction = new Fraction(a, b);
			return fraction;
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

	public static boolean isNumber(String str) {
		boolean isNumeric = str.chars().allMatch(Character::isDigit);
		if (str.equals("")) {
			return false;
		} else {
			return isNumeric;
		}
	}

}
