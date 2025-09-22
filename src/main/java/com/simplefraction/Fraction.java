package com.simplefraction;

public final class Fraction extends Number implements Comparable<Fraction> {
    private final int numerateur;
    private final int denominateur;

    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN   = new Fraction(1, 1);

    public Fraction(int n, int d) {
        if (d == 0) throw new IllegalArgumentException("le dénominateur ne doit pas être égal à zéro");
        if (d < 0) { n = -n; d = -d; }
        int p = pgcd(Math.abs(n), d);
        this.numerateur = n / p;
        this.denominateur = d / p;
    }
    public Fraction(int n) { this(n, 1); }
    public Fraction() { this(0, 1); }

    public int getNumerateur() { return numerateur; }
    public int getDenominateur() { return denominateur; }

    @Override public String toString() { return numerateur + "/" + denominateur; }

    @Override public double doubleValue() { return (double) numerateur / denominateur; }
    @Override public int intValue() { return (int) doubleValue(); }
    @Override public long longValue() { return (long) doubleValue(); }
    @Override public float floatValue() { return (float) doubleValue(); }

    public Fraction add(Fraction x) {
        double n = this.numerateur * x.denominateur + x.numerateur * this.denominateur;
        double d = this.denominateur * x.denominateur;
        return new Fraction((int) n, (int) d);
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Fraction f)) return false;
        return this.numerateur == f.numerateur && this.denominateur == f.denominateur;
    }

    @Override public int compareTo(Fraction o) {
        double x = this.numerateur * o.denominateur;
        double y = o.numerateur * this.denominateur;
        return Double.compare(x, y);
    }

    private static int pgcd(int a, int b) {
        while (b != 0) {
            int t = a % b; a = b; b = t;
        }
        return (a == 0) ? 1 : a;
    }
}
