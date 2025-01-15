# Cómo enviar peticiones HTTP con JavaScript

## **1. Introducción**
JavaScript proporciona varias formas de enviar peticiones HTTP. Las más comunes son:

- **XMLHttpRequest** (XHR): Método antiguo pero funcional.
- **Fetch API**: Una API moderna y ampliamente adoptada.
- **Bibliotecas externas** como Axios.

En este tutorial, nos enfocaremos en **Fetch API** por su simplicidad y soporte moderno.

---

## **2. Enviar peticiones HTTP con Fetch API**

### **2.1. Petición GET**
```javascript
// Petición GET para obtener datos
fetch('https://jsonplaceholder.typicode.com/posts/1')
  .then(response => {
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.json();
  })
  .then(data => {
    console.log('Datos recibidos:', data);
  })
  .catch(error => {
    console.error('Error en la petición:', error);
  });
```

### **2.2. Petición POST**
```javascript
// Petición POST para enviar datos
fetch('https://jsonplaceholder.typicode.com/posts', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    title: 'foo',
    body: 'bar',
    userId: 1
  })
})
  .then(response => {
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.json();
  })
  .then(data => {
    console.log('Datos enviados y respuesta recibida:', data);
  })
  .catch(error => {
    console.error('Error en la petición:', error);
  });
```

### **2.3. Petición PUT**
```javascript
// Petición PUT para actualizar datos
fetch('https://jsonplaceholder.typicode.com/posts/1', {
  method: 'PUT',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    id: 1,
    title: 'foo actualizado',
    body: 'bar actualizado',
    userId: 1
  })
})
  .then(response => response.json())
  .then(data => {
    console.log('Datos actualizados:', data);
  })
  .catch(error => {
    console.error('Error en la petición:', error);
  });
```

### **2.4. Petición DELETE**
```javascript
// Petición DELETE para eliminar datos
fetch('https://jsonplaceholder.typicode.com/posts/1', {
  method: 'DELETE'
})
  .then(response => {
    if (response.ok) {
      console.log('Recurso eliminado correctamente');
    } else {
      throw new Error(`Error al eliminar: ${response.status}`);
    }
  })
  .catch(error => {
    console.error('Error en la petición:', error);
  });
```

---

## **3. Enviar peticiones con Axios (Biblioteca externa)**

Axios es una biblioteca popular para realizar peticiones HTTP en JavaScript. Ofrece una sintaxis más simple y características adicionales como soporte para interceptores.

### **Instalar Axios**
```bash
npm install axios
```

### **Ejemplo: Petición GET con Axios**
```javascript
const axios = require('axios');

axios.get('https://jsonplaceholder.typicode.com/posts/1')
  .then(response => {
    console.log('Datos recibidos:', response.data);
  })
  .catch(error => {
    console.error('Error en la petición:', error);
  });
```

### **Ejemplo: Petición POST con Axios**
```javascript
axios.post('https://jsonplaceholder.typicode.com/posts', {
  title: 'foo',
  body: 'bar',
  userId: 1
})
  .then(response => {
    console.log('Datos enviados y respuesta recibida:', response.data);
  })
  .catch(error => {
    console.error('Error en la petición:', error);
  });
```

---

## **4. Comparación entre Fetch y Axios**
| Característica              | Fetch API        | Axios           |
|-----------------------------|------------------|-----------------|
| Nativa de JavaScript        | Sí               | No              |
| Soporte para interceptores  | No               | Sí              |
| Manejo automático de JSON   | No               | Sí              |
| Cancelación de peticiones   | No               | Sí              |
