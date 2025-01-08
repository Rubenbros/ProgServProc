
## **Introducción a las Redes Informáticas**

Las redes informáticas son como carreteras digitales que permiten que los dispositivos (ordenadores, teléfonos móviles, impresoras, etc.) puedan comunicarse entre sí para compartir información y recursos. Estas carreteras usan normas y señales (protocolos) para que la información llegue a su destino de forma correcta y sin accidentes.

### **Clasificación de las Redes Informáticas**

- **LAN (Local Area Network):** Red pequeña, como la de una casa u oficina.
- **MAN (Metropolitan Area Network):** Red más grande, como la que cubre una ciudad.
- **WAN (Wide Area Network):** Red global, como Internet.
- **PAN (Personal Area Network):** Red personal, como la que se crea con Bluetooth entre tu móvil y tus auriculares.

## **Modelo OSI (Open Systems Interconnection)**

El **modelo OSI** es como una receta para que los dispositivos puedan hablar entre sí a través de una red. Se divide en **7 capas**, donde cada una tiene un trabajo específico.

### **Capa 1: Capa Física**

- **¿Qué hace?** Es la encargada de enviar y recibir los bits (ceros y unos) por cables, ondas de radio o fibra óptica.
- **Ejemplo:** Es como los cables de una carretera por donde viajan los coches (datos).
- **Detalles adicionales:**
    - Define el tipo de medio físico que se utilizará (cobre, fibra óptica, inalámbrico).
    - Determina la velocidad de transmisión.
    - Sincronización entre dispositivos para que la comunicación sea efectiva.
- **Elementos importantes:**
    - Cables (Ethernet, fibra óptica).
    - Conectores (RJ-45).
    - Hubs.
    - Señales eléctricas, ópticas o inalámbricas.

### **Capa 2: Capa de Enlace de Datos**

- **¿Qué hace?** Se asegura de que los datos que viajan por la carretera (capa física) lleguen sin errores.
- **Ejemplo:** Es como un agente de tráfico que revisa que los coches (datos) no choquen ni se pierdan.
- **Detalles adicionales:**
    - Separa los datos en tramas (frames).
    - Controla el acceso al medio para evitar colisiones.
    - Detecta y corrige errores causados por interferencias.
- **Funciones principales:**
    - Divide los datos en tramas.
    - Detecta y corrige errores.
    - Evita colisiones.
- **Elementos importantes:**
    - Switches.
    - Tarjetas de red (NIC).
    - Protocolo Ethernet (IEEE 802.3).

### **Capa 3: Capa de Red**

- **¿Qué hace?** Encuentra la mejor ruta para que los datos lleguen al destino correcto.
- **Ejemplo:** Es como un GPS que indica el mejor camino para llegar de un lugar a otro.
- **Detalles adicionales:**
    - Se asegura de que los datos lleguen al destino correcto, incluso si tienen que pasar por varias redes diferentes.
    - Gestiona direcciones IP y realiza el enrutamiento de paquetes.
    - Puede fragmentar paquetes grandes para que puedan viajar por la red.
- **Funciones principales:**
    - Asigna direcciones IP.
    - Enruta paquetes de datos.
    - Fragmenta paquetes grandes.
- **Elementos importantes:**
    - Routers.
    - Protocolos IP (Internet Protocol) y ICMP (Internet Control Message Protocol).

### **Capa 4: Capa de Transporte**

- **¿Qué hace?** Se asegura de que los datos lleguen completos, en orden y sin errores.
- **Ejemplo:** Es como un servicio de mensajería que se asegura de que tu paquete llegue intacto y en el orden correcto.
- **Detalles adicionales:**
    - Divide los datos en segmentos para que puedan ser enviados correctamente.
    - Controla la congestión para evitar sobrecargas.
    - Puede retransmitir paquetes perdidos.
- **Funciones principales:**
    - Control de flujo.
    - Corrección de errores.
    - Garantiza la entrega de los datos.
- **Protocolos importantes:**
    - TCP (Transmisión confiable).
    - UDP (Más rápido, pero sin garantías).

### **Capa 5: Capa de Sesión**

- **¿Qué hace?** Establece, mantiene y termina la conversación entre dos dispositivos.
- **Ejemplo:** Es como una partida de ajedrez online: alguien debe conectarse, jugar y cerrar la partida.
- **Detalles adicionales:**
    - Establece sesiones de comunicación entre dispositivos.
    - Sincroniza y administra la comunicación.
    - Permite la recuperación de sesiones interrumpidas.
- **Funciones principales:**
    - Inicio y cierre de sesiones.
    - Restaurar sesiones interrumpidas.
- **Protocolos importantes:**
    - NetBIOS.
    - RPC (Remote Procedure Call).

### **Capa 6: Capa de Presentación**

- **¿Qué hace?** Traduce los datos a un formato que el dispositivo receptor pueda entender.
- **Ejemplo:** Es como un decodificador de televisión que transforma la señal digital en imágenes y sonido.
- **Detalles adicionales:**
    - Cifra y descifra los datos para garantizar seguridad.
    - Comprime datos para que viajen más rápido.
    - Convierte formatos de datos (XML, JSON, HTML).
- **Funciones principales:**
    - Cifrado y descifrado de datos.
    - Compresión de datos.
- **Protocolos importantes:**
    - SSL/TLS.
    - MIME.

### **Capa 7: Capa de Aplicación**

- **¿Qué hace?** Es la capa que interactúa directamente con el usuario.

- **Ejemplo:** Es como cuando envías un correo electrónico usando Gmail.

- **Detalles adicionales:**

    - Facilita la comunicación entre el usuario y la red.
    - Proporciona servicios específicos, como correo electrónico, transferencia de archivos o navegación web.

