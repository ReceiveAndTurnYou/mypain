<html>
<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load("current", {packages:["corechart"]});
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Услуга', 'Цена'],
                <#list map as key, value>
            ['${key}', ${value}],
        </#list>
            ['Sleep',    0]
        ]);

            var options = {
                title: 'График популярности типа товаров',
                pieHole: 0.1,
            };

            var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
<div id="donutchart" style="width: 900px; height: 500px;"></div>
</body>


<div th:insert="recycling/footer :: footer" ></div>
</html>