(function() {

	var app = angular.module('app');

	app.controller('stanController', stanController);

	function stanController(sobeDataService,stavkeDataService, $http, $route, $timeout, $location) {
		this.headingTitle = "Stan";
		var self = this;
		self.editMode = false;
		self.addMode = false;
		var baseSobeUrl = "/api/sobe";
		var baseStavkeUrl = "/api/stavke";
		
//CRUD FUNKCIJE
		// GET ALL SOBE
		sobeDataService.getSobe().then(function(data) {
			self.sobe = data;
		})
		// GET ALL STAVKE
		sobeDataService.getStavke().then(function(data) {
			self.stavke = data;
		})
		//
		
		 this.saveSoba = function (){
	        this.tooggleEditMode();//VRACA IZ SAVE STANJA U EDIT
	       var userData =  this.selectedSoba;
	       
	        	sobeDataService.createSoba(userData)
	           .then(function(){
	                self.successMessage = "Soba uspesno dodata !";
	                $timeout(function () {
	 	               // 3000 ms delay to reload the page.
	 	               $route.reload();
	 	           }, 2000);
	           },
	           function() {
	               self.errorMessage = "Greska !";
	           }
	           );
	           self.addMode = false;
	           
	    }
		
		
		
		//DELETE SOBA
		this.deleteSoba = function(id){
			sobeDataService.deleteSobaa(id);
			 
			 self.successMessage = "Uspesno obrisana prostorija !";
		}
		

		
		//ADD CONTACT
	    this.addSoba = function (){
	        self.addMode = true;
	        this.editMode = true;
	        this.selectedSoba = {};
	        self.selectedSoba.name = "Nova prostorija";
	        
	        
	    } 
		
		
		
		
	    
		
		//POMOCNE FUNKCIJE
	 
	    
	    
	    this.izmeniSoba = function(id){
	        $location.path('/sobe/edit/' + id);
	    }
		
		// SELEKTUJ STAVKU
		this.selectStavka = function(id) {
			var promise1 = sobeDataService.getStavkeById(id).then(function(data) {
			self.stavke = data;
			});
				console.log(this.selectedStavka);
				console.log("Selektuj: " + id);
				this.selectedStavka = self.stavke;
			
		}
		

		// EDIT MODE
		this.tooggleEditMode = function() {
			this.editMode = !this.editMode;
		}
		
	}

})();