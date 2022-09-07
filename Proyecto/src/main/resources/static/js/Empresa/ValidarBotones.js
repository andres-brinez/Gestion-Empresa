
//Validar los botones que hay en la vista de Empresa

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


//boton Ver empleados
const buttonEmpleados = document.querySelector('.btnEmpleados');

buttonEmpleados.addEventListener('click', function(e){

    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');
        // el value del checkbox es el id de la empresa
        let idEmpresa = checkboxSeleccionado.value;


        //redireciona a la página indicada con el atributo id
        window.location.href = "/Empresa/"+idEmpresa+"/Empleados";


    }
    catch (e) {

        alert("No hay ninguna Empresa  seleccionada");
    }






});

const buttonEliminar = document.querySelector(".btnEliminar")
buttonEliminar.addEventListener("click", function(e) {


    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');

        // el value del checkbox es el id de la empresa
        let idEmpresa = checkboxSeleccionado.value;

        // confirmar si se quiere eliminar la empresa
        let confirmacion = confirm("¿Está seguro que desea eliminar la empresa?");
        if(confirmacion){
            //redireciona a la página indicada con el atributo id
            window.location.href = "/EliminarEmpresa/"+idEmpresa;
        }



    }
    catch (e) {

        alert("No hay ninguna Empresa  seleccionada");
    }


})

//boton editar Empresa
const buttonEditar = document.querySelector('.btnEditar');

buttonEditar.addEventListener('click', function(e){

    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');
        // el value del checkbox es el id de la empresa
        let idEmpresa = checkboxSeleccionado.value;


        //redireciona a la página indicada con el atributo id
        window.location.href = "/EditarEmpresa/"+idEmpresa;


    }
    catch (e) {

        alert("No hay ninguna Empresa  seleccionada");
    }

});

// Ver los movimientos de la empresa seleccionada
const buttonMovimiento = document.querySelector(".btnMovimientos")
buttonMovimiento.addEventListener("click", function(e) {


    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');

        // el value del checkbox es el id de la empresa
        let idempleado = checkboxSeleccionado.value;


        //redireciona a la página indicada con el atributo id

        window.location.href = "Empresa/"+idempleado+"/Movimientos";


    }
    catch (e) {

        alert("Selecciona la empresa para ver sus momovimientos");
    }


})
