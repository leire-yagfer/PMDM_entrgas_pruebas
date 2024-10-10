package org.example.Util;

//clase abstracta cuenta bancaria --> heredan los tipos de cuenta (ahorro y corriente)
public abstract class CuentaBancaria implements Imprimible {

    //ATRIBUTOS
    private Persona titular;
    private String iban;
    private double saldo;


    //CONSTRUCTOR
    public CuentaBancaria(Persona titular, String iban, double saldoInicial) {
        this.titular = titular;
        this.iban = iban;
        this.saldo = saldoInicial;
    }


    //GET Y SET
    public Persona getTitular() {
        return titular;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }


    //MÉTODOS
    //método para depositar dinero en la cuenta
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }//depositar


    //método para retirar dinero de la cuenta
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }//retirar


    //método para obtener el saldo actual de la cuenta
    public double obtenerSaldo() {
        return saldo;
    }//obtenerSaldo


    //método abstracto que deberá ser implementado por las clases hijas
    public abstract String devolverInfoString();
}//class