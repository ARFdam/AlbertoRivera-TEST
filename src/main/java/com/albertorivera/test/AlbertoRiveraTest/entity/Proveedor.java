package com.albertorivera.test.AlbertoRiveraTest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "proveedores")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_proveedor;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_alta")
	private Date fecha_alta;
	
	@ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

	public Proveedor() {
		super();
	}

	public Proveedor(Long id_proveedor, String nombre, Date fecha_alta, Cliente cliente) {
		super();
		this.id_proveedor = id_proveedor;
		this.nombre = nombre;
		this.fecha_alta = fecha_alta;
		this.cliente = cliente;
	}

	public Long getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
