
//---------Validar los botones que hay en la vista de Empresa---------------------

// seleccionar solo un checkbox, llama la función creada
soloUnCheckbox()

// al dar click en el boton

const buttonEliminar = document.querySelector(".btnEliminar")
buttonEliminar.addEventListener("click", function(e) {EditarEliminar("eliminar" )})

const buttonEditar = document.querySelector('.btnEditar');
buttonEditar.addEventListener('click', function(e){EditarEliminar("editar")});


// Ver los movimientos de la empresa seleccionada
const buttonMovimientosEmpresa = document.querySelector(".btnMovimientos")
buttonMovimientosEmpresa.addEventListener("click", function(e) {EmpleadoMovimiento("Movimientos");})

//ver los empleados de la empresa seleccionada
const buttonEmpleadosEmpresa = document.querySelector('.btnEmpleados-Empresa');
buttonEmpleadosEmpresa.addEventListener('click', function(e){EmpleadoMovimiento("Empleados")});


//------------------------FUNCIONES---------------------

// función para seleccionar solo un checkbo
function soloUnCheckbox() {

    let checkboxes = document.querySelectorAll('input[type="checkbox"]')

    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            checkboxes.forEach(function(otherCheckbox) {
                if (otherCheckbox !== checkbox)
                    otherCheckbox.checked = false
            })
        })
    })
}

// con tipo indicamos si es editar o eliminar
function EditarEliminar(tipo){

    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');

        // el value del checkbox es el id de la empresa
        let idEmpresa = checkboxSeleccionado.value;

        if (tipo === "eliminar") {

            Swal.fire({
                title: "¿Estás seguro que desea eliminar esta empresa?",
                text: "No podras revertir esto!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si',
                cancelButtonText: 'Cancelar'
            })
                .then((result) => {
                    if (result.isConfirmed) {
                        //redireciona a la página indicada con el atributo id
                        window.location.href = "/EliminarEmpresa/" + idEmpresa;
                    }

                })
        }
        else if (tipo === "editar") {

            // redireciona a la página indicada con el atributo id
            window.location.href = "/EditarEmpresa/" + idEmpresa;
        }




    }

    catch (e) {
        // si no hay ningun checkbox seleccionado
        Swal.fire({
            title: 'No hay ninguna empresa seleccionada',
            text: "Seleccione una para poder realizar esta acción",
            icon: 'question',

        })
    }

}

// con tipo indicamos si es para Empleados o Movimientos
function EmpleadoMovimiento(tipo){
    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');
        // el value del checkbox es el id de la empresa
        let idEmpresa = checkboxSeleccionado.value;

        if(tipo=== "Empleados"){
            //redireciona a la página indicada con el atributo id
            window.location.href = "/Empresa/"+idEmpresa+"/Empleados";
        }

        else if (tipo=== "Movimientos") {
            //redireciona a la página indicada con el atributo id
            window.location.href = "/Empresa/"+idEmpresa+"/Movimientos";
        }



    }
    catch (e) {
        // si no hay ningun checkbox seleccionado
        Swal.fire({
            title: 'No hay ninguna empresa seleccionada',
            text: "Seleccione una  para poder realizar esta acción",
            icon: 'question',

        })
    }

}