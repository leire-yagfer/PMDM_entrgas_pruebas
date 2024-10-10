package org.example.Util;

//clase abstracta porque tiene un par de clases que heredan datos almacenados en esta clase
public abstract class CuentaBancaria {

   /* Titular de la cuenta (un objeto de la clase Persona, la cual contendrá información sobre
            el titular: nombre, apellidos y DNI).
            • Saldo actual de la cuenta (número real).
            • Número de cuenta (IBAN).
            • Tipo de interés anual (si se trata de una cuenta de ahorro).
            • Lista de entidades autorizadas para cobrar recibos de la cuenta (si se trata de
            una cuenta corriente).
            • Comisión de mantenimiento (para el caso de una cuenta corriente personal).
            • Tipo de interés por descubierto (si es una cuenta corriente de empresa).
            • Máximo descubierto permitido (si se trata de una cuenta corriente de empresa)

*/


    //ATRIBUTOS
    Persona titular = new Persona();
    private double saldo;
    private String numCuenta;


    //CONSTRUCTOR

    //GET Y SET
}
