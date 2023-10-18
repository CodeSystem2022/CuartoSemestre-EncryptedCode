//Clase 10, Andrea LLavel
function hola(nombre) {
    return new Promise(function (resolve, reject)  {
    setTimeout(function() {
        console.log('Hola '+nombre);
        resolve(nombre);
    }, 1000);
});
}

function hablar(nombre) {     //Usamos la sintaxis ES6
    return new Promise((resolve, reject) => {
    setTimeout(function() {
       console.log('bla bla bla bla');
       resolve();
    }, 1000);
});
}

//CallBack: significa lamar de nuevo o llamar de vuelta
function adios(nombre){
    return new Promise((resolve, reject) => {
       setTimeout( function() {
          console.log('Adios'+ nombre);
         // resolve();
         reject('Hay un error');
        }, 1000);  //aca se le puede agregar mas tiempo
    });
}

//Llamado a la funcion
console.log('Iniciando el proceso...');
hola('Ariel')
    .then(hablar)
    .then(hablar)
    .then(hablar)
    .then(adios)
    .then((nombre) => {
        console.log('Terminando el proceso');
    })
    .catch(error => {
        console.log('Ha habido un error: ');
        console.log(error);
    }) 
