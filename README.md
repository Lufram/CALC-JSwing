# CALC-JSwing
Aplicación de escritorio - calculadora

## Requerimiento 1.

Realizaremos una calculaculadora utilizando JSwing que utilizara botones para introducir los numeros y los operadores. 

### Estética

Utilizaremos GridBagLayaut para distribier los botones y los espacios dentre paneles. Los botones se crearan mediante un bucle que creara un botonpor cada elemento en el Array de symbolos añadiendo a cada boton las propiedades, parametrso y Listeners. HHemos personalizado el título y el Icono de la ventana de la aplicación.

### Funcionalidad

- No se permite introducir un "." si ya existe en el texto.
- No se permite introducir 0 si el valor del numero en pantalla es 0 excepto si es o.
- No se permite introducir parametros por teclado.
- Si se introduce un operador despues de seleccionar otro se sobreescribe.
- Se permite realizar operaciones continuadas Ejem.: 3+3-2 al introducir un segundo operador sin pulsar "=" realizara la operacion y añadira el operador.
- No se permite dividir entre 0. Resultado Error.


### Funcionalidad botones especiales

El operador raiz cuadrada no esta disponible, invoca una ventana que nos avisara de ello con un boton de ok para cerrarla.

El operador raiz cubica solicitara una contraseña en una ventana emergente y comprobara si el texto introducido concuerda con la contraseña

- Contraseña: password123

Si la contraseña es correcta realizara la operación.
Si no hay ningun numero introducido previamente no realizara ninguna acción.
Si la contraseña es incorrecta informa de ello en la ventana y vuelve a solicitarla.




