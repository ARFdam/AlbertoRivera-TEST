package com.albertorivera.test.AlbertoRiveraTest.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.albertorivera.test.AlbertoRiveraTest.dto.ProveedorDTO;
import com.albertorivera.test.AlbertoRiveraTest.entity.Cliente;
import com.albertorivera.test.AlbertoRiveraTest.entity.Proveedor;

public class ConverterProveedorTest {

    @Test
    public void shouldConvertListProveedorToListProveedorDTO() {
        // Arrange
        ConverterProveedor converter = new ConverterProveedor();
        Cliente cliente1 = new Cliente();
        cliente1.setCodigo("001");
        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("002");
        List<Proveedor> proveedores = new ArrayList<>();
        proveedores.add(new Proveedor(Long.valueOf(1), "Proveedor 1", new Date(), cliente1));
        proveedores.add(new Proveedor(Long.valueOf(2), "Proveedor 2", new Date(), cliente2));

        // Act
        List<ProveedorDTO> result = converter.convertListProveedor(proveedores);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

        ProveedorDTO proveedor1DTO = result.get(0);
        assertEquals(1, proveedor1DTO.getId_proveedor());
        assertEquals("Proveedor 1", proveedor1DTO.getNombre());
        assertNotNull(proveedor1DTO.getFecha_alta());
        assertEquals("001", proveedor1DTO.getCliente().getCodigo());

        ProveedorDTO proveedor2DTO = result.get(1);
        assertEquals(2, proveedor2DTO.getId_proveedor());
        assertEquals("Proveedor 2", proveedor2DTO.getNombre());
        assertNotNull(proveedor2DTO.getFecha_alta());
        assertEquals("002", proveedor2DTO.getCliente().getCodigo());
    }

    @Test
    public void shouldConvertProveedorToProveedorDTO() {
        // Arrange
        ConverterProveedor converter = new ConverterProveedor();
        Cliente cliente = new Cliente();
        cliente.setCodigo("001");
        Proveedor proveedor = new Proveedor(Long.valueOf(1), "Proveedor 1", new Date(), cliente);

        // Act
        ProveedorDTO result = converter.tratarProveedor(proveedor);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getId_proveedor());
        assertEquals("Proveedor 1", result.getNombre());
        assertNotNull(result.getFecha_alta());
        assertEquals("001", result.getCliente().getCodigo());
    }
}
