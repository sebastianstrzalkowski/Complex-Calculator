package pl.sebastianstrzalkowski.calculator.models;

public class Complex {

    private double real;
    private double imaginary;
    private double angle;

    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }



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
}
