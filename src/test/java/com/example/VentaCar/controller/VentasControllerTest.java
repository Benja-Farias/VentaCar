package com.example.VentaCar.controller;

import com.example.VentaCar.model.Autos;
import com.example.VentaCar.model.Clientes;
import com.example.VentaCar.model.Empleados;
import com.example.VentaCar.model.Ventas;
import com.example.VentaCar.service.VentasService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VentasControllerTest {

    @Mock
    private VentasService ventasService;

    @InjectMocks
    private VentasController ventasController;

    @Test
    void crearVenta_retorna201() {

        Autos autos = new Autos(2,"HBHA03","Suzuki","Alto","2019",5600990,105231,"Usado");
        Empleados empleados = new Empleados(1, "Gabriel García Márquez", 87888995, "gabriel@gmail.com");
        Clientes clientes = new Clientes(1, "Jose Guzman", 98998763, "jose@gmail.com", "San Joaquin");
        Ventas ventas = new Ventas(1, clientes, empleados, autos, java.sql.Date.valueOf("2019-01-01"), 5600990);
        
        when(ventasService.saveVentas(ventas)).thenReturn(ventas);

        var respuesta = ventasController.agregarVentas(ventas);

        assertNotNull(respuesta);

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        var body = respuesta.getBody();
        assertNotNull(body);

        assertEquals("Jose Guzman", body.getClientes().getNombre_cliente());
        assertEquals("Gabriel García Márquez", body.getEmpleados().getNombre_empleado());
        assertEquals("HBHA03", body.getAutos().getPatente());



    }
}