/*----------------------------------
 * definicion de variables globales
 *---------------------------------*/

var mapboxaccesstoken = 'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw';
var attributionInfo = 'copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, '
	+ '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, '
	+ 'Imagery © <a href="http://mapbox.com">Mapbox</a>';

function mapModelInit(modelo,maxzoom){
	var layer = L.tileLayer(mapboxaccesstoken,{
		maxZoom : maxzoom,
		attribution : attributionInfo,
		id : modelo
		});
	return layer;
}

/*------------------------------------
 Inicializacion del mapa
 --------------------------------------*/
function initmap(id, coordx, coordy, initialzoom, maxzoom) {
	
	var streets = mapModelInit('mapbox.streets',maxzoom);
	
	var light = mapModelInit('mapbox.light',maxzoom);
	
	var map = L.map(id,{
		center:[coordx, coordy],
		zoom : initialzoom,
		layers:[light,streets]
	});	
	
	var baseMaps = {
		    "Light": light,
		    "Streets": streets
		};
	L.control.layers(baseMaps).addTo(map);
	
	return map
}

function addMarker(coordx, coordy, mapa, texto) {
	L.marker([coordx, coordy]).addTo(mapa).bindPopup(texto);// .openPopup();
}

function addCircle(coordx, coordy, radio, col, fillCol, fillOp, mapa, texto) {
	L.circle([51.508, -0.11], 500, {
		color : col,
		fillColor : fillCol,
		fillOpacity : fillOp
	}).addTo(mapa).bindPopup(texto);
}

function addPolygon(coordsList, mapa, texto) {
	L.polygon(coordsList).addTo(mapa).bindPopup(texto);
}

