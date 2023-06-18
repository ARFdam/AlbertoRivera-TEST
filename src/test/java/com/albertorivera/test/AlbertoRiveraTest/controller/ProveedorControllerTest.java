package com.albertorivera.test.AlbertoRiveraTest.controller;

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

import com.albertorivera.test.AlbertoRiveraTest.dto.ProveedorDTO;
import com.albertorivera.test.AlbertoRiveraTest.service.ProveedorService;

public class ProveedorControllerTest {

    @Mock
    private ProveedorService proveedorService;

    @InjectMocks
    private ProveedorController proveedorController;

    public ProveedorControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnProveedoresByCodigoCliente() {
        // Arrange
        String codigoCliente = "123456";
        List<ProveedorDTO> proveedores = new ArrayList<>();
        ProveedorDTO prov1 = new ProveedorDTO();
        prov1.setNombre("Proveedor 1");
        ProveedorDTO prov2 = new ProveedorDTO();
        prov2.setNombre("Proveedor 2");
        proveedores.add(prov1);
        proveedores.add(prov2);

        when(proveedorService.findProveedorByCodigoCliente(codigoCliente)).thenReturn(proveedores);

        // Act
        List<ProveedorDTO> result = proveedorController.getProveedoresByCodigoCliente(codigoCliente);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Proveedor 1", result.get(0).getNombre());
        assertEquals("Proveedor 2", result.get(1).getNombre());

        verify(proveedorService, times(1)).findProveedorByCodigoCliente(codigoCliente);
    }
}
