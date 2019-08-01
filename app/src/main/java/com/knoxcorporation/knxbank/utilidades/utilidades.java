package com.knoxcorporation.knxbank.utilidades;

public class utilidades {
    //Constantes tablas
    public static final String TABLA_CLIENTE="cliente";
    public static final String TABLA_CUENTA="cuenta";
    public static final String TABLA_TRANSACCION="transaccion";
    //Constantes campos general
    public static final String CAMPO_ID="ID";
    public static final String CAMPO_CUENTABANCARIA="cuentaBancaria";
    public static final String CAMPO_FECHAMOVIMIENTO="fechaMovimiento";
    //Constantes campos cliente
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDOS="apellido";
    public static final String CAMPO_DNI="DNI";
    public static final String CAMPO_EDAD="edad";
    public static final String CAMPO_CLAVE="clave";
    public static final String CAMPO_EMAIL="email";
    //Constantes campos cuenta
    public static final String CAMPO_SALDOACTUAL="saldoActual";
    public static final String CAMPO_MOVIMIENTO="Movimiento";
    //Constantes campos Transaccion
    public static final String CAMPO_CUENTABANCARIARECIBIR="cuentaBancariaRecibir";
    public static final String CAMPO_SALDOENVIADO="saldoEnviado";

    //CREACION DE TABLAS
    public static final String CREAR_TABLACLIENTE="CREATE TABLE"+TABLA_CLIENTE+"("+CAMPO_ID+"INTEGER,"+CAMPO_DNI+"  TEXT,"+CAMPO_CUENTABANCARIA+" TEXT,"+CAMPO_NOMBRE+"TEXT,"+CAMPO_APELLIDOS+"TEXT,"+CAMPO_EDAD+" INTEGER,"+CAMPO_CLAVE+"INTEGER,"+CAMPO_EMAIL+"TEXT)";

    //CREACION TABLA CUENTA
    public static final String CREAR_TABLACUENTA= "CREATE TABLE"+TABLA_CUENTA+"("+CAMPO_ID+"INTEGER,"+CAMPO_CUENTABANCARIA+" TEXT,"+CAMPO_SALDOACTUAL+"INTEGER,"+CAMPO_MOVIMIENTO+"TEXT,"+CAMPO_FECHAMOVIMIENTO+"DATE)";

    //CREACION TABLA TRANSACCION
    public  static final String CREAR_TABLATRANSACCION= "CREATE TABLE"+TABLA_TRANSACCION+"("+CAMPO_ID+"INTEGER,"+CAMPO_CUENTABANCARIA+" TEXT,"+CAMPO_CUENTABANCARIARECIBIR+"INTEGER,"+CAMPO_SALDOENVIADO+"TEXT,"+CAMPO_FECHAMOVIMIENTO+"DATE)";



}
