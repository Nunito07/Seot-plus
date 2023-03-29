
//ADMINISTRADOR

// TABLA DESPEGABLE BTN DESPACHAR
$(document).ready(function(){
	$(document).on('click','.despachar',function(){
		var row = $(this);
			swal({
				title: '¿Confirmar Despacho?',
				type: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#3085d6',
				cancelButtonColor: '#d33',
				confirmButtonText: 'Si'
				}).then((result) => {
				if (result.value) {
			swal(
			'',
			'Se ha generado el despacho',
			'success'
			)
			}
			})
		});

	});
        
        
//INICIO TABLA DESPLEGABLE 2

var $table1 = $('#adicion');

$table1.on('expand-row.bs.table', function(e, index, row, $detail) {
  var desc = $(".suma"+ index).html();
  $detail.html(desc);
});

$table1.on("click-row.bs.table", function(e, row, $tr) {

  console.log("Clicked on: " + $(e.target).attr('class'), [e, row, $tr]);

  if ($tr.next().is('tr.detail-view')) {
    $table1.bootstrapTable('collapseRow', $tr.data('index'));
  } else {
    $table1.bootstrapTable('expandRow', $tr.data('index'));
  }
});

//PESTAÑA SEGUIMIENTO  DESCRIPCION
$(document).ready(function(){

    $(document).on('click', '.save', function(){
      var parent = $(this).parent().parent();
      var cantidad = parent.children("td:nth-child(4)");
      var tdButtons = parent.children("td:nth-child(5)");
      
      cantidad.html(cantidad.children("input[type=text]").val());
      
      tdButtons.html(
        "<button class=\"btn btn-xs btn-warning editarD\">Editar</button>" 
         

      );
    });

    $(document).on('click', '.editarD', function(){
      var par = $(this).parent().parent(); //
      var cantidad = par.children("td:nth-child(4)");
      var tdButtons = par.children("td:nth-child(5)");
      cantidad.html("<input type='text' id='txtcantidad'  minlength='1' maxlength='2' value='"+cantidad.html()+"'/>");
      tdButtons.html("<button class=\"btn btn-xs btn-success save\"><i class=\"material-icons\">Guardar</i></button></td>");
    })
  });



// PESTAÑA Y/O MODULO SEGUIMIENTO

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
























