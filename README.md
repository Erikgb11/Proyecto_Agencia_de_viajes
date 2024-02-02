# Prototipo de Agencia de Viajes
Esta aplicación es un prototipo que simula ser una agencia de viajes, la aplicación busca gestionar una aplicación de venta de vuelos, viajes en autobus, hoteles, cruceros, paquetes de vuelos-hoteles y viajes en autobus-hoteles utilizando los principios del paradigma POO.

El sistema cuenta con interfaz gráfica haciendo uso de Swing.

El sistema utiliza la serialización para guardar datos, usando archivos de texto como fuente de almacenamiento de datos.

La aplicación es capaz de enviar correos electronicos usando JavaMail.

## Requisitos
- Java8 o superior (recomendado)
- Netbeans (opcional)

## Uso
1. Clona el repositorio:
    ```zsh
   git clone https://github.com/Erikgb11/Proyecto_Agencia_de_viajes.git
   ```
2. Antes de ejecutar el proyecto es necesario que configures en el código tu correo para que pueda mandar correos.
   1. En tu cuenta de gmail es necesario que obtengas una contraseña para aplicaciones.
   2. Una vez obtenida configura el método transfer_to_email(), especificamente las lineas:
      ```zsh
         String correoEnvia = "Aqui va tu correo";
         String contraseña = "Aqui va tu contraseña generada(sin espacios)";
      ```
      En los códigos Csesion.java, Inicio.java, InicioAdmin.java e Isesion.java.
3. Cargar el proyecto, aqui puedes usar netbeans, para cargarlo en netbeans ve a la pestaña de "File", alli usa la opción "Open File", busca el archivo y cargalo.
   1. ![Carga1](/demostraciones/carga1.png) 
   2. ![Carga2](/demostraciones/carga2.png) 
4. Como aun no hay registros de Administradores, ejecuta cAdmin.java y crea un Administrador.
5. Ejecutar el proyecto por completo.


## Demostración
A continuación se muestran algunos videos demostrativos de la aplicación. Si desea ver más a detalle cada caso, puedes ir al apartado de 
[demostraciones](demostraciones/README.md)

### Creación de cuenta(Administrador)
Primero comenzamos con la creación del administrador, el cual se encarga de gestionar los servicios a vender

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/72844079-6bb7-44de-b8dd-635f7b0244ab

Y como podemos ver nos llega el correo correspondiente.
[Correo Creacion de Admin](/demostraciones/CreacionAdmin1.png) 

### Inicio de sesión (Admin)
Iniciamos sesión con alguna de las cuentas registradas

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/f84c138b-0c67-4744-a71b-efe9d7ed37b3

### Creación de cuenta(Cliente)
Seguimos con la creación de una cuenta de cliente

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/dd5c3184-9922-44f2-bb41-57e6165b84fc

Ahora podemos ir a nuestro correo y vemos que se mando el correo correspondiente
[Correo Creacion de Cliente](/demostraciones/CreacionCliente1.png) 

### Inicio de sesión (Cliente)
Iniciamos sesión con alguna de las cuentas registradas

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/98471bae-406a-4f74-a84b-83f00301cc90

### Olvide mi contraseña
Recuperamos la contraseña
[Recuperar contraseña](/demostraciones/RecuperarContra1.png) 

Y observamos que se envio el correo correspondiente
[Correo con contraseña](/demostraciones/RecuperarContra2.png) 

### Subir saldo
Subimos el saldo de nuestra cuenta para poder comprar servicios

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/4fdb990a-00e7-4031-891e-fefd852a5e7c

### Registro de Viajes
Registramos un servicio con la cuenta de Administrador

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/0ec4b47d-9723-409a-9741-f83485ac4faf

Ahora vemos el Autobus registrado
[Bus Registrado](/demostraciones/IngresarBus2.png) 


### Registro de Hotel
Registramos un hotel con la cuenta de administrador

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/72f31665-03bb-42ae-9291-fd39ed3f38b1

Ahora vemos el Hotel registrado
[Hotel Registrado](/demostraciones/IngresarHotel2.png) 

### Registro de Paquetes
Registramos algun paquete de viaje y hotel

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/dff8b981-12a6-4ad6-ba7a-30cda7cf262e



Ahora vemos el Bus-Hotel registrado
[Hotel-Bus registrado](/demostraciones/IngresarHB2.png) 

### Edicion de cuenta
Se lleva a cabo la edición de una de las cuentas registradas

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/8b657a98-f917-4ba0-b3be-0e89dd8a6bd1

Y se muestra el correo que se envio
[Correo de Edición cuenta](/demostraciones/EdicionCuenta2.png) 

### Comprar servicio e Historial de compras
Compramos uno de los servicios disponibles en el catalogo y vemos su historial de compras

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/089c5329-e7ab-4343-b4d9-ff4048f9a311



### Borrar Cuenta
Aquí es posible llevar a cabo la eliminación de cuentas tanto al cliente como al admin pero se probara con el cliente

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/9450e025-d1ea-4da2-91bb-e7c10fd078ea

[Correo de borrar Cuenta](/demostraciones/BorrarCuenta2.png)
[Intento de inicio de sesión](/demostraciones/BorrarCuenta3.png)

### Mostrar historial (Admin)
El admin puede acceder a el historial de todas las compras.

https://github.com/Erikgb11/Proyecto_Agencia_de_viajes/assets/91389946/8338500f-4666-433c-94e5-3f5d90f7aa9b




