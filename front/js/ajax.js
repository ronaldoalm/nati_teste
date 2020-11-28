$( document ).ready(function() {
    var host = 'http://localhost:8081'

    $('#login').click(function(){
		
		var matricula = $('#matricula').val();
		var senha = $('#password').val();
		
        var  usuario = {matricula : matricula , senha : senha};
       
		
		$.ajax({
			url: host+'/api/v1/login',
			type:'POST',
            dataType: 'json',
            contentType : "application/json",
			data:  JSON.stringify( usuario ),
			cache: false,
			success: (data) => {

                console.log(data);
            },
            error:  (err) => {
               console.log(err);
            }
			});
    });


    $('#cadastrar-usuario').click(function(){
		
		var nome_completo = $('#nomeCompleto').val();
        var matricula = $('#matricula').val();
        var tipo_usuario = $('#tipoUsuario').val(); 
		
        var  usuario = {matricula : matricula , tipoUsuario : tipo_usuario, nomeCompleto:nome_completo };
       
        console.log(usuario);

        $.ajax({
			url: host+'/api/administrador/v1/usuario',
			type:'POST',
            dataType: 'json',
            contentType : "application/json",
			data:  JSON.stringify( usuario ),
			cache: false,
            statusCode: {
                200: function() {
                    document.getElementById('nomeCompleto').value = ''
                    document.getElementById('matricula').value = ''
                    document.getElementById('tipoUsuario').value = 'ADMINISTRADOR'

                    alert("Usuário cadastrado com sucesso!")

                },
                500: function() {
                   alert("TESTE");
                }
    
              }


			});

    });

        $('.data-table').DataTable( {
            "ajax": {
                "url": host+"/api/administrador/v1/usuario/todos",
                "dataSrc": "",
            },
            "columns": [
                { "data": "matricula" },
                { "data": "nome_completo" },
                { "data": "tipo_usuario" }
            ]
        } );
    
    
});