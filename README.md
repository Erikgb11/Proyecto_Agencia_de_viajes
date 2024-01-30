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
2. Antes de ejecutar el proyecto es necesario que configures en el código tu correo para que pueda mandar correos
   2.1. En tu cuenta de gmail es necesario que obtengas una contraseña para aplicaciones
   2.2. Una vez obtenida configura el método transfer_to_email(), especificamente las lineas:
      ```zsh
         String correoEnvia = "Aqui va tu correo";
         String contraseña = "Aqui va tu contraseña generada(sin espacios)";
      ```
      En los códigos Csesion.java, Inicio.java, InicioAdmin.java e Isesion.java.
3. Cargar el proyecto, aqui puedes usar netbeans, para cargarlo en netbeans ve a la pestaña de "File", alli usa la opción "Open File", busca el archivo y cargalo
   3.1. ![Carga1](/demostraciones/carga1.png) 
   3.2. ![Carga2](/demostraciones/carga2.png) 
4. Ejecutar 


## Demostración
A continuación se muestran algunos videos demostrativos de la aplicación. Si desea ver más a detalle cada caso, puedes ir al apartado de [demostraciones](demostraciones/README.md)

### Creación de cuenta(Administrador)
Primero comenzamos con la creación del administrador, el cual se encarga de gestionar los servicios a vender
### Creación de cuenta(Cliente)
Seguimos con la creación de una cuenta de cliente

### Inicio de sesión
Iniciamos sesión con alguna de las cuentas registradas

### Subir saldo
Subimos el saldo de nuestra cuenta para poder comprar servicios

### Registro de Viajes
Registramos un servicio con la cuenta de Administrador

### Registro de Hotel
Registramos un hotel con la cuenta de administrador

### Registro de Paquetes
Registramos algun paquete de viaje y hotel

### Edicion de cuenta
Se lleva a cabo la edición de una de las cuentas registradas

### Borrar Cuenta
Se lleva a cabo la eliminación de una de las cuentas registradas

### Comprar servicio
Compramos uno de los servicios disponibles en el catalogo

### Mostrar historial (Cliente)
Se muestra el historial de compras que tiene el cliente

### Mostrar historial (Admin)
El admin puede acceder a el historial de todas las compras.



