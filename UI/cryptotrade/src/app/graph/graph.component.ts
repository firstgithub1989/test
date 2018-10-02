import { Component, OnInit } from '@angular/core';
declare let d3: any;

@Component({
  selector: 'graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent implements OnInit {

  options: {};
  data: {};

  constructor() { }

  ngOnInit() {
    this.options = {
      chart: {
        type: 'ohlcBarChart',
                height: 450,
                margin : {
                    top: 20,
                    right: 20,
                    bottom: 40,
                    left: 60
                },
                x: function(d){ return d['date']; },
                y: function(d){ return d['close']; },
                duration: 100,
                xAxis: {
                    axisLabel: 'Dates',
                    tickFormat: function(d) {
                        return d3.time.format('%x')(new Date((20000 * 86400000) +
                        (d * 86400000)));
                    },
                    showMaxMin: false
                },

                yAxis: {
                    axisLabel: 'Stock Price',
                    tickFormat: function(d){
                        return '$' + d3.format(',.1f')(d);
                    },
                    showMaxMin: false
                },
                zoom: {
                    enabled: true,
                    scaleExtent: [1, 10],
                    useFixedDomain: false,
                    useNiceScale: false,
                    horizontalOff: false,
                    verticalOff: true,
                    unzoomEventType: 'dblclick.zoom'
                }
      }
    };
    this.data = [{values: [
      {"date":15326,"close":8182.89,"high":8278.01,"low":7806.25,"open":7937.1,"volume":80336.48,"adjusted":7806.09},{"date":15327,"close":8230.87,"high":8238.04,"low":8070.04,"open":8182.88,"volume":36136.12,"adjusted":8070.42},{"date":15328,"close":8216.78,"high":8291.55,"low":8123.53,"open":8230.82,"volume":34073.43,"adjusted":8123.98},{"date":15329,"close":8176.06,"high":8273.61,"low":7867.44,"open":8216.7,"volume":83918.76,"adjusted":7867.99},{"date":15329,"close":7735.3,"high":8176.27,"low":7663.7,"open":8176.08,"volume":97152.13,"adjusted":7663.24},{"date":15330,"close":7610.9,"high":7760.74,"low":7449.31,"open":7736.25,"volume":78466.37,"adjusted":7449.81},{"date":15331,"close":7542.34,"high":7713.32,"low":7470.86,"open":7610.9,"volume":55711.79,"adjusted":7470.76},{"date":15332,"close":7417.6,"high":7542.49,"low":7296.76,"open":7542.34,"volume":79126.57,"adjusted":7296.83},{"date":15333,"close":7017.89,"high":7490.89,"low":6940.15,"open":7417.6,"volume":74300.44,"adjusted":6940.97},{"date":15334,"close":7042.39,"high":7092.53,"low":6898.31,"open":7017.89,"volume":52556.01,"adjusted":6898.39},{"date":15335,"close":6945.78,"high":7160.4,"low":6854.79,"open":7042.57,"volume":58545.04,"adjusted":6854.75},{"date":15336,"close":6723.21,"high":7150.86,"low":6685.02,"open":6945.77,"volume":82683.83,"adjusted":6685.27}
  ]}];
  }

}
