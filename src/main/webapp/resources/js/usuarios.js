function enviarUsuario(){ 
    var usuario = $('#usuario').val(); 
    var password = $('#password').val();


    console.log(usuario);
    console.log(password);


    if (usuario == "seot@misena.edu.co" && password == "1234") {     


        alert('Bienvenido administrador');
        $('#formLogin').attr('action', '../../modulos/Pedidos/Administrador/index.html');

    }else if(usuario == "fer.electricos13@gmail.com" && password == "123456"){
        alert('Bienvenido Cliente');
        $('#formLogin').attr('action', '../../modulos/Pedidos/Distribuidor/index.html');

    }else{
       swal(
  'Oops...',
  'Complete los campos',
  'error'
)

    }
}


