$(function () {

    $("#changeData").hide();
    var userId = $.cookie("userId");
    if (userId === undefined){
        userId = 0;
        $("#userPicA").hide();
        $("#reg_login").show();
    }else{
        $("#reg_login").hide();
        $("#userPicA").show();
        $.ajax({
            url:"http://localhost:8080/user/getUserPic",
            type: "post",
            data: {
                'userId': userId
            },
            datatype: "text",
            success: function (data) {
                $("#userPic").attr("src",data);
            }
        });
        $("#userPic").click(function () {
            $("#centerDiv").hide();
            $("#mainBody").hide();
            $("#changeData").show();
        });
        $("#index").click(function () {
            $("#centerDiv").show();
            $("#changeData").hide();
            $("#mainBody").show();
        })
    }
});