function updateTime(){
	var currentTime = new Date()
	var hours = currentTime.getHours()
	var minutes = currentTime.getMinutes()
	var seconds = currentTime.getSeconds()
	if (seconds < 10){
		seconds = "0" + seconds;
	}
	if (minutes < 10){
		minutes = "0" + minutes;
	}
	if (hours > 12){
		hours = hours-12;
	}
	var t_str = "Time: " + hours + ":" + minutes + ":" + seconds + " ";
	if(currentTime.getHours() > 11){
		t_str += "PM";
	} else {
		t_str += "AM";
	}
	document.getElementById('time').innerHTML = t_str;
}
setInterval(updateTime, 0);