//SECCIÓN ACTUALIZAR CATALOGO//
$(document).ready(function(){
	$(document).on('click','.eliminar',function(){
		var row = $(this);

				swal({
		  title: '¿Esta!! seguro de eliminar el pedido?',
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
		      'El pedido ha sido eliminado exitosamente.',
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











$(document).ready(function(){
	$(document).on('click','.novedad',function(){
		var row = $(this);

		swal({
		  title: 'Digite la Novedad Presentada',
		  input: 'text',
		  showCancelButton: true,
		  confirmButtonText: 'Generar Novedad',
		}).then((result) => {
		  if (result.value) {
	    swal({
		      type: 'success',
		      title: 'Su novedad ha sido generada',
		    })
		  }
		})
		});

	});


// DESCARGA  EXCEL
  $().ready(function(){
        $('.descargar').click(function(){
     
            swal({
  title: '¿Quiere descargar los reportes ?',
  text: "El documento sera guardado en su dispositivo",
  type: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Si, descargar '
}).then((result) => {
  if (result.value) {
      $("#tablep").table2excel({
    filename: "Reportes_de_garantias"
  }); 
  }
})

        })
      })



// DESCARGAR  PDF

  $().ready(function(){
        $('.descargarp').click(function(){
     
            swal({
  title: '¿Quiere descargar la visualizacion del pedido?',
  text: "El documento sera guardado en su dispositivo",
  type: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Si, descargar '
}).then((result) => {
  if (result.value) {
  



 var doc = new jsPDF();
var specialElementHandlers = {
    '#editor': function (element, renderer) {
        return true;
    }
};

   
    doc.fromHTML($('#tablep').html(), 15, 15, {
        'width': 170,
            'elementHandlers': specialElementHandlers
    });
    doc.save('Reporte_de_garantias');

    
  }
})

        })
      })


// enviar CATALOGO

$(document).ready(function(){
	$(document).on('click','.agregar',function(){
		var row = $(this);
			swal({
				title: '¿Confirmar Envío?',
				type: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#14B9FF',
				cancelButtonColor: '#d33',
				confirmButtonText: 'Si'
				}).then((result) => {
				if (result.value) {
			swal(
			'',
			'Se ha generado el envío',
			'success'
			)
			}
			})
		});

	});

//Generer verificaciòn Pedido


$(document).ready(function(){
	$(document).on('click','.verificar',function(){
		var row = $(this);
			swal({
				title: '¿Confirmar Pedido Correcto?',
				type: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#14B9FF',
				cancelButtonColor: '#d33',
				confirmButtonText: 'Si'
				}).then((result) => {
				if (result.value) {
			swal(
			'',
			'Verificación Exitosa - Gracias por elegirnos',
			'success'
			)
			}
			})
		});

	});


// eliminar CATALOGO


$(document).ready(function(){
	$(document).on('click','.quitar',function(){
		var row = $(this);
		swal({
  title: '¿Quiere eliminar el envío?',
  text: "puede ver sus productos solicitados en la tabla",
  type: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#d33',
  cancelButtonColor: '#3085d6',
  confirmButtonText: 'Si, eliminar'
}).then((result) => {
  if (result.value) {
    swal(
      'Producto Eliminado de su lista',
      '',
      'success'
    )
  }
})
		});

	});




// ACTUALIZAR STOCK

$(document).ready(function(){
	$(document).on('click','.adicionar',function(){
		var row = $(this);

				swal({
		  title: '¿Esta seguro de ingresar esta cantidad?',
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
		      'El producto ha sido ingresado exitosamente.',
		      'success'
		    )
		  // result.dismiss can be 'cancel', 'overlay',
		  // 'close', and 'timer'
		  } else if (result.dismiss === 'cancel') {
		    swal(
		      '',
		      'La acción ha sido cancelada',
		      
		    )
		  }
		});

	});
	});


// RETIRAR STOCK

$(document).ready(function(){
	$(document).on('click','.retirar',function(){
		var row = $(this);

				swal({
		  title: '¿Esta seguro de retirar esta cantidad?',
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
		      'El producto ha sido retirado exitosamente.',
		      'success'
		    )
		  // result.dismiss can be 'cancel', 'overlay',
		  // 'close', and 'timer'
		  } else if (result.dismiss === 'cancel') {
		    swal(
		      '',
		      'La acción ha sido cancelada',
		      
		    )
		  }
		});

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



//
//$(document).ready(function(){
//
//  $(document).on('click', '.add', function(){
//    var tbody = $('.tbody');
//
//    tbody.append(
//      "<tr>"+
//      "<td><input type='text'/></td>"+
//      "<td><input type='text'/></td>"+
//      "<td><button class=\"btn btn-xs btn-success save\"><i class=\"material-icons\">save</i></button></td>"+
//      "</tr>");
//
//    });
//    $(document).on('click', '.save', function(){
//      var parent = $(this).parent().parent();
//      var tdName = parent.children("td:nth-child(1)");
//      var tdPhone = parent.children("td:nth-child(2)");
//      var tdButtons = parent.children("td:nth-child(3)");
//      tdName.html(tdName.children("input[type=text]").val());
//      tdPhone.html(tdPhone.children("input[type=text]").val());
//      tdButtons.html(
//        "<button class=\"btn btn-xs btn-info edit\"><i class=\"fa fa-edit\"></i></button>" + " " +
//        "<button class=\"btn btn-xs btn-info add\"><i class=\"fa fa-plus\"></i></button>" 
//
//      );
//    });
//
//    $(document).on('click', '.edit', function(){
//      var par = $(this).parent().parent(); //trAKDAKLDJ
//      var tdName = par.children("td:nth-child(1)");
//      var tdPhone = par.children("td:nth-child(2)");
//      var tdButtons = par.children("td:nth-child(3)");
//
//      tdName.html("<input type='text' id='txtName' value='"+tdName.html()+"'/>");
//      tdPhone.html("<input type='text' id='txtPhone' value='"+tdPhone.html()+"'/>");
//      tdButtons.html("<button class=\"btn btn-xs btn-success save\"><i class=\"material-icons\">save</i></button></td>");
//    })
//  }); 
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

