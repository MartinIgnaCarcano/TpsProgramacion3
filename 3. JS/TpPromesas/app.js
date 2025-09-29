// Creá una función getUserById(id, callback) que reciba:
// un id de usuario,

// una función callback que se ejecutará después de 1.5 segundos.
// 2. Dentro del setTimeout, buscá el usuario con find.
// 3. Si existe → devolver el usuario.
// 4. Si no existe → devolver un error.
const users = [
  { id: 1, name: "Ana" },
  { id: 2, name: "Luis" },
  { id: 3, name: "María" },
];
function hola() {
  console.log("hola");
}

function getUserById(id, callback) {
  const resultado = users.find((user) => user.id === id);

  if (resultado !== undefined) {
    console.log(resultado); // Muestra el usuario

    // Espera 1 segundo antes de ejecutar el callback
    setTimeout(() => {
      callback(); // Llamada al callback
    }, 1000);
  } else {
    console.log("error");
  }
}

// 1. Creá una función getUserByIdPromise(id) que retorne una Promesa.
// 2. Usá resolve si se encuentra el usuario y reject si no existe.
// 3. Probá la función con .then() y .catch().

function getUserByIdPromise(id) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const resultado = users.find((user) => user.id === id);
      if (resultado !== undefined) {
        resolve("usuario");
      } else {
        reject("error reject");
      }
    }, 1500);
  });
}

// 1. Creá una función async function fetchUser(id).
// 2. Usá await para esperar el resultado de getUserByIdPromise(id).
// 3. Manejá el error con try/catch.
async function fetchUser(id) {
  try {
    const respuesta = await getUserByIdPromise(id);
    console.log(respuesta)
  } catch {
    console.log("entre en el catch");
  }
}
