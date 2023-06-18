package com.albertorivera.test.AlbertoRiveraTest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDTO {

	private Long id_cliente;
	private String codigo;
}
