package com.armando.vehiculos;
/*
 * Autor: Byron Melo
 * Fecha: 26/10/2025 Versión:1.0
 * Descripción:
 * Esta es una clase hija que hereda los atributos y métodos de la superclase Vehículo,
 * además implementa el metodo abstracto de la interfaz Motor para calcular las revoluciones del motor
 * y también implementa el metodo asbstracto de la interfaz Vela para definir según la velocidad
 * del viento si es buena idea salir a navegar.
 * Tiene 2 atributos nuevos aparte de los atributos heredados, estos son tipo que es de tipo TipoAcuatico
 * (clase de tipo enumeración).
 * El otro atributo es capacidadPasajero de tipo int.
 */


public class Acuatico extends Vehiculo implements Motor, Vela {

    //es un atributo de tipo TipoAcuatico que solo puede tener 2 valores: SUPERFICIE O TERRESTRE
    protected TipoAcuatico tipo;

    //Este atributo representa cuántos pasajeros puede llevar el vehículo acuático
    protected int capacidadPasajeros;

    /*Constructor de la clase Acuático
     * @param velocidadActual Parámetro que define la velocidad actual
     * de un vehículo acuático
     * @param velocidadMaxima Parámetro que define la velocidad
     * máxima permitida para un vehículo acuático
     *
     */
    public Acuatico(int velocidadActual, int velocidadMaxima, TipoAcuatico tipo,  int capacidadPasajeros) {
        //Invocamos al constructor de la clase padre
        super(velocidadActual, velocidadMaxima);
        this.tipo = tipo;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    /*
     * Implementación del metodo abstracto acelerar heredado de
     * Vehículo que permite incrementar la velocidad de un vehículo acuático
     * @param velocidad Parámetro que define el incremento de +velocidad de un vehículo acuático
     */
    void acelerar(int velocidad) {
        int vel = velocidadActual + velocidad;
        if (vel > velocidadMaxima) {
            System.out.println("Supera la velocidad máxima permitida");
        } else {
            velocidadActual = vel;
        }
    }

    /*
     * Implementación del metodo abstracto frenar heredado de Vehículo
     * que permite decrementar la velocidad de un vehículo acuático
     * @param velocidad Parámetro que define el decremento de
     * velocidad de un vehículo acuático
     */

    void frenar(int velocidad) {
        int vel = velocidadActual - velocidad;
        if (vel < 0) {
            System.out.println("La velocidad no puede ser negativa");
        } else {
            velocidadActual = vel;
        }
    }

    /*
     * Implementación del metodo abstracto calcularRevolucionesMotor
     * heredado de la interfaz Motor que calcula las revoluciones de un motor
     * como la multiplicación de su fuerza por su radio
     * @param fuerza Parámetro que define la fuerza que tiene el motor
     * de un vehículo acuático
     * @param radio Parámetro que define el radio de un motor de un vehículo acuático*/

    public int calcularRevolucionMotor(int fuerza, int radio) {
        return (fuerza * radio);
    }

    /*
     * Implementación de metodo abstracto recomendarVelocidad
     * proveniente de la interfaz Vela que recomienda una determinada
     * velocidad del vehículo de acuerdo a la velocidad del viento
     * Se agregó una lógica que cumpla con el enunciado de la tarea para
     * distintas situaciones con base a la velocidad del viento.
     * @param velocidadViento Parámetro que define la velocidad del
     * viento que influenciará la velocidad actual del vehículo
     */

    public void recomedarVelocidad(int velocidadViento){
        if (velocidadViento > 80){
            System.out.println("La velocidad del viento es mayor a 80km/h, se recomienda no salir a navegar");
            System.out.println("Se ha reducido la velocidad del vehículo a 0 km/h");
            velocidadActual=0;
        } else if(velocidadViento > 50) {
            System.out.println("La velocidad del viento es: + velocidadViento");
            System.out.println("Se ha reducido la velocidad del vehículo 20 km/h");
            velocidadActual= velocidadActual-20;
        } else {
            System.out.println("La velocidad del viento es: " + velocidadViento + " Puedes navegar tranquilamente");
        }
    }
}
