// SCRIPT DEL MAIN DE LAS TABLAS DINAMICAS 

    $(document).on('click', '.save', function(){
      var parent = $(this).parent().parent();

      var notificacion = parent.children("td:nth-child(6)");
      var tdButtons = parent.children("td:nth-child(7)");


      notificacion.html(notificacion.children("input[type=text]").val());
      tdButtons.html(
       
        "<button class=\"btn btn-xs btn-warning edit\"><i class=\"material-icons\">Nueva Notificación</i></button>"
      );
    });

    $(document).on('click', '.edit', function(){
      var par = $(this).parent().parent(); 

      var tdId2 = par.children("td:nth-child(6)");
      var tdButtons = par.children("td:nth-child(7)");
      tdId2.html("<input type='text' id='txtEmail' value='"+tdId2.html()+"'/>");
      tdButtons.html("<button class=\"btn btn-xs btn-success save\"><i class=\"material-icons\">Enviar</i></button></td>");
    })


// FINALIZA SCRIPT DE LAS TABLAS DINAMICAS




  // GARANTIAS DISTRIBUIDOR EN GESTION
  


  $().ready(function(){
        $('.enviarg').click(function(){
     
        swal({
  title: 'Are you sure?',
  text: "You won't be able to revert this!",
  type: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Yes, delete it!'
}).then((result) => {
  if (result.value) {
    swal(
      'Deleted!',
      'Your file has been deleted.',
      'success'
    )
  }
})

        })
      })


// ELIMINAR TABLAS

$(document).ready(function(){
  $(document).on('click','.delete',function(){
    var row = $(this);

        swal({
      title: '¿Esta seguro de eliminar el producto?',
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
          'El producto ha sido eliminado exitosamente.',
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



// Guardar



$(document).ready(function(){
  $(document).on('click','.save',function(){
    var row = $(this);

    swal(
  'Guardado',
  'Se le enviara informe al distribuidor',
  'success'
)

  });
  });


// VERIFICAR STOCK GARANTIAS 
// 

$(document).ready(function(){
  $(document).on('click','.eliminar',function(){
    var row = $(this);

        swal({
      title: '¿Esta seguro de enviar producto?',
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
          'Codigo',
          '001G23',
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


// VERIFICAR CODIGO GARANTIAS


  $().ready(function(){
        $('.enviarg').click(function(){
     
swal(
  'Su Codigo:',
  'MF000',
  'success'
)
        })
      })




     // Bar chart
    var ctx = document.getElementById("mybarChart");
    var mybarChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", 
        "Junio", "Julio", "Agosto", "Septiembre", "Octubre", 
        "Noviembre", "Diciembre"],
        datasets: [{
          label: '#Domestica',
          backgroundColor: "#3FA9F5",
          data: [12,30,40,28,92,50,45,34,56,12,98,23]
        }, {
          label: '#Metallica',
          backgroundColor: "#154360",
          data: [19,56,25,48,72,34,12,45,67,12,34,23,]
        }, {
          label: '#Industrial',
          backgroundColor: "#808080",
          data: [2,36,52,84,27,44,21,54,23,98,11,33,]
        },
        {
          label: '#Semi-Industrial',
          backgroundColor: "black",
          data: [9,20,34,22,20,40,23,44,66,88,44,12]
        }]
      },

      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    });