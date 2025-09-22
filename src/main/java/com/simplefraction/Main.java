package com.simplefraction;

public class Main {
    public static void main(String[] args) {
        Fraction f12 = new Fraction(1, 2);
        Fraction f3  = new Fraction(3);
        Fraction f0  = new Fraction();
        assert f12.getNumerateur() == 1 && f12.getDenominateur() == 2;
        assert f3.getNumerateur() == 3 && f3.getDenominateur() == 1;
        assert f0.toString().equals("0/1");

        assert Fraction.UN.toString().equals("1/1");
        assert Fraction.ZERO.doubleValue() == 0.0;

        assert Math.abs(f12.doubleValue() - 0.5) < 1e-9;

        Fraction sum = new Fraction(1, 3).add(new Fraction(1, 6));
        assert sum.toString().equals("1/2");

        assert new Fraction(2, 4).equals(new Fraction(1, 2));

        assert new Fraction(1,2).compareTo(Fraction.UN) < 0;

        Number aNumber = java.math.BigDecimal.ONE;
        Number anotherNumber = new Fraction(1, 2);
        assert Math.abs(aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5) < 1E-8;

        System.out.println("C'est bon");
    }
}
