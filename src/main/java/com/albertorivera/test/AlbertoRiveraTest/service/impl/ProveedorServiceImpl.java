package com.albertorivera.test.AlbertoRiveraTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertorivera.test.AlbertoRiveraTest.converter.ConverterProveedor;
import com.albertorivera.test.AlbertoRiveraTest.dto.ProveedorDTO;
import com.albertorivera.test.AlbertoRiveraTest.entity.Proveedor;
import com.albertorivera.test.AlbertoRiveraTest.query.QueryBuilder;
import com.albertorivera.test.AlbertoRiveraTest.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	private QueryBuilder queryBuilder;
	
	@Autowired
	private ConverterProveedor converterProveedor;

	@Override
	public List<ProveedorDTO> findProveedorByCodigoCliente(String codCliente) {
		List<Proveedor> queryResult = queryBuilder.buscarProveedoresPorCodigoCliente(codCliente);
		return converterProveedor.convertListProveedor(queryResult);
	}

}
