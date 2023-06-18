package com.albertorivera.test.AlbertoRiveraTest.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.albertorivera.test.AlbertoRiveraTest.dto.ProveedorDTO;
import com.albertorivera.test.AlbertoRiveraTest.entity.Proveedor;

@Component
public class ConverterProveedor {

	public List<ProveedorDTO> convertListProveedor(List<Proveedor> listProveddor) {
		List<ProveedorDTO> lResult = new ArrayList<>();
		for(Proveedor prov: listProveddor) {
			ProveedorDTO provDTO = new ProveedorDTO();
			provDTO = tratarProveedor(prov);
			lResult.add(provDTO);
		}
		return lResult;
	}
	
	public ProveedorDTO tratarProveedor(Proveedor proveedor) {
		return ProveedorDTO.builder()
				.id_proveedor(proveedor.getId_proveedor())
				.nombre(proveedor.getNombre())
				.fecha_alta(proveedor.getFecha_alta())
				.cliente(proveedor.getCliente())
				.build();
	}

}
