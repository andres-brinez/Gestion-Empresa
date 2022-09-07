// seleccionar solo un checkbox
let checkboxes = document.querySelectorAll('input[type="checkbox"]')

checkboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', function() {
        checkboxes.forEach(function(otherCheckbox) {
            if (otherCheckbox !== checkbox)
                otherCheckbox.checked = false
        })
    })
})




const buttonEliminar = document.querySelector(".btnEliminar")
buttonEliminar.addEventListener("click", function(e) {


    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');

        // el value del checkbox es el id de la movimiento
        let idmovimiento = checkboxSeleccionado.value;

        // confirmar si se quiere eliminar la movimiento
        let confirmacion = confirm("¿Está seguro que desea eliminar la movimiento?");
        if(confirmacion){
            //redireciona a la página indicada con el atributo id
            window.location.href = "/EliminarMovimiento/"+idmovimiento;
        }



    }
    catch (e) {

        alert("No hay ninguna movimiento  seleccionada");
    }


})

//boton editar movimiento
const buttonEditar = document.querySelector('.btnEditar');

buttonEditar.addEventListener('click', function(e){

    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');
        // el value del checkbox es el id de la movimiento
        let idmovimiento = checkboxSeleccionado.value;


        //redireciona a la página indicada con el atributo id
        window.location.href = "/EditarMovimiento/"+idmovimiento;


    }
    catch (e) {

        alert("No hay ninguna movimiento  seleccionada");
    }






});
