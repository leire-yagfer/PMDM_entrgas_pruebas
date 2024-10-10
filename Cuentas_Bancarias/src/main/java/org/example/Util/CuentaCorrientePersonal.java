package org.example.Util;

//clase que hereda de CuentaCorriente
public class CuentaCorrientePersonal extends CuentaCorriente {
    private double comisionMantenimiento;

    //CONSTRUCTOR
    public CuentaCorrientePersonal(Persona titular, String iban, double saldoInicial, String entidadesAutorizadas, double comisionMantenimiento) {
        super(titular, iban, saldoInicial, entidadesAutorizadas);
        this.comisionMantenimiento = comisionMantenimiento;
    }


    //MÉTODOS
    //método que añado al haber heredado la clase CuentaCorriente
    @Override
    public String devolverInfoString() {
        return "Cuenta Corriente Personal - " + getTitular().devolverInfoString() +
                ", IBAN: " + getIban() + ", Saldo: " + getSaldo() +
                ", Entidades autorizadas: " + getEntidadesAutorizadas() +
                ", Comisión de mantenimiento: " + comisionMantenimiento;
    }//devolverInfoString
}//class