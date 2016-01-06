$('#certainid').highcharts({
    chart: {
        plotBackgroundColor: 'null',
        plotBorderWidth: 'null',
        plotShadow: 'false'
    },
    title: {
        text: 'Browser market shares at a specific website, 2010'
    },
    toottip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: 'true',
            cursor: 'pointer',
            dataLabels: {
                enabled: 'true',
                color: '#000000',
                connectorColor: '#000000',
                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
            }
        }
    },
    series: [{
        type: 'pie',
        name: 'test2',
        data: [['test1', 10], ['test2', 11], ['test3', 10]]
    }]
});