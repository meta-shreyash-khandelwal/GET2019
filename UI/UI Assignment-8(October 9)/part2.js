String.prototype.removeConsecutive = function ()
{
	var inputString=this.toString();
for(var i =0; i < inputString.length-1; i++)
{
if(inputString.charAt(i)==inputString.charAt(i+1))
{
	inputString=inputString.substring(0,i)+inputString.substring(i+2);
	i=0;
}
}
return inputString;	
}