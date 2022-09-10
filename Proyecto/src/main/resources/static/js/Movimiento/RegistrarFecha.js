// registrar fecha de movimiento automaticamente
window.onload = function() { // al cargar la página
    // traer la fehca actual y la pasa a json, solo trae los numeros del 1 a 10 y remplaza los / por -
    document.getElementById("fechaRegistro").value=new Date().toJSON().slice(0,10).replace(/-/g,'-');
}