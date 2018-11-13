import { Component, OnInit, ViewChild } from '@angular/core';
import { TickerService } from '../ticker/ticker.service';
import { ActivatedRoute } from '@angular/router';
declare let d3: any;

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent implements OnInit {

  options: {};
  data: {};
  toSym: string;
  fromSym: string;

  constructor(private tickerService: TickerService,
    private route: ActivatedRoute) {
        this.route.params.subscribe( params => {
        this.toSym = params['toSym'];
        this.fromSym = params['fromSym'];
    });
  }

  ngOnInit() {
    this.options = {
      chart: {
        type: 'ohlcBarChart',
                height: 450,
                margin : {
                    top: 20,
                    right: 20,
                    bottom: 40,
                    left: 100
                },
                x: function(d){ return d['date']; },
                y: function(d){ return d['close']; },
                duration: 100,
                tooltip: {
                    hideDelay: 0,
                    enabled: false,
                },
                xAxis: {
                    axisLabel: 'Dates',
                    tickFormat: function(d) {
                        return d3.time.format('%I:%M:%S')(new Date(
                        (d * 1000)));
                    },
                    showMaxMin: false
                },

                yAxis: {
                    axisLabel: 'Stock Price',
                    margin: 60,
                    tickFormat: function(d){
                        return d3.format(',.6f')(d);
                    },
                    showMaxMin: true
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
//     this.data = [{'values': [
//         {"date":1539043200,"close":6631.79,"high":6657,"low":6589.39,"open":6650.07,"volume":32204.25,"adjusted":6650.07},
//         {"date":1539129600,"close":6581.07,"high":6633.22,"low":6487.86,"open":6631.79,"volume":49264.39,"adjusted":6631.79},
//         {"date":1539216000,"close":6209.47,"high":6581.59,"low":6171.95,"open":6581.07,"volume":104258.49,"adjusted":6581.07},
//         {"date":1539302400,"close":6250.85,"high":6296.56,"low":6173.86,"open":6209.47,"volume":46195.91,"adjusted":6209.47},
//         {"date":1539388800,"close":6267.27,"high":6280.73,"low":6238.92,"open":6252.1,"volume":21914.85,"adjusted":6252.1},
//         {"date":1539475200,"close":6277.73,"high":6346.56,"low":6247.17,"open":6267.27,"volume":34130.1,"adjusted":6267.27},
//         {"date":1539561600,"close":6612.36,"high":7234.83,"low":6244.77,"open":6277.73,"volume":177320.05,"adjusted":6277.73},
//         {"date":1539648000,"close":6583.05,"high":6724.91,"low":6545.54,"open":6612.69,"volume":49191.34,"adjusted":6612.69},
//         {"date":1539734400,"close":6574.52,"high":6589.2,"low":6511.6,"open":6583.05,"volume":33538.55,"adjusted":6583.05},
//         {"date":1539820800,"close":6488.72,"high":6616.27,"low":6445.05,"open":6576.4,"volume":50725.31,"adjusted":6576.4},{"date":1539907200,"close":6486.34,"high":6503.09,"low":6449.36,"open":6489.37,"volume":17488.56,"adjusted":6489.37}
//   ]}];

     this.tickerService.getHistStream(this.fromSym, this.toSym).subscribe(
        res => {
        this.data = [res];
    });
  }

}
