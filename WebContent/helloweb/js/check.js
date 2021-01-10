window.onload=function()
{
 var sb=document.getElementById("sb");
 sb.onclick=function()
 {
  if(document.mform.username.value=="")//判断表单是否为空
  {
   alert("用户名不能为空!");//弹出一个警告窗口 
   document.mform.username.focus();//本文档的表单域下的username获得输入焦点，光标会点位到 username 文本框位置。
   return false;
  } 
  else if(document.mform.password.value=="")
  {
   alert("密码不能为空!");
   document.mform.password.focus();
   return false; 
  }
 }
}