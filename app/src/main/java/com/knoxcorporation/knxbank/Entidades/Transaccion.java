package com.knoxcorporation.knxbank.Entidades;

import java.util.Date;

public class Transaccion {
    private Integer ID,cuentaBancaria,cuentaBancariaRecibir,saldoEnviado;
    private Date fechaMovimiento;

    public Transaccion(Integer ID, Integer cuentaBancaria, Integer cuentaBancariaRecibir, Integer saldoEnviado, Date fechaMovimiento) {
        this.ID = ID;
        this.cuentaBancaria = cuentaBancaria;
        this.cuentaBancariaRecibir = cuentaBancariaRecibir;
        this.saldoEnviado = saldoEnviado;
        this.fechaMovimiento = fechaMovimiento;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(Integer cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Integer getCuentaBancariaRecibir() {
        return cuentaBancariaRecibir;
    }

    public void setCuentaBancariaRecibir(Integer cuentaBancariaRecibir) {
        this.cuentaBancariaRecibir = cuentaBancariaRecibir;
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
