function showFormRegister() {
    $('#myModal').modal('toggle');
}

function getFormData( $form ){
	var array = $form.serializeArray( );
	var json = {};
	
	jQuery.map( array, function( n, i ){
		json[ n['name'] ] = n['value'];
	} );
	
	return json;
}


$( document ).ready( function( ){
	//on "enter" press...
	/*$('#login-form input').keypress(function (e) {
	  if (e.which == 13) {
		sendData( );
		return false;
	  }
	});*/ 
	//$( "#signin" ).click( sendData );
	
	$( "#signup-form" ).submit( function( event ){
		//prevent the form from sendding data
		event.preventDefault();
		if( ! $( "#signup-form" ).valideasy( ) ){
			console.debug( "Not validated" );
			return;
		}
		var formData = getFormData( $( this ) );
		formData.param = "Alta";
		
		jQuery.ajax( {
			"data": formData,
			"method": "post",
			"url": "Registrar",
			success: function( data, status, xhr ){
				console.debug( "Exito" );
				$('#myModal').modal( 'hide' );
				$('#myModal').on('hidden.bs.modal', function (e) {
					var response = JSON.parse( data );
					if( response.status == 100 ){
						swal( "Correcto", response.description, "success" );
					}
					else{
						console.error( "Error al agregar al usuario: " + response.status );
						swal( "Error", response.description, "error" );
					}
					
				})
			}
		} );

	} );
	
});//end documentReady