
function typeUpdate(type_list, type) {
	var next = type_list.querySelector(".next");

	if(type === "TODO"){
		type = "DOING";
	}
	else if(type === "DOING"){
		type = "DONE";
		next.remove();
	}
	var current_type = document.querySelector("#"+type);
	current_type.appendChild(type_list);
	
}


function clicked(id, type) {

	var type_list = type.closest('li'); // type(input테그)에서 가장 가까운 li테그 부모를 찾음
	type = type.closest('ul').getAttribute('id'); // type(input)에서 가장 가까운 ul테그의 id값을 찾음
	
	
	typeUpdate(type_list, type);

	
}
