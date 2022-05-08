package Banco;

import CentroOperaciones.CuentaBanco;
import CentroOperaciones.Operaciones;

import java.io.*;
import java.util.*;

/**
 * <p>Clase que ejecuta las acciones de <b> cuenta </b> .</p>
 * @author <b>Joaquin Moreno Sanchez</b>
 * @version 0.01 Alpha de la Pre-Alpha
 * @since 2022-03-11
 */
public class Banco implements Serializable {

    HashMap<String, CuentaBanco> listaCuentas ;

    public Banco() {
        this.listaCuentas = new HashMap<>();
    }

    public void addAccount(CuentaBanco account){
        if(listaCuentas.containsKey(account.getNumber())){
            System.out.println("No se puede guardar la cuenta. El codigo está repetido");
        }else{
            listaCuentas.put(account.getNumber(),account);
        }
    }

    public void removeAccount(String numCuenta){
        listaCuentas.remove(numCuenta);
        System.out.println("LA CUENTA "+numCuenta+ " HA SIDO ELIMINADA CORRECTAMENTE");
    }

    public void displayBalance(String numCuenta){
        for(Map.Entry<String,CuentaBanco> cuenta: listaCuentas.entrySet()) {
            if(numCuenta.equals(cuenta.getKey())){
            System.out.println("Balance Cuenta: " +numCuenta+" --> " + cuenta.getValue().getBalance());
            }else{
                System.out.println("LA CUENTA INTRODUCIDA NO EXISTE");
            }
        }
    }

    public void displayAccount(String accountNumber){

        if(listaCuentas.containsKey(accountNumber)){
            System.out.println(listaCuentas.get(accountNumber).toString());
        }else{
            System.out.println("LA CUENTA INTRODUCIDA NO EXISTE");
        }
    }

    public void creditAccount(String accountNumber,float amount){

        if(listaCuentas.containsKey(accountNumber)){
            listaCuentas.get(accountNumber).credit(amount);
        }
    }

    public void withdraw(String accountNumber, float amount){
        if(listaCuentas.containsKey(accountNumber)){
            listaCuentas.get(accountNumber).withdraw(amount);
        }
    }

    public void deposit(String accountNumber,float amount){
        if(listaCuentas.containsKey(accountNumber)){
            listaCuentas.get(accountNumber).deposit(amount);
        }
    }


    public void transfer(String accountNumber1, String accountNumber2, float amount ){
        if(listaCuentas.containsKey(accountNumber1)){
            listaCuentas.get(accountNumber1).withdraw(amount);
        }
        if(listaCuentas.containsKey(accountNumber2)){
            listaCuentas.get(accountNumber2).deposit(amount);
        }
    }

    public void listOperationsAccount(String accountNumber, Calendar time) {

        if (listaCuentas.containsKey(accountNumber)) {
            List<Operaciones> temp = listaCuentas.get(accountNumber).getOperationAfters(time);

            for(Operaciones operacion : temp){
                System.out.println(operacion.toString());
            }
        }
    }

    public String generaNumCuenta(){
        int numCuenta;
        numCuenta = (int)Math.floor(Math.random()*(100 - 1000) + 1000);
        return "number-"+numCuenta;
    }

    public void listarCuentas() {
        for (Map.Entry<String, CuentaBanco> cuenta : listaCuentas.entrySet()) {
            System.out.println("--> " + cuenta.getValue());
        }
    }

    public void cambiarDatos(String accountNumber){
        Scanner sc = new Scanner(System.in);

        if (listaCuentas.containsKey(accountNumber)) {
            System.out.println("Indique su nombre a modificar:");
            String nombre = sc.nextLine();
            listaCuentas.get(accountNumber).getOwner().setNombre(nombre);

            System.out.println("Indique su edad a modificar:");
            int edad = Integer.parseInt(sc.nextLine());
            listaCuentas.get(accountNumber).getOwner().setEdad(edad);

            System.out.println("Indique su sexo a modificar:");
            char sexo = sc.nextLine().charAt(0);
            listaCuentas.get(accountNumber).getOwner().setSexo(sexo);

        }else{
            System.out.println("Su cuenta no existe");
        }
    }

}
