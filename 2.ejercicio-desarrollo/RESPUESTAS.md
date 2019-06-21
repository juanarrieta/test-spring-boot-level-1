En el siguiente documento se encuentran las rutas asociadas a los metodos desarrollados de los ejercicios propuestos, en el desarrollo se solucionaron los dos ejercicios indicados, mas algunos de la seccion del bonus, las credenciales de acceso al sitio son: 
### usuario = tecso y el password = 1234 ###

**** RUTAS DE LOS METODOS ****

#### Ejercicio 1 ####

/app/view/api/titular_fisico        methods=[POST]
/app/view/api/titular_fisico/{id}   methods=[DELETE]
/app/view/api/titular_fisico        methods=[GET]
/app/view/api/titular_fisico        methods=[PUT]
/app/view/api/titular_juridico      methods=[PUT]
/app/view/api/titular_juridico      methods=[POST]
/app/view/api/titular_juridico/{id} methods=[DELETE]
/app/view/api/titular_juridico      methods=[GET]

#### Ejercicio 2 ####

/app/view/api/cuenta_corriente/{id} methods=[DELETE] 
/app/view/api/cuenta_corriente      methods=[POST]
/app/view/api/cuenta_corriente      methods=[GET]
/app/view/api/movimiento            methods=[POST]
/app/view/api/movimiento            methods=[GET]

#### Bonus (funcionalidad no requerida) ####
Front end: Se utilizo Angular 
Base de datos: Se cambio la base de datos H2 por MySQL, dentro del proyecto se incluyo una carpeta llamada BD en donde se suministra un backup de la base de datos.