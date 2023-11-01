$(document).ready(function () {
    var gearChart = am4core.create("gearTypeChart", am4charts.PieChart);
    var fuelChart = am4core.create("fuelTypeChart", am4charts.PieChart);

    $.ajax({
        url: "/CarRaport",
        method: "GET",
        contentType: 'application/json',
        dataType: 'json'
    }).done(function (data) {

        console.log(data);
        gearChart.data = [{

            "gearType": "Otomatic Gear",
            "data": data.O,
            "color": am4core.color("#352F44")
        }, {
            "gearType": "Manuel Gear",
            "data": data.M,
            "color": am4core.color("#B9B4C7")

        }]
        fuelChart.data = [{

            "fuelType": "Fuel",
            "data": data.F,
            "color": am4core.color("#512B81")
        }, {
            "fuelType": "Diesel",
            "data": data.D,
            "color": am4core.color("#9F91CC")
        }, {
            "fuelType": "Hybrid",
            "data": data.H,
            "color": am4core.color("#A084E8")
        }, {
            "fuelType": "Electric",
            "data": data.E,
            "color": am4core.color("#974EC3")
        }]

        function animateValue(obj, start, end, duration) {
            let startTimestamp = null;
            const step = (timestamp) => {
                if (!startTimestamp) startTimestamp = timestamp;
                const progress = Math.min((timestamp - startTimestamp) / duration, 1);
                obj.innerHTML = Math.floor(progress * (end - start) + start);
                if (progress < 1) {
                    window.requestAnimationFrame(step);
                }
            };
            window.requestAnimationFrame(step);
        }

        const obj = document.getElementById("value");
        animateValue(obj, 0, data.NumberOfCars, 4000);


        var gearPieSeries = gearChart.series.push(new am4charts.PieSeries());
        gearPieSeries.dataFields.value = "data";
        gearPieSeries.dataFields.category = "gearType";
        gearPieSeries.slices.template.stroke = am4core.color("#FAF0E6");
        gearPieSeries.slices.template.strokeWidth = 2;
        gearPieSeries.slices.template.strokeOpacity = 1;
        gearPieSeries.labels.template.text = "{category}";
        gearPieSeries.slices.template.propertyFields.fill = "color";
        gearChart.legend = new am4charts.Legend();

        var fuelPieSeries = fuelChart.series.push(new am4charts.PieSeries());
        fuelPieSeries.dataFields.value = "data";
        fuelPieSeries.dataFields.category = "fuelType";
        fuelPieSeries.slices.template.stroke = am4core.color("#FAF0E6");
        fuelPieSeries.slices.template.strokeWidth = 2;
        fuelPieSeries.slices.template.strokeOpacity = 1;
        fuelPieSeries.labels.template.text = "{category}";
        fuelPieSeries.slices.template.propertyFields.fill = "color";
        fuelChart.legend = new am4charts.Legend();

    });
});

$(document).ready(function () {


    var colorChart = am4core.create("colorChart", am4charts.XYChart);
    var colorData = [];

    $.ajax({
        url: "/ColorReport",
        method: "GET",
        contentType: 'application/json',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);

        for (var color in data) {
            var value = data[color];

            // Add data for each color to the array
            colorData.push({
                "color": color,
                "amountOfColor": value
            });
        }

        // Assign the array of data to colorChart.data
        colorChart.data = colorData;
        var categoryAxis = colorChart.xAxes.push(new am4charts.CategoryAxis());
        categoryAxis.dataFields.category = "color";

        var valueAxis = colorChart.yAxes.push(new am4charts.ValueAxis());
        valueAxis.title.text = "Amount Of Colors"; // Modify this to fit your data

        var series = colorChart.series.push(new am4charts.ColumnSeries());
        series.dataFields.valueY = "amountOfColor";
        series.dataFields.categoryX = "color";
        series.name = "Color";
        series.columns.template.tooltipText = "Color: {categoryX}\nAmount: {valueY}";
        colorChart.cursor = new am4charts.XYCursor();

        // Add distinctive colors for each column using adapter
        // series.columns.template.adapter.add("fill", (fill, target) => {
        //     return colorChart.colors.getIndex(target.dataItem.index);
        // });
        // Set the data from colorData array
        series.columns.template.adapter.add("fill", function (fill, target) {
            var colors = ["#279EFF", "#FFEECC", "#000000", "#4E6C50", "#F86F03", "#FE0000", "#FFFFFF", "#DAC0A3", "#F1C93B", "#102C57", "#0B666A", "#54B435", "#9BA4B5"]; // Add more colors as needed
            return am4core.color(colors[target.dataItem.index % colors.length]);
        });
        // series.columns.template.adapter.add("stroke", function (fill, target) {
        //     var colors = ["#279EFF", "#FFEECC", "#000000", "#4E6C50", "#F86F03", "#FE0000", "#FFFFFF", "#DAC0A3", "#F1C93B", "#102C57", "#0B666A", "#54B435", "#9BA4B5"]; // Add more colors as needed
        //     return am4core.color(colors[target.dataItem.index % colors.length]);
        // });
        series.columns.template.stroke = am4core.color("#000000");
        colorChart.validateData();
        series.data = colorData;

    });
})

$(document).ready(function () {


    var brandChart = am4core.create("brandChart", am4charts.XYChart);
    var brandData = [];

    $.ajax({
        url: "/BrandReport",
        method: "GET",
        contentType: 'application/json',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);

        for (var brand in data) {
            var value = data[brand];

            // Add data for each color to the array
            brandData.push({
                "brand": brand,
                "amountOfBrand": value
            });
        }

        // Assign the array of data to colorChart.data
        brandChart.data = brandData;
        var categoryAxis = brandChart.xAxes.push(new am4charts.CategoryAxis());
        categoryAxis.dataFields.category = "brand";

        var valueAxis = brandChart.yAxes.push(new am4charts.ValueAxis());
        valueAxis.title.text = "Amount Of Brands"; // Modify this to fit your data

        var series = brandChart.series.push(new am4charts.ColumnSeries());
        series.dataFields.valueY = "amountOfBrand";
        series.dataFields.categoryX = "brand";
        series.name = "Brand";
        series.columns.template.tooltipText = "Brand: {categoryX}\nAmount: {valueY}"
        series.data = brandData;
        brandChart.cursor = new am4charts.XYCursor();
        series.columns.template.fill = am4core.color("#79155B");
        series.columns.template.stroke = am4core.color("#000000");
        // Set the data from colorData array
        brandChart.validateData();

    });
});



