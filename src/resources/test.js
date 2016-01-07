$(function () {
    Highcharts.setOptions({
        // 所有语言文字相关配置都设置在 lang 里
        lang: {
            resetZoom: '重置',
            resetZoomTitle: '重置缩放比例'
        }
    });
    $('#container').highcharts({

        chart: {
            zoomType: 'x',
            selectionMarkerFill: 'rgba(0,0,0, 0.2)',
            resetZoomButton: {
                // 按钮定位
            	position:{
                    align: 'right', // by default
                    verticalAlign: 'top', // by default
                    x: 0,
                    y: -30
                },
                // 按钮样式
                theme: {
                    fill: 'white',
                    stroke: 'silver',
                    r: 0,
                    states: {
                        hover: {
                            fill: '#41739D',
                            style: {
                                color: 'white'
                            }
                        }
                    }
                }
            }
        },

        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },

        series: [{
            data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
        }]
    });
});