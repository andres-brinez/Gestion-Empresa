// registrar fecha de movimiento automaticamente
window.onload = function() { // al cargar la página

    // traer fecha actual en formato "yyyy-MM-dd"
    let fechaActual = new Date().toISOString().slice(0,10);

    // campo fecha
    let campoFecha= document.getElementById("fechaRegistro")

    campoFecha.value = fechaActual;



}