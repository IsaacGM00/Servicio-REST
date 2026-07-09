Para ejecutar el servicio REST:
  - Se compila con el comando "mvn clean install", se tiene que ver como se muestra a continuación:
    <img width="800" height="800" alt="image" src="https://github.com/user-attachments/assets/8252eb7c-9944-43c1-9bc8-92252f536fd3" />
  - Después, se levanta con el comando "mvn spring-boot:run", se tiene que ver como se aprecia a continuación:
    <img width="1547" height="936" alt="image" src="https://github.com/user-attachments/assets/6e0e9b8b-b5d4-4a2a-a989-6dc2ff4d008d" />

Una vez realizado lo anterior, es posible visualizar los endpoints en "Postman" o "Swagger".

<b>Postman</b>
1. En la barra de hasta arriba, para realizar un registro, se coloca la acción "POST" junto con el siguiente link: http://localhost:8080/api/users
   <br></br>
   <img width="346" height="57" alt="image" src="https://github.com/user-attachments/assets/81266e45-f858-4f02-afdc-b0b716b3081d" />

3. En la pestaña "Body", en la esquina derecha, seleccionar "JSON"
   <img width="680" height="300" alt="image" src="https://github.com/user-attachments/assets/ff0e4fa1-cf7f-4408-ab94-a73ed8f9894d" />

4. Colocar el cuerpo de los datos a registrar acorde a las variables existentes en el codigo
   <img width="562" height="122" alt="image" src="https://github.com/user-attachments/assets/2edd5465-947a-415d-8372-f34ecdc9a69b" />

5. Se muestra un mensaje 200 de éxito
   <img width="1487" height="192" alt="image" src="https://github.com/user-attachments/assets/82a5b296-c9a4-4f34-9ed0-5ec39deb20a0" />

6. Para realizar otras acciones como consultar o borrar, se repite el paso uno pero se coloca las acciones "GET" y "DELETE" respectivamente con el mismo link mencionado en el paso 1, dependiendo de la accion/método puede o no tener parámetros.

<b>NOTA: </b>en este caso, para consultar los registros realizados, se ingresa a H2.
- Se escribe en el navegador el sigiente link: http://localhost:8080/h2-ui/ y se tiene que ver esta pantalla. Se ajunstan los parametros de "JDBC URL", "user" y "password" declarados en el archivo de properties.
  <img width="675" height="442" alt="image" src="https://github.com/user-attachments/assets/8b5e949c-3dc1-4f61-9afe-b083e1fe7ec4" />

- Se da clic en "Test Connection" para corroborar que los parámetros sean correctos y tiene que arrojar un mensaje exitoso.
  <img width="602" height="432" alt="image" src="https://github.com/user-attachments/assets/398634bd-5316-4879-87e3-1392126d2739" />

- Después, se le da clic en "Connect" y se tiene que visualizar la sigiente pantalla.
  <img width="1917" height="912" alt="image" src="https://github.com/user-attachments/assets/90be9325-3e5e-4f96-83ae-465b59607779" />

- Se realiza la consulta a la tabla "USERS", arrojando los registros.
  <img width="752" height="360" alt="image" src="https://github.com/user-attachments/assets/8ad4bd15-bf81-42e3-a043-e231182addbc" />

<b>Swagger</b>
1. Se ingresa en el navegador el siguiente link: http://localhost:8080/swagger-ui/index.html
   
2. Se tiene que ver como la siguiente imagen la pantalla
   <img width="1896" height="902" alt="image" src="https://github.com/user-attachments/assets/332fdab7-570b-42dd-985c-d69d7f75c905" />

3. Para realizar un registro, se le da clic en el botón "Try it out"
   <img width="1422" height="460" alt="image" src="https://github.com/user-attachments/assets/8345d24b-46dd-4d23-a376-8bd480e95de9" />

4. Se realiza el cuerpo del JSON con los datos a registrar y una vez terminado, se le da clic en "Execute"
   <img width="1411" height="587" alt="image" src="https://github.com/user-attachments/assets/da2995a6-d4e8-42ff-9710-1ca295c1a990" />

5. Tiene que arrojar un mensaje de 200, es decir, que fue exitosa la acción
   <img width="1402" height="880" alt="image" src="https://github.com/user-attachments/assets/5cb76cd9-d61b-4160-876c-b5b0a227f8f3" />

6. Para las otras acciones como "GET", "DELETE", etc. se realizan los mismos pasos anteriores, dependiendo si solicita parámetros o no.
