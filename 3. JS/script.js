//EJERCICIO 1
let palabras = prompt("Ingrese 5 palabras").split(" ");
palabras.forEach(palabra => {
    console.log(palabra);
});

//EJERCICIO 2
palabras.unshift("primera") //insertamos el string y desplazamos los demas
palabras.push("ultima") //insertamos en la ultima posicion
palabras.splice(1, 1); //eliminarmos el que este en la posicion 1 de array que seria el segundo valor

palabras.forEach(palabra => { //mostramos por consola
    console.log(palabra);
});

//EJERCICIO 3
palabras.forEach(palabra => { //mostramos la palabra junto con su longitud
    console.log(palabrea + palabra.length);
});

let palabraMasLarga = palabras.reduce((a, b) => a.length > b.length ? a : b); //buscamos la palabra con mayor cantidad de caracteres
console.log("La palabra mas larga es: " + palabraMasLarga);

let contador = 0;
palabras.forEach(palabra => { 
    if (palabra.includes("a")) { //contamos cuántas palabras contienen la letra "a"
        contador++;
    }
});
console.log("La cantidad de palabras que contienen la letra 'a' es: " + contador);

//EJERCICIO 4
let invertidas = palabras.map(palabra => palabra.split("").reverse().join("")); //invertimos cada palabra usando split, reverse y join
console.log("Palabras invertidas: " + invertidas);

//EJERCICIO 5
let pregunta = prompt("¿Desea comprotabar palindromos? (si/no)").toLowerCase(); //preguntamos al usuario si desea comprobar palíndromos
if (pregunta == 'si' || pregunta == 'sí') {
    for (let i = 0; i < palabras.length; i++) { 
        if (palabras[i] === invertidas[i]) { //comparamos la palabra original con la invertida para ver si es palíndromo
            console.log("La palabra " + palabras[i] + " es un palindromo")
        } else {
            console.log("La palabra " + palabras[i] + " NO es un palindromo")
        }
    }
}

//EJERCICIO 6
let superPalabra="";
for (let i = 0; i < palabras.length; i++) {
    if (palabras[i].length>4) { //si la palabra tiene más de 4 caracteres la agregamos
        if(i!=0){
            superPalabra+="-"+palabras[i] //si no es la primera, agregamos un guion antes
        }else{
            superPalabra+=palabras[i] //si es la primera, la agregamos sin guion
        }
    }
}
console.log(superPalabra) //mostramos la cadena final de palabras largas unidas con guiones
