function downloadQR( ){
	var str = '<img src="';
	str += '../DownloadQR?code=';
	str += $( this ).attr( "id" );
	str += '" />';
	console.debug( str );
	
	swal( {
    	title: "C&oacute;digo QR",
    	text: str,
    	html: true,
    	allowOutsideClick: true,
    	confirmButtonText: "Aceptar"
    } );
	
}

$( document ).ready( function( ){
	$( ".action-down-qr" ).on( { click: downloadQR } );
} );