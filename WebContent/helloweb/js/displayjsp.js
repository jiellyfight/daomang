window.onload=function()
{
 var sb=document.getElementById("bu");
 sb.onclick=function()
 {
  if(document.form.time.value=="")//判断表单是否为空
  {
   alert("时间点不能为空!");//弹出一个警告窗口 
   document.form.time.focus();//本文档的表单域下的time获得输入焦点，光标会点位到time 文本框位置。
   return false;
  }
 }
}