- **Funciones principales:**

    - Autenticación.
    - Gestión de recursos.

- **Protocolos importantes:**

    - HTTP (Páginas web).
    - FTP (Transferencia de archivos).
    - SMTP (Envío de correos).

## **Modelo TCP/IP**

### **1. Introducción al Modelo TCP/IP**
El modelo **TCP/IP (Transmission Control Protocol / Internet Protocol)** es la base fundamental para la comunicación en redes modernas, especialmente en Internet. Surgió como una alternativa más práctica al modelo OSI y se ha convertido en el estándar para las redes actuales.

### **2. Comparativa entre el Modelo OSI y TCP/IP**
Aunque ambos modelos describen cómo se realiza la comunicación en redes, tienen diferencias clave:

| Característica | Modelo OSI | Modelo TCP/IP |
|---------------|-----------|---------------|
| **Capas** | 7 | 4 |
| **Enfoque** | Teórico | Práctico |
| **Protocolo principal** | No define protocolos específicos | TCP/IP |
| **Uso** | Referencia educativa | Implementación real |

El modelo TCP/IP es más directo y está diseñado específicamente para redes reales.

### **3. Capas del Modelo TCP/IP**
El modelo TCP/IP se divide en **4 capas**, cada una con funciones específicas:

#### **Capa 1: Capa de Acceso a la Red (Network Access Layer)**
- **¿Qué hace?** Se encarga de la transmisión física de los datos entre dispositivos conectados directamente.
- **Ejemplo sencillo:** Es como el sistema de carreteras por donde viajan los coches (datos).
- **Protocolos importantes:** Ethernet, Wi-Fi, PPP (Point-to-Point Protocol).
- **Dispositivos clave:** Switches, tarjetas de red (NIC).

#### **Capa 2: Capa de Internet (Internet Layer)**
- **¿Qué hace?** Encargada del direccionamiento lógico (direcciones IP) y del enrutamiento de paquetes a través de redes.
- **Ejemplo sencillo:** Es como un GPS que indica el mejor camino para llegar al destino.
- **Protocolos importantes:** IP (Internet Protocol), ICMP (Internet Control Message Protocol), ARP (Address Resolution Protocol).
- **Dispositivos clave:** Routers.

#### **Capa 3: Capa de Transporte (Transport Layer)**
- **¿Qué hace?** Garantiza que los datos lleguen completos, en orden y sin errores.
- **Ejemplo sencillo:** Es como un servicio de mensajería que verifica que los paquetes lleguen en orden.
- **Protocolos importantes:** TCP (Transmission Control Protocol), UDP (User Datagram Protocol).
- **Diferencias clave:**
  - **TCP:** Confiable, garantiza la entrega.
  - **UDP:** Rápido, no garantiza la entrega.

#### **Capa 4: Capa de Aplicación (Application Layer)**
- **¿Qué hace?** Permite la interacción directa entre aplicaciones y la red.
- **Ejemplo sencillo:** Es como una aplicación de correo electrónico o un navegador web.
- **Protocolos importantes:** HTTP, FTP, SMTP, DNS, DHCP.

### **4. Protocolos importantes en el Modelo TCP/IP**
- **IP (Internet Protocol):** Encargado de direccionar y enrutar paquetes.
- **TCP (Transmission Control Protocol):** Asegura la entrega fiable de los datos.
- **UDP (User Datagram Protocol):** Entrega rápida, pero sin garantías.
- **HTTP (HyperText Transfer Protocol):** Transferencia de páginas web.
- **FTP (File Transfer Protocol):** Transferencia de archivos.
- **SMTP (Simple Mail Transfer Protocol):** Envío de correos electrónicos.
- **DNS (Domain Name System):** Traduce nombres de dominio en direcciones IP.

### **5. Comparativa entre TCP y UDP**
| Característica | TCP | UDP |
|---------------|-----|-----|
| **Conexión** | Orientado a la conexión | No orientado a la conexión |
| **Fiabilidad** | Alta | Baja |
| **Velocidad** | Más lento | Más rápido |
| **Uso común** | Navegación web, correos electrónicos | Streaming, juegos online |

### **6. Funcionamiento de una Comunicación TCP/IP**
1. **Capa de Aplicación:** La aplicación solicita enviar datos (por ejemplo, un correo electrónico).
2. **Capa de Transporte:** Los datos se dividen en segmentos (TCP) o datagramas (UDP).
3. **Capa de Internet:** Los segmentos se encapsulan en paquetes IP con direcciones de origen y destino.
4. **Capa de Acceso a Red:** Los paquetes se convierten en señales físicas y se envían al destinatario.
5. **En el receptor:** Las capas se deshacen del encapsulamiento en orden inverso hasta que los datos llegan a la aplicación.

### **7. Ventajas del Modelo TCP/IP**
- Altamente escalable.
- Interoperabilidad entre diferentes sistemas.
- Amplio soporte en hardware y software.
- Ideal para redes globales como Internet.

### **8. Desventajas del Modelo TCP/IP**
- Difícil de administrar en redes muy grandes.
- El protocolo IP no garantiza la entrega de los paquetes.
- Menor control sobre detalles específicos en comparación con el modelo OSI.

### **9. Resumen del Modelo TCP/IP**
- **Capa de Acceso a la Red:** Control del medio físico.
- **Capa de Internet:** Direccionamiento y enrutamiento.
- **Capa de Transporte:** Control de flujo y errores.
- **Capa de Aplicación:** Interacción con el usuario.

El modelo TCP/IP es la columna vertebral de las redes modernas y su comprensión es esencial para cualquier profesional en informática y telecomunicaciones.

