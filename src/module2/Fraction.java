/*
 * Module 2 Project - Fraction Calculator
 * 
 * PART 1 - FRACTION CLASS
 * PART 2 – FRACTIONCALCULATOR CLASS
 * PART 3 - PUTTING IT ALL TOGETHER!
 * PART 4 - HACKER PROBLEM - FRACTIONCALCULATORADVANCED
 */
package module2;

public class Fraction {
	private int num; // numerator
	private int den; // denominator

	public Fraction(int num, int den) {
		// This constructor should throw an IllegalArgumentException if the denominator
		// is zero.
		if (den == 0) {
			throw new IllegalArgumentException("Denominator must be positive.");
		}
		// If the user enters a negative denominator bump the negative sign to the
		// numerator.
		if (num < 0 && den < 0) {
			this.num = Math.abs(num);
			this.den = Math.abs(den);
		} else if (num > 0 && den < 0) {
			this.num = Math.negateExact(num); // convert positive value to negative.
			this.den = Math.abs(den);
		} else {
			this.num = num;
			this.den = den;
		}
	}

	public Fraction(int num) {
		this.num = num;
		this.den = 1;
	}

	public Fraction() {
		this.num = 0;
		this.den = 1;
	}

	public int getNumerator() {
		return num;
	}

	public int getDenominator() {
		return den;
	}

	public String toString() {
		return num + "/" + den;
	}

	public Double toDouble() {
		return ((double) num / den);
	}

	public Fraction add(Fraction other) {
		int newNum = ((this.num * other.den) + (this.den * other.num));
		int newDen = this.den * other.den;
		return new Fraction(newNum, newDen);

	}

	public Fraction subtract(Fraction other) {
		int newNum = ((this.num * other.den) - (this.den * other.num));
		int newDen = this.den * other.den;
		return new Fraction(newNum, newDen);

	}

	public Fraction multiply(Fraction other) {
		int newNum = this.num * other.num;
		int newDen = this.den * other.den;
		return new Fraction(newNum, newDen);
	}

	public Fraction divide(Fraction other) {
		if (other.den == 0) {
			/* throw an IllegalArgumentException if the user asks to divide by zero */
			throw new IllegalArgumentException(Integer.toString(den));
		}

		int newNum = this.num * other.den;
		int newDen = this.den * other.num;
		return new Fraction(newNum, newDen);

	}

	public boolean equals(Object other) {
		if (other instanceof Fraction) {
			other = (Fraction) other;
			if (num * ((Fraction) other).getDenominator() == den * ((Fraction) other).getNumerator()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public void toLowestTerms() {
		// To convert a fraction to lowest terms
		int numGCD = gcd(this.num, this.den);
		this.num /= numGCD;
		this.den /= numGCD;
		if (this.den < 0) {
			this.num *= -1;
			this.den *= -1;
		}

	}

	public static int gcd(int num, int den) {
		if (den == 0) {
			return num;
		}
		return gcd(num, num % den);
	}

}
