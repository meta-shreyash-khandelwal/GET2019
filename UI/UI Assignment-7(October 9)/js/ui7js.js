var nextNode = document.createElement('div');
var firstNode = document.createElement('div');
var vehicleCounter;
firstNode.innerHTML = '<label for="check0">Name</label><input type="text" id="check0" name="check0">';
document.getElementById('container').appendChild(firstNode);
var i = 0;
var j = 0;
var labels = ["Name ", "Gender-(M or F ) ", "Email ", "Password ", "Confirm Password ", "Contact "];
var labelVehicle = ["Vehicle Name ", "Type ", "Vehicle Number ", "Employee ID ", "Identification "];
//alert("I before"+i);
functionFirstForm();

function functionFirstForm() {
	//var node = document.createElement('div');;
	element = document.getElementById("check" + i);
	element.onkeyup = function (e) {
		if (e.keyCode == 13) {
			//alert("I before in "+i);
			if (document.getElementById("check" + i).value != '') {
				i++;
				firstNode.innerHTML = "";
				nextNode.innerHTML = "";
				//node.innerHTML=""; 
				var title = labels[i];
				var node = document.createElement('div');
				if (i == 3 || i == 4) {
					//alert("IN :");
					node.innerHTML = '<label for="check' + i + '">' + title + '</label><input type="password" id="check' + i + '" name="check' + i + '">';
					document.getElementById('container').appendChild(node);
					nextNode = node;
				} else if (i == 5) {
					node.innerHTML = '<label for="check' + i + '">' + title + '</label><input type="number" id="check' + i + '" name="check' + i + ' required">' +
						'<br><br><button onclick="hideFirstDiv()">Submit</button>';
					document.getElementById('container').appendChild(node);
					//document.getElementById('container').appendChild(node);    
					//document.getElementById('container').innerHTML='';    
					nextNode = node;
				} else if (i < 6) {
					node.innerHTML = '<label for="check' + i + '">' + title + '</label><input type="text" id="check' + i + '" name="check' + i + '">';
					document.getElementById('container').appendChild(node);
					nextNode = node;
				}
				functionFirstForm();
			}
		}
	}
}
var firstNodeVehicle = document.createElement('div');
var nextNodeVehicle = document.createElement('div');

function hideFirstDiv() {
	document.getElementById('container').style.display = "none";
	document.getElementById('secondContainer').style.display = "block";
	firstNodeVehicle.innerHTML = '<label for="vcheck0">Vehicle Name</label><input type="text" id="vcheck0" name="vcheck0">';
	document.getElementById('secondContainer').appendChild(firstNodeVehicle);
	functionSecondForm();
}

function hideFirst(hidediv) {
	//alert(hidediv);
	document.getElementById(hidediv).style.display = "none";
}

function functionSecondForm() {
	//alert("J here"+j);
	element = document.getElementById("vcheck" + j);
	element.onkeyup = function (e) {
		if (e.keyCode == 13) {
			//alert("I before in "+i);

			if (document.getElementById("vcheck" + j).value != '') {
				j++;
				if (j == 2) {
					vehicleCounter = document.getElementById("vcheck1").value;
				}

				firstNodeVehicle.innerHTML = "";
				nextNodeVehicle.innerHTML = "";
				//node.innerHTML=""; 
				/* if(document.getElementById("vcheck1").value!='')
	  {
	  vehicleCounter=document.getElementById("vcheck1").value;
	  }*/
				var title = labelVehicle[j];
				var node = document.createElement('div');

				if (j == 4) {
					//alert("IN :");
					node.innerHTML = '<label for="vcheck' + j + '">' + title + '</label><textarea id="vcheck' + j + '" name="vcheck' + j + '"></textarea>' +
						'<br><br><button onclick="hideSecondDiv()">Submit Vehicle Form</button>';
					document.getElementById('secondContainer').appendChild(node);
					nextNodeVehicle = node;
				} else if (j == 1) {
					node.innerHTML = '<label for="vcheck' + j + '">' + title + '</label><input type="text" id="vcheck' + j + '" name="check' + j + '">(Select m-MotorCycle , c-Cycle,f-four-Wheeler)';
					document.getElementById('secondContainer').appendChild(node);

					//document.getElementById('container').appendChild(node);    
					//document.getElementById('container').innerHTML='';    
					nextNodeVehicle = node;
				}
				/*   else if (j==1)
      {
      //alert("IN 5:");
      node.innerHTML = '<label for="vcheck' + i + '">'+ title +'</label><select id="opted" name="opt">'+
'<option value="cycle">Cycle</option>'+
'<option value="motor">MotorCycle</option>'+
'<option  value="car" selected>Four Wheeler</option></select>';
      document.getElementById('secondContainer').appendChild(node);  
	  
      //document.getElementById('container').appendChild(node);    
      //document.getElementById('container').innerHTML='';    
      nextNodeVehicle=node;
      
      }
	  */
				else if (j < 5) {
					node.innerHTML = '<label for="vcheck' + i + '">' + title + '</label><input type="text" id="vcheck' + j + '" name="check' + j + '">';
					document.getElementById('secondContainer').appendChild(node);
					nextNodeVehicle = node;
				}
				functionSecondForm();
			}
		}
	}
}

