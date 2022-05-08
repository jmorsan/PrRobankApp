package Cuentas;

import CentroOperaciones.Operaciones;
import Clientes.Persona;

import java.util.Calendar;

public class CuentaProtegida extends Cuenta{
    private float LowerBound;

    public CuentaProtegida(Persona owner, String number, float lowerBound,float balance) {
        super(owner, number,balance);
        LowerBound = lowerBound;
    }


    @Override
    public void withdraw(float amount){
        if(amount>=LowerBound){
            super.setBalance(super.getBalance()-amount);
            super.theOperations.add(new Operaciones("Débito",amount, Calendar.getInstance()));
        }else{
            System.out.println("No puede sacar menos de "+LowerBound+" cantidad.");
        }
    }
}
