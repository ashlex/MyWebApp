$(document).ready(function(){

    $(".button").on("click", function(){
        var mydata={action:$(this).attr("action"), value:$(this).attr("value")};
        $.ajax({
            type: "POST",
            url: "\My",
            dataType: 'json',
            data: mydata,
            success: function(msg,textStatus){
                $(".display").text(msg.display)
            },
            error: function (XMLHttpRequest, textStatus, errorThrown){
                $(".display").text(textStatus)
            }
        });
    });
});