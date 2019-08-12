package com.knoxcorporation.knxbank.Entidades;

import java.util.Date;

public class Cuenta {
    private Integer ID,cuentaBancaria,saldoActual,Movimiento;
    private Date fechaMovimiento;

    public Cuenta(Integer ID, Integer cuentaBancaria, Integer saldoActual, Integer movimiento, Date fechaMovimiento) {
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

    public Integer getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Integer saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Integer getMovimiento() {
        return Movimiento;
    }

    public void setMovimiento(Integer movimiento) {
        Movimiento = movimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }
}
