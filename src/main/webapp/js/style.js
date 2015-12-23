/* 
* @Author: anchen
* @Date:   2015-12-16 19:44:13
* @Last Modified by:   anchen
* @Last Modified time: 2015-12-17 22:51:11
*/
// 验证表单
function IsNum(oNum){
    if(!oNum){ 
        return false;
    }
    var strP=/^\d+(\.\d+)?$/;
    if(!strP.test(oNum)){
        return false;
    }
    try{
        if(parseFloat(oNum)!=oNum){
            return false;
        }
    }catch(ex){
        return false;
    }
    return true;
}
// 空值验证
 function IsEmpty(text){

    return (text.length > 0);
}
// 邮箱验证
function check_Email(address){
    if((address == "")||(address.indexOf('@') == -1)||(address.indexOf('.') == -1)){
        return false;
    }
    return true;
} 
// 电话号码
// 规则说明：
// 1、可以是1开头的11位数字（手机号）
// 2、可以是“区号-电话号-分机号”或者是“(区号)电话号-分机号”格式
// 3、区号是0开头的3～4位数字，可以没有区号
// 4、电话号是5～8位数字，不能以0开头
// 5、分机号是1～8位数字，可以没有分机号
function check_phone(val){
    var telReg = !!val.match(/^1\d{10}$|^(0\d{2,3}-?|\(0\d{2,3}\))?[1-9]\d{4,7}(-\d{1,8})?$/);
    //如果通过认证
    if(telReg){
         return true;
    }
    return false;
}
//校验密码：只能输入6-20个字母、数字、下划线  
function isPasswd(s){   
    var patrn=/^(\w){6,20}$/;   
    if (!patrn.exec(s)){ 
        return false; 
    }
    return true; 
}
//Ajax提交表单
// function sendForm(str,url,obj){
//     alert("sendForm2 ok");
//     var xmlhttp;
//     if(window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
//          xmlhttp=new XMLHttpRequest();
//      }
//     else{// code for IE6, IE5
//         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//     }
//     xmlhttp.onreadystatechange=function(){
//         if (xmlhttp.readyState==4 && xmlhttp.status==200){
//             obj=xmlhttp.responseText;
//         }
//     }
//     xmlhttp.open("POST",url,true);
//     xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//     xmlhttp.send(str);
//     return obj;
// }
