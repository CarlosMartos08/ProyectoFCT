window.addEventListener("load",function(ev){
    ev.preventDefault()
    plantillaAnuncio = traerPlantilla("../resources/templates/anuncio.html")

    listaInmuebles = traerInmuebles()

    var contenedor = document.getElementsByClassName("contenedor")[0].children[0]
    contenedor.innerHTML=""

    var anuncioCarrusel = document.getElementsByClassName("anuncioCarrusel")[0]

    for(let i=0; i<listaInmuebles.length; i++){

        clonAnuncioCarrusel = anuncioCarrusel.cloneNode(true)
        clonAnuncioCarrusel.getElementsByClassName("banos")[0].innerHTML = listaInmuebles[i].banos + " baños"
        clonAnuncioCarrusel.getElementsByClassName("direccion")[0].innerHTML = listaInmuebles[i].direccion
        clonAnuncioCarrusel.getElementsByClassName("habs")[0].innerHTML = listaInmuebles[i].habs + " habitaciones"
        clonAnuncioCarrusel.getElementsByClassName("precio")[0].innerHTML = listaInmuebles[i].precio.toLocaleString("es", {style: "currency", currency: "EUR"});
        clonAnuncioCarrusel.getElementsByClassName("provincia")[0].innerHTML = listaInmuebles[i].localidad + ", " + listaInmuebles[i].provincia
        clonAnuncioCarrusel.getElementsByClassName("imagen")[0].src = listaInmuebles[i].imagenes[0].img_url + listaInmuebles[i].imagenes[0].nombre_img
        clonAnuncioCarrusel.getElementsByClassName("imagen")[0].setAttribute("name",listaInmuebles[i].id_inmueble)
        clonAnuncioCarrusel.getElementsByClassName("detalles")[0].setAttribute("name",listaInmuebles[i].id_inmueble);
        clonAnuncioCarrusel.getElementsByClassName("imagen")[0].onclick=mostrarDetalles(clonAnuncioCarrusel.getElementsByClassName("imagen")[0].getAttribute("name"));
        clonAnuncioCarrusel.getElementsByClassName("detalles")[0].onclick=mostrarDetalles(clonAnuncioCarrusel.getElementsByClassName("detalles")[0].getAttribute("name"));
        clonAnuncioCarrusel.setAttribute("id","tns1-item"+i)
        clonAnuncioCarrusel.setAttribute("class","property-item tns-item")
        clonAnuncioCarrusel.setAttribute("aria-hidden","true")
        clonAnuncioCarrusel.setAttribute("tabindex","-1")
        anuncioCarrusel.parentElement.appendChild(clonAnuncioCarrusel);


        clonAnuncio = plantillaAnuncio.cloneNode(true)
        clonAnuncio.getElementsByClassName("banos")[0].innerHTML = listaInmuebles[i].banos + " baños"
        clonAnuncio.getElementsByClassName("direccion")[0].innerHTML = listaInmuebles[i].direccion
        clonAnuncio.getElementsByClassName("habs")[0].innerHTML = listaInmuebles[i].habs + " habitaciones"
        clonAnuncio.getElementsByClassName("precio")[0].innerHTML = listaInmuebles[i].precio.toLocaleString("es", {style: "currency", currency: "EUR"});
        clonAnuncio.getElementsByClassName("provincia")[0].innerHTML = listaInmuebles[i].localidad + ", " + listaInmuebles[i].provincia
        clonAnuncio.getElementsByClassName("imagen")[0].src = listaInmuebles[i].imagenes[0].img_url + listaInmuebles[i].imagenes[0].nombre_img
        clonAnuncio.getElementsByClassName("imagen")[0].setAttribute("name",listaInmuebles[i].id_inmueble)
        clonAnuncio.getElementsByClassName("detalles")[0].setAttribute("name",listaInmuebles[i].id_inmueble);
        clonAnuncio.getElementsByClassName("imagen")[0].onclick=mostrarDetalles(clonAnuncio.getElementsByClassName("imagen")[0].getAttribute("name"));
        clonAnuncio.getElementsByClassName("detalles")[0].onclick=mostrarDetalles(clonAnuncio.getElementsByClassName("detalles")[0].getAttribute("name"));


        contenedor.appendChild(clonAnuncio)
    }

    // document.getElementsByClassName("detalles").onclik = mostrarDetalles();


})

