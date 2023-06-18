package com.albertorivera.test.AlbertoRiveraTest.dto;

import java.util.Date;

import com.albertorivera.test.AlbertoRiveraTest.entity.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO {
	
	private Long id_proveedor;
	
	private String nombre;
	
	private Date fecha_alta;
	
    private Cliente cliente;
}
