//---------Validar los botones que hay en la vista de Emleados--------------------

// seleccionar solo un checkbox, llama la función creada
soloUnCheckbox()


//boton editar empleado
const buttonEditar = document.querySelector('.btnEditar');
buttonEditar.addEventListener('click', function(e){EditarEliminar("editar")});

//boton eliminar empleado
const buttonEliminar = document.querySelector(".btnEliminar")
buttonEliminar.addEventListener("click", function(e) {EditarEliminar("eliminar")});

// Ver los movimientos del empleado seleccionado
const buttonMovimiento = document.querySelector(".btnMovimientos")
buttonMovimiento.addEventListener("click", function(e) {
    e.preventDefault();


    try{

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');

        // el value del checkbox es el id de la empleado
        let idempleado = checkboxSeleccionado.value;


        //redireciona a la página indicada con el atributo id

        window.location.href = "/Empleado/"+idempleado+"/Movimientos";


    }
    catch (e) {

        Swal.fire({
            title: 'No hay ningún empleado seleccionado',
            icon: 'question',

        })
    }


})

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

    try {

        // saber cual checkbox esta seleccionado
        let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked');

        // el value del checkbox es el id del empleado
        let idempleado = checkboxSeleccionado.value;

        if (tipo === "eliminar") {

            Swal.fire({
                title: "¿Estás seguro que desea eliminar este empleado?",
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
                        window.location.href = "/EliminarEmpleado/" + idempleado;
                    }

                })
        } else if (tipo === "editar") {

            //redireciona a la página indicada con el atributo id
            window.location.href = "/EditarEmpleado/" + idempleado;
        }


    } catch (e) {
        // si no hay ningun checkbox seleccionado
        Swal.fire({
            title: 'No hay ningún empleado seleccionado',
            icon: 'question',

        })
    }

}
