$(document).ready(function(){

    $(".button:not(#commit)").on("click", function () {
        var a = $(".display");
        a.html(a.text() + $(this).text());
    });
    $("#commit").on("click", function(){
        $.ajax({
            type: "POST",
            url: "\My",
            data: "value="+$(".display").text(),
            success: function(msg){
                alert( "Прибыли данные: " + msg );
            }
        });
    });
});