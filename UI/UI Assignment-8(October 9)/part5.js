String.prototype.repeatify = function (times) {
	var repeatedString = '';
   for (var i =0; i < times; i++) {
  	repeatedString += this.toString();
  }
  
	return repeatedString;
}



console.log('hello'.repeatify(3));