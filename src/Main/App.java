package Main;

import Banco.Banco;
import CentroOperaciones.CuentaBanco;
import Clientes.Persona;
import Cuentas.CuentaBonus;
import Cuentas.CuentaProtegida;
import Cuentas.CuentaStandard;
import java.io.*;
import java.util.Calendar;
import java.util.Scanner;
//Proyecto Sincronizado
/**
 * <p>Clase de la <b>APLICACION</b> .</p>
 * @author <b>Joaquin Moreno Sanchez</b>
 * @version 0.01 Alpha de la Pre-Alpha
 * @since 2022-03-11
 */
public class App implements Serializable {
    Scanner sc = new Scanner(System.in);
    Banco bank = new Banco();

    public void Menu() {
        int opcion;
        String numCuenta1;
        String numCuenta2;
        float amount;
        String fecha;
        Calendar time = Calendar.getInstance();
        boolean ok =true;
        do {
            ok = true;

            try {

                do {
                    System.out.println("Opciones:");
                    System.out.println("1- Crear Cuenta Protegida");
                    System.out.println("2- CrearCuenta Bonus");
                    System.out.println("3- Crear Cuenta Standard");
                    System.out.println("4- Ingresar Dinero en Cuenta");
                    System.out.println("5- Sacar Dinero Cuenta");
                    System.out.println("6- Conceder Crédito a Cuenta");
                    System.out.println("7- Hacer Transferencia entre Cuentas");
                    System.out.println("8- Listar Cuentas del Banco");
                    System.out.println("9- Mostrar Cuenta");
                    System.out.println("10- Mostrar Balance de Cuenta");
                    System.out.println("11- Listar Operaciones de Cuenta desde Fecha");
                    System.out.println("12- Modificar Datos Titular");
                    System.out.println("13- Borrar Cuenta");
                    System.out.println("14- Guardar Banco en Fichero");
                    System.out.println("15- Cargar Banco desde Fichero");
                    System.out.println("0- Salir");

                    opcion = Integer.parseInt(capturar());


                    switch (opcion) {

                        case 1:
                            crearCuenta(1);

                            break;

                        case 2:
                            crearCuenta(2);

                            break;

                        case 3:
                            crearCuenta(3);

                            break;

                        case 4:
                            System.out.println("Indique su numero de cuenta: ");
                            numCuenta1 = sc.nextLine();
                            System.out.println("Indique la cantidad a depositar: ");
                            amount = Float.parseFloat(capturar());
                            bank.deposit(numCuenta1, amount);
                            break;

                        case 5:
                            System.out.println("Indique su numero de cuenta: ");
                            numCuenta1 = sc.nextLine();
                            System.out.println("Indique la cantidad a retirar: ");
                            amount = Float.parseFloat(capturar());
                            bank.withdraw(numCuenta1, amount);
                            break;

                        case 6:
                            System.out.println("Indique su numero de cuenta: ");
                            numCuenta1 = sc.nextLine();
                            System.out.println("Indique la cantidad del credito: ");
                            amount = Integer.parseInt(capturar());
                            bank.creditAccount(numCuenta1, amount);
                            break;

                        case 7:
                            System.out.println("Indique su numero de cuenta: ");
                            numCuenta1 = sc.nextLine();
                            System.out.println("Indique el numero de cuenta a la que hacer la transferencia: ");
                            numCuenta2 = sc.nextLine();
                            sc.nextLine();
                            System.out.println("Indique la cantidad de la transferencia: ");
                            amount = Float.parseFloat(capturar());
                            bank.transfer(numCuenta1, numCuenta2, amount);
                            break;

                        case 8:
                            bank.listarCuentas();
                            sc.nextLine();
                            break;

                        case 9:
                            System.out.println("Indique su numero de cuenta: ");
                            numCuenta1 = sc.nextLine();
                            bank.displayAccount(numCuenta1);
                            break;

                        case 10:
                            System.out.println("Indique su numero de cuenta: ");
                            numCuenta1 = sc.nextLine();
                            bank.displayBalance(numCuenta1);

                            break;

                        case 11:
                            System.out.println("Indique su numero de cuenta: ");
                            numCuenta1 = sc.nextLine();
                            System.out.println("Indique su numero la fecha(yyyy/mm/dd): ");
                            fecha = sc.nextLine();

                            time.set(Integer.parseInt(fecha.substring(0, 4)), Integer.parseInt(fecha.substring(5, 7)) - 1, Integer.parseInt(fecha.substring(8)));

                            bank.listOperationsAccount(numCuenta1, time);
                            break;


                        case 12:
                            System.out.println("Indique su numero de cuenta: ");
                            numCuenta1 = sc.nextLine();

                            bank.cambiarDatos(numCuenta1);
                            break;

                        case 13:
                            System.out.println("Indique su numero de cuenta: ");
                            numCuenta1 = sc.nextLine();
                            sc.nextLine();
                            bank.removeAccount(numCuenta1);
                            break;

                        case 14:

                            guardarFichero();
                            break;

                        case 15:
                            cargarFichero();
                            break;

                        case 0:
                            System.out.println("Que tenga un buen dia");
                            break;


                        default:
                            System.out.println("Elija una de la opciones.");
                            Menu();
                            break;

                    }

                } while (opcion != 0);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                ok=false;
                sc.nextLine();
            }
        }while(!ok);
    }

    public Persona crearPersona() {
        String nombre;
        int edad;
        String dni;
        char sexo;


        //dni=sc.nextLine();

            System.out.println("Indique su Nombre:");
            nombre = sc.nextLine();
            System.out.println("Indique su Edad:");
            edad = Integer.parseInt(capturar());
            System.out.println("Indique su Sexo(H/M):");
            sexo = sc.nextLine().charAt(0);

            return new Persona(nombre, edad, sexo);

    }

    public void crearCuenta(int tipo) {
        float balance = 0f;
        int limite;

        switch (tipo) {

            case 1:

                System.out.println("Indique la cantidad inicial que tendrá su cuenta: ");
                balance = Float.parseFloat(capturar());
                System.out.println("Indique el limite que tendrá su cuenta");
                limite = Integer.parseInt(capturar());


                bank.addAccount(new CuentaProtegida(crearPersona(), bank.generaNumCuenta(), limite, balance));
                break;

            case 2:

                System.out.println("Indique la cantidad inicial que tendrá su cuenta: ");
                balance = Float.parseFloat(capturar());

                bank.addAccount(new CuentaBonus(crearPersona(), bank.generaNumCuenta(), balance));
                break;

            case 3:

                System.out.println("Indique la cantidad inicial que tendrá su cuenta: ");
                balance = Float.parseFloat(capturar());

                bank.addAccount(new CuentaStandard(crearPersona(), bank.generaNumCuenta(), balance));
                break;
        }

    }

    public String capturar() {
        return sc.nextLine();
    }

    public void guardarFichero() {

        FileOutputStream fos = null;
        ObjectOutputStream ops = null;
        CuentaBanco c;
        String carpeta = "";
        int eleccion = 0;

        //escritura
        try {

            File f = new File(".");
            String[] files = f.list();

            System.out.println("Elija el directorio a guardar:");
            System.out.println("0-Crear Nueva Carpeta");

            // Display the names of the files
            for (int i = 0; i < files.length; i++) {
                System.out.println((i + 1) + "-" + files[i]);
            }

            eleccion = Integer.parseInt(capturar());


            if (eleccion == 0) {

                System.out.println("Como desea llamar a la carpeta?");
                carpeta = sc.nextLine();
                File carp = new File(carpeta);
                carp.mkdir();


            } else {
                carpeta = files[eleccion - 1];
            }

            //Se crea el fichero
            fos = new FileOutputStream(carpeta + "\\bank.dat");
            ops = new ObjectOutputStream(fos);

            //Se escribe el objeto en el fichero
            ops.writeObject(bank);


        } catch (FileNotFoundException ex) {
            System.out.println("1" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("2" + ex.getMessage());
        } finally {
            try {
                if (fos != null) fos.close();
                if (ops != null) ops.close();
            } catch (IOException ex) {
                System.out.println("3" + ex.getMessage());
            }
        }

        System.out.println("Guardado Correctamente");

    }

    public void cargarFichero() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {


            int eleccion = 0;
            // Create a file object
            File f = new File(".");

            // Get all the names of the files present
            // in the given directory
            String[] files = f.list();

            System.out.println("Elija el directorio a cargar:");

            // Display the names of the files
            for (int i = 0; i < files.length; i++) {
                System.out.println(i + "-" + files[i]);
            }

            eleccion = Integer.parseInt(capturar());

            fis = new FileInputStream(files[eleccion] + "\\bank.dat");
            ois = new ObjectInputStream(fis);


            bank = (Banco) ois.readObject();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
