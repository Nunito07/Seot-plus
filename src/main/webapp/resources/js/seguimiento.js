$(document).ready(function() {
    $(document).on('click', '#confirm', function() {
        swal({
            title: '¿Desea Enviar Reporte De Estado?',
            type: 'info',
            showCancelButton: true,
            confirmButtonColor: '#17a2b8',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Confirmar',
            cancelButtonText: 'Cancelar',
            confirmButtonClass: 'btn btn-info',
            cancelButtonClass: 'btn btn-danger',
            buttonsStyling: true
        }).then(function(result) {
            if (result.value) {
                swal("Solicitud Enviada", " ", "success");
            } else if (result.dismiss === 'cancel') {
                swal('Solicitud Cancelada', ' ', 'error')
            }
        })
    });
});
// DATEPICKER
// $(document).ready(function() {
//     $(document).on('click', '', function() {
//         $(".form_datetime").datetimepicker({
//             format: "dd MM yyyy - hh:ii",
//             autoclose: true,
//             todayBtn: true,
//             startDate: "2017-01-01 07:00",
//             minuteStep: 10
//         });
//     });
// });

// $("#datetime").datetimepicker({
//     format: 'yyyy-mm-dd hh:ii',
//     autoclose: true,
//     todayBtn: true
// });
// BTNS-DESCRIPCIÓN

$(document).ready(function(){

  $(document).on('click', '.add', function(){
    var tbody = $('.tbody');

    tbody.append(
      "<tr>"+
      "<td><input type='text'/></td>"+
      "<td><input type='text'/></td>"+
      "<td><button class=\"btn btn-xs btn-success save\"><i class=\"material-icons\">save</i></button></td>"+
      "</tr>");

    });
    $(document).on('click', '.save', function(){
      var parent = $(this).parent().parent();
      var tdName = parent.children("td:nth-child(1)");
      var tdPhone = parent.children("td:nth-child(2)");
      var tdButtons = parent.children("td:nth-child(3)");
      tdName.html(tdName.children("input[type=text]").val());
      tdPhone.html(tdPhone.children("input[type=text]").val());
      tdButtons.html(
        "<button class=\"btn btn-xs btn-info edit\"><i class=\"fa fa-edit\"></i></button>" + " " +
        "<button class=\"btn btn-xs btn-info add\"><i class=\"fa fa-plus\"></i></button>" 

      );
    });

    $(document).on('click', '.edit', function(){
      var par = $(this).parent().parent(); //trAKDAKLDJ
      var tdName = par.children("td:nth-child(1)");
      var tdPhone = par.children("td:nth-child(2)");
      var tdButtons = par.children("td:nth-child(3)");

      tdName.html("<input type='text' id='txtName' value='"+tdName.html()+"'/>");
      tdPhone.html("<input type='text' id='txtPhone' value='"+tdPhone.html()+"'/>");
      tdButtons.html("<button class=\"btn btn-xs btn-success save\"><i class=\"material-icons\">save</i></button></td>");
    })
  });


// SCRIPT PARA FUNCIONAMIENTO DEL SISTEMA

 $(".openNav").click(function() {
  $("body").toggleClass("navOpen");
  $("nav").toggleClass("open");
  $(".wrapper").toggleClass("open");
  $(this).toggleClass("open");
});

  $(function () {
  $('[data-toggle="tooltip"]').tooltip()
})

 $(function () {
  $('[data-toggle="tooltip"]').tooltip()
})



// CERRAR SESIÓN
  $().ready(function(){
        $('.sesion').click(function(){
        swal({
  title: '¿Quiere salir del sistema?',
  text: "Recuerde guardar los cambios!",
  type: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#14B9FF',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Si, Salir'
}).then((result) => {
  if (result.value) {
     location.href ="../../../index.html";
    
  }
})

        })
      })








  // SCRIPTS DE DISTRIBUIDOR  SEG....
// $(document).ready(function() {
//     $(document).on('click', '', function() {
//         $(".form_datetime").datetimepicker({
//             format: "dd MM yyyy - hh:ii",
//             autoclose: true,
//             todayBtn: true,
//             startDate: "2017-01-01 07:00",
//             minuteStep: 10
//         });
//     });
// });
// MODAL BOTONES
$(document).ready(function(){

  $(document).on('click', '.add', function(){
    var tbody = $('.tbody');

    tbody.append(
      "<tr>"+
      "<td><input type='text'/></td>"+
      "<td><input type='text'/></td>"+
      "<td><button class=\"btn btn-xs btn-success save\"><i class=\"material-icons\">save</i></button></td>"+
      "</tr>");

    });
    $(document).on('click', '.save', function(){
      var parent = $(this).parent().parent();
      var tdName = parent.children("td:nth-child(1)");
      var tdPhone = parent.children("td:nth-child(2)");
      var tdButtons = parent.children("td:nth-child(3)");
      tdName.html(tdName.children("input[type=text]").val());
      tdPhone.html(tdPhone.children("input[type=text]").val());
      tdButtons.html(
        "<button class=\"btn btn-xs btn-info edit\"><i class=\"fa fa-edit\"></i></button>" + " " +
        "<button class=\"btn btn-xs btn-info add\"><i class=\"fa fa-plus\"></i></button>" 

      );
    });

    $(document).on('click', '.edit', function(){
      var par = $(this).parent().parent(); //trAKDAKLDJ
      var tdName = par.children("td:nth-child(1)");
      var tdPhone = par.children("td:nth-child(2)");
      var tdButtons = par.children("td:nth-child(3)");

      tdName.html("<input type='text' id='txtName' value='"+tdName.html()+"'/>");
      tdPhone.html("<input type='text' id='txtPhone' value='"+tdPhone.html()+"'/>");
      tdButtons.html("<button class=\"btn btn-xs btn-success save\"><i class=\"material-icons\">save</i></button></td>");
    })
  });
// ENVIAR SOLICITUD
$(document).ready(function() {
    $(document).on('click', '#send', function() {
        swal({
            title: '¿Desea Solicitar Reporte De Estado?',
            type: 'info',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Confirmar',
            cancelButtonText: 'Cancelar',
            confirmButtonClass: 'btn btn-info',
            cancelButtonClass: 'btn btn-danger',
            buttonsStyling: true
        }).then(function(result) {
            if (result.value) {
                swal("Solicitud Enviada", " ", "success");
            } else if (result.dismiss === 'cancel') {
                swal('Solicitud Cancelada', ' ', 'error')
            }
        })
    });
});


