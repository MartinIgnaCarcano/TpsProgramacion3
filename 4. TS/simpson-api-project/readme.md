Ejercicio 1.2
El comando "npm init -y" crea el fichero package.json y su finalidad es mantener un historial de los paquetes instalados y optimizar la forma en que se generan las dependencias del proyecto y los contenidos de la carpeta node_modules/

Ejercicio 1.3
--save-dev  Se utiliza para guardar el paquete con fines de desarrollo. Ejemplo: pruebas unitarias, minimización...
--save      Se utiliza para guardar el paquete necesario para que se ejecute la aplicación.

Ejercicio 1.4
strict --> Cuando está en true, habilita una serie de verificaciones más rigurosas del compilador para ayudarte a encontrar errores antes de ejecutar el código.
outDir --> Por defecto, TypeScript genera los archivos .js en el mismo lugar que los .ts, pero con outDir podés organizarlos mejor.
target --> El target determina el estándar de JS que se generará.

Ejercicio 1.5
🔹 "build": "tsc"
- Qué hace:
Ejecuta el comando tsc (TypeScript Compiler).
Esto transpila todos los archivos TypeScript (.ts) del proyecto a JavaScript (.js) siguiendo la configuración del archivo tsconfig.json.
- Cuándo se usa:
Cuando querés compilar el proyecto una sola vez, por ejemplo antes de desplegarlo (deploy) o al probar una versión estable.

🔹 watch": "tsc --watch"
- Qué hace:
Ejecuta el compilador de TypeScript en modo “observación” (watch mode).
El comando --watch le indica al compilador que observe los archivos .ts y los vuelva a compilar automáticamente cada vez que se detecta un cambio.
- Cuándo se usa:
Cuando estás desarrollando activamente y querés que la compilación sea automática cada vez que guardás un archivo.
Evita tener que ejecutar npm run build manualmente cada vez.