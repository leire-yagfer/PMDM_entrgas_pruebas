package org.example.Util;

//clase que hereda de CuentaBancaria
public class CuentaAhorro extends CuentaBancaria {

    //ATRIBUTOS
    private double tipoInteres;

    //CONSTRUCTOR
    public CuentaAhorro(Persona titular, String iban, double saldoInicial, double tipoInteres) {
        super(titular, iban, saldoInicial);
        this.tipoInteres = tipoInteres;
    }


    //MÉTODOS
    //método que añado al haber heredado la clase CuentaBancaria
    @Override
    public String devolverInfoString() {
        return "Cuenta Ahorro - " + getTitular().devolverInfoString() +
                ", IBAN: " + getIban() + ", Saldo: " + getSaldo() +
                ", Interés: " + tipoInteres + "%";
    }//devolverInfoString
}//class
