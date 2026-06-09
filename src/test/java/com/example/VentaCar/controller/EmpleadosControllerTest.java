package com.example.VentaCar.controller;

import com.example.VentaCar.model.Empleados;
import com.example.VentaCar.service.EmpleadosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmpleadosControllerTest {

    @Mock
    private EmpleadosService empleadosService;

    @InjectMocks
    private EmpleadosController empleadosController;

    @Test
    void crearEmpleado_retorna201() {

        // Vamos a verificar que el método agregarLibro del controlador funciona correctamente
        // Para ello crearfemos un libro con un autor válido y simularemos el comportamiento del servicio
        Empleados empleados = new Empleados(1, "Gabriel García Márquez", 87888995, "gabriel@gmail.com");

        // ""Simulamos""" el comportamiento del servicio (mock):
        // Así evitamos acceder a base de datos en una prueba unitaria.
        // Cuando el servicio intente guardar el libro, le decimos que devuelva el mismo libro (como si lo hubiera guardado).
        // Cuando el controlador invoque saveLibro con ese libro, Mockito devolverá ese mismo libro al instante, sin ejecutar lógica real, sin repositorio, sin DB.
        when(empleadosService.saveEmpleados(empleados)).thenReturn(empleados);

        // Llamamos al método del controlador que queremos probar.
        // El resultado es un ResponseEntity<Libro> con estado HTTP y cuerpo.
        var respuesta = empleadosController.agregarEmpleados(empleados);

        // Para que el test sea completo, verificamos varios aspectos de la respuesta:

        // 1) La respuesta no debe ser nula.
        assertNotNull(respuesta);

        // 2) El estado HTTP esperado al crear un recurso es 201 (CREATED).
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        // 3) El cuerpo de la respuesta debe existir.
        var body = respuesta.getBody();
        assertNotNull(body);

        // 4) Validamos un dato clave del cuerpo para confirmar que se devolvió el libro correcto.
        //assertEquals("Cien años de soledad", body.getTitulo());

    }
}