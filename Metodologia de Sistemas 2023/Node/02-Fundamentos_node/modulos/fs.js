//Andrea llavel. Clase 13.
//La ruta que estamos poniendo txt es relativa al directorio en el cual se ejecuta, node o nodemon,pero no es relativa
//al directorio en el que se encuentra el archivo js en ejecucion
const fs = require('fs');

//Primero leemos el archivo.txt
function leer(ruta, cb) {
    fs.readFile(ruta, (err, data)=> {
        cb(data.toString());
    })
}

//Segundo escribimos el archivo1.txt creandolo y escribiendo en el
function escribir(ruta, contenido) {
    fs.writeFile(ruta, contenido, function (err){
        if (err){
            console.log('No se ha podido escribir', err);
        } else {
            console.log('Se ha escrito correctamente');
        }
    })
}

//Tercero eliminamos el archivo.txt
function borrar(ruta, cb) {
    fs.unlink(ruta, cb); //elimina de manera asincrona
}

borrar(`${__dirname}/archivo.txt`, console.log);  //el console.log apunta al callback y es quien nos responde null,
//si lo quitamos nos daria un  error. porque no lo estaria encontrando. Encontramos un null, porque no hay ningun error
//si escribimos un archivo, que ya existe, se sobreescibe
//escribir(`${__dirname}/archivo.txt`, 'Reescribimos el archivo', console.log);
//leer(`${__dirname}/archivo.txt`, console.log);  //Sintaxis ES6