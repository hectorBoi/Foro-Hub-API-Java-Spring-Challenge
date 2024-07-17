# ForoHub

¡Bienvenido a nuestro último desafío Challenge Back End!

## Descripción

Un foro es un espacio donde todos los participantes de una plataforma pueden plantear sus preguntas sobre determinados tópicos. Aquí en Alura Latam, los estudiantes utilizan el foro para resolver sus dudas sobre los cursos y proyectos en los que participan. Este lugar mágico está lleno de mucho aprendizaje y colaboración entre estudiantes, profesores y moderadores.

### Objetivo

Ya sabemos para qué sirve el foro y conocemos su aspecto, ¿pero sabemos cómo funciona detrás de escena? Es decir, ¿dónde se almacenan las informaciones? ¿Cómo se tratan los datos para relacionar un tópico con una respuesta, o cómo se relacionan los usuarios con las respuestas de un tópico?

Este es nuestro desafío, llamado ForoHub: en él, vamos a replicar este proceso a nivel de back end y, para eso, crearemos una API REST usando Spring.

### Funcionalidades

Nuestra API se centrará específicamente en los tópicos, y debe permitir a los usuarios:

- Crear un nuevo tópico.
- Mostrar todos los tópicos creados.
- Mostrar un tópico específico.
- Actualizar un tópico.
- Eliminar un tópico.

Esto es lo que normalmente conocemos como CRUD* (CREATE, READ, UPDATE, DELETE) y es muy similar a lo que desarrollamos en LiterAlura, pero ahora de forma completa, agregando las operaciones de UPDATE y DELETE, y usando un framework que facilitará mucho nuestro trabajo.

*Traducción libre (en orden): Crear, Consultar, Actualizar y Eliminar.

## Requisitos del Proyecto

Nuestro objetivo con este challenge es implementar una API REST con las siguientes funcionalidades:

1. **API con rutas implementadas siguiendo las mejores prácticas del modelo REST.**
2. **Validaciones realizadas según las reglas de negocio.**
3. **Implementación de una base de datos relacional para la persistencia de la información.**
4. **Servicio de autenticación/autorización para restringir el acceso a la información.**

## Tecnologías Utilizadas

- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Hibernate**
- **Spring Security**
- **Maven**

## Endpoints de la API

### Crear un nuevo tópico

**POST /api/topics**

Cuerpo de la solicitud:

```json
{
  "title": "Título del tópico",
  "message": "Mensaje del tópico",
  "authorId": 1
}
```

### Mostrar todos los tópicos creados

**GET /api/topics**

### Mostrar un tópico específico

**GET /api/topics/{id}**

### Actualizar un tópico

**PUT /api/topics/{id}**

Cuerpo de la solicitud:

```json
{
  "title": "Título actualizado",
  "message": "Mensaje actualizado"
}
```

### Eliminar un tópico

**DELETE /api/topics/{id}**
