


    $(document).on('click', '.saveuser', function(){
      var parent = $(this).parent().parent();
      var nombre = parent.children("td:nth-child(1)");
      var apellido = parent.children("td:nth-child(2)");
      var correo = parent.children("td:nth-child(3)");
      var contraseña = parent.children("td:nth-child(4)");
      var telefono = parent.children("td:nth-child(5)");
      var tdButtons = parent.children("td:nth-child(6)");
      nombre.html(nombre.children("input[type=text]").val());
      apellido.html(apellido.children("input[type=text]").val());
      correo.html(correo.children("input[type=text]").val());
      contraseña.html(contraseña.children("input[type=text]").val());
      telefono.html(telefono.children("input[type=text]").val());
      tdButtons.html(
        "<button class=\"btn btn-xs btn-danger deleteuser\"><i class=\"material-icons\">Eliminar</i></button>" + " " +
        "<button class=\"btn btn-xs btn-info edituser\"><i class=\"material-icons\">Modificar</i></button>"
      );
    });

    $(document).on('click', '.edituser', function(){
      var par = $(this).parent().parent(); 
      var nombre = par.children("td:nth-child(1)");
      var apellido = par.children("td:nth-child(2)");
      var correo = par.children("td:nth-child(3)");
      var contraseña = par.children("td:nth-child(4)");
      var telefono = par.children("td:nth-child(5)");
      var tdButtons = par.children("td:nth-child(6)");

      nombre.html("<input type='text' id='txtName' value='"+nombre.html()+"'/>");
      apellido.html("<input type='text' id='txtPhone' value='"+apellido.html()+"'/>");
      correo.html("<input type='text' id='txtEmail' value='"+correo.html()+"'/>");
      contraseña.html("<input type='text' id='txtEmail' value='"+contraseña.html()+"'/>");
      telefono.html("<input type='text' id='txtEmail' value='"+telefono.html()+"'/>");
      tdButtons.html("<button class=\"btn btn-xs btn-success saveuser\"><i class=\"material-icons\">Guardar</i></button></td>");
    })
 

// FINALIZA SCRIPT DE LAS TABLAS DINAMICAS


// ELIMINAR TABLAs

$(document).ready(function(){
  $(document).on('click','.deleteuser',function(){
    var row = $(this);

        swal({
      title: '¿Esta seguro de eliminar el usuario?',
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si',
      cancelButtonText: 'No',
      confirmButtonClass: 'btn btn-success mr-2',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: false
    }).then((result) => {
      if (result.value) {
         row.parent().parent().remove();
        swal(
          'Completado',
          'El usuario ha sido eliminado exitosamente.',
          'success'
        )
      // result.dismiss can be 'cancel', 'overlay',
      // 'close', and 'timer'
      } else if (result.dismiss === 'cancel') {
        swal(
          '',
          'La accion eliminar ha sido cancelada',
          'error'
        )
      }
    });

  });
  });





