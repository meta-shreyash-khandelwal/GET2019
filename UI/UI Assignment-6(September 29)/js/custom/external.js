/*
  To change the color & background color of anchor tags on vertical navbar.
*/
$(document).ready(function(){
  $(".nav-item").click(function(){
    $(this).css({"color": "purple",
      "background-color": "lavender"})
  });

  $(".nav-item").click(function(){
    $(this).siblings().css({"color": "grey",
      "background-color": "white"})
  });
});