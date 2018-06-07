function init() {

	if (sessionStorage.getItem("expression") == null) {
		sessionStorage.setItem("expression", "0");
		document.getElementById("treeStack").innerHTML = "0";
	}

	if (sessionStorage.getItem("stack") == null) {
		sessionStorage.setItem("stack", "0");
		document.getElementById("treeStack").innerHTML = "0";
	}

	var chart = new Treant(getChartConfig());

}

function submitted() {
	var textbox = document.getElementById("textbox");
	if (textbox == null) {
		return false;
	} else {
		var textboxValue = textbox.value;
		var opCode = validInput(textboxValue);
		if (opCode != 0) {
			if (opCode == 1) {
				alert("Please enter an expression");
			} else if (opCode == 2) {
				alert("Spaces are not allowed!");
			} else if (opCode == 3) {
				alert("Invalid character! Allowed characters are numbers and: * / + - ( )");
			} else if (opCode == 4) {
				alert("You must enter only one digit numbers!");
			}
			return false;
		}
		else {
			editTree(textboxValue);
			return true;
		}
	}
}

function editTree(input) {
	sessionStorage.setItem("expression", input);
}

function getTree() { // USING POST METHOD (From: https://stackoverflow.com/questions/6418220/javascript-send-json-object-with-ajax)
	var xmlhttp = new XMLHttpRequest(); // new HttpRequest instance 
	xmlhttp.open("POST", "http://localhost:8080/RESTfulExample/rest/json/post", false);
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	xmlhttp.send(JSON.stringify({
		expression: sessionStorage.getItem("expression")
	}));

	var message = JSON.parse(xmlhttp.responseText);
	console.log(message);
	sessionStorage.setItem("stack", message.stack);
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

function validInput(input) {
	if (input == "") {
		return 1;
	}

	array = input.split("");

	var pastNum = false; // indicates if a number was read in the last iteration
	for (var i = 0; i < array.length; i++) {
		var char = input[i];

		if (char == " ") {
			return 2;
		}

		if (char != '1' && char != '2' && char != '3' && char != '4' && char != '5' && char != '6' && char != '7' &&
		char != '8' && char != '9' && char != '0' && char != '*' && char != '/' && char != '+' && char != '-' &&
		char != '(' && char != ')' ) {
			return 3;
		}

		if (char == '1' || char == '2' || char == '3' || char == '4' || char == '5' || char == '6' || char == '7' ||
		char == '8' || char == '9' || char == '0') {
			if (pastNum) {
				return 4;
			} else {
				pastNum = true;
			}
		} else {
			pastNum = false;
		}
	}

	return 0;
}