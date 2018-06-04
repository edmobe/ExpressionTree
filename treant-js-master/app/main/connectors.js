var tree = getTree();

console.log("Iteration in JS");

function submitted() {
	console.log("Iteration submitted");
	var textbox = document.getElementById("textbox");
	if (textbox == null) {
		return false;
	} else {
		var textboxValue = textbox.value;
		if (textboxValue == "") {
			alert("Please enter an expression");
			return false;
		} else {
			editTree();
			return true;
		}
	}
}

function editTree(expression) {
	console.log(chart);
	chart.tree.reload();
}

function getTree() {	
	tree = {
		text: {
			name: "0"
		},
		children: [{
				text: {
					name: "100"
				}
			},
			{
				text: {
					name: "14"
				}
			}

		]
	};

	return tree;
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

		nodeStructure: tree
	};

	return chart_config;
}


// Sending and receiving data in JSON format using POST method

var xhr = new XMLHttpRequest();
var url = "url";
xhr.open("POST", url, true);
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var json = JSON.parse(xhr.responseText);
        console.log(json.email + ", " + json.password);
    }
};
var data = JSON.stringify({"email": "hey@mail.com", "password": "101010"});
xhr.send(data);