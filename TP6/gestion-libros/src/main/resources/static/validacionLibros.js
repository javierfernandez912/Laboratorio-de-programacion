const formulario = document.getElementById("formulario_libros");
const inputTitulo = document.getElementById("titulo");
const inputAutor = document.getElementById("autor");
const inputEditorial = document.getElementById("editorial");
const inputAnio = document.getElementById("anio_edicion");
const selectGenero = document.getElementById("genero");

formulario.addEventListener("submit", function (event) {
    let validado = true;
    let mensajeError = "Carga de libros no válida. Se encontraron los siguientes errores:\n\n";

    // valida titulo (max 50)
    if (inputTitulo.value.length > 50 || inputTitulo.value.trim().length === 0) {
        mensajeError = mensajeError + "El título no puede estar vacío ni superar los 50 caracteres.\n";
        validado = false;
    }

    // valida autor (max 30)
    if (inputAutor.value.length > 30 || inputAutor.value.trim().length === 0) {
        mensajeError = mensajeError + "El autor no puede estar vacío ni superar los 30 caracteres.\n";
        validado = false;
    }

    // valida editorial (max 30)
    if (inputEditorial.value.length > 30 || inputEditorial.value.trim().length === 0) {
        mensajeError = mensajeError + "La editorial no puede estar vacía ni superar los 30 caracteres.\n";
        validado = false;
    }

    // valida año (entre 1000 y 2026)
    let anio = parseInt(inputAnio.value);
    if (isNaN(anio) || anio < 1000 || anio > 2026) {
        mensajeError = mensajeError + "El año de edición debe ser un número de 4 dígitos entre 1000 y 2026.\n";
        validado = false;
    }

    // valida genero. que el usuario haya seleccionado alguno.
    if (selectGenero.value === "" || selectGenero.value === null) {
        mensajeError = mensajeError + "Debe seleccionar un género temático de la lista desplegable.\n";
        validado = false;
    }

    // verifica que ninguna de las validaciones anteriores resulte en error.
    if (!validado) {
        event.preventDefault(); // frena el envio si habia un error
        alert(mensajeError); //muestra un mensaje con los errores
    }
});