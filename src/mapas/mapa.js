var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
        osmAttrib = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
        osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});

var map = L.map('map').setView([-4.036, -79.201], 15);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);L.marker([-4.0288326810933714, -79.20570554047544]).addTo(map)
.bindPopup('DecorCars.')
 
L.marker([-4.032226299858193, -79.20608832955597]).addTo(map)
.bindPopup('MultiMercados El Portal.')
 
L.marker([-4.0, -74.0]).addTo(map)
.bindPopup('Media Luna.')
 
