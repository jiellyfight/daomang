window.onload=function()
{
 var sb=document.getElementById("add");
 sb.onclick=function()
 {
  if(document.mform.tem.value=="")
  {
   alert("温度不能为空!");
   document.mform.tem.focus();
   return false; 
  }
  else if(document.mform.airhum.value=="")
  {
   alert("空气湿度不能为空!");
   document.mform.airhum.focus();
   return false; 
  }
  else if(document.mform.soilhum.value=="")
  {
   alert("土壤湿度不能为空!");
   document.mform.soilhum.focus();
   return false; 
  }
  else if(document.mform.ph.value=="")
  {
   alert("ph值不能为空!");
   document.mform.ph.focus();
   return false; 
  }
  else if(document.mform.lux.value=="")
  {
   alert("光照强度不能为空!");
   document.mform.lux.focus();
   return false; 
  }
  else if(document.mform.ltime.value=="")
  {
   alert("光照时间不能为空!");
   document.mform.ltime.focus();
   return false; 
  }
 }
}