
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


//boton editar empleado
const buttonEditar = document.querySelector('.btnEditar');

buttonEditar.addEventListener('click', function(e){

    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');
        // el value del checkbox es el id de la empleado
        let idempleado = checkboxSeleccionado.value;


        //redireciona a la página indicada con el atributo id
        window.location.href = "/EditarEmpleado/"+idempleado;


    }
    catch (e) {

        alert("No hay ninguna empleado  seleccionada");
    }






});

const buttonEliminar = document.querySelector(".btnEliminar")
buttonEliminar.addEventListener("click", function(e) {


    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');

        // el value del checkbox es el id de la empleado
        let idempleado = checkboxSeleccionado.value;

        // confirmar si se quiere eliminar la empleado
        let confirmacion = confirm("¿Está seguro que desea eliminar la empleado?");
        if(confirmacion){
            //redireciona a la página indicada con el atributo id
            window.location.href = "/EliminarEmpleado/"+idempleado;
        }



    }
    catch (e) {

        alert("No hay ninguna empleado  seleccionada");
    }


})

// Ver los movimientos del empleado seleccionado
const buttonMovimiento = document.querySelector(".btnMovimientos")
buttonMovimiento.addEventListener("click", function(e) {


    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');

        // el value del checkbox es el id de la empleado
        let idempleado = checkboxSeleccionado.value;


        //redireciona a la página indicada con el atributo id

        window.location.href = "Empleado/"+idempleado+"/Movimientos";


    }
    catch (e) {

        alert("Seleccione una empleado para ver sus movimientos");
    }


})