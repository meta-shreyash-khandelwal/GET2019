   function show() { 
	document.getElementById('firstForm').innerHTML=''; 
     alert("Employee ID - E001/01");
    document.getElementById('secondForm').style.display='block'; 
    (<HTMLInputElement>document.getElementById('employee')).value='E001/01';
    }   

    function showCurrencyCycle() { 
        let money:string;
       let x =(<HTMLInputElement>document.getElementById('currency')).value;
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
       let x =(<HTMLInputElement>document.getElementById('currency1')).value;
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
        let x =(<HTMLInputElement>document.getElementById('currency2')).value;
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
 

       var x:string;
       function show2() { 
       x =(<HTMLInputElement>document.getElementById('opted')).value;
       //alert(x);
       document.getElementById('secondForm').innerHTML=''; 
       if(x=="cycle")
       {
        document.getElementById('cyclepass').style.display='block';
       }
       else if(x=="motor")
       {
        document.getElementById('motorpass').style.display='block'; 
       }
       else
       {
        document.getElementById('fourpass').style.display='block'; 
       }  
         }   
 
         function checkForm() { 
            let name=document.forms["employee"]["name"].value;
            let email=document.forms["employee"]["email"].value;
            let passwordObtained=document.forms["employee"]["password"].value;
            let contact=document.forms["employee"]["contact"].value;
            let confirmPassword=document.forms["employee"]["confirm"].value;
            let letterNumber = /[0-9]+$/;
            let passwordCheck= /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
            let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            //alert(passwordObtained);
            //alert(passwordObtained.match(passwordCheck));
            if(name.length<2 )
            {
            alert("Name length less than 2 ");
            //return false;
            } 
            else if(name.match(letterNumber))
            {
            alert("Name contains numbers");
            //return false;
            } 
            else if (!email.match(mailformat))                 
            { 
            alert("Please enter a valid e-mail address."); 
            //return false; 
            }
            else if (!passwordObtained.match(passwordCheck))                 
             { 
            alert("Password should contain atleast one lowercase,one uppercase and one number and minimum length 8"); 
            //return false; 
             }
                else if(contact.length<=8)
            {
            alert("Contact length should be greater than 8");
            //return false;
            }
            else if(confirmPassword!=passwordObtained)
            {
            alert("Please enter the same password in confirm password field");
            //return false;
            }
            else 
            {
            show();
            }
            }	
        
            function showT()
            {
                let money:string;
            if(x=="cycle")
            {
           money=(<HTMLInputElement>document.querySelector('input[name = "cyclepass"]:checked')).value;
            document.getElementById('showTicket').innerHTML='<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is '+money+'</div>';
            }
            else if(x=="motor")
            {
            money=(<HTMLInputElement>document.querySelector('input[name = "motorpass"]:checked')).value;
            document.getElementById('showTicket').innerHTML='<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is '+money+'</div>';
            }
            else
            {
            money=(<HTMLInputElement>document.querySelector('input[name = "fourpass"]:checked')).value;
            document.getElementById('showTicket').innerHTML='<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is '+money+'</div>';
            }  
            document.getElementById('cyclepass').innerHTML='';
            document.getElementById('motorpass').innerHTML='';
            document.getElementById('fourpass').innerHTML='';
            //document.getElementById('showTicket').innerHTML='<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is '+moneyy+'</div>';
            }