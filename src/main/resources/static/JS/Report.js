//-----------------------------------------------------
// Title: Report.js
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary:The JavaScript file primarily focuses on fetching data through AJAX requests and visualizing it using am4charts for different aspects of the car data, including gear types, fuel types, colors, and brands. It serves the purpose of presenting a comprehensive overview of car-related statistics in a visual and interactive manner.
//----------------------------------------------------
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

// $(document).ready(function () {


//     var brandPriceChart = am4core.create("brandPriceChart", am4charts.XYChart);
//     var brandData = [];

//     $.ajax({
//         url: "/BrandPriceReport",
//         method: "GET",
//         contentType: 'application/json',
//         dataType: 'json'
//     }).done(function (data) {
//         console.log(data);

//         for (var brand in data) {
//             if (data.hasOwnProperty(brand)) { // Ensure it's a direct property of the object, not from the prototype chain
//                 var brandRich = data[brand];
    
//                 // Access the fields of BrandRich
//                 var totalPrice = brandRich.totalPrice;
//                 var maxPrice = brandRich.maxPrice;
//                 var minPrice = brandRich.minPrice;
//                 var averagePrice = brandRich.averagePrice;
    
//                 // Add data for each brand to the array
//                 brandData.push({
//                     "brand": brand,
//                     "totalPrice": totalPrice,
//                     "maxPrice": maxPrice,
//                     "minPrice": minPrice,
//                     "averagePrice": averagePrice
//                 });
//             }

//         // Assign the array of data to colorChart.data
//         brandChart.data = brandData;
//         var categoryAxis = brandChart.xAxes.push(new am4charts.CategoryAxis());
//         categoryAxis.dataFields.category = "brand";

//         var valueAxis = brandChart.yAxes.push(new am4charts.ValueAxis());
//         valueAxis.title.text = "Prices"; // Modify this to fit your data

//         function createSeries(field, name) {
//             var series = brandChart.series.push(new am4charts.LineSeries());
//             series.dataFields.valueY = field;
//             series.dataFields.categoryX = "brand";
//             series.name = name;
//             series.tooltipText = "{name}: [bold]{valueY}[/]";
//             return series;
//         }
//         // Add series for different properties
//         createSeries("totalPrice", "Total Price");
//         createSeries("maxPrice", "Max Price");
//         createSeries("minPrice", "Min Price");
//         createSeries("averagePrice", "Average Price");
        
//         // Add data to the chart
//         chart.data = brandData;

//         // var series = brandChart.series.push(new am4charts.ColumnSeries());
//         // series.dataFields.valueY = "amountOfBrand";
//         // series.dataFields.categoryX = "brand";
//         // series.name = "Brand";
//         // series.columns.template.tooltipText = "Brand: {categoryX}\nAmount: {valueY}"
//         // series.data = brandData;
//         // brandChart.cursor = new am4charts.XYCursor();
//         // series.columns.template.fill = am4core.color("#79155B");
//         // series.columns.template.stroke = am4core.color("#000000");
//         // // Set the data from colorData array
//         // brandChart.validateData();
//         brandChart.validateData();

//     });
// });

$(document).ready(function () {
    var brandChart = am4core.create("brandPriceChart", am4charts.XYChart);
    var brandData = [];

    $.ajax({
        url: "/BrandPriceReport",
        method: "GET",
        contentType: 'application/json',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);

        // Iterate through the keys of the HashMap
        for (var brand in data) {
            if (data.hasOwnProperty(brand)) {
                var brandRich = data[brand];

                // Access the fields of BrandRich
                var totalPrice = brandRich.totalPrice;
                var maxPrice = brandRich.maxPrice;
                var minPrice = brandRich.minPrice;
                var averagePrice = brandRich.averagePrice;

                // Add data for each brand to the array
                brandData.push({
                    "brand": brand,
                    "totalPrice": totalPrice,
                    "maxPrice": maxPrice,
                    "minPrice": minPrice,
                    "averagePrice": averagePrice
                });
            }
        }

        // Create chart
        var categoryAxis = brandChart.xAxes.push(new am4charts.CategoryAxis());
        categoryAxis.dataFields.category = "brand";

        var valueAxis = brandChart.yAxes.push(new am4charts.ValueAxis());
        valueAxis.title.text = "Prices"; // Modify this to fit your data

        // Create series for different properties
        function createSeries(field, name) {
            var series = brandChart.series.push(new am4charts.LineSeries());
            series.dataFields.valueY = field;
            series.dataFields.categoryX = "brand";
            series.name = name;
            series.tooltipText = "{name}: [bold]{valueY}[/]";
            return series;
        }

        // Add series for different properties
        createSeries("totalPrice", "Total Price");
        createSeries("maxPrice", "Max Price");
        createSeries("minPrice", "Min Price");
        createSeries("averagePrice", "Average Price");

        // Add data to the chart
        brandChart.data = brandData;

        // Uncomment the following lines if you want to configure additional settings for your chart
        brandChart.cursor = new am4charts.XYCursor();
        series.columns.template.fill = am4core.color("#79155B");
        series.columns.template.stroke = am4core.color("#000000");

        // Validate the data to render the chart
        brandChart.validateData();
    });
});





