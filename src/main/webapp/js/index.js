/* 
* @Author: anchen
* @Date:   2015-12-13 15:27:59
* @Last Modified by:   anchen
* @Last Modified time: 2015-12-17 21:02:15
*/
function addLoadEvent(func){ 
    var oldonload = window.onload; 
    if (typeof window.onload != 'function') { 
    window.onload = func; 
    } 
    else { 
    window.onload = function(){ 
    oldonload(); 
    func(); 
    } 
   } 
}
window.onload=function(){
    $('signUp').onclick=function(){
        if(!validate()){
            document.form2.onsubmit=function(){
                return false;
            }
        }
        else{
            document.form2.onsubmit=function(){
                sendDate();
                return true;
            }
        }
    }
}
function sendDate(){
    var xmlhttp;
    var form2='{"result":"email|name|success";}';
    var obj = eval ("(" + form2 + ")");
    if(window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
         xmlhttp=new XMLHttpRequest();
     }
    else{// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        if (xmlhttp.readyState==4 && xmlhttp.status==200){
            obj.result=xmlhttp.responseText;
        }
    }
    xmlhttp.open("POST","user/regist",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("u_email&u_name&u_password");
    if(obj.result=='success'){
        alert("注册成功！");
    }
    else if(obj.result=='email'){
        alert("注册失败，邮箱已存在！");
    }
     else if(obj.result=='name'){
        alert("注册失败，用户名已存在！");
    }
}
function $(id) { return document.getElementById(id);}
function Tab(){
    var oTab=$('tab');
    var aLi=oTab.getElementsByTagName('li');
    var aA=oTab.getElementsByTagName('ul')[0].getElementsByTagName('a');
    var aDiv=getByClass(oTab, 'box');
    var i=0;
    
    aDiv[0].style.display='block';
    
    for(i=0; i<aLi.length; i++){
        aLi[i].index=i;
        aLi[i].onclick=function(){
            for(i=0; i<aLi.length; i++){
                aLi[i].className='';
                aDiv[i].style.display='none';
            }
            this.className='active';
            aDiv[this.index].style.display='block';
        };
        aA[i].onfocus=function(){this.blur();
        };
    }
}
function getByClass(oParent, sClassName){
    var aElm=oParent.getElementsByTagName('*');
    var aArr=[];
    for(var i=0; i<aElm.length; i++)
    {
        if(aElm[i].className==sClassName)
        {
            aArr.push(aElm[i]);
        }
    }
    return aArr;
}
function searchBox(){
    // var isOut = true;
    // var other = window.document;
    var dom=$('search_box');
    // other.onclick = function(){
    //     if(isOut){
    //         dom.style.display ='none';
    //     }
    //     isOut = true;
    // }
    $('searchBtnClick').onclick=function(){
        if(dom.style.display=='none'){
            dom.style.display='block';
        }
        else if(dom.style.display=='block'){
           dom.style.display='none'; 
        }
         // isOut = false;
    }
}
//form2验证
function validForm(){
   var stp=document.getElementById('signUp');
   document.form2.user_name.onblur=function(){
        var uName=document.form2.user_name;
        if(!userName(uName)){
            stp.disabled = true;
        }
   }
   document.form2.user_email.onblur=function(){
       var uEmail=document.form2.user_email;
        useremail(uEmail);
   }
   $('pwd1').onblur=function(){
        var pwd=$('pwd1');
        if(!userpassword(pwd)){
            stp.disabled = true;
        }
   }
   $('pwd2').onblur=function(){
        var pwd=$('pwd2');
        if(!userpassword(pwd)){
            stp.disabled = true;
        }
   }
   $('pwd2').onkeyup=function(){
        if(pwdIsSame()){
           stp.disabled = true;
        }
   }
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
    var pw1 = document.getElementById("pwd1").value;
    var pw2 = document.getElementById("pwd2").value;
    if((pw1 == pw2)&&(pwd2.nextSibling.className=="msg")) {
        pwd2.nextSibling.innerHTML="密码确认成功！";
    }
    else if(pwd2.nextSibling.className=="msg") {
        pwd2.nextSibling.innerHTML="两次密码不相同！";
    }
}
addLoadEvent(Tab);
addLoadEvent(searchBox);
addLoadEvent(validForm);
