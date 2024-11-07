document.addEventListener("DOMContentLoaded", async () => {
  // Función para obtener y mostrar los datos de la base de datos
  const fetchProducto = async () => {
    try {
      // Realizamos una petición GET a la API que devuelve todos los administradores
      const response = await fetch("http://localhost:8080/conexion/datos");
      if (response.ok) {
        const administradores = await response.json();

        // Seleccionamos el tbody donde se van a mostrar los datos
        const proTableBody = document.getElementById("proTableBody");
        proTableBody.innerHTML = ""; // Limpiamos cualquier dato previo

        // Iteramos sobre los administradores y los agregamos a la tabla
        administradores.forEach((estu) => {
          const row = document.createElement("tr");

          // Crear las columnas con los datos del estudiantes
          row.innerHTML = `
              <td>${estu.estuCedula}</td>
              <td>${estu.estuApellido}</td>
              <td>${estu.estuLatitudResidencia}</td>
              <td>${estu.estuLatitudTrabajo}</td>
              <td>${estu.estuLongitudResidencia}</td>
              <td>${estu.estuLongitudTrabajo}</td>
              <td>${estu.estuNombre}</td>
              <td>${estu.estuResidencia}</td>
              <td>${estu.estuTrabajo}</td>
              <td>
                <button class="btn btn-danger btn-delete" data-id="${estu.estuCedula}">Eliminar</button>
              </td>
            `;

          proTableBody.appendChild(row);
        });
        // Agregar evento a los botones de eliminar
        document.querySelectorAll(".btn-delete").forEach((button) => {
          button.addEventListener("click", (event) => {
            const id = event.target.getAttribute("data-id");
            eliminarProducto(id);
          });
        });
      } else {
        console.error("Error al obtener los productos:", response.status);
      }
    } catch (error) {
      console.error("Error en la conexión:", error);
    }
  };

  // Llamamos a la función para obtener los datos cuando cargue la página
  fetchProducto();
});

const eliminarProducto = async (id) => {
  const confirmacion = confirm(
    "¿Estás seguro de que deseas eliminar este producto?"
  );
  if (confirmacion) {
    try {
      const response = await fetch(
        `http://localhost:8080/conexion/prodE/${id}`,
        {
          method: "DELETE",
        }
      );

      if (response.ok) {
        alert("Producto eliminado correctamente");
        // Recargar la tabla después de eliminar
        fetchProducto();
      } else {
        console.error("Error al eliminar el producto:", await response.text());
        alert("Error al eliminar el producto.");
      }
    } catch (error) {
      console.error("Error en la conexión al eliminar:", error);
      alert("Error al eliminar el producto.");
    }
  }
};

