(function() {

	var app = angular.module('app');

	app.controller('usersController', usersController);

	function usersController(usersDataService,$route, $timeout ) {
		this.headingTitle = "Korisnici";
		var self = this;
		self.editMode = false;
		self.addMode = false;

//CRUD FUNKCIJE
		// GET ALL
		usersDataService.getUsers().then(function(data) {
			self.users = data;
		})
		
		 // SAVE USER
	    this.saveUser = function (){
	        this.tooggleEditMode();//VRACA IZ SAVE STANJA U EDIT
	       var userData =  this.selectedContact;
	       
	    //    AKO SAM U ADD-MODE ONDA CU PROSLEDITI USERA U CREATE USERA, A AKO SAM U ...
	        if(self.addMode = true){
	        	usersDataService.createUser(userData)
	            //    DATA SUCCESS MESSAGE
	           .then(function(){
	                self.successMessage = "Korisnik uspesno izmenjen !";
	           },
	           function() {
	               self.errorMessage = "Greska !";
	           }
	           );
	           self.addMode = false;
	        }
	        else {
	        	usersDataService.saveUser(userData)
	            //    DATA SUCCESS MESSAGE
	           .then(function() {
	                self.successMessage = "Korisnik uspesno izmenjen !";
	           },
	           function() {
	               self.errorMessage = "Greska !";
	           }
	           );
	        }
	    }
		
		//ADD CONTACT
	    this.addContact = function (){
	        self.addMode = true;
	        this.editMode = true;
	        this.selectedContact = {};
	        self.selectedContact.nameFirst = undefined;
	        self.selectedContact.nameLast = undefined;
	        self.selectedContact.phone = undefined;
	        self.selectedContact.userName = undefined;
	        self.selectedContact.password = undefined;
	        self.selectedContact.active = true;
	        self.selectedContact.roles = "ROLE_USER";
	        self.selectedContact.picture = "http://www.clker.com/cliparts/d/L/P/X/z/i/no-image-icon-md.png";
	        
	    } 
	    //DELETE USER
	    this.deleteUser = function (){
	    	 var userData =  this.selectedContact;
	    	usersDataService.deleteUserID(userData);
		   self.successMessage = "Uspesno obrisan korisnik !";
		   
		   this.selectedContact = {};
	        self.selectedContact.nameFirst = undefined;
	        self.selectedContact.nameLast = undefined;
	        self.selectedContact.phone = undefined;
	        self.selectedContact.userName = undefined;
	        self.selectedContact.password = undefined;
	        self.selectedContact.active = undefined;
	        self.selectedContact.roles = undefined;
	        self.selectedContact.picture = undefined;
	        
	        $timeout(function () {
	            // 0 ms delay to reload the page.
	            $route.reload();
	        }, 0);
	    	
	    }
		
		
		
		
		
		
		
		
//POMOCNE FUNKCIJE
		// SELEKTUJ ODREDJENO IME
		this.selectContact = function(index) {
			this.selectedContact = this.users[index];
			// UKLANJANJE SUCCESS MESSAGE POSLE UNETE PROMENE
			self.successMessage = undefined;
			self.errorMessage = undefined;
		}

		// EDIT MODE
		this.tooggleEditMode = function() {
			this.editMode = !this.editMode;
		}
		
		

	}

})();