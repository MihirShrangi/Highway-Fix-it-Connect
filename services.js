const map = L.map('map').setView([22.7203, 75.8676], 13);

	const tiles = L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
		maxZoom: 19,
		attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
	}).addTo(map);


coords = [[22.7246462, 75.8571168], [22.7291333, 75.8185065], [22.7417684, 75.8974368], [22.7004750, 75.8701819], [22.6815999, 75.8347774], [22.7283639, 75.8746719]]
rent = ['Taj Crane Service = +91-7867354628','My Car = +91-9898756275','MyTVS = +91-8976375987','A One Auto Car Service = +91-7898579802','Droom = +91-9080900654','Ar Towing Services = +91-8989095672']


let l = coords.length;

var t1 = document.querySelector('#t1');
var t2 = document.querySelector('#t2');
var t3 = document.querySelector('#t3');
var t4 = document.querySelector('#t4');
var t5 = document.querySelector('#t5');
var t6 = document.querySelector('#t6');

ts = [t1,t2,t3,t4,t5,t6]


for (let i = 0; i < l; i++)
{
    //popups
   var pop = L.popup({
       closeOnClick: true
    }).setContent('some text');
    //markers
    var marker = L.marker(coords[i]).addTo(map);
    
    //labels
    var toollip = L.tooltip({
        permanent: true
    }).setContent(rent[i]);
    marker.bindTooltip(toollip);


    //zoom in / fly to
    ts[i].addEventListener("mouseover", ()=> {
        map.flyTo(coords[i], 16)
    })
}