﻿# Proyecto: Automatización de DemoBlaze con Selenium

Suites de pruebas automatizadas para la página [DemoBlaze Store](https://demoblaze.com/) utilizando Java 11, Selenium y TestNG.

### Características

- Se utilizó una estructura de abstracción de páginas estilo **Screenplay**.
- Existen dos _suites_ disponibles, que hacen uso de _drivers_ correspondientes para **Windows** (`suite-windows.xml`) y **Linux** (`suite-linux.xml`) mediante un _webdriver.factory_. Los _drivers_ se encuentran en `resources/webdrivers`.
- Ambas _suites_ ejecutan pruebas en _Chrome_ y _Firefox_.
- El reporte de la última ejecución se encuentra en `Reports/index.html`. Esta incluye _logs_ y capturas de pantalla para pasos importantes de navegación.
- La ejecución de pruebas crea un archivo `automation-YYYY-MM-DD.log` en la raíz, con información detallada de la misma.
- Las pruebas consumen información localizada en archivos JSON en `resources/testdata` mediante _DataProviders_.

 ### Dependencias

 - Java 11 (+ librerías: Selenium, TestNG, AventStack, Log4J).

### Pruebas implementadas

- **purchase - addLaptopProductToCart()**: Filtrar productos de tipo laptop y agregar el primero al carrito.
- **purchase - successfulLaptopProductPurchase()**: Filtrar productos de tipo laptop, agregar el primero al carrito y proceder con la orden de compra.
- **login - testLoginCorrect()**: Comprobar el inicio de sesión con credenciales correctas.
- **login - testLoginUsernameInvalid()**: Comprobar el rechazo de inicio de sesión con un usuario inexistente.
- **login - testLoginPasswordInvalid()**: Comprobar el rechazo de inicio de sesión con una contraseña incorrecta (para un usuario registrado).
