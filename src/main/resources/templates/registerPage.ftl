<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

    </head>

    <body>
        手机 : <input id="mobile" type="number"><br>
        密码 : <input id="password" type="password"><br>
        验证码 : <input id="securityCode" type="number">  <input id="sendCode" type="button" value="发送验证码"><br>
        <input id="register" type="button" value="确定">

    </body>
</html>

<script>

    $('#sendCode').click(function(){
        $.ajax({
            url:"http://localhost:8080/v2/register/send",
            data:{
                mobile : $('#mobile').val()
            }
        }).done(function(data){
            if(data == 200){
                alert("register status: " + data);
            }
        })
    });

    $('#register').click(function(){
        $.ajax({
            type: "POST",
            url:"http://localhost:8080/v2/register/save",
            data:JSON.stringify({
                securityCode : $('#securityCode').val(),
                mobile : $('#mobile').val(),
                password : $('#password').val()
            }),
            contentType: "application/json",
            dataType: 'json'
        }).done(function(data){
            if(data == 200){
                alert("register status: " + data);
            }
        })
    });

</script>