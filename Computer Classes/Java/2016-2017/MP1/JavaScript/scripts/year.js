function updateYear(){
	var currentTime = new Date()
	var year = currentTime.getFullYear()
	var tString = year;
	document.getElementById('year').innerHTML = tString;
}
setInterval(updateYear, 0);