package com.knoxcorporation.knxbank.Entidades;

import java.util.Date;

public class Transaccion {
    private Integer ID,cuentaBancariaEnviar,cuentaBancaria,saldoEnviado;
    private Date fechaMovimiento;

    public Transaccion(Integer ID, Integer cuentaBancariaEnviar, Integer cuentaBancaria, Integer saldoEnviado, Date fechaMovimiento) {
        this.ID = ID;
        this.cuentaBancariaEnviar = cuentaBancariaEnviar;
        this.cuentaBancaria = cuentaBancaria;
        this.saldoEnviado = saldoEnviado;
        this.fechaMovimiento = fechaMovimiento;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCuentaBancariaEnviar() {
        return cuentaBancariaEnviar;
    }

    public void setCuentaBancariaEnviar(Integer cuentaBancariaEnviar) {
        this.cuentaBancariaEnviar = cuentaBancariaEnviar;
    }

    public Integer getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(Integer cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Integer getSaldoEnviado() {
        return saldoEnviado;
    }

    public void setSaldoEnviado(Integer saldoEnviado) {
        this.saldoEnviado = saldoEnviado;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }
}
