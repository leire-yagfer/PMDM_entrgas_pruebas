package org.example;

import org.example.Util.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco(); //creo la instancia del banco para manejar las cuentas
        Scanner sc = new Scanner(System.in);
        int opcion;

        try {
            do {
                System.out.println("-------------- \n " +
                        "Elige opción:\n " +
                        "1. Abrir una nueva cuenta \n " +
                        "2. Ver un listado de las cuentas abiertas \n " +
                        "3. Obtener los datos de una cuenta concreta \n " +
                        "4. Realizar un ingreso en una cuenta \n " +
                        "5. Retirar efectivo de una cuenta \n " +
                        "6. Consultar el saldo actual de una cuenta \n " +
                        "7. Salir de la aplicación ");
                opcion = sc.nextInt();

                sc.nextLine(); //evito que me de error tras haber introducido un valor numérico y posteriormente un String

                switch (opcion) {
                    case 1: //abrir cuenta
                        abrirNuevaCuenta(banco, sc);
                        break;
                    case 2: //listado cuentas abiertas
                        verListadoCuentas(banco);
                        break;
                    case 3: //datos de una cuenta
                        obtenerDatosCuenta(banco, sc);
                        break;
                    case 4: //realizar ingreso
                        realizarIngreso(banco, sc);
                        break;
                    case 5: //retirar efectivo
                        retirarEfectivo(banco, sc);
                        break;
                    case 6: //consultar saldo
                        consultarSaldo(banco, sc);
                        break;
                    case 7: //salir
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida, intente de nuevo.");
                        break;
                }//switch
            } while (opcion != 7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//try-catch
    }//main


    //MÉTODOS
    // método para abrir una nueva cuenta bancaria
    private static void abrirNuevaCuenta(Banco banco, Scanner sc) {
        System.out.println("--- Abrir nueva cuenta ---");
        System.out.print("Ingrese el nombre del titular: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese los apellidos del titular: ");
        String apellidos = sc.nextLine();
        System.out.print("Ingrese el DNI del titular: ");
        String dni = sc.nextLine();
        Persona titular = new Persona(nombre, apellidos, dni);

        System.out.println("Seleccione el tipo de cuenta:");
        System.out.println("1. Cuenta de Ahorro");
        System.out.println("2. Cuenta Corriente Personal");
        System.out.println("3. Cuenta Corriente Empresa");
        int tipoCuenta = sc.nextInt();
        sc.nextLine(); // limpiar el buffer

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = sc.nextDouble();
        sc.nextLine(); // limpiar el buffer

        System.out.print("Ingrese el IBAN de la cuenta: ");
        String iban = sc.nextLine();

        CuentaBancaria nuevaCuenta = null;

        switch (tipoCuenta) {
            case 1:
                System.out.print("Ingrese el tipo de interés anual: ");
                double interes = sc.nextDouble();
                nuevaCuenta = new CuentaAhorro(titular, iban, saldoInicial, interes);
                break;
            case 2:
                System.out.print("Ingrese las entidades autorizadas (separadas por comas): ");
                String entidades = sc.nextLine();
                System.out.print("Ingrese la comisión de mantenimiento: ");
                double comision = sc.nextDouble();
                nuevaCuenta = new CuentaCorrientePersonal(titular, iban, saldoInicial, entidades, comision);
                break;
            case 3:
                System.out.print("Ingrese las entidades autorizadas (separadas por comas): ");
                String entidadesEmpresa = sc.nextLine();
                System.out.print("Ingrese el máximo descubierto permitido: ");
                double maxDescubierto = sc.nextDouble();
                System.out.print("Ingrese el tipo de interés por descubierto: ");
                double interesDescubierto = sc.nextDouble();
                System.out.print("Ingrese la comisión fija por descubierto: ");
                double comisionDescubierto = sc.nextDouble();
                nuevaCuenta = new CuentaCorrienteEmpresa(titular, iban, saldoInicial, entidadesEmpresa, maxDescubierto, interesDescubierto, comisionDescubierto);
                break;
            default:
                System.out.println("Tipo de cuenta no válido.");
                return;
        }//switch

        if (banco.abrirCuenta(nuevaCuenta)) {
            System.out.println("Cuenta abierta con éxito.");
        } else {
            System.out.println("Error al abrir la cuenta.");
        }
    }//abrirNuevaCuenta

    // método para ver el listado de cuentas
    private static void verListadoCuentas(Banco banco) {
        System.out.println("--- Listado de cuentas ---");
        List<String> cuentas = banco.listadoCuentas();
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas disponibles.");
        } else {
            for (String cuentaInfo : cuentas) {
                System.out.println(cuentaInfo);
            }//for
        }//else
    }//verListadoCuentas


    //método para obtener los datos de una cuenta específica
    private static void obtenerDatosCuenta(Banco banco, Scanner sc) {
        System.out.println("--- Obtener datos de una cuenta ---");
        System.out.print("Ingrese el IBAN de la cuenta: ");
        String iban = sc.nextLine();
        String infoCuenta = banco.informacionCuenta(iban);
        if (infoCuenta != null) {
            System.out.println(infoCuenta);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }//obtenerDatosCuenta


    // método para realizar un ingreso en una cuenta
    private static void realizarIngreso(Banco banco, Scanner sc) {
        System.out.println("--- Realizar ingreso ---");
        System.out.print("Ingrese el IBAN de la cuenta: ");
        String iban = sc.nextLine();
        System.out.print("Ingrese la cantidad a ingresar: ");
        double cantidad = sc.nextDouble();

        if (banco.ingresoCuenta(iban, cantidad)) {
            System.out.println("Ingreso realizado con éxito.");
        } else {
            System.out.println("Error al realizar el ingreso. Verifique el IBAN.");
        }
    }//realizarIngreso


    //método para retirar efectivo de una cuenta
    private static void retirarEfectivo(Banco banco, Scanner sc) {
        System.out.println("--- Retirar efectivo ---");
        System.out.print("Ingrese el IBAN de la cuenta: ");
        String iban = sc.nextLine();
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = sc.nextDouble();

        if (banco.retiradaCuenta(iban, cantidad)) {
            System.out.println("Retirada realizada con éxito.");
        } else {
            System.out.println("Error al realizar la retirada. Verifique el saldo o el IBAN.");
        }
    }//retirarEfectivo


    //método para consultar el saldo de una cuenta
    private static void consultarSaldo(Banco banco, Scanner sc) {
        System.out.println("--- Consultar saldo ---");
        System.out.print("Ingrese el IBAN de la cuenta: ");
        String iban = sc.nextLine();
        double saldo = banco.obtenerSaldo(iban);
        if (saldo >= 0) {
            System.out.println("El saldo actual de la cuenta es: " + saldo + " euros.");
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }//consultarSaldo
}//class
