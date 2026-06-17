package com.example.VentaCar.controller;

import com.example.VentaCar.model.Autos;
import com.example.VentaCar.service.AutosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutosControllerTest {

    @Mock
    private AutosService autosService;

    @InjectMocks
    private AutosController autosController;

    @Test
    void crearAuto_retorna201() {


        Autos autos = new Autos(2,"HBHA03","Suzuki","Alto","2019",5600990,105231,"Usado");

        when(autosService.saveAutos(autos)).thenReturn(autos);

        var respuesta = autosController.agregarAutos(autos);

        assertNotNull(respuesta);

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        var body = respuesta.getBody();
        assertNotNull(body);

        // 4) Validamos un dato clave del cuerpo para confirmar que se devolvió el libro correcto.
        //assertEquals("Cien años de soledad", body.getTitulo());

    }
}