/*
  Line Chart
*/
new Morris.Line({
  // ID of the element in which to draw the chart.
  element: 'overviewchart',
  // Chart data records -- each entry in this array corresponds to a point on the chart.
  data: [
      { year: '2009', valueA: 0, valueB: 0, valueC: 0 },
      { year: '2010', valueA: 150, valueB: 30, valueC: 50 },
      { year: '2011', valueA: 20, valueB: 50, valueC: 150 },
      { year: '2012', valueA: 150, valueB: 80, valueC: 40 },
      { year: '2013', valueA: 20, valueB: 110, valueC: 150 },
      { year: '2014', valueA: 50, valueB: 150, valueC: 40 },
      { year: '2015', valueA: 150, valueB: 170, valueC: 130 }
  ],
  // The name of the data record attribute that contains x-values.
  xkey: 'year',
  // A list of names of data record attributes that contain y-values.
  ykeys: ['valueA', 'valueB', 'valueC'],
  // Labels for the ykeys -- will be displayed when you hover over the chart.
  labels: ['Series A', 'Series B', 'Series C'],
  // Line Colors -- line colors of the chart.
  lineColors: ['rgb(13, 167, 214)', 'rgb(209, 114, 193)', 'rgb(62, 153, 165)']
});

/*
  Donut Chart
*/
new Morris.Donut({
  element: 'donutchart',
  data: [
    { label: "Canada", value: 30 },
    { label: "London", value: 20 },
    { label: "USA", value: 12 }
  ],
  labelColor:"#9CC4E4",
  colors: ['#5e6ee4', 'lavender', 'rgb(13, 167, 214)']
});

/*
  Area Chart
*/
new Morris.Area({
  element: 'morris-area-chart',
  data: [
    {y:"2011", a:10, b:15},
    {y:"2012", a:30, b:35},
    {y:"2013", a:10, b:25},
    {y:"2014", a:55, b:45},
    {y:"2015", a:30, b:20},
    {y:"2016", a:40, b:35},
    {y:"2017", a:10, b:25},
    {y:"2018", a:25, b:30}
  ],
  xkey:"y",
  ykeys:["a","b"],
  labels:["Series A","Series B"],
  gridLineColor:"#eef0f2",
  lineColors:["#00c292","#03a9f3"],
  lineWidth:0,
  fillOpacity:.1,
  grid: false,
  axes: false,
  pointSize:0
});