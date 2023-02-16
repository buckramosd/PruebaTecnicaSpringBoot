# PruebaTecnicaSpringBoot
Aplicación web Java para CRUD con BD PostgreSQL utilizando Spring Boot y Hibernate

 * URL: Para acceder a la aplicación web escriba "localhost:8080/crud"
 * NOTA: Es necesario crear la tabla prueba_practica, o bien modificar application.properties para que use la tabla postgres creada por defecto
 * NOTA: Para iniciar el proyecto escriba en la terminal "mvn spring-boot:run"
 * NOTA: Para lanzar el Docker: "cd src/main/docker" + "docker-compose up"

Principales ficheros:

  - UserController: Controlador para el mapeo del CRUD.
  - UserRepository: Interfaz que extiende de JpaRepository para la persistencia de datos.
  - Usuario: Clase POJO con las propiedades id, nombre, apellido, edad.
  - IUserService: Interfaz que provee de los métodos para hacer CRUD.
  - UserServiceImpl: Clase para la implementación de los métodos para CRUD.
  - PruebaTecnicaARVisionApplication: Clase principal del proyecto.
  - Templates/crud: Directorio con las vistas a devolver en la aplicación web.
  - application.properties: Fichero de configuración de Spring.
  - schema.sql: Script para la creación de la tabla de la BD.
  - Docker: Directorio que contiene el .jar del proyecto y los ficheros Dockerfile y docker-compose.yml.
