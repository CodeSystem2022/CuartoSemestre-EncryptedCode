//Clase 9 de Node, Andrea LLavel - CallbackHell
function hola(nombre, miCallback) {
    setTimeout(function() {
        console.log('Hola '+nombre);
        miCallback(nombre);
    }, 1000);
}

function hablar(callbackHablar) {
    setTimeout(function() {
       console.log('bla bla bla bla');
       callbackHablar();
    }, 1000);
}

//CallBack: significa lamar de nuevo o llamar de vuelta
function adios(nombre, otroCallback){
    setTimeout(function(){
         console.log('Adios'+ nombre);
         otroCallback();
    }, 1500);  //aca se le puede agregar mas tiempo
}

// Funcion Recursiva. Cuando la llamemos , necestamos el nombre, con quien empezamos hablar, luego las veces que queremos 
// hablar con la persona y lo que queremos que pase despues en el callback
function conversacion (nombre, veces, callback){   //Utilizar la recursividad
    if ( veces > 0) {     //En el if si hay mas veces que cero, al llegar a cero se ejecuta el callback.
        hablar( function () {   //La misma funcion hablar llama nuevamente a conversacion
            conversacion(nombre, --veces, callback);
        });    // Es mejor la recursividad
    } else {
        callback(nombre, callback);
    }
}

//-- Proceso principal
console.log('Iniciando el proceso...');
hola('Ariel', function (nombre) {

    conversacion(nombre, 4, function () {
        console.log('Terminando el proceso');
    });
});

//El callbackHell, no es una buena practica. Cuando se genera , debemos recurrir a una funcion recursiva, para solucionar el tema.
//hola('Carlos',function(nombre) {
 //Como podemos utilizar variables compartidas en los callback?
//   hablar(function(){
//        hablar( function() {
//            hablar( function() {
//              hablar ( function () {
//                    adios(nombre, function(){
//                       console.log('Terminando el proceso...'); 
//                    });
//                });
//            });
//        });   
//    });
//});


