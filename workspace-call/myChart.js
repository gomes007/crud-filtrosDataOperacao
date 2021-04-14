data = [18000, 12000, 20000, 15000, 10000, 23000, 20000];
labels = ["domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sábado"];

data2 = [20000, 14000, 12000, 15000, 18000, 19000, 22000];



function renderChart(data, labels) {
    var ctx = document.getElementById("myChart").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Esta semana',
                    data: data,
                },
                {
                    label: 'Semana seguinte',
                    data: data2,
                },
            ]
        },
    });
}

$("#renderBtn").click(
    function () {
        //data = [20000, 14000, 12000, 15000, 18000, 19000, 22000];
        //labels = ["domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sábado"];
        renderChart(data, labels);
    }
);

$("#changeBtn").click(
    function () {
        data[4] = 12000;
        renderChart(data, labels);
    }
);