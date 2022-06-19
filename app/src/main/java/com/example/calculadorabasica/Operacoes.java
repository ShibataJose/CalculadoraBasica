package com.example.calculadorabasica;

public class Operacoes {

    public double soma(double numero1, double numero2){

        return numero1 + numero2;

    }

    public double subtracao(double numero1, double numero2){


        return numero1 - numero2;

    }

    public double multiplicacao(double numero1, double numero2){


        return numero1 * numero2;

    }

    public double divisao(double numero1, double numero2){


        return numero1 / numero2;

    }

    public double exponenciacao(double numero1, double numero2){


    return StrictMath.pow(numero1,numero2);

    }

}
