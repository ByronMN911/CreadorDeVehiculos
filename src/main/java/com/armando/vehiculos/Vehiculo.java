package com.armando.vehiculos;

/*
 * Autor: Byron Melo
 * Fecha: 26/10/2025 Versión:1.0
 * Descripción:
 * clase abstracta es una clase que no puede ser instanciada directamente,
 * es decir no se pueden crear objetos a partir de ella. Su principal propósito
 * es servir como modelo o plantilla para que otras clases hereden sus características.
 * Las clases abstractas se utilizan cuando se quiere definir un comportamiento
 * común para un conjunto de clases relacionadas, pero dejando ciertos detalles
 * sin implementar, para que las subclases los definan según sus propias necesidades
 */
public abstract class Vehiculo {
    /*
    * No se agrega un modificador de acceso de forma explicita, por lo que
    * estos atributos son públicos por defecto.
    * */

    int velocidadActual;
    int velocidadMaxima;

    /*
    * Constructor de la clase Vehiculo
    * @param velocidadActual Parámetro que define la velocidad actual de un vehículo
    * @param VelocidadMáxima Parámetro que define la velocidad máxima de un vehículo
    * */
    public Vehiculo(int velocidadActual, int velocidadMaxima) {
        this.velocidadActual = velocidadActual;
        this.velocidadMaxima = velocidadMaxima;
    }

    /*
    * Metodo que no retorna ningun valor y su función es imprimir la velocidad actual
    * y velocidad máxima de un vehículo.
    * */
    public void imprimir(){
        System.out.println("Velocidad Actual: " + velocidadActual);
        System.out.println("Velocidad Maxima: " + velocidadMaxima);
    }

    /*
     * Metodo abstracto que permite incrementar la velocidad de un
     * vehículo
     * @param velocidad Parámetro que define el incremento de la
     * velocidad de un vehículo
     * */
    /*
     * Un metodo abstracto es aquel que se declara, pero no se implementa dentro
     * de una clase abstracta. Su cuerpo es reemplazado por una declaración
     * vacía, y las clases hijas (subclases) son las responsables
     * de proporcionar la implementación concreta del metodo
     */
    abstract void acelerar(int velocidad);

    /*
     * Metodo abstracto que permite decrementar la velocidad de un vehículo
     * @param velocidad Parámetro que define el decremento de la velocidad de un vehículo
     */
    abstract void frenar(int velocidad);
}
