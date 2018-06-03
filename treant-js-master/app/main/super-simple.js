
var simple_chart_config = {
	chart: {
		container: "#OrganiseChart-simple"
	},
	
	nodeStructure: {
		text: { name: "+" },
		children: [
			{
				text: { name: "5" },
				children : [
					{
						text: { name: "*" },
						children: [
							{text : "7"},
							{text: "4"},
						]
					},
				]
			},
			{
				text: { name: "2" }
			}
		]
	}
};