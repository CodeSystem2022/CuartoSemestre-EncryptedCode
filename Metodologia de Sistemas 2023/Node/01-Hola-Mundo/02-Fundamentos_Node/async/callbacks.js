//Clase 8, Andrea LLavel
function hola(nombre, miCallback) {
    setTimeout(function() {
        console.log('Hola '+nombre);
        miCallback(nombre);
    }, 1000);
}
//CallBack: significa lamar de nuevo o llamar de vuelta
function adios(nombre, otroCallback){
    setTimeout(function(){
         console.log('Adios'+ nombre);
         otroCallback();
    }, 1500);  //aca se le puede agregar mas tiempo
}

console.log('Iniciando el proceso...');
hola('Carlos',function(nombre) {
 //Como podemos utilizar variables compartidas en los callback?
  adios(nombre, function(){
    console.log('Terminando el proceso...');
    });
});


//hola('Carlos', function(){});
//adios('Carlos', function(){});