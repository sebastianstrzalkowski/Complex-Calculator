package pl.sebastianstrzalkowski.calculator.models;

public class Complex {

    private double real;
    private double imaginary;
    private double angle;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
    }

    ;

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public Complex readComplex(String complex) {
        String complexRe = "";
        String complexIm = "";
        Double re;
        Double im;
        char array[] = new char[complex.length()];
        array = complex.toCharArray();
        boolean imMinus = false;
        boolean reMinus = false;
        boolean imTrue = false;

        for (int i = 0; i < complex.length(); i++) {
            if ((array[i] >= '0' && array[i] <= '9' ) || (array[i] == '-' && imTrue == false)) {
                if (array[i] == '-') {
                    reMinus = true;
                    i++;
                }
                complexRe += array[i];
            } else if ((array[i] == '+' || array[i] == '-') && (array[i + 1] == 'j' || array[i + 1] == 'i')) {
                imTrue = true;
                if (array[i] == '-') {
                    imMinus = true;
                }else {
                    for (int j = i + 2; j < complex.length(); j++) {
                        complexIm += array[j];
                    }
                }
                break;
            }
        }
        re = Double.parseDouble(complexRe);
        im = Double.parseDouble(complexIm);
        if (imMinus == true) {
            im = 0 - im;
        }
        if (reMinus == true) {
            re = 0 - re;
        }
        Complex com = new Complex(re, im);

        return com;
    }


    public Complex addComplex(Complex complex1, Complex complex2) {
        double re = complex1.real + complex2.real;
        double im = complex1.imaginary + complex2.imaginary;
        Complex complex = new Complex(re, im);
        return complex;
    }

    public Complex subtractionComplex(Complex complex1, Complex complex2) {
        double re = complex1.real - complex2.real;
        double im = complex1.imaginary - complex2.imaginary;
        Complex complex = new Complex(re, im);
        return complex;
    }

    public Complex multiplicationComplex(Complex complex1, Complex complex2) {
        double re = complex1.real * complex2.real - complex1.imaginary * complex2.imaginary;
        double im = complex1.real * complex2.imaginary + complex2.real * complex1.imaginary;

        Complex complex = new Complex(re, im);
        return complex;
    }

    public Complex divisionComplex(Complex complex1, Complex complex2) {
        double re = (complex1.real * complex2.real + complex1.imaginary * complex2.imaginary) / (complex2.real * complex2.real + complex2.imaginary * complex2.imaginary);
        double im = (complex1.imaginary * complex2.real - complex1.real * complex2.imaginary) / (complex2.real * complex2.real + complex2.imaginary * complex2.imaginary);
        Complex complex = new Complex(re, im);
        return complex;
    }

    @Override
    public String toString() {
        return real + "+j" + imaginary;
    }
}
