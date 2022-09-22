

let passwordvista = document.querySelector(".password-vista");
let passwordnovista = document.querySelector(".password-no-visto");
let input_contrasena = document.querySelector("#password");

if (input_contrasena.type==="password") {
  passwordvista.style.display = "block";
  passwordnovista.style.display = "none";
} 
else {
  passwordvista.style.display = "none";
  passwordnovista.style.display = "block";
}

// cuando quiero ver el password
passwordvista.addEventListener("click", () => {

  input_contrasena.type = "text";
  passwordvista.style.display = "none";
  passwordnovista.style.display = "block";

});

// cuando quiero ocultar el password
passwordnovista.addEventListener("click", () => {

  input_contrasena.type = "password"; // se cambia el tipo de input
  passwordnovista.style.display = "none"; // se oculta el icon para no ver la contraseña 
  passwordvista.style.display = "block"; // se muestra el icon para ver la contras{a}
  

});

