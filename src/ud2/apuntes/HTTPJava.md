# Cómo enviar peticiones HTTP desde Java

## **1. Introducción**
Enviar peticiones HTTP desde Java es esencial para interactuar con APIs RESTful y otros servicios web. Este tutorial cubre:

1. Enviar peticiones GET y POST usando `HttpURLConnection`.
2. Utilizar `HttpClient` introducido en Java 11.
3. Ejemplos con bibliotecas externas como Apache HttpClient y OkHttp.

---

## **2. Usando HttpURLConnection**
`HttpURLConnection` es la opción nativa para enviar peticiones HTTP en Java.

### **Ejemplo: Petición GET**
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetExample {
    public static void main(String[] args) throws Exception {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Response: " + response.toString());
    }
}
```

### **Ejemplo: Petición POST**
```java
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPostExample {
    public static void main(String[] args) throws Exception {
        String url = "https://jsonplaceholder.typicode.com/posts";
        String jsonInputString = "{"title": "foo", "body": "bar", "userId": 1}";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}
```

---

## **3. Usando HttpClient (Java 11)**
El paquete `java.net.http` introducido en Java 11 facilita el envío de peticiones HTTP.

### **Ejemplo: Petición GET**
```java
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class HttpClientGetExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }
}
```

### **Ejemplo: Petición POST**
```java
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpClientPostExample {
    public static void main(String[] args) throws Exception {
        String json = "{"title": "foo", "body": "bar", "userId": 1}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }
}
```

---

## **4. Usando Apache HttpClient**
Apache HttpClient es una biblioteca externa popular para enviar peticiones HTTP.

### **Agregar dependencia Maven**
```xml
<dependency>
    <groupId>org.apache.httpcomponents.client5</groupId>
    <artifactId>httpclient5</artifactId>
    <version>5.2</version>
</dependency>
```

### **Ejemplo: Petición GET**
```java
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public class ApacheHttpClientExample {
    public static void main(String[] args) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://jsonplaceholder.typicode.com/posts/1");
            try (CloseableHttpResponse response = client.execute(request)) {
                System.out.println("Response Code: " + response.getCode());
            }
        }
    }
}
```

---

## **5. Usando OkHttp**
OkHttp es otra biblioteca popular y moderna para enviar peticiones HTTP.

### **Agregar dependencia Maven**
```xml
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.11.0</version>
</dependency>
```

### **Ejemplo: Petición GET**
```java
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpExample {
    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            System.out.println("Response Body: " + response.body().string());
        }
    }
}
```
