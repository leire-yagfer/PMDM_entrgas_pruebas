package org.example.Util;

import java.util.ArrayList;
import java.util.List;

//clase banco que administra las cuentas
public class Banco {
    //ATRIBUTOS
    private List<CuentaBancaria> cuentas; //lista que almacena las cuentas bancarias


    //CONSTRUCTOR
    public Banco() {
        this.cuentas = new ArrayList<>();
    }


    //MÉTODOS
    //método para abrir una nueva cuenta bancaria
    public boolean abrirCuenta(CuentaBancaria cuentaB) {
        //verifico si la cuenta ya existe
        for (CuentaBancaria cb : cuentas) {
            if (cb.getIban().equals(cuentaB.getIban())) {
                return false; //si el iban ya existe, no se añade la cuenta
            }
        }//for
        cuentas.add(cuentaB); //añade la nueva cuenta a la lista
        return true;
    }//abrirCuenta


    // método para listar todas las cuentas
    public List<String> listadoCuentas() {
        List<String> lista = new ArrayList<>();
        // recorre todas las cuentas bancarias y añade su información a la lista
        for (CuentaBancaria cuenta : cuentas) {
            lista.add(cuenta.devolverInfoString());
        }
        return lista;
    }//listadoCuentas


    //método para obtener la información de una cuenta específica por su IBAN
    public String informacionCuenta(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.devolverInfoString();
            }
        }
        return null; //si no se encuentra la cuenta, retorna null
    }//informacionCuenta


    //método para realizar un ingreso en una cuenta
    public boolean ingresoCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                cuenta.depositar(cantidad); // realiza el ingreso
                return true;
            }
        }
        return false; // si no encuentra la cuenta, retorna false
    }//ingresoCuenta

    //método para retirar dinero de una cuenta
    public boolean retiradaCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.retirar(cantidad); // intenta retirar y devuelve el resultado
            }
        }
        return false; // si no encuentra la cuenta, retorna false
    }//retiradaCuenta


    //método para obtener el saldo de una cuenta específica
    public double obtenerSaldo(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.obtenerSaldo(); // retorna el saldo si encuentra la cuenta
            }
        }
        return -1; // si no encuentra la cuenta, retorna -1
    }//obtenerSaldo
}//class