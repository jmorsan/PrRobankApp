package Cuentas;

import CentroOperaciones.CuentaBanco;
import CentroOperaciones.Operaciones;
import Clientes.Persona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public abstract class Cuenta implements CuentaBanco, Serializable {

    private Persona owner;
    private String number;
    private float balance;
    protected List<Operaciones> theOperations;

    public Cuenta(Persona owner, String number) {
        this.owner = owner;
        this.number = number;
        this.theOperations = new ArrayList<>();
    }

    public Cuenta(Persona owner, String number, float balance) {
        this.owner = owner;
        this.number = number;
        this.balance = balance;
        this.theOperations = new ArrayList<>();
    }

    @Override
    public Persona getOwner() {
        return owner;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public void credit(float amount){
        setBalance(getBalance()+amount);
        theOperations.add(new Operaciones("Deposito",amount,Calendar.getInstance()));

    }

    @Override
    public void deposit(float amount){
        setBalance(getBalance()+amount);
        theOperations.add(new Operaciones("Deposito",amount,Calendar.getInstance()));
    }

    @Override
    public void withdraw(float amount){

        setBalance(getBalance()-amount);
        theOperations.add(new Operaciones("Débito",amount,Calendar.getInstance()));
    }

    @Override
    public List<Operaciones> getOperationAfters(Calendar date){
        List<Operaciones> alloperation = new ArrayList<>();
        for (Operaciones op:theOperations) {
            if(op.getDate().after(date)){
                alloperation.add(op);
            }
        }
        return alloperation;
    }

    public String displayOperations(){
        Iterator<Operaciones> itr = theOperations.iterator();
        String alloperation="";
        for (Operaciones op:theOperations) {
            alloperation = alloperation.concat(op.toString());
        }

        return alloperation;
    }

    @Override
    public String toString() {

        return "Numero de Cuenta: " + number +
                " Propietario: " + owner +
                " Balance: " + balance;
    }
}
