const formulario = document.getElementById("formulario_expedientes");
const inputExpediente = document.getElementById("numero_expediente");
const selectTipoTramite = document.getElementById("tipo_tramite");
const inputDias = document.getElementById("dias_tramite");
const inputResponsable = document.getElementById("responsable");
const contenedorErrores = document.getElementById("contenedor_errores");
const expedientesTrabajados = document.getElementById("cantidad_expedientes");
const horasTrabajadas = document.getElementById("horas_trabajadas");
const botonEstadistica = document.getElementById("boton_estadistica");
const divEstadistica = document.getElementById("div_estadistica");

let validado = false; // para saber si el expediente esta en buen formato o no.

const botonJson = document.getElementById("boton_json");
const resultadoJson = document.getElementById("resultado_json");

// a) Formateo del número de expediente. 
inputExpediente.addEventListener("blur", function () {
    let valor = inputExpediente.value;
    if (valor.length === 4 && !isNaN(valor)) { //si tiene 4 digitos y ES un numero
        // Formateás: EXP-XXXX/25
        inputExpediente.value = "EXP-" + valor + "/25";
    } else {         // O no tiene exactamente 4 digitos numericos o no es un numero
        alert("El expediente debe contener exactamente 4 números.");
        inputExpediente.value = "";
    }
});



// b) Mensaje según tipo de trámite

selectTipoTramite.addEventListener("change", function () {
    let tramiteSeleccionado = selectTipoTramite.value;

    if (tramiteSeleccionado == "urgente") {
        alert("Resolución dentro de las 24 horas");
    }
    else if (tramiteSeleccionado == "normal") {
        alert("Resolución dentro de las 48 horas");
    }
    else {
        alert("Resolución dentro de las 96 horas");
    }
});

//c) Validación de días en trámite

inputDias.addEventListener("blur", function () {
    if (inputDias.value.trim() === "") {
        alert("La cantidad de dias en tramite no puede estar vacia.");
    }
    else if (parseInt(inputDias.value) <= 0) {
        alert("La cantidad de dias en tramite no puede ser menor o igual que 0.");
    }
});



// e) Validación del responsable

inputResponsable.addEventListener("input", function () {
    let textoModificado = inputResponsable.value.toUpperCase(); //pasa el nombre a mayusculas
    inputResponsable.value = textoModificado.replace(/[0-9]/g, ""); //borra todos los numeros que se intentan ingresar.
});


formulario.addEventListener("reset", function () { //cuando toca el boton de limpiar borra los mensajes de error
    contenedorErrores.innerHTML = "";
    divEstadistica.innerHTML = "";
    resultadoJson.textContent = "";
});


// f) Validación general del formulario
formulario.addEventListener("submit", function (event) {
    validado = false;
    event.preventDefault();
    let todoOk = true;
    contenedorErrores.innerHTML = "";

    let formatoValido = /^EXP-[0-9]{4}\/25$/.test(inputExpediente.value);

    if (!formatoValido) {
        contenedorErrores.innerHTML += "<p style='color: red;'>Error: El número de expediente debe tener el formato de 4 números (se guardará como EXP-0000/25).</p>";
        todoOk = false;
    }
    let dias = parseInt(inputDias.value);
    if (isNaN(dias) || dias <= 0) {
        contenedorErrores.innerHTML += "<p style='color: red;'>Error: Los días de trámite deben ser números y mayores a 0.</p>";
        todoOk = false;
    }

    // d) Validación del estado
    let radioChequeado = document.querySelector('input[name="estado"]:checked');
    if (!radioChequeado) {
        contenedorErrores.innerHTML += "<p style='color: red;'>Error: Debe seleccionar un estado.</p>";
        todoOk = false;
    }

    // e) Validación del responsable
    let tieneNumeros = /[0-9]/.test(inputResponsable.value);
    if (tieneNumeros || inputResponsable.value.trim() === "") {
        contenedorErrores.innerHTML += "<p style='color: red;'>Error: El responsable es obligatorio y no puede tener números.</p>";
        todoOk = false;
    }


    if (todoOk) { //si paso todas las validaciones muestra el mensaje de validacion
        validado = true;
        contenedorErrores.innerHTML = "<p style='color: green;'>Expediente validado correctamente</p>";
    }
    else {
        validado = false;
    }
});
// 4 a) Cálculo de productividad
botonEstadistica.addEventListener("click", function () {
    if (isNaN(expedientesTrabajados.value) || isNaN(horasTrabajadas.value) || horasTrabajadas.value <= 0) {
        alert("Expedientes trabajados y Horas trabajadas deben ser numeros. Horas trabajadas no puede ser menor o igual a 0.");
    }
    else {
        let productividad = expedientesTrabajados.value / horasTrabajadas.value;
        let nivelProductividad = "";
        let mensajeAdicional = "";

        if (productividad < 2) {
            nivelProductividad = "bajo";
        }
        else if (productividad >= 2 && productividad <= 5) {
            nivelProductividad = "medio";
        }
        else {
            nivelProductividad = "alto";
            mensajeAdicional = "Buen rendimiento!";
        }

        let mensajeFinal = "El nivel de productividad fue " + nivelProductividad + ". " + mensajeAdicional;
        divEstadistica.innerHTML = "<p>Productividad: " + productividad + " → " + nivelProductividad + ". " + mensajeAdicional + "</p>";
    }
});

//5
botonJson.addEventListener("click", function () {

    //c) Validación previa.
    if (!validado) {
        alert("Error: Primero debe validar el expediente correctamente antes de generar el JSON.");
        resultadoJson.textContent = ""; // limpia el campo del json por si antes se genero uno
    }
    else {
        let expedienteObjeto = { //a) creacion del objeto expediente
            numero: inputExpediente.value,
            area: document.getElementById("area").value,
            tramite: selectTipoTramite.value,
            dias: parseInt(inputDias.value),
            estado: document.querySelector('input[name="estado"]:checked').value,
            responsable: inputResponsable.value
        };

        // b) Conversión a formato JSON. Utilizar la función JSON.stringify() para convertir el objeto a formato JSON 
        let jsonFormateado = JSON.stringify(expedienteObjeto, null, 4);

        //d) Mostrar el JSON generado en pantalla dentro de un <pre> o <textarea>. 
        resultadoJson.textContent = jsonFormateado;

    }
});

formulario.addEventListener("input", function () { //en caso de modificar cualquier valor, la bandera de validado vuelve a false.
    validado = false;
    document.getElementById("resultado_json").textContent = ""; //limpia el campo del json
});

