# Solución — Examen Práctico
## Qué se implementó
se implementó el endpoint para borrar clientes
## Cómo se implementó
se agregaron los métodos al repositorio, servicio, y controlador
## Cambios en base de datos / configuración
Se creo la base de datos y se cambiaron las dependencias de maven, en el properties se agregó la clase para el driver y la url para la base de datos
## Dificultades encontradas
muchas, mi maquina está muy lenta y el IDE que había instalado se rompió y tuve que hacerlo a mano, y no pude probarlo corriendo por falta de tiempo
## Mejoras que podrían aplicarse
Falta implementar la mayoría de las validaciones del frontEnd, y en el backend falta agregar el nuevo campo de email en el cliente, base da datos, entidad.
Falta validaciones de datos requiridos en la entidad, se podría utlizar Validation de Spring para ello.
Falta el manejo de Excepciones, se puede agregar @RestControllerAdvise para manejar de manera integral las excepciones.