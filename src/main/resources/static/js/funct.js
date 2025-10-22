document.addEventListener("DOMContentLoaded", function() {
    fetch('http://localhost:8080/usuarios')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error en la respuesta de la API');
            }
            return response.json();
        })
        .then(data => {
            const usuariosTableBody = document.getElementById('usuarios').getElementsByTagName('tbody')[0];
            
            usuariosTableBody.innerHTML = '';

            if (data && data.length > 0) {
                
                data.forEach(function(usuario) {
                    let row = document.createElement('tr');
                    row.innerHTML = `
                        <td><img src="${usuario.picture}" alt="Foto"></td>
                        <td>${usuario.name.first} ${usuario.name.last}</td>
                        <td>${usuario.gender}</td>
                        <td>${usuario.location.city}, ${usuario.location.state}, ${usuario.location.country}</td>
                        <td>${usuario.email}</td>
                        <td>${usuario.dob.date}</td>
                    `;
                    usuariosTableBody.appendChild(row);
                });
            } else {
                console.error('No se encontraron usuarios en la respuesta');
            }
        })
        .catch(error => {
            console.error('Error al cargar los usuarios:', error);
        });
});
