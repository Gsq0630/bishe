$(function () {
    $("#chat").click(function () {
      var chat = $("#chat");
      chat.css("background-color","#eeeeee");
      chat.css("color","#6e8ef4");
      var match = $("#match");
      match.css("background-color","#6e8ef4");
      match.css("color","#eeeeee");
      $("#mainBody-1").hide();
      $("#mainBody-2").show();
    });

    $("#match").click(function () {
        var match = $("#match");
        match.css("background-color","#eeeeee");
        match.css("color","#6e8ef4");
        var chat = $("#chat");
        chat.css("background-color","#6e8ef4");
        chat.css("color","#eeeeee");
        $("#mainBody-2").hide();
        $("#mainBody-1").show();
    });
    
    $("#startMatch").click(function () {
        $("#mainBody-1").addClass("Rotation");

    })
    
    
});