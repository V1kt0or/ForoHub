# ForoHub

ForoHub es una API REST desarrollada con Spring Framework que permite gestionar tópicos en un foro. Este proyecto fue creado como parte de un desafío para replicar el funcionamiento de un foro a nivel de back-end. La API permite realizar operaciones CRUD sobre los tópicos y cuenta con un sistema de autenticación y autorización.

## Características

- Crear un nuevo tópico.
- Mostrar todos los tópicos creados.
- Mostrar un tópico específico.
- Actualizar un tópico.
- Eliminar un tópico.
- Validaciones según reglas de negocio.
- Persistencia de información en una base de datos MySQL.
- Autenticación y autorización mediante JWT (Bearer Token).

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- Maven

## Requisitos previos

Asegúrate de tener instalado en tu entorno:

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [MySQL](https://dev.mysql.com/downloads/)
- Un cliente para probar APIs como [Postman](https://www.postman.com/) o [cURL](https://curl.se/).

## Configuración del proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/V1kt0or/ForoHub.git
   cd ForoHub
   ```

4. La API estará disponible en: `http://localhost:8091`.

## Endpoints principales

| Método | Endpoint           | Descripción                       | Autenticación |
|--------|--------------------|-----------------------------------|----------------|
| POST   | `/api/auth/login` | Inicia sesión y genera un token JWT. | No             |
| POST   | `/api/topicos`    | Crea un nuevo tópico.              | Sí            |
| GET    | `/api/topicos`    | Obtiene todos los tópicos.         | Sí            |
| GET    | `/api/topicos/{id} ` | Obtiene un tópico por su ID.        | Sí            |
| PUT    | `/api/topicos` | Actualiza un tópico por su ID.      | Sí            |
| DELETE | `/api/topicos/{id}` | Elimina un tópico por su ID.        | Sí            |

## Modelo de datos

### Tópico
```json
{
  "titulo": "Duda sobre Spring",
  "mensaje": "¿Cómo configurar una base de datos en Spring Boot?",
  "fechaCreacion": "2024-01-01",
  "status": "ABIERTO",
  "autor": 101,
  "curso": 202,
}
```

### Usuario
```json
{
  "login": "Juan Perez",
  "clave": "hashed_password",
}
```

## Autenticación y autorización

El proyecto utiliza JWT para la autenticación. Para acceder a los endpoints protegidos:

1. Haz una petición `POST` al endpoint `/api/auth/login` con las credenciales del usuario:
   ```json
   {
      "login": "Juan Perez",
     "password": "123456"
   }
   ```
 ![Vista API](F1.png)

2. Obtén el token JWT de la respuesta y utilízalo en el encabezado `Authorization` para futuras peticiones:
   ```
   jwToken: tu_token_jwt
   ```

## Insertar
![Vista API](F2.png)
## Ver Lista
![Vista API](F3.png)

## Ver uno
![Vista API](F4.png)
## Actualizar
![Vista API](F5.png)

## Eliminar

![Vista API](F5.png)

