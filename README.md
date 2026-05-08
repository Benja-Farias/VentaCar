# Ventacar - API REST con Spring Boot + JPA + MySQL

Este proyecto académico tiene las siguientes funcionalidades:

- `Clientes` : Tiene la capacidad de gestionar clientes (crear/actualizar/eliminar)
- `empleados`: Tiene la capacidad de poder manejar empleados y sus ventas
- `Autos`: Tiene la capacidad de gestionar el inventario de autos disponibles
- `Ventas`: Tiene la capacidad de poder gestionar las ventas realizadas por empleados y poder ver detalladamente estas

---


## 1) Requisitos

- Java 17
- Maven (opcional si usas `mvnw`)
- **MySQL** corriendo en `localhost:3306` (usuario `root`, sin contraseña)
- IDE recomendado: VS Code / IntelliJ / Eclipse
- Postman

---


## 2) Configuración de base de datos

El archivo `src/main/resources/application.properties` contiene la conexión:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ventacar?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
---

## 3) ¿Cómo ejecutar el proyecto?

### 1. Iniciar la Base de Datos
Antes de ejecutar el código Java, asegúrate de que el motor de base de datos esté activo:

Abrir el servidor: Inicia Laragon activando el modulo MySQL

Verificar la base de datos: Asegúrate de que las credenciales en el archivo `src/main/resources/application.properties` esten correctos.

### 2. Abrir el proyecto en Visual Studio Code
Descarga el archivo y clonalo a traves de este repositorio

Busca la carpeta raíz de tu proyecto (cualquier archivo que tenga .java) y ábrela.

Luego haz click en el boton de ejecutar.

---

## 4) URL base de la API

Por defecto Spring Boot levanta en puerto `8080`:

```text
http://localhost:8080
```

Base path del controlador:

```text
/api/v1/autos
```
---

## 5) Autor

- **Benjamin Farias**
