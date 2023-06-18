package com.albertorivera.test.AlbertoRiveraTest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albertorivera.test.AlbertoRiveraTest.dto.ProveedorDTO;
import com.albertorivera.test.AlbertoRiveraTest.service.ProveedorService;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;

	@GetMapping(value = "/get/{codCliente}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProveedorDTO> getProveedoresByCodigoCliente(@PathVariable String codCliente) {
		List<ProveedorDTO> listProveedor = new ArrayList<>();
		listProveedor = proveedorService.findProveedorByCodigoCliente(codCliente);
		return listProveedor;
	}
}
