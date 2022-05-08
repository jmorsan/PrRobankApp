package CentroOperaciones;



import java.awt.*;
import java.io.Serializable;
import java.util.Calendar;

public class Operaciones implements Serializable {

    private Calendar date;
    private float amount;
    private String type;

    public Operaciones(String type, float amount, Calendar date ) {
        this.date = Calendar.getInstance();
        this.amount = amount;
        this.type = type;
    }

    public Calendar getDate() {

        return date;
    }

    public void changueCalendar(Calendar date){

        this.date = date;

    }

    @Override
    public String toString() {
        return "\n Fecha: " +date.getTime() +" Cantidad: "+amount +" Tipo:"+ type;
    }
}