function hideSecondDiv() {
	document.getElementById('secondContainer').style.display = "none";
	//alert(vehicleCounter);
	if (vehicleCounter == "m") {
		motorCounter = 1;
		document.getElementById('motorpass').style.display = "block";
	} else if (vehicleCounter == "f") {
		document.getElementById('fourpass').style.display = "block";
	} else {
		document.getElementById('cyclepass').style.display = "block";
		cycleCounter = 1;
	}

	/*
	  if(cycleCounter==1)
	  {
	  document.getElementById('cyclepass').style.display="block";
	  }
	  else if(fourCounter==1)
	  {
	  document.getElementById('fourpass').style.display="block";
	  }
	 else 
	 {
	 document.getElementById('motorpass').style.display="block";
	 }
	  
	  */

}
var x;
var money;

function showCurrencyCycle() {
	x = document.getElementById('currency').value;
	if (x == "inr") {
		document.getElementById('cyclepassr').style.display = 'block';
		document.getElementById('cyclepassus').style.display = 'none';
		document.getElementById('cyclepassyen').style.display = 'none';
	} else if (x == "usd") {
		document.getElementById('cyclepassus').style.display = 'block';
		document.getElementById('cyclepassr').style.display = 'none';
		document.getElementById('cyclepassyen').style.display = 'none';
	} else {
		document.getElementById('cyclepassyen').style.display = 'block';
		document.getElementById('cyclepassr').style.display = 'none';
		document.getElementById('cyclepassus').style.display = 'none';
	}
}

function showCurrencyMotor() {
	x = document.getElementById('currency1').value;
	// alert(x);
	if (x == "inr") {
		document.getElementById('motorpassr').style.display = 'block';
		document.getElementById('motorpassus').style.display = 'none';
		document.getElementById('motorpassyen').style.display = 'none';
	} else if (x == "usd") {
		document.getElementById('motorpassus').style.display = 'block';
		document.getElementById('motorpassr').style.display = 'none';
		document.getElementById('motorpassyen').style.display = 'none';
	} else {
		document.getElementById('motorpassyen').style.display = 'block';
		document.getElementById('motorpassr').style.display = 'none';
		document.getElementById('motorpassus').style.display = 'none';
	}
}

function showCurrencyFour() {
	//alert("HELLO FOUR");
	x = document.getElementById('currency2').value;
	if (x == "inr") {
		document.getElementById('fourpassr').style.display = 'block';
		document.getElementById('fourpassus').style.display = 'none';
		document.getElementById('fourpassyen').style.display = 'none';
	} else if (x == "usd") {
		document.getElementById('fourpassus').style.display = 'block';
		document.getElementById('fourpassr').style.display = 'none';
		document.getElementById('fourpassyen').style.display = 'none';
	} else {
		document.getElementById('fourpassyen').style.display = 'block';
		document.getElementById('fourpassr').style.display = 'none';
		document.getElementById('fourpassus').style.display = 'none';
	}
}


function showT() {
	//alert(vehicleCounter);
	if (vehicleCounter == "c") {
		money = document.querySelector('input[name = "cyclepass"]:checked').value;
		document.getElementById('showTicket').innerHTML = '<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is ' + money + '</div>';
	} else if (vehicleCounter == "m") {
		money = document.querySelector('input[name = "motorpass"]:checked').value;
		document.getElementById('showTicket').innerHTML = '<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is ' + money + '</div>';
	} else {
		money = document.querySelector('input[name = "fourpass"]:checked').value;
		document.getElementById('showTicket').innerHTML = '<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is ' + money + '</div>';
	}
	document.getElementById('cyclepass').innerHTML = '';
	document.getElementById('motorpass').innerHTML = '';
	document.getElementById('fourpass').innerHTML = '';
	//document.getElementById('showTicket').innerHTML='<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is '+moneyy+'</div>';
}
