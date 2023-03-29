
// MOVIMINETO DEL MENU
$(".openNav").click(function () {
    $("body").toggleClass("navOpen");
    $("nav").toggleClass("open");
    $(".wrapper").toggleClass("open");
    $(".openNav").toggleClass("open");
});




//// CERRAR SESIÓN
//  $().ready(function(){
//        $('.sesionuser').click(function(){
//        swal({
//  title: '¿Quiere salir del sistema?',
//  text: "Recuerde guardar los cambios!",
//  type: 'warning',
//  showCancelButton: true,
//  confirmButtonColor: '#14B9FF',
//  cancelButtonColor: '#d33',
//  confirmButtonText: 'Si, Salir'
//}).then((result) => {
//  if (result.value) {
//     location.href ="HomePage.xhtml";
//    
//  }
//})
//
//        })
//      })



// TOOLTIP DE BOOSTRAP
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})




