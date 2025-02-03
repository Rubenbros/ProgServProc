# Proyecto Finder

## Descripción
Este proyecto, desarrollado de manera individual, integra los aspectos de Programación de Servicios y Procesos (PSP) y Acceso a Datos (AD) para crear una aplicación de interacción entre usuarios. La aplicación permite la autenticación de usuarios, la visualización de perfiles y la interacción a través de un sistema de "like" que, de coincidir, genera un match. Asimismo, se contempla la gestión de imágenes de perfil y, opcionalmente, un sistema básico de mensajería.

## Requisitos

### Funcionalidades Generales
- **Usuarios y Logging:**  
  Implementar un sistema de usuarios y registro de actividad.
- **Perfiles:**  
  Mostrar perfiles de la base de datos una vez que el usuario haya iniciado sesión.
- **Interacción (Like/No Like):**
  - El usuario decide si dar like o no.
  - **Match:** Si ambos usuarios se dan like, se produce un match.
  - Visualización de la lista de matches.
  - Evitar mostrar nuevamente los perfiles rechazados.
  - Si se da like y el otro usuario aún no ha sido consultado, no se produce acción inmediata.
- **Fotos de Perfil:**  
  Permitir cambiar la foto de perfil y visualizar las fotos de otros usuarios.

### Extras (Para obtener la nota máxima)
- **Extra PSP:**  
  Notificar a ambos usuarios cuando se produzca un match.
- **Extra AD:**  
  Implementar un sistema básico de mensajería entre usuarios que hayan hecho match.

### Parte PSP
- Desarrollar un servidor que reciba peticiones HTTP y gestione las respuestas.
- Crear un cliente que interactúe con el servidor:
  - **Opciones:**  
    - Java (interfaz de consola).  
    - JavaScript (interfaz web interactiva, con botones, etc.) → con calificación adicional.

### Parte AD
- Interactuar con la base de datos.
- Diseñar un modelo de datos adecuado a las necesidades del proyecto.
- Garantizar la consistencia de los datos.
- Cifrar las contraseñas.

## Consideraciones Finales
- **Proyecto individual.**
- **Fecha máxima de entrega:** 9 de marzo.
- La integración entre PSP y AD deberá ser coherente y funcional.
