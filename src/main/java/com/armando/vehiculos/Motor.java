package com.armando.vehiculos;

/* Autor: Byron Melo
 * Fecha: 26/10/2025 Versión:1.0
 * Descripción:
 * Esta interfaz denominada Motor modela un motor que será implementado
 * por las clases Terrestre y Acuatico, es decir, las subclases implementarán
 * un metodo para calcular las revoluciones del motor.
 */

public interface Motor {
    /*
     * Metodo abstracto que permite calcular las revoluciones de un motor a partir de la fuerza y radio del motor
     * @param fuerza Parámetro que define la fuerza del motor de un vehículo
     * @param radio Parámetro que define el radio del motor de un vehículo
     *
     */
    int calcularRevolucionMotor(int fuerza, int radio);
}