/** *************************/
/* Efecto Scroll ************/
/** ************************* */
let ubicacionY = window.pageYOffset;
window.onscroll = function() {
	let desplazamientoScroll = window.pageYOffset;
	if (ubicacionY >= desplazamientoScroll) {
		document.getElementById('cabecera').style.display = 'block';
		document.getElementById('seccion').style.paddingTop = '400px';
	} else {
		document.getElementById('cabecera').style.display = 'none';
		document.getElementById('seccion').style.paddingTop = '250px';
	}
	ubicacionY = desplazamientoScroll;
}

$(document).ready(function() {
	/** ************************ */
	/* Cabecera **************** */
	/** ************************ */
	$(".enlace-menu-0").click(function() {
		$(".enlace-menu-1").removeClass("active-menu");
		$(".enlace-menu-2").removeClass("active-menu");
		$(".enlace-menu-0").addClass("active-menu");
		document.getElementById('cabecera').style.display = 'none';
		document.getElementById('seccion').style.paddingTop = '250px';
	});

	$(".enlace-menu-1").click(function() {
		$(".enlace-menu-0").removeClass("active-menu");
		$(".enlace-menu-2").removeClass("active-menu");
		$(".enlace-menu-1").addClass("active-menu");
		document.getElementById('cabecera').style.display = 'none';
		document.getElementById('seccion').style.paddingTop = '250px';
	});

	$(".enlace-menu-2").click(function() {
		$(".enlace-menu-1").removeClass("active-menu");
		$(".enlace-menu-0").removeClass("active-menu");
		$(".enlace-menu-2").addClass("active-menu");
		document.getElementById('cabecera').style.display = 'none';
		document.getElementById('seccion').style.paddingTop = '250px';
	});

	var contador = 0;
	$(".checkbtn").click(function() {
		if (contador == 0) {
			document.getElementById('cabecera').style.display = 'none';
			contador = 1;
		} else {
			document.getElementById('cabecera').style.display = 'block';
			contador = 0;
		}
	});
});
