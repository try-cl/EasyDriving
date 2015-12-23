$(document).ready(function(){
        $("#tab li").click(function(){
        $("#tab li").eq($(this).index()).addClass("active").siblings().removeClass('active');
        $(".box").hide().eq($(this).index()).show();

        });

      $("#signUp").click(function(){
        if(!validate()){
            document.form2.onsubmit=function(){
                return false;
            }
        }
        else{
            addUser();
        }
     }
        );
        validForm2();

});
function addUser(){
        var user={
            u_email:$("#user_email").val(),
            u_name:$("#user_name").val(),
            u_password:$("#pwd1").val()
        };

        $.ajax({
            url:'http://localhost:8080/EasyDriving/user/regist',
            data:user,
            type:'post',
            dataType:"json",
            success:function(r){
                alert(r.result);

                //if(result=="success"){
                //    alert("注册成功！");
                //}else if(result=="email"){
                //    alert("注册失败，邮箱已存在！");
                //
                //}else if(result=="name"){
                //    alert("注册失败，用户名已存在！");
                //}
            }
        });
    }
//form2验证
function validForm2(){
   var stp=$("signUp");
   $("#user_name").blur(function(){
        var uName=document.form2.user_name;
        if(!userName(uName)){
            stp.disabled = true;
        }
   });
   $("#user_email").blur(function(){
       var uEmail=document.form2.user_email;
        useremail(uEmail);
   });
   $("#pwd1").blur(function(){
        var pwd=document.getElementById('pwd1');
        if(!userpassword(pwd)){
            stp.disabled = true;
        }
   });
   $("#pwd2").blur(function(){
        var pwd=document.getElementById('pwd2');
        if(!userpassword(pwd)){
            stp.disabled = true;
        }
   });
   $("#pwd2").keyup(function(){
        if(pwdIsSame()){
           stp.disabled = true;
        }
   });
   return ;
}
function userName(uName){
     if(!IsEmpty(uName.value)){
        if(uName.nextSibling.className!=="msg"){
                var odiv=document.createElement('div');
                odiv.className='msg';
                odiv.innerHTML="对不起，请先填入用户名!";
                uName.parentNode.insertBefore(odiv,uName.nextSibling);
        }
        return false;
    }
    else if(uName.nextSibling.className=="msg"){
        uName.parentNode.removeChild(uName.nextSibling);
    }
    return true;
}
function useremail(uEmail){
    if(!IsEmpty(uEmail.value)){
        if(uEmail.nextSibling.className!=="msg"){
                var odiv=document.createElement('div');
                odiv.className='msg';
                odiv.innerHTML="对不起,邮箱必填!";
                uEmail.parentNode.insertBefore(odiv,uEmail.nextSibling);
        }
        return false;
    }
    if(!check_Email(uEmail.value)){
        if(uEmail.nextSibling.className!=="msg"){
                var odiv=document.createElement('div');
                odiv.className='msg';
                odiv.innerHTML="请正确填写邮箱地址！";
                uEmail.parentNode.insertBefore(odiv,uEmail.nextSibling);
        }
        else if(uEmail.nextSibling.className=="msg"){
                uEmail.nextSibling.innerHTML="请正确填写邮箱地址！";
        }
        return false;
    }
    else if(uEmail.nextSibling.className=="msg"){
        uEmail.parentNode.removeChild(uEmail.nextSibling);
    }
    return true;
}
function userpassword(pwd){
    if(!IsEmpty(pwd.value)){
        if(pwd.nextSibling.className!=="msg"){
                var odiv=document.createElement('div');
                odiv.className='msg';
                odiv.innerHTML="请输入至少六位密码！";
                pwd.parentNode.insertBefore(odiv,pwd.nextSibling);
        }
        return false;
    }
    else if(!isPasswd(pwd.value)){
        if(pwd.nextSibling.className!=="msg"){
                var odiv=document.createElement('div');
                odiv.className='msg';
                odiv.innerHTML="对不起，密码格式错误！";
                pwd.parentNode.insertBefore(odiv,pwd.nextSibling);
        }
        else if(pwd.nextSibling.className=="msg"){
                pwd.nextSibling.innerHTML="对不起，密码格式错误！";
        }
        return false;
    }
    else if(pwd.nextSibling.className=="msg"){
        pwd.parentNode.removeChild(pwd.nextSibling);
    }
    return true;
}
function validate(){
    var uName=document.form2.user_name;
    var uEmail=document.form2.user_email;
    var pwd=$('pwd1');
    var pwd=$('pwd2');
    if(!(userName(uName)||useremail(uEmail)||userpassword(pwd1)||userpassword(pwd2))){
        return false;
    }
    else return true;
}
function pwdIsSame(){
    var pw1= $("#pwd1").value;
    var pw2 = $("#pwd2").value;
    if((pw1 == pw2)&&(pwd2.nextSibling.className=="msg")) {
        pwd2.nextSibling.innerHTML="密码确认成功！";
    }
    else if(pwd2.nextSibling.className=="msg") {
        pwd2.nextSibling.innerHTML="两次密码不相同！";
    }
}