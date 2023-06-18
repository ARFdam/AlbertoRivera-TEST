# AlbertoRivera-TEST
Prueba técnica de Alberto Rivera Ferrari
Indica en el fichero README.md como ejecutar el programa y dependencias utilizadas. 

El proyecto se arranca mediante la clase "AlbertoRiveraTestApplication.java" usando el boton derecho -> Run As.. -> Java Application,
se arrancará por defecto en el puerto 8080.

Se han utilizado las siguientes dependencias:
  - Spring boot-starter-data-jpa
  - Spring boot-starter-web
  - mysql-connector-java
  - lombok
  - junit-jupiter-api
 
En cuanto a los scripts de la creacioon de la BBDD se ecuentran en la ruta del proyecto: "/AlbertoRivera-Test/src/main/resources/scripts",
se deben ejecutar "create_schema.sql" para crear el schema, las tablas y sus inserciones.

Por ultimo un ejemplo de la llamada en postman de ejemplo:
 - URL llamada: http://localhost:8080/proveedores/get/005
 - Resultado: [
                {
                    "id_proveedor": 1,
                    "nombre": "Coca-cola",
                    "fecha_alta": "2023-06-17T22:00:00.000+00:00",
                    "cliente": {
                        "id_cliente": 5,
                        "codigo": "005"
                    }
                },
                {
                    "id_proveedor": 2,
                    "nombre": "Pepsi",
                    "fecha_alta": "2023-06-17T22:00:00.000+00:00",
                    "cliente": {
                        "id_cliente": 5,
                        "codigo": "005"
                    }
                }
            ]