function mostrarDetalles(id_inmueble){
    return function(ev) {
        ev.preventDefault();
        plantillaPropiedad = traerPlantilla("../resources/templates/propiedad.html");
        inmueble = traerInmueble(id_inmueble)

        plantillaPropiedad.getElementsByClassName("banos")[0].innerHTML = inmueble.banos + " baños"
        plantillaPropiedad.getElementsByClassName("direccion")[0].innerHTML = inmueble.direccion
        plantillaPropiedad.getElementsByClassName("habs")[0].innerHTML = inmueble.habs + " habitaciones"
        plantillaPropiedad.getElementsByClassName("provincia")[0].innerHTML = inmueble.localidad + ", " + inmueble.provincia
        plantillaPropiedad.getElementsByClassName("imagen")[0].src = inmueble.imagenes[0].img_url + inmueble.imagenes[0].nombre_img
        plantillaPropiedad.getElementsByClassName("metros")[0].innerHTML = inmueble.m2 + ' m2'
        plantillaPropiedad.getElementsByClassName("descripcion")[0].innerHTML = inmueble.descripcion

        document.getElementsByClassName("titulo")[0].innerHTML = inmueble.direccion
        document.getElementsByClassName("contenedor")[0].children[0].innerHTML = "";
        document.getElementsByClassName("contenedor")[0].children[0].appendChild(plantillaPropiedad)


    }
}

function traerInmueble(id){
    var ajax=new XMLHttpRequest();
    ajax.open("GET","http://localhost:8080/inmuebles/"+id, false);
    ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajax.send();
    respuesta = JSON.parse(ajax.responseText);
    return respuesta;
}


function traerPlantilla(url){
    var ajax=new XMLHttpRequest();
    ajax.open("GET",url,false);
    ajax.send();
    var textoPlantilla=ajax.responseText;
    var div=document.createElement("div");
    div.innerHTML=textoPlantilla;
    return div.children[0];
}

function traerInmuebles(){
    var ajax=new XMLHttpRequest();
    ajax.open("GET", "http://localhost:8080/inmuebles/", false);
    ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajax.send();
    respuesta = JSON.parse(ajax.responseText);
    return respuesta;
}




// Función para leer un inmueble de la base de datos
function readInmueble(id) {
    // Aquí iría el código para obtener un inmueble de la base de datos por su ID
}

// Función para actualizar un inmueble en la base de datos
function updateInmueble(id, nombre, direccion, precio) {
    // Aquí iría el código para actualizar un inmueble en la base de datos
}

// Función para eliminar un inmueble de la base de datos
function deleteInmueble(id) {
    // Aquí iría el código para eliminar un inmueble de la base de datos
}




// Función para crear un Persona en la base de datos
function createPersona(nombre) {
    // Aquí iría el código para insertar un nuevo inmueble en la base de datos
}

// Función para leer un Persona de la base de datos
function readPersona(id) {
    // Aquí iría el código para obtener un Persona de la base de datos por su ID
}

// Función para actualizar un Persona en la base de datos
function updatePersona(id, nombre) {
    // Aquí iría el código para actualizar un Persona en la base de datos
}

// Función para eliminar un Persona de la base de datos
function deletePersona(id) {
    // Aquí iría el código para eliminar un Persona de la base de datos
}


// ajax.open("GET","http://localhost:8080/inmuebles/");
// ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

// // Función para crear un inmueble en la base de datos
// function createInmueble(descripcion, habs, banos, m2, precio, direccion, localidad, provincia) {
//     // Aquí iría el código para insertar un nuevo inmueble en la base de datos
//
//     // Crear un objeto JavaScript
//     var datos = {
//         descripcion: 'John',
//         habs: 30,
//         banos: 2,
//         m2: 200,
//         precio: 1212,
//         direccion:"HOla",
//         localidad:"Hola",
//         provincia:"Hola"
//     };
//
// // Convertir el objeto a una cadena JSON
//     var jsonString = JSON.stringify(datos);
//
// // Imprimir la cadena JSON en la consola
//     console.log(jsonString);
//
//     var ajax=new XMLHttpRequest();
//     ajax.onreadystatechange=function() {
//         if (this.readyState == 4 && this.status == 200) {
//             var respuesta = JSON.parse(this.responseText);
//             console.log(respuesta);
//             if (respuesta.success) {
//
//             } else {
//                 var mensajeError = respuesta.error;
//                 muestraError(trVisita, mensajeError, "visita_solapada");
//             }
//         }
//     }
//     ajax.open("POST","http://localhost:8080/personas/insertar/");
//     ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     ajax.send(datos);
// }