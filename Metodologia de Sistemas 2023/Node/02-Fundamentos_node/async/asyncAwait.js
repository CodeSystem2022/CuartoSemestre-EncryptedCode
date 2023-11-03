//Clase 11. AsyncAwait. Andrea Llavel.
//El async nos esta mostrando , un formato sincrono
//La palabra async , no es necesaria en las funciones, porque ya son asincronas
//Igual proyectan una sincronia visual
async function hola(nombre) {
    return new Promise(function (resolve, reject)  {
    setTimeout(function() {
        console.log('Hola '+nombre);
        resolve(nombre);
    }, 1000);
});
}
//El async se puede utilizar sin await, estamos utlizamos promesas
async function hablar(nombre) {     //Usamos la sintaxis ES6
    return new Promise((resolve, reject) => {
    setTimeout(function() {
       console.log('bla bla bla bla');
       resolve();
    }, 1000);
});
}

//CallBack: significa llamar de nuevo o llamar de vuelta
async function adios(nombre){
    return new Promise((resolve, reject) => {
       setTimeout( function() {
          console.log('Adios'+ nombre);
         // resolve();
         resolve();
        }, 1000);  //aca se le puede agregar mas tiempo
    });
}

//await hola('Ariel');   //Esto es una mala sintaxis

//Asi se hace
//await solo es valido , dentro de una funcion asincrona
async function main(){   //Estamos dicinedo que nuestra funcion main, es asincrona
   let nombre = await hola('Ariel');   //Esperamos la funcion hola y despues continuamos
   await hablar();                //await no se puede usar , sin async
   await hablar();
   await hablar();
   await adios(nombre);
   console.log('Termina el proceso...')
}

//console.log('Empezamos el proceso...')
//main();
//console.log('Esta va a ser la segunda instruccion')

//the code written in Enghish. Await is only valid within an asynchronous function

function sayHello(name){
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            console.log("Hello"+name);
            resolve(name);
        }, 1000);
    });
}

function talk(name){
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            console.log("Bla bla bla bla");
            resolve(name);
        }, 1000);
    });
}

function sayBye(name){
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            console.log("Goodbye"+name);
            resolve(name);
        }, 1000);
    });
}

async function conversation(name){
    console.log('Code in English');
    console.log("Starting async process...");
    await sayHello(name);
    await talk();
    await talk();
    await talk();
    await sayBye(name);
    console.log("Process completed");
}

conversation("Ariel");
