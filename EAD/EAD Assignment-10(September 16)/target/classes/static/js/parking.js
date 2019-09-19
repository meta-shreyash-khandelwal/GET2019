   
function showCurrencyCycle() { 
 var money;
var x =document.getElementById('currency').value;
if(x=="inr")
{
 document.getElementById('cyclepassr').style.display='block'; 
  document.getElementById('cyclepassus').style.display='none'; 
  document.getElementById('cyclepassyen').style.display='none'; 
}
else if(x=="usd")
{
 document.getElementById('cyclepassus').style.display='block'; 
 document.getElementById('cyclepassr').style.display='none'; 
  document.getElementById('cyclepassyen').style.display='none';
}
else
{
 document.getElementById('cyclepassyen').style.display='block'; 
 document.getElementById('cyclepassr').style.display='none'; 
 document.getElementById('cyclepassus').style.display='none'; 
}  
  }   
function showCurrencyMotor() { 
var x =document.getElementById('currency1').value;
// alert(x);
if(x=="inr")
{
 document.getElementById('motorpassr').style.display='block'; 
  document.getElementById('motorpassus').style.display='none'; 
  document.getElementById('motorpassyen').style.display='none'; 
}
else if(x=="usd")
{
 document.getElementById('motorpassus').style.display='block'; 
 document.getElementById('motorpassr').style.display='none'; 
  document.getElementById('motorpassyen').style.display='none';
}
else
{
 document.getElementById('motorpassyen').style.display='block'; 
 document.getElementById('motorpassr').style.display='none'; 
 document.getElementById('motorpassus').style.display='none'; 
}  
}   
function showCurrencyFour() { 
  //alert("HELLO FOUR");
var x =document.getElementById('currency2').value;
if(x=="inr")
{
 document.getElementById('fourpassr').style.display='block'; 
  document.getElementById('fourpassus').style.display='none'; 
  document.getElementById('fourpassyen').style.display='none'; 
}
else if(x=="usd")
{
 document.getElementById('fourpassus').style.display='block'; 
 document.getElementById('fourpassr').style.display='none'; 
  document.getElementById('fourpassyen').style.display='none';
}
else
{
 document.getElementById('fourpassyen').style.display='block'; 
 document.getElementById('fourpassr').style.display='none'; 
 document.getElementById('fourpassus').style.display='none'; 
}  
}   
var x;
function show2(y) { 
	//alert("HI");
x=y;
	//x=document.getElementById("span_id");
	//alert(y);
//x =document.getElementById('opted').value;
//alert(x);

if(x=="cycle")
{
 document.getElementById('cyclepass').style.display='block';
 document.getElementById('motorpass').style.display='none'; 
 document.getElementById('fourpass').style.display='none'; 

}
else if(x=="motor")
{
 document.getElementById('motorpass').style.display='block'; 
 document.getElementById('cyclepass').style.display='none'; 
 document.getElementById('fourpass').style.display='none'; 
}
else
{
 document.getElementById('fourpass').style.display='block'; 
 document.getElementById('cyclepass').style.display='none'; 
 document.getElementById('motorpass').style.display='none'; 
}  
  }   
function showT()
{
//alert("HI in showT");
//alert(x);
//var moneyr=document.querySelector('input[name = "fourpass"]:checked').value;
//var moneyu=document.querySelector('input[name = "cyclepass"]:checked').value;
//var moneyy=document.querySelector('input[name = "motorpass"]:checked').value;
//var gender = document.querySelector('input[name = "fourpass"]:checked').value;
//alert(moneyr);
//alert(moneyu);
//alert(moneyy);
if(x=="cycle")
{
var money=document.querySelector('input[name = "cyclepass"]:checked').value;
document.getElementById('showTicket').innerHTML='<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is '+money+'</div>';
}
else if(x=="motor")
{
var money=document.querySelector('input[name = "motorpass"]:checked').value;
document.getElementById('showTicket').innerHTML='<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is '+money+'</div>';
}
else
{
var money=document.querySelector('input[name = "fourpass"]:checked').value;
document.getElementById('showTicket').innerHTML='<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is '+money+'</div>';
}  
document.getElementById('cyclepass').innerHTML='';
document.getElementById('motorpass').innerHTML='';
document.getElementById('fourpass').innerHTML='';
//document.getElementById('showTicket').innerHTML='<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is '+moneyy+'</div>';
}