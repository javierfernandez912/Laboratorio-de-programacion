const formulario = document.getElementById("formulario_libros");
const inputIdLibro = document.getElementById("id");
const inputTitulo = document.getElementById("titulo");
const inputAutor = document.getElementById("autor");
const inputEditorial = document.getElementById("editorial");
const inputAnio = document.getElementById("anio_edicion");

const inputIdGenero = document.getElementById("id_genero");
const inputNombreGenero = document.getElementById("nombre_genero");


formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    let validado = true;

    let mensajeError = "Carga de libros no válida. Se encontraron los siguientes errores:\n\n";

    if (inputIdLibro.value > 99999 || idLibro <= 0 || isNaN(idLibro)) {
        mensajeError = mensajeError + "El ID del libro debe ser un número mayor a 0 y menor a 99999.\n";
        validado = false;
    }

    if (inputTitulo.value.length > 50 || inputTitulo.value.trim().length == 0) {
        mensajeError = mensajeError + "El titulo no puede estar vacio ni superar los 50 caracteres.\n";
        validado = false;
    }

    if (inputAutor.value.length > 30 || inputAutor.value.trim().length == 0) {
        mensajeError = mensajeError + "El autor no puede estar vacio ni superar los 30 caracteres.\n";
        validado = false;
    }

    if (inputEditorial.value.length > 30 || inputEditorial.value.trim().length == 0) {
        mensajeError = mensajeError + "La editorial no puede estar vacia ni superar los 30 caracteres.\n";
        validado = false;
    }

    let anio = parseInt(inputAnio.value);
    if (anio > 2026 || isNaN(anio) || anio < 1000) {
        mensajeError = mensajeError + "El año de edición debe ser un número mayor 999 y menor a 2027.\n";
        validado = false;
    }

    let idGenero = parseInt(inputIdGenero.value);
    if (isNaN(idGenero) || idGenero <= 0 || inputIdGenero.value.length > 5) {
        mensajeError = mensajeError + "El ID del género debe ser un número positivo menor a 99999.\n";
        validado = false;
    }

    if (inputNombreGenero.value.length > 20 || inputNombreGenero.value.trim().length == 0) {
        mensajeError = mensajeError + "El nombre del género no puede estar vacio ni superar los 20 caracteres.\n";
        validado = false;
    }

    if (validado) {
        alert("Carga de libro realizada con éxito!\nFormulario enviado.");
    }
    else {
        alert(mensajeError);
    }
});

