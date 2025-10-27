package com.armando.vehiculos;

import java.util.Scanner;

/*
 * Autor: Byron Melo
 * Fecha: 26/10/2025 Versión:1.0
 * Descripción:
 * Esta es la clase main, contiene el metodo de entrada main y en esta clase se crean
 * metodos para instanciar clases de las clases hijas Terrestre y Acuatico.
 * Se utilizan estructuras condicionales y estructuras de repetición para diseñar un
 * menú de navegación en consola donde el usuario pueda ingresar datos y así crear
 * vehiculos terrestres y acuáticos personalizados.
 */
public class Main {
    //Creamos un objeto de tipo escáner para leer datos que el usuario ingresa por teclado
    private static Scanner sc = new Scanner(System.in);
    //Definimos una bandera booleana para el bucle while y la inicializamos con false
    private static boolean salir = false;

    //Metodo main de entrada del programa
    public static void main(String[] args) {

        //Bucle while que se ejecuta hasta que la variable salir sea verdadera
        while(!salir){
            //Llamamos al metodo que muestra el menú para crear un vehículo terrestre o acuático
            menuVehiculos();
            //Lee el valor ingresado por el usuario y limpia el buffer
            int opcion = Integer.parseInt(sc.nextLine());
            //Estructura condicional que contiene el flujo del programa.
            switch(opcion){
                //El primer caso cuando el usuario quiere crear un vehículo de tipo terrestre
                case 1:
                    //Este metodo crea un objeto de tipo Terrestre y muestra el menú de operaciones para ese vehículo
                    crearTerrestre();
                    break;
                case 2:
                    //Este metodo crea un objeto de tipo Acuático y muestra el menú de operaciones para ese vehículo
                    crearAcuatico();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo: ");
                    break;
            }
        }

    }

    //Un metodo que muestra al usuario un menú de opciones para elegir el vehículo a crear
    public static void menuVehiculos(){
        System.out.println("============= SISTEMA CREADOR DE VEHICULOS PERSONALIZADOS =============");
        System.out.println(""" 
                Elige el tipo de vehículo que deseas crear:\n
                1)Vehículo Terrestre \n
                2)Vehículo Acuático \n
                3)Salir
                """);
    }

    //Metodo que pide al usuario los parámetros necesarios para crear una instancia de la clase Terrestre
    public static void crearTerrestre(){
        System.out.println("Ingresa el nombre de tu vehículo terrestre: ");
        String nombreTerrestre = sc.nextLine();
        System.out.println("Ingresa la velocidad actual de tu vehículo terrestre: ");
        int velocidadActual = Integer.parseInt(sc.nextLine());
        System.out.println("Ingresa la velocidad máxima de tu vehículo terrestre: ");
        int velocidadMaxima = Integer.parseInt(sc.nextLine());
        System.out.println("""
                Ingresa el uso de tu vehículo terrestre: \n
                Escribe 1 para elegir uso Militar \n
                Escribe 0 para elegir uso Civil 
                """);
        int tipoDeUso = Integer.parseInt(sc.nextLine());
        /*
        * Como creamos una clase de tipo enumeración para que la variable uso de la clase Terrestre solo
        * pueda tener 2 valores: MILITAR y CIVIL, debemos asignar un valor a la variable uso mediante
        * una estructura condicional simple if, si tipoDeUso es equivalente 1 será MILITAR y si no lo es
        * será CIVIL.
        * */
        UsoVehiculo uso = (tipoDeUso == 1 ? UsoVehiculo.MILITAR : UsoVehiculo.CIVIL);
        System.out.println("Ingresa el número de llantas de tu vehículo terrestre: ");
        int numeroLlantas = Integer.parseInt(sc.nextLine());

        //Se crea una instancia de la clase Terrestre dando los parámetros necesarios
        Terrestre terrestre = new Terrestre(velocidadActual, velocidadMaxima, numeroLlantas, uso );

        //Se llama a un metodo que va a mostrar el menú de operaciones para un vehículo terrestre ya creado.
        menuTerrestre(terrestre, nombreTerrestre);
    }

