package com.albertorivera.test.AlbertoRiveraTest.service;

import java.util.List;

import com.albertorivera.test.AlbertoRiveraTest.dto.ProveedorDTO;

public interface ProveedorService {

	List<ProveedorDTO> findProveedorByCodigoCliente(String codCliente);
}
