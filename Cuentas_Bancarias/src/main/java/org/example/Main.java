package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int opcion;
        try {
            do {
                System.out.println("-------------- \n " +
                        "Elige opción:\n " +
                        "1. Abrir una nueva cuenta \n " +
                        "2. Ver un listado de las cuentas disponibles \n " +
                        "3. Obtener los datos de una cuenta concreta \n " +
                        "4. Realizar un ingreso en una cuenta \n " +
                        "5. Retirar efectivo de una cuenta \n " +
                        "6. Consultar el saldo actual de una cuenta \n " +
                        "7. Salir de la aplicación ");
                opcion = sc.nextInt();

                sc.nextLine();

                switch (opcion) {
                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:

                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        break;
                }//switch
            } while (opcion != 7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//try-catch
    }//main
}//class