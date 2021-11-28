# CALC-JSwing
Aplicación de escritorio - calculadora

## Requerimiento 1.

Realizaremos una calculadora utilizando JSwing que utilizara botones para introducir los números y los operadores. 

### Estética

Utilizaremos GridBagLayaut para distribuir los botones y los espacios dentro paneles. Los botones se crearán mediante un bucle que creara un botón por cada elemento en el Array de símbolos añadiendo a cada botón las propiedades, parámetros y Listeners. Hemos personalizado el título y el Icono de la ventana de la aplicación.

### Funcionalidad

- No se permite introducir un "." si ya existe en el texto.
- No se permite introducir 0 si el valor del número en pantalla es 0 excepto si es “0.”
- No se permite introducir parámetros por teclado.
- Si se introduce un operador después de seleccionar otro se sobrescribe.
- Se permite realizar operaciones continuadas Ejem.: 3+3-2 al introducir un segundo operador sin pulsar "=" realizará la operación y añadirá el operador.
- No se permite dividir entre 0. Resultado Error.


### Funcionalidad botones especiales

El operador raíz cuadrada no está disponible, invoca una ventana que nos avisara de ello con un botón de ok para cerrarla.

El operador raíz cubica solicitara una contraseña en una ventana emergente y comprobara si el texto introducido concuerda con la contraseña

- Contraseña: password123

Si la contraseña es correcta realizara la operación.
Si no hay ningún número introducido previamente no realizara ninguna acción.
Si la contraseña es incorrecta informa de ello en la ventana y vuelve a solicitarla.
