package Cuentas;

import CentroOperaciones.Operaciones;
import Clientes.Persona;

import java.util.Calendar;

public class CuentaStandard extends Cuenta{
    private Calendar openDate;
    private float interest;

    public CuentaStandard(Persona owner, String number, float balance) {
        super(owner, number, balance);

    }


    @Override
    public void withdraw(float amount){

        super.setBalance(super.getBalance()-amount-(amount*interest));
        super.theOperations.add(new Operaciones("Débito",amount,Calendar.getInstance()));

    }

}
