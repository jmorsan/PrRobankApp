package Clientes;

import java.io.Serializable;

/**
 * <p>Clase para <b>crear personas</b> .</p>
 * @author <b>Joaquin Moreno Sanchez</b>
 * @version 0.01 Alpha de la Pre-Alpha
 * @since 2022-03-11
 */
public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;

    /**
     * <H3><b>Constructor por defecto.</b></H3>
     */
    public Persona(String nombre) {
        this.nombre = nombre;
        this.dni = generaDNI();
    }

    /**
     * <H3><b>Constructor por parametros.</b></H3>
     * Parametros a completar:
     * <ul>
     * <li>@param <b>nombre</b> -> <i>Nombre de la persona</i></li>
     * <li>@param <b>edad</b> -> <i>Edad de la persona</i></li>
     * <li>@param <b>sexo</b> -><i>Sexo de la persona</i></li>
     * </ul>
     */
    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = generaDNI();
        this.sexo = sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * <H3>Metodo que genera y retorna un <b>dni</b> que pertenece a la persona.</H3>
     * @return <i>documento nacional de identidad</i>
     */
    private String generaDNI(){
        int numdni;
        numdni = (int)Math.floor(Math.random()*(10000000 - 100000000) + 100000000);
        return Integer.toString(numdni)+generaLetraDNI(numdni);
    }

    /**
     * <H3>Metodo que genera y retorna la <b>letra del dni</b> que pertenece a la persona.</H3>
     * @return <i>caracter que conforma el dni junto a un numero</i>
     */
    private char generaLetraDNI(int numdni){
        String codigoDNI="TRWAGMYFPDXBNJZSQVHLCKE";

        return codigoDNI.charAt(numdni%23);
    }

    /**
     * <H3>Metodo que muestra los siguientes datos de la persona creada:</H3>
     * <ul>
     *    <li>@return <b>nombre</b></li>
     *    <li>@return <b>edad</b></li>
     *    <li>@return <b>dni</b></li>
     *    <li>@return <b>sexo</b></li>
     * </ul>
     */
    @Override
    public String toString() {
        return
                "Nombre: " + nombre  +
                "  Edad: " + edad +
                "  Dni: " + dni +
                "  Sexo: " + sexo;
    }
}