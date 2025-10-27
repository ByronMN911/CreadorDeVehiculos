package com.armando.vehiculos;

/*
 * Autor: Byron Melo
 * Fecha: 26/10/2025 Versión:1.0
 * Descripción:
 * Esta es una clase hija que hereda los atributos y métodos de la superclase Vehiculo,
 * además implementa el metodo abstracto de la interfaz Motor.
 * Tiene 2 atributos nuevos aparte de los atributos heredados, estos son cantidadLlantas que es
 * de tipo int y el atributo uso que es de tipo UsoVehiculo (tipo de clase enumeración).
 */

public class Terrestre extends Vehiculo implements Motor {
    //Este atributo representa cuántas llantas tendrá el vehiculo a crear
    protected int cantidadLlantas;

    /*Es un atributo de tipo de dato UsoVehiculo el cual solo puede tener 2 valores posibles
     *definidos en la clase enumeración, estos valores son: MILITAR, CIVIL
     */
    protected UsoVehiculo uso;

    /**
     * Constructor de la clase Terreste
     * @param velocidadActual Parámetro que define la velocidad actual de un vehículo terrestre
     * @param velocidadMaxima Parámetro que define la velocidad máxima permitida para un
     * vehículo terrestre
     */
    public Terrestre(int velocidadActual, int velocidadMaxima, int cantidadLlantas, UsoVehiculo uso) {
        //Invoca al constructor de la clase padre
        super(velocidadActual, velocidadMaxima);
        this.cantidadLlantas = cantidadLlantas;
        this.uso = uso;
    }

    /*
     * Implementación del metodo abstracto acelerar heredado de Vehículo que permite
     * incrementar la velocidad de un vehículo terrestre
     * @param velocidad Parámetro que define el incremento de la velocidad de un vehículo terrestre
     */

    public void acelerar(int velocidad){
        int vel = velocidadActual+velocidad;
        if (vel>velocidadMaxima){
            System.out.println("Supera la velocidad máxima permitida");
        }else{
            velocidadActual=vel;
        }
    }

    /*
     * Implementación del metodo abstracto frenar heredado de Vehículo que permite
     * decrementar la velocidad de un vehículo terrestre
     * @param velocidad Parámetro que define el decremento de la velocidad de un vehículo terrestre
     */

    public void frenar(int velocidad){
        int vel = velocidadActual-velocidad;
        if (vel < 0){
            System.out.println("La velocidad no puede ser negativa");
        }else{
            velocidadActual=vel;
        }
    }

    /**
     * Implementación del metodo abstracto calcularRevolucionesMotor
     * heredado de la intefaz Motor que calcula las revoluciones de un motor
     * como la multiplicación de su fuerza por su radio
     * @param fuerza Parámetro que define la fuerza del motor de un vehículo
     * @param radio Parámetro que define el radio del motor de un vehículo
     */
    public int calcularRevolucionMotor(int fuerza, int radio){
        return (fuerza*radio);
    }
}