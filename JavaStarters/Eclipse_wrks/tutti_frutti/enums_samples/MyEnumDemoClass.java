package enums_samples;

public class MyEnumDemoClass {


	public static void main(String[] args) {
		
		Operations op = Operations.MINUS;
		System.out.println ("Enumeration member: " + op);
		System.out.println("45 - 32 = " + op.calc(45, 32));
		
		System.out.println("Работает как критерий для switch:");		
		switch (op) {
			case PLUS: System.out.println (Operations.PLUS); break;
			case MINUS: System.out.println (Operations.MINUS); break;
			case MULT: System.out.println (Operations.MULT); break;
			case DIVIDE: System.out.println (Operations.DIVIDE); break;
		}

		System.out.println("Другая версия:");
		try
		{
			System.out.println ("3 * 4 = " + Operations_V.MULT.calc(3, 4));
		}
		catch (Exception e) { e.printStackTrace(); }
		
		double earthWeight = 800;
        double mass = earthWeight/Planet.EARTH.surfaceGravity();
        System.out.printf("Пусть ваш вес на Земле - %f%n", 800.0f);
        for (Planet p : Planet.values())
            System.out.printf("Ваш вес на планете %s : %f%n",
                             p, p.surfaceWeight(mass));

        System.out.println ("Кое-какие вещи:");
//      Planet p = new Planet (1.0, 2.0); // ошибка
        Planet p = Planet.EARTH;
        switch (p) {
//			case Planet.EARTH: System.out.println (Planet.EARTH); 
			case EARTH: System.out.println (Planet.EARTH); 
//    		case Planet.JUPITER: System.out.println (Planet.JUPITER); 
    		case JUPITER: System.out.println (Planet.JUPITER); 
        }
	}
}

enum Operations 
{
	PLUS	{ double calc (double op1, double op2) { return op1 + op2; }},
	MINUS	{ double calc (double op1, double op2) { return op1 - op2; }},
	MULT 	{ double calc (double op1, double op2) { return op1 * op2; }},
	DIVIDE	{ double calc (double op1, double op2) { return op1 / op2; }};

	abstract double calc (double op1, double op2);
}

enum Operations_V 
{
	PLUS, MINUS, MULT, DIVIDE;
	double calc (double op1, double op2) throws Exception 
	{
		switch (this)
		{
			case PLUS:		return op1 + op2;
			case MINUS:		return op1 - op2;
			case MULT:		return op1 * op2;
			case DIVIDE:	return op1 / op2;
			default: throw new Exception ("Unknown enum data " + this);
		}
	}
}

enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7),
    PLUTO   (1.27e+22,  1.137e6);

    private final double mass;   // кг
    private final double radius; // метры
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    public double mass()   { return mass; }
    public double radius() { return radius; }

    // гравитационная постоянная  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    public double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
}
    
