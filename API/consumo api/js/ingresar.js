"use strict";

// Maneja el formulario de registro de proveedores
const formProveedor = document.getElementById("studentForm");
if (formProveedor) {
  formProveedor.addEventListener("submit", async (event) => {
    event.preventDefault(); // Evita el envío del formulario de forma tradicional

    // Obtén los datos del formulario
    const formData = new FormData(formProveedor);
    const datos = Object.fromEntries(formData.entries());

    // Log de los datos enviados para depuración
    console.log("Datos enviados (Ventas):", {
      estuCedula: datos.cedula,
      estuApellidos: datos.apellido,
      estuNombres: datos.nombre,
      estuResidencia: datos.direccionCasa,
      estuTrabajo: datos.direccionTrabajo,
      // Cambiamos la estructura de las coordenadas a objetos con latitud y longitud
      estuUbiResidencia: { latitude: parseFloat(datos.latitudCasa), longitude: parseFloat(datos.longitudCasa) },
      estuUbiTrabajo: { latitude: parseFloat(datos.latitudTrabajo), longitude: parseFloat(datos.longitudTrabajo) },
    });

    try {
      const response = await fetch("http://localhost:8080/conexion/datosAG", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          estuCedula: datos.cedula,
          estuApellidos: datos.apellido,
          estuNombres: datos.nombre,
          estuResidencia: datos.direccionCasa,
          estuTrabajo: datos.direccionTrabajo,
          // Cambiamos la estructura de las coordenadas a objetos con latitud y longitud
          estuUbiResidencia: { latitude: parseFloat(datos.latitudCasa), longitude: parseFloat(datos.longitudCasa) },
          estuUbiTrabajo: { latitude: parseFloat(datos.latitudTrabajo), longitude: parseFloat(datos.longitudTrabajo) },
        }),
      });

      if (response.ok) {
        alert("Registro exitoso");
        formProveedor.reset(); // Reinicia el formulario
      } else {
        console.error("Error al registrar (Producto):", await response.text());
        alert("Error al registrar.");
      }
    } catch (error) {
      console.error("Error (Producto):", error);
      alert("Error en la conexión con el servidor.");
    }
  });
}
