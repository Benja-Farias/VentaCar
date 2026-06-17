package com.example.VentaCar.controller;

import com.example.VentaCar.model.Clientes;
import com.example.VentaCar.service.ClientesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientesControllerTest {

    @Mock
    private ClientesService clientesService;

    @InjectMocks
    private ClientesController clientesController;

    @Test
    void crearCliente_retorna201() {


        Clientes clientes = new Clientes(1, "Jose Guzman", 98998763, "jose@gmail.com", "San Joaquin");

        when(clientesService.saveCliente(clientes)).thenReturn(clientes);

        var respuesta = clientesController.agregarCliente(clientes);

        assertNotNull(respuesta);

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        var body = respuesta.getBody();
        assertNotNull(body);

        // 4) Validamos un dato clave del cuerpo para confirmar que se devolvió el libro correcto.
        //assertEquals("Cien años de soledad", body.getTitulo());

    }
}