// Crea una función declarativa que reciba un número y devuelva su cuadrado.

function cuadrado (num) {
    return num * num;
}

console.log(cuadrado(5));
// Crea una función expresada que reciba un número y devuelva su cubo.
const cubo = function(num) {
    return num * num * num;
}
console.log(cubo(3));

// Explica brevemente la diferencia entre ambos tipos de funciones y cuándo se usan.
// Declarativa → function nombre() {} → se “sube” al inicio del código y podés usarla antes de declararla.
// Expresada → const nombre = function() {} → se guarda en una variable, y solo existe después de esa línea.

// Crea una arrow function que reciba un nombre y una edad.
// La edad debe ser opcional, con valor por defecto de 18.
// La función debe devolver un mensaje con el nombre y la edad.
// Ejemplo esperado: "Hola Ana, tienes 18 años".

const saludo = (nombre, edad = 18) => `Hola ${nombre}, tienes ${edad} años.`;

console.log(saludo("Ana"));
console.log(saludo("Luis", 25));

// Crea un objeto persona con: nombre, edad y un método para presentarlo que
// devuelva un mensaje de presentación.
// Explica la diferencia entre propiedades y métodos dentro de un objeto.
let persona = {
    nombre: "Carlos",
    edad: 30,
    presentarse: function() {
        return `Hola, me llamo ${this.nombre} y tengo ${this.edad} años.`;
    }
}
//propiedades
//Son valores (datos) asociados a un objeto.
// Representan las características o atributos de ese objeto.
// Se guardan como pares clave: valor

//métodos
//Son funciones asociadas a un objeto.
// Representan acciones o comportamientos que el objeto puede realizar.
// Se definen como funciones dentro del objeto.


// Usa desestructuración para obtener las propiedades del objeto persona y mostrar
// cada valor por separado.

let {nombre, edad, } = persona;
console.log(nombre);
console.log(edad);

// Explica qué ventajas tiene usar desestructuración sobre acceder a cada propiedad
// individualmente. 

//Menos líneas, más legible. Evita repetir el nombre del objeto muchas veces. Renombrar variables fácilmente

// Crea un array de números y agrega más números usando spread.
let numeros = [1, 2, 3];
let masNumeros = [0, ...numeros, 4, 5];
// Crea una función que reciba cualquier cantidad de números usando rest y calcule la
// suma.
function sumar(...nums) {
    return nums.reduce((a, b) => a + b, 0);
}
// Explica la diferencia entre spread y rest y cuándo se utiliza cada uno.
//Spread → Expande los elementos de un array u objeto en lugares donde se esperan múltiples elementos.
// Se usa en llamadas a funciones, literales de arrays y objetos.
//Rest → Agrupa múltiples elementos en un solo array u objeto.
// Se usa en definiciones de funciones para parámetros variables y en desestructuración.

// Selecciona el título con getElementById y cambia su texto con textContent.

let titulo = document.getElementById("titulo");
titulo.textContent = "Nuevo Título";

// Agrega un par de elementos nuevos a la lista usando createElement y appendChild.
let lista = document.getElementById("lista");
let nuevoElemento1 = document.createElement("li");
nuevoElemento1.textContent = "Elemento 4";
lista.appendChild(nuevoElemento1);
// Agrega o quita clases al título usando classList.add, remove o toggle.
titulo.classList.add("resaltado");
titulo.classList.remove("resaltado");
titulo.classList.toggle("resaltado");
 

//  Cuando el usuario escriba algo y haga clic en el botón, el texto ingresado debe
// agregarse a la lista como un nuevo <li>.
let boton = document.getElementById("boton");
let input = document.getElementById("inputTexto");

 boton.addEventListener("click", () => {
      const texto = input.value.trim(); // quitamos espacios vacíos

      if (texto !== "") {
        const li = document.createElement("li");
        li.textContent = texto;
        lista.appendChild(li);
 input.value = "";
      } else {
        alert("Por favor, escribe algo antes de agregar.");
      }
    });

//  Explica qué evento estás utilizando y por qué.
// El evento es "click", que se activa cuando el usuario hace clic en el botón.
// Se usa para ejecutar una función en respuesta a la acción del usuario de hacer click.

// Al enviar el formulario, previene que la página se recargue usando preventDefault.
let formulario = document.getElementById("formulario");
let inputTexto = document.getElementById("inputFormulario");
let mensaje = document.getElementById("mensaje");
  formulario.addEventListener("submit", (event) => {
      // Evita que la página se recargue al enviar el formulario
      event.preventDefault();

      // Tomamos el valor del input
      let valor = inputTexto.value.trim();

      if (valor !== "") {
        // Opción 1: Mostrar en una alerta
        // alert("Ingresaste: " + valor);

        // Opción 2: Mostrar dentro del DOM
        mensaje.textContent = "Ingresaste: " + valor;
      } else {
        mensaje.textContent = "Por favor, escribe algo.";
      }

      // Limpiamos el input
      inputTexto.value = "";});
// ● Explica para qué sirve preventDefault.
// Evita el comportamiento predeterminado del navegador, como recargar la página al enviar un formulario.


//  Detecta cuando el usuario presiona Enter en el input para agregar un nuevo elemento
// a la lista.
input.addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    event.preventDefault(); // evita que el formulario se envíe si está dentro de uno
    const texto = input.value.trim();

    if (texto !== "") {
      const li = document.createElement("li");
      li.textContent = texto;
      lista.appendChild(li);
      input.value = ""; // limpiar el campo
    } else {
      alert("Por favor, escribe algo antes de agregar.");
    }
  }
});

//  Agrega un <select> con opciones y detecta cuando el usuario cambia la selección
// usando el evento change.
//  Muestra en un párrafo cuál opción se seleccionó.
  const select = document.getElementById('miSelect');
    const resultado = document.getElementById('resultado');


    select.addEventListener('change', () => {
      const valorSeleccionado = select.value;

      if (valorSeleccionado) {
        resultado.textContent = `Has seleccionado: ${valorSeleccionado}`;
      } else {
        resultado.textContent = 'No has seleccionado ninguna opción.';
      }
    });

//  Explica la diferencia entre input, change y keydown
// input → se activa cada vez que cambia el valor del input (mientras escribís).
// change → se activa cuando el valor final del input cambia y pierde foco (o al seleccionar una opción en un select).
// keydown → se activa cuando se presiona una tecla, antes de que el carácter aparezca en el input.

