package com.vinni.entity;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name = "Vehiculos")
public class Vehiculo implements Serializable{
    @Id
    private String placa;
    private String marca;
    private int modelo;
    private long precio;

	public Vehiculo() {
		super();
	}

	public Vehiculo(String placa, String marca, int modelo, long precio) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

    public Long consultarSOAT() {
        int modelo = 2000 - this.modelo;
        double valorSumar = modelo * 100000; 
        Long ValorSeguro = (long) (valorSumar + precio * 0.1);
        return ValorSeguro;
    }
}
