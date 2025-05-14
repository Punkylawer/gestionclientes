# Gestión de Clientes – Estudio Jurídico 🧾

Proyecto backend desarrollado en **Java 17** con **Spring Boot 3.4.5**, orientado a la gestión de consultas jurídicas para estudios legales. Incluye autenticación JWT, validación avanzada, filtros dinámicos, paginación, y protección de endpoints con Spring Security.

> ⚙️ Desarrollado usando **JDK 22**, pero compilado para **Java 17** (LTS y compatible con entornos empresariales).

---

## 🚀 Tecnologías utilizadas

- Java 17 (JDK 22 local)
- Spring Boot 3.4.5
- Spring Data JPA
- Spring Security
- JWT (Json Web Tokens)
- MySQL + Hibernate
- Maven
- Postman (testing API)

---

## 🧱 Estructura del proyecto

com.example.gestionclientes
├── config # Seguridad JWT
├── controller # Endpoints REST
├── dto # Request & Response DTOs
├── exception # GlobalExceptionHandler
├── mapper # Conversión entre entidades y DTOs
├── model # Entidades JPA
├── repository # Interfaces JPA
├── security # JwtService y filtro JWT
├── service # Lógica de negocio
└── validation # Validaciones personalizadas (email único, etc.)


---

## ✅ Funcionalidades implementadas

- 🔐 Registro y Login con JWT
- 🔏 Protección de endpoints vía Spring Security
- 🔍 Filtros por `apellido` y `tipoConsulta`
- 📄 Validaciones:
  - Email válido y único
  - Teléfono numérico entre 8 y 15 dígitos
- 🛡 Manejo centralizado de excepciones con mensajes claros
- 🧭 Paginación y ordenamiento en `GET /api/clientes`
- 🧪 Probado desde Postman (todos los métodos)

---

## 📬 Endpoints disponibles

### Autenticación (`/auth`)
- `POST /register` → crea usuario y devuelve token
- `POST /login` → devuelve JWT si las credenciales son válidas

### Gestión de clientes (`/api/clientes`)
- `GET /` → listado con paginación (token requerido)
- `GET /{id}` → detalle por ID
- `POST /` → crear nuevo cliente
- `PUT /{id}` → actualizar cliente
- `DELETE /{id}` → eliminar cliente

### Filtros adicionales
- `GET /buscar-por-apellido?apellido=Gonzalez`
- `GET /buscar-por-tipo-consulta?tipoConsulta=Laboral`

---

## 🔐 Seguridad y JWT

- Los endpoints `/auth/**` son públicos
- Todos los endpoints `/api/**` requieren token válido
- Los roles son administrados mediante `SimpleGrantedAuthority`
- Clave secreta JWT definida en `application.properties`

---

## 🧪 Probar con Postman

1. `POST /auth/register` → devuelve JWT
2. `POST /auth/login` → devuelve JWT
3. Incluir en cada request protegida:
Authorization: Bearer <tu_token>


---

## 👤 Autor

**Luciano Barili**  
Abogado y Java Developer Jr.  
[GitHub](https://github.com/tu_usuario) · [LinkedIn](https://linkedin.com/in/tu_usuario)

---

## 📝 Licencia

Proyecto de uso libre con fines educativos y de demostración profesional.

