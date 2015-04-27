
/**
 * @fileoverview
 * Provides methods for the Hello Endpoints sample UI and interaction with the
 * Hello Endpoints API.
 *
 * @author danielholevoet@google.com (Dan Holevoet)
 */

/** google global namespace for Google projects. */
var google = google || {};

/** devrel namespace for Google Developer Relations projects. */
google.devrel = google.devrel || {};

/** samples namespace for DevRel sample code. */
google.devrel.samples = google.devrel.samples || {};

/** hello namespace for this sample. */
google.devrel.samples.hello = google.devrel.samples.hello || {};

/**
 * Client ID of the application (from the APIs Console).
 * @type {string}
 */
google.devrel.samples.hello.CLIENT_ID =
	'replace this with your web client ID';

/**
 * Scopes used by the application.
 * @type {string}
 */
google.devrel.samples.hello.SCOPES =
	'https://www.googleapis.com/auth/userinfo.email';

/**
 * Whether or not the user is signed in.
 * @type {boolean}
 */
google.devrel.samples.hello.signedIn = false;

/**
 * Loads the application UI after the user has completed auth.
 */
google.devrel.samples.hello.userAuthed = function() {
	var request = gapi.client.oauth2.userinfo.get().execute(function(resp) {
		if (!resp.code) {
			google.devrel.samples.hello.signedIn = true;
			document.getElementById('signinButton').innerHTML = 'Sign out';
			document.getElementById('authedGreeting').disabled = false;
		}
	});
};

/**
 * Handles the auth flow, with the given value for immediate mode.
 * @param {boolean} mode Whether or not to use immediate mode.
 * @param {Function} callback Callback to call on completion.
 */
google.devrel.samples.hello.signin = function(mode, callback) {
	gapi.auth.authorize({client_id: google.devrel.samples.hello.CLIENT_ID,
		scope: google.devrel.samples.hello.SCOPES, immediate: mode},
		callback);
};

/**
 * Presents the user with the authorization popup.
 */
google.devrel.samples.hello.auth = function() {
	if (!google.devrel.samples.hello.signedIn) {
		google.devrel.samples.hello.signin(false,
				google.devrel.samples.hello.userAuthed);
	} else {
		google.devrel.samples.hello.signedIn = false;
		document.getElementById('signinButton').innerHTML = 'Sign in';
		document.getElementById('authedGreeting').disabled = true;
	}
};

/**
 * Prints a greeting to the greeting log.
 * param {Object} greeting Greeting to print.
 */
google.devrel.samples.hello.print = function(greeting) {
	var element = document.createElement('div');
	element.classList.add('row');
	element.innerHTML = greeting.message;
	document.getElementById('outputLog').appendChild(element);
};

/**
 * Gets a numbered greeting via the API.
 * @param {string} id ID of the greeting.
 */
google.devrel.samples.hello.getGreeting = function(id) {
	gapi.client.helloworld.greetings.getGreeting({'id': id}).execute(
			function(resp) {
				if (!resp.code) {
					google.devrel.samples.hello.print(resp);
				} else {
					window.alert(resp.message);
				}
			});
};

/**
 * Lists greetings via the API.
 */
google.devrel.samples.hello.listGreeting = function() {
	gapi.client.helloworld.greetings.listGreeting().execute(
			function(resp) {
				if (!resp.code) {
					resp.items = resp.items || [];
					for (var i = 0; i < resp.items.length; i++) {
						google.devrel.samples.hello.print(resp.items[i]);
					}
				}
			});
};

/**
 * Gets a greeting a specified number of times.
 * @param {string} greeting Greeting to repeat.
 * @param {string} count Number of times to repeat it.
 */
google.devrel.samples.hello.multiplyGreeting = function(
		greeting, times) {
	gapi.client.helloworld.greetings.multiply({
		'message': greeting,
		'times': times
	}).execute(function(resp) {
		if (!resp.code) {
			google.devrel.samples.hello.print(resp);
		}
	});
};

/**
 * Greets the current user via the API.
 */
google.devrel.samples.hello.authedGreeting = function(id) {
	gapi.client.helloworld.greetings.authed().execute(
			function(resp) {
				google.devrel.samples.hello.print(resp);
			});
};

/**
 * Enables the button callbacks in the UI.
 */
google.devrel.samples.hello.enableButtons = function() {
	document.getElementById('getGreeting').onclick = function() {
		google.devrel.samples.hello.getGreeting(
				document.getElementById('id').value);
	}

	document.getElementById('listGreeting').onclick = function() {
		google.devrel.samples.hello.listGreeting();
	}

	document.getElementById('multiplyGreetings').onclick = function() {
		google.devrel.samples.hello.multiplyGreeting(
				document.getElementById('greeting').value,
				document.getElementById('count').value);
	}

	document.getElementById('authedGreeting').onclick = function() {
		google.devrel.samples.hello.authedGreeting();
	}

	document.getElementById('signinButton').onclick = function() {
		google.devrel.samples.hello.auth();
	}
};

/**
 * Initializes the application.
 * @param {string} apiRoot Root of the API's path.
 */
google.devrel.samples.hello.init = function(apiRoot) {
	// Loads the OAuth and helloworld APIs asynchronously, and triggers login
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			google.devrel.samples.hello.enableButtons();
			google.devrel.samples.hello.signin(true,
					google.devrel.samples.hello.userAuthed);
		}
	}

	apisToLoad = 2; // must match number of calls to gapi.client.load()
	gapi.client.load('helloworld', 'v1', callback, apiRoot);
	gapi.client.load('oauth2', 'v2', callback);
};


//реєстрація 


function formValidation()  
{  
	var uid = document.registration.userid;  
	var passid = document.registration.passid;  
	var uname = document.registration.username;  
	var ufac = document.registration.faculty;  
	var ucourse = document.registration.course;  
	var uemail = document.registration.email;  

	{  
		if(passid_validation(passid,7,12))  
		{  
			if(allLetter(uname))  
			{  
				if(facultyselect(ufac))  
				{  
					if(courseselect(ucourse))  
					{  
						if(ValidateEmail(uemail))  
						{   
							{  
							}  
						}   
					}  
				}   
			}  
		}  

	}  
	return false;  
}  




//повертання паролю
function passid_validation(passid,mx,my)  
{  
	var passid_len = passid.value.length;  
	if (passid_len == 0 ||passid_len >= my || passid_len < mx)  
	{  
		alert("Password should not be empty / length be between "+mx+" to "+my);  
		passid.focus();  
		return false;  
	}  
	return true;  
}



//повертання ніку 
function allLetter(uname)  
{   
	var letters = /^[A-Za-z]+$/;  
	if(uname.value.match(letters))  
	{  
		return true;  
	}  
	else  
	{  
		alert('Username must have alphabet characters only');  
		uname.focus();  
		return false;  
	}  
}  

//повертання мейлу 

function ValidateEmail(uemail)  
{  
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(uemail.value.match(mailformat))  
	{  
		return true;  
	}  
	else  
	{  
		alert("You have entered an invalid email address!");  
		uemail.focus();  
		return false;  
	}  
}  

  