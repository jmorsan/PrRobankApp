package Cuentas;

import CentroOperaciones.Operaciones;
import Clientes.Persona;

import java.util.Calendar;

public class CuentaBonus extends Cuenta {

    private float bonusRate;

    public CuentaBonus(Persona owner, String number, float balance) {
        super(owner, number, balance);
        this.bonusRate = 0.01f;

    }

    public CuentaBonus( Persona owner, String number ){
        super(owner, number);
        this.bonusRate = 0.01f;

    }


    @Override
    public void credit(float amount){
        super.setBalance(super.getBalance()+amount+(amount*bonusRate));
        super.theOperations.add(new Operaciones("Depósito",amount,Calendar.getInstance()));

    }

}
