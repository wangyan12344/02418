function successHandler(data,resultTemplate){
	var dataJsonStr = JSON.stringify(data);
	$("#resultId").html(dataJsonStr);
}