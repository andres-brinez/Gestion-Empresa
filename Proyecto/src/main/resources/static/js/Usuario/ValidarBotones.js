//---------Validar los botones que hay en la vista de Usuarios--------------------

// seleccionar solo un checkbox, llama la función creada
soloUnCheckbox()


const buttonEliminar = document.querySelector(".btnEliminar")
buttonEliminar.addEventListener("click", function(e) {EditarEliminar("eliminar")})

//boton editar usuario
const buttonEditar = document.querySelector('.btnEditar');
buttonEditar.addEventListener('click', function(e){EditarEliminar("editar")});


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

        // el value del checkbox es el id del usuario
        let idUsuario = checkboxSeleccionado.value;

        if (tipo == "eliminar") {

            Swal.fire({
                title: "¿Estás seguro que desea eliminar este usuario?",
                text: "No podrás revertir esto!",
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
                        window.location.href = "/EliminarUsuario/"+idUsuario;
                    }

                })
        } else if (tipo == "editar") {

            //redireciona a la página indicada con el atributo id
            window.location.href = "/EditarUsuario/"+idUsuario;
        }


    } catch (e) {
        // si no hay ningun checkbox seleccionado
        console.log(e);
        Swal.fire({
            title: 'No hay ningún usuario seleccionado',
            icon: 'question',

        })
    }

}