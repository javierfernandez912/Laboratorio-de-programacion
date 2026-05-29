const enlacesRelacionados = document.querySelectorAll(".barra_lateral a");

enlacesRelacionados.forEach(function (enlace) { //recorre todos los enlaces de la barra lateral
    enlace.addEventListener("click", function (event) {

        let tituloArticulo = enlace.textContent; //recupera el nombre del articulo de la barra lateral
        alert("Abriendo el articulo: '" + tituloArticulo + "'"); //muestra un mensaje
    });
});


const botonesLeerMas = document.querySelectorAll(".leer_mas");

botonesLeerMas.forEach(function (boton) { //recorre todos los botones de leer mas
    boton.addEventListener("click", function () {
        let articuloPadre = boton.parentElement;
        let tituloPrincipal = articuloPadre.querySelector("h1").textContent; //recupera el titulo del articulo

        alert("Gracias por tu interes!\nEl articulo completo sobre '" + tituloPrincipal + "' aun no esta disponible."); //muestra un mensaje
    });
});