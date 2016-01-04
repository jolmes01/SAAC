function showFormRegister() {
    $('#myModal').modal('toggle');
}

function receiveData( data, status, xhr ){
	var json = undefined;
	try{
		json = JSON.parse( data );
		console.debug( json );
	}
	catch( exception ){
		console.error( data );
		console.error( exception );
		swal( {
	    	title: "Error",
	    	text: "Ha ocurrido un error inesperado",
	    	type: "error",
	    	allowOutsideClick: true,
	    	confirmButtonText: "Aceptar"
	    } );
		return;
	}
	if( json.status == 2 ){
		swal( {
	    	title: "Ops...",
	    	text: "El usuario o la contraseña son incorrectos",
	    	type: "error",
	    	allowOutsideClick: true,
	    	confirmButtonText: "Aceptar"
	    } );
	}
	else if( json.status == 3 ){
		swal( {
	    	title: "Ops...",
	    	text: "Hemos experimentado un error. Por favor, vuelve a intentarlo m\u00e1s tarde.",
	    	type: "error",
	    	allowOutsideClick: true,
	    	confirmButtonText: "Aceptar"
	    } );
	}
	else if( json.status == 100 ){
		window.location.replace( json.url );
	}
}//end function


function sendData( ){
	//validate
	if( ! $( "#login-form" ).valideasy( ) ){
		console.debug( "Not validated" );
		return;
	}
				    		
	$.ajax( {
		url: "Login", 
		data: {
			id: "Ingreso",
			userName: $( "#userName" ).val( ),
			claveUser: $( "#claveUser" ).val( )
		},
		method: "post",
		success: receiveData
	} );//end AJAX
}

$( document ).ready( function( ){
	//on "enter" press...
	$('#login-form input').keypress(function (e) {
	  if (e.which == 13) {
		sendData( );
		return false;
	  }
	}); 
	$( "#signin" ).click( sendData );
	
	$( "#signup-form" ).submit( function( event ){
		//prevent the form from sendding data
		event.preventDefault();
		if( ! $( "#signup-form" ).valideasy( ) ){
			console.debug( "Not validated" );
			return;
		}
		
		console.debug( $( this ).serialize( ) );

	} );
	
});//end documentReady