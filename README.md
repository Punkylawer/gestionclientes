# Gestión de Clientes – Estudio Jurídico

Proyecto backend desarrollado con **Java 17** y **Spring Boot**, orientado a la gestión de consultas y clientes para un estudio jurídico. Incluye un CRUD completo, validaciones avanzadas, filtros de búsqueda, paginación y está preparado para integrar autenticación JWT.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.4.5
- Maven
- Spring Web
- Spring Data JPA
- MySQL
- Hibernate Validator
- GitHub Desktop (control de versiones)

---

## 🧱 Estructura del proyecto

El backend está organizado en una arquitectura por capas:

com.example.gestionclientes
├── controller // Endpoints REST
├── service // Lógica de negocio
├── repository // Acceso a base de datos (JPA)
├── dto // DTOs de entrada/salida
├── model // Entidad Cliente
├── mapper // Conversión entre entidades y DTOs
├── validation // Validaciones personalizadas
├── exception // Manejo global de errores
└── config // Seguridad y validación (modularizado)


---

## ✅ Funcionalidades implementadas

- CRUD completo para entidad `Cliente`
- Validaciones integradas:
  - Campos obligatorios
  - Formato de email
  - Teléfono numérico (entre 8 y 15 dígitos)
  - Email único con validador personalizado
- Global Exception Handler con respuestas limpias y claras
- Filtros por `apellido` (parcial, case-insensitive)
- Filtros por `tipoConsulta` (exacto, case-insensitive)
- Paginación y ordenamiento en el endpoint general

---

## 📬 Endpoints principales

- `POST /api/clientes` – Crear cliente
- `GET /api/clientes` – Listar con paginación y orden
  - Parámetros: `page`, `size`, `sort`, `dir`
- `GET /api/clientes/{id}` – Buscar por ID
- `PUT /api/clientes/{id}` – Actualizar cliente
- `DELETE /api/clientes/{id}` – Eliminar cliente
- `GET /api/clientes/buscar-por-apellido?apellido=Pérez`
- `GET /api/clientes/buscar-por-tipo-consulta?tipoConsulta=Sucesiones`

---

## 💡 Próximos pasos

- Integración de Spring Security y JWT para autenticación.
- Protección de rutas y generación de tokens.
- Documentación con Swagger.
- Despliegue en entorno cloud.

---

## 🧑‍💻 Autor

Luciano Barili – [GitHub](https://github.com/tu_usuario) · Java Developer Jr en formación.

---

## 📝 Licencia

Este proyecto es de libre uso con fines educativos y demostrativos.
