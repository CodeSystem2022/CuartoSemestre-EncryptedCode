console.log('Inicio del Programa');  // 1
setTimeout(() =>{
    console.log('Primer Timeout');  // 5
}, 3000);

setTimeout(() =>{
    console.log('Segundo Timeout'); // 3
}, 0);

setTimeout(() =>{
    console.log('Tercero Timeout'); // 4
}, 0);

console.log('Fin de Programa');  // 2

//Todo es sincrono, instrucciones no bloqueantes