    /*Metodo que no retorna ningún valor y se encarga de mostrar al usuario todas las opciones de manejo
    *que tiene para el vehículo que ha creado previamente
    *@param terrestre Parámetro que necesita el método y representa un objeto de la clase Terrestre
    *@param nombre Parámetro que necesita el método y representa el nombre del objeto creado.
     */
    public static void menuTerrestre(Terrestre terrestre, String nombre){
        //Definimos una variable booleana instanciada con false para manejar el bucle while.
        boolean regresar = false;

        //Bucle while que itera mientras regresar sea falsa.
        while(!regresar){
            System.out.println("============= MENÚ PARA EL VEHÍCULO " + nombre.toUpperCase() + " =============");
            System.out.println(""" 
                ¿Qué quieres hacer con tu vehículo?:\n
                1)Acelerar \n
                2)Frenar \n
                3)Calcular las revoluciones del motor \n
                4)Mostrar la información del vehículo \n
                5)Volver al menú principal
                """);
            int opcion = Integer.parseInt(sc.nextLine());

            //Estructura condicional que tiene toda la lógica para ejecutar las operaciones disponibles
            switch(opcion){
                case 1:
                    System.out.println("Ingresa la velocidad (km/h) que quieres acelerar para tu vehículo terrestre: ");
                    int velocidad = Integer.parseInt(sc.nextLine());
                    //Llamamos al metodo acelerar de la clase Terrestre y le da como parámetro la velocidad ingresada por el usuario
                    terrestre.acelerar(velocidad);
                    System.out.println("La velocidad actual del vehículo es igual a: " + terrestre.velocidadActual);
                    break;
                case 2:
                    System.out.println("Ingresa la velocidad (km/h) que quieres frenar para tu vehículo terrestre: ");
                    int frenar = Integer.parseInt(sc.nextLine());
                    //Llamamos al metodo frenar de la clase Terrestre y le da como parámetro la velocidad ingresada por el usuario
                    terrestre.frenar(frenar);
                    System.out.println("La velocidad actual del vehículo es igual a: " + terrestre.velocidadActual);
                    break;
                case 3:
                    System.out.println("Ingresa la fuerza del motor del vehículo terrestre: ");
                    int fuerza = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingresa el radio del motor del vehículo terrestre: ");
                    int radio = Integer.parseInt(sc.nextLine());
                    //Llamamos al metodo calcularRevolucionMotor de la clase Terrestre y le da como parámetro la fuerza y el radio
                    int fuerzaMotor = terrestre.calcularRevolucionMotor(fuerza, radio);
                    System.out.println("La fuerza del motor del vehículo " +nombre+ " es de: " + fuerzaMotor +"revoluciones");
                    break;
                case 4:
                    /* Mostrar información del vehículo, no es necesario getters porque el modificador de acceso de esos
                     * atributos es de tipo protected, por lo que todas las clases del paquete pueden acceder a ellos.
                     */
                    System.out.println("\n--- Información del Vehículo Terrestre ---");
                    System.out.println("Nombre: " + nombre);
                    terrestre.imprimir();
                    System.out.println("Llantas: " + terrestre.cantidadLlantas);
                    System.out.println("Uso: " + terrestre.uso);
                    break;
                case 5:
                    //Se termina el bucle while porque no se cumple la condición
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo: ");
                    break;
            }
        }
    }

    //Metodo que pide al usuario los parámetros necesarios para crear una instancia de la clase Acuatico
    public static void crearAcuatico(){
        System.out.println("Ingresa el nombre de tu vehículo acuático: ");
        String nombreAcuatico = sc.nextLine();
        System.out.println("Ingresa la velocidad actual de tu vehículo acuático: ");
        int velocidadActual = Integer.parseInt(sc.nextLine());
        System.out.println("Ingresa la velocidad máxima de tu vehículo acuático: ");
        int velocidadMaxima = Integer.parseInt(sc.nextLine());
        System.out.println("""
                Ingresa cuál es el tipo de vehiculo acuático a crear: \n
                Escribe 1 para elegir uso Superficie \n
                Escribe 0 para elegir uso Submarino 
                """);
        int tipoVehiculo = Integer.parseInt(sc.nextLine());
        /*
         * Como creamos una clase de tipo enumeración para que la variable tipo de la clase Acuático solo
         * pueda tener 2 valores: SUPERFICIE o SUBMARINO, debemos asignar un valor a la variable uso mediante
         * una estructura condicional simple if, si tipoDeUso es equivalente 1 será SUPERFICIE y si no lo es
         * será SUBMARINO.
         * */
        TipoAcuatico tipo = (tipoVehiculo  == 1 ? TipoAcuatico.SUPERFICIE: TipoAcuatico.SUBMARINO);
        System.out.println("Ingresa la capacidad de pasajeros de tu vehículo acuático: ");
        int capacidadPasajeros = Integer.parseInt(sc.nextLine());

        //Se crea una instancia de la clase Acuático dando los parámetros necesarios
        Acuatico acuatico = new Acuatico(velocidadActual, velocidadMaxima, tipo, capacidadPasajeros);

        //Se llama a un metodo que va a mostrar el menú de operaciones para un vehículo acuático ya creado.
        menuAcuatico(acuatico, nombreAcuatico);
    }

    /*Metodo que no retorna ningún valor y se encarga de mostrar al usuario todas las opciones de manejo
     *que tiene para el vehículo que ha creado previamente
     *@param acuatico Parámetro que necesita el metodo y representa un objeto de la clase Acuatico
     *@param nombre Parámetro que necesita el metodo y representa el nombre del objeto creado.
     */
    public static void menuAcuatico(Acuatico acuatico, String nombre){
        //Definimos una variable booleana instanciada con false para manejar el bucle while.
        boolean regresar = false;

        //Bucle while que itera mientras regresar sea falsa.
        while(!regresar){
            System.out.println("============= MENÚ PARA EL VEHÍCULO " + nombre.toUpperCase() + " =============");
            System.out.println(""" 
                ¿Qué quieres hacer con tu vehículo?:\n
                1)Acelerar \n
                2)Frenar \n
                3)Calcular las revoluciones del motor \n
                4)Recomendar velocidad en base a la velocidad del viento \n
                5)Mostrar la información del vehículo \n
                6)Volver al menú principal
                """);
            int opcion = Integer.parseInt(sc.nextLine());

            //Estructura condicional que tiene toda la lógica para ejecutar las operaciones disponibles
            switch(opcion){
                case 1:
                    System.out.println("Ingresa la velocidad (km/h) que quieres acelerar para tu vehículo acuático: ");
                    int velocidad = Integer.parseInt(sc.nextLine());
                    //Llamamos al metodo acelerar de la clase Terrestre y le da como parámetro la velocidad ingresada por el usuario
                    acuatico.acelerar(velocidad);
                    System.out.println("La velocidad actual del vehículo es igual a: " + acuatico.velocidadActual);
                    break;
                case 2:
                    System.out.println("Ingresa la velocidad (km/h) que quieres frenar para tu vehículo acuático: ");
                    int frenar = Integer.parseInt(sc.nextLine());
                    //Llamamos al metodo frenar de la clase Terrestre y le da como parámetro la velocidad ingresada por el usuario
                    acuatico.frenar(frenar);
                    System.out.println("La velocidad actual del vehículo es igual a: " + acuatico.velocidadActual);
                    break;
                case 3:
                    System.out.println("Ingresa la fuerza del motor del vehículo terrestre: ");
                    int fuerza = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingresa el radio del motor del vehículo terrestre: ");
                    int radio = Integer.parseInt(sc.nextLine());
                    //Llamamos al metodo calcularRevolucionMotor de la clase Terrestre y le da como parámetro la fuerza y el radio
                    int fuerzaMotor = acuatico.calcularRevolucionMotor(fuerza, radio);
                    System.out.println("La fuerza del motor del vehículo " +nombre+ " es de: " + fuerzaMotor +"revoluciones");
                    break;
                case 4:
                    System.out.println("Ingresa la velocidad del viento (km/h) para recibir una recomendación de navegación: ");
                    int velocidadViento = Integer.parseInt(sc.nextLine());
                    acuatico.recomedarVelocidad(velocidadViento);
                    break;
                case 5:
                    /* Mostrar información del vehículo, no es necesario getters porque el modificador de acceso de esos
                     * atributos es de tipo protected, por lo que todas las clases del paquete pueden acceder a ellos.
                     */
                    System.out.println("\n--- Información del Vehículo Acuático ---");
                    System.out.println("Nombre: " + nombre);
                    acuatico.imprimir();
                    System.out.println("Tipo de Vehículo Acuático: " + acuatico.tipo);
                    System.out.println("Cantidad de Pasajeros: " + acuatico.capacidadPasajeros);
                    break;
                case 6:
                    //Se termina el bucle while porque no se cumple la condición
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo: ");
                    break;
            }
        }
    }
}