function init() {

	if (localStorage.getItem("expression") == null) {
		localStorage.setItem("expression", "0");
		document.getElementById("treeStack").innerHTML = "[0]";
	}

	if (localStorage.getItem("stack") == null) {
		localStorage.setItem("stack", "[0]");
		document.getElementById("treeStack").innerHTML = "[0]";
	}

	var chart = new Treant(getChartConfig());

}

function submitted() {
	var textbox = document.getElementById("textbox");
	if (textbox == null) {
		return false;
	} else {
		var textboxValue = textbox.value;
		if (textboxValue == "") {
			alert("Please enter an expression");
			return false;
		} else {
			editTree(textboxValue);
			return true;
		}
	}
}

function editTree(input) {
	localStorage.setItem("expression", input);
}

function getTree() { // USING POST METHOD (From: https://stackoverflow.com/questions/6418220/javascript-send-json-object-with-ajax)
	var xmlhttp = new XMLHttpRequest(); // new HttpRequest instance 
	xmlhttp.open("POST", "http://localhost:8080/Server/rest/json/post", false);
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	xmlhttp.send(JSON.stringify({
		expression: localStorage.getItem("expression")
	}));

	var message = JSON.parse(xmlhttp.responseText);
	console.log(message);
	localStorage.setItem("stack", message.stack);
	document.getElementById("treeStack").innerHTML = message.stack;

	return message.tree;
}

function getChartConfig() {
	var chart_config = {
		chart: {
			container: "#OrganiseChart-big-commpany",
			levelSeparation: 45,

			connectors: {
				type: "step",
				style: {
					"stroke-width": 2
				}
			},
			node: {
				HTMLclass: "big-commpany"
			}
		},

		nodeStructure: getTree()
	};

	return chart_config;
}

function about() {
	window.location = "https://github.com/edmobe/expressionTree";
}