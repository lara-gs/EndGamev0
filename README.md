# EndGame

**EndGame** es un juego de historia interactiva ambientado en el año 2612. Este proyecto es una crítica social al capitalismo que permite a los jugadores tomar decisiones que afectan directamente el desarrollo de la trama.

### Sobre el juego

**EndGame** presenta una historia ambientada en un mundo distópico. Las elecciones de los jugadores son fundamentales, ya que afectan no solo el destino de su historia, sino también el curso del mundo.

**Cada decisión tiene un impacto significativo y podría cambiar los resultados futuros.**

### Características principales

- **Sistema de inicio de sesión** con roles de usuario.
- **Elecciones** con consecuencias que alteran la narrativa.
- **Una historia disponible por ahora**, con planes de implementar más en el futuro.
- **Base de datos relacional** para gestionar usuarios, historias y progresos.

---

### Tecnologías utilizadas

#### Backend
- **Java 21**
- **Spring Boot**
- **MySQL**
- **JPA/Hibernate**

#### Testing
- **JUnit**
- **Mockito**
- **Cobertura del 65%**

#### Herramientas
- **VSCode**
- **Postman**

---

### Requisitos de instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tuusuario/endgame.git
   cd endgame
   ```

2. **Configurar la base de datos MySQL**:
   - Crear una base de datos llamada `endgame`.
   - Actualizar el archivo `application.properties` con las credenciales de tu base de datos.

3. **Construir el proyecto**:
   - Asegúrate de tener Maven instalado.
   - Ejecuta el siguiente comando:
     ```bash
     mvn clean install
     ```

4. **Ejecutar la aplicación**:
   ```bash
   mvn spring-boot:run
   ```

5. **Probar la API con Postman**:
   - Importa el archivo de colección Postman que se encuentra en `docs/postman_collection.json`.

6. **Ejecutar las pruebas unitarias**:
   - Usa el comando:
     ```bash
     mvn test
     ```

---


---

### Estado del proyecto

- **Cobertura de pruebas**: 65%+
- **Funcionalidades principales implementadas**: completadas.
- **Pendientes**:
  - Continuar la historia.
  - Implementar más historias.
  - Añadir elementos más visuales.

---

### Contribuciones

Si deseas contribuir, por favor sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una rama con un nombre descriptivo:
   ```bash
   git checkout -b feature/nombre-funcionalidad
   ```
3. Envía un pull request describiendo tus cambios.

---


