package CentroOperaciones;

import Clientes.Persona;

import java.util.Calendar;
import java.util.List;

public interface CuentaBanco {

    public void credit(float cantidad);
    public void withdraw(float cantidad);
    public void deposit(float cantidad);
    public Persona getOwner();
    public String getNumber();
    public float getBalance();
    public List<Operaciones> getOperationAfters(Calendar time);
}
