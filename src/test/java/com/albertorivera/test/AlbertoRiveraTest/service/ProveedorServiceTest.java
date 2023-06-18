package com.albertorivera.test.AlbertoRiveraTest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.albertorivera.test.AlbertoRiveraTest.converter.ConverterProveedor;
import com.albertorivera.test.AlbertoRiveraTest.dto.ProveedorDTO;
import com.albertorivera.test.AlbertoRiveraTest.entity.Proveedor;
import com.albertorivera.test.AlbertoRiveraTest.query.QueryBuilder;
import com.albertorivera.test.AlbertoRiveraTest.service.impl.ProveedorServiceImpl;

public class ProveedorServiceTest {

	@Mock
	private QueryBuilder queryBuilder;

	@Mock
	private ConverterProveedor converterProveedor;

	@InjectMocks
	private ProveedorServiceImpl proveedorService;

	public ProveedorServiceTest() {
	        MockitoAnnotations.openMocks(this);
	    }

	@Test
	    public void shouldReturnProveedoresByCodigoCliente() {
	        // Arrange
	        String codigoCliente = "123456";
	        List<Proveedor> proveedoresQueryResult = new ArrayList<>();
	        Proveedor prov1 = new Proveedor();
	        prov1.setNombre("Proveedor 1");
	        Proveedor prov2 = new Proveedor();
	        prov2.setNombre("Proveedor 2");
	        proveedoresQueryResult.add(prov1);
	        proveedoresQueryResult.add(prov2);

	        when(queryBuilder.buscarProveedoresPorCodigoCliente(codigoCliente)).thenReturn(proveedoresQueryResult);

	        List<ProveedorDTO> proveedoresDTO = new ArrayList<>();
	        ProveedorDTO provDto1 = new ProveedorDTO();
	        provDto1.setNombre("Proveedor 1");
	        ProveedorDTO provDto2 = new ProveedorDTO();
	        provDto2.setNombre("Proveedor 2");
	        proveedoresDTO.add(provDto1);
	        proveedoresDTO.add(provDto2);

	        when(converterProveedor.convertListProveedor(proveedoresQueryResult)).thenReturn(proveedoresDTO);

	        // Act
	        List<ProveedorDTO> result = proveedorService.findProveedorByCodigoCliente(codigoCliente);

	        // Assert
	        assertNotNull(result);
	        assertEquals(2, result.size());
	        assertEquals("Proveedor 1", result.get(0).getNombre());
	        assertEquals("Proveedor 2", result.get(1).getNombre());

	        verify(queryBuilder, times(1)).buscarProveedoresPorCodigoCliente(codigoCliente);
	        verify(converterProveedor, times(1)).convertListProveedor(proveedoresQueryResult);
	    }
}
