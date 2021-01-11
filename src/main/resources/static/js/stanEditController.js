(function() {
var app = angular.module("app");

app.controller("stanEditController", stanEditController);

function stanEditController (sobeDataService, stavkeDataService, $scope, $http, $route, $timeout, $location, $routeParams){
	var baseUrlSoba = "/api/sobe";
	var baseUrlStavka = "/api/stavke";
	
	var self = this;
	self.editMode = false;
	self.addMode = false;
	
	 $scope.selectedSoba = null;
	 
	 $scope.stavke = null;
	 $scope.novStavka = {};
    
	
    var getSelectedSoba = function(){
        $http.get(baseUrlSoba + "/" + $routeParams.id)
            .then(
            	function success(res){
            		$scope.selectedSoba = res.data;
            	},
            	function error(data){
            		 self.successMessage = "Neuspesno dobavljanje soba !";
            	}
            );
    }
    getSelectedSoba();
    
    
    
    
    
    $scope.izmeniSoba = function(){
        $http.put(baseUrlSoba + "/" + $scope.selectedSoba.id, $scope.selectedSoba )
            .then(
            	function success(data){
            		$location.path('/');
            	},
            	function error(data){
            		 self.successMessage = "Neuspesno dobavljanje soba !";
            	}
            );
        
    };
   
    
    
	var getStavka = function(){
		$http.get(baseUrlSoba + "/"+ $routeParams.id + "/stavke")
			.then(
            	function success(res){
            		$scope.stavke = res.data;
            	},
            	function error(res){
            		self.successMessage = "Neuspesno dobavljanje stavki !";
            	}
            	);
		}
	getStavka();
	
	$scope.dodaj = function(){
        $http.post(baseUrlStavka, $scope.novStavka)
            .then(
            	function success(res){
            		getStavka();
            		 self.successMessage = "Uspesno dodata stavka !";
            		
            	},
            	 
            	function error(res){
            		 self.successMessage = "Neuspeh !";
            	}
            );
        
        $timeout(function () {
	         // 3000 ms delay to reload the page.
	         $route.reload();
	     }, 2000);
        
        
        
	};
	
	
	//DELETE SOBA
	this.deleteStavka = function(id){
		stavkeDataService.deleteStavkaID(id);
		 
		 self.successMessage = "Uspesno obrisana stavka !";
		 
		 $timeout(function () {
	         // 3000 ms delay to reload the page.
	         $route.reload();
	     }, 2000);
	}
	//EDIT STAVKA
	
	 // SAVE STAVKA EDIT
    this.saveEditStavka = function (){
        this.tooggleEditMode();//VRACA IZ SAVE STANJA U EDIT
       var stavkaData =  this.selectedStavka;
       stavkeDataService.saveStavka(stavkaData)
            //    DATA SUCCESS MESSAGE
           .then(function() {
                self.successMessage = "Stavka uspesno izmenjena !";
                
                $timeout(function () {
       	         $route.reload();
       	     }, 2000);
           },
           function() {
               self.errorMessage = "Greska !";
           }
           );
        
    }
	
	
	
	
	
	
	
	
    
   
	//POMOCNE FUNKCIJE
    $scope.getTotal = function(){
        var total = 0;
        for(var i = 0; i < $scope.stavke.length; i++){
            var product = $scope.stavke[i];
            var igra = parseInt(product.cena);
            total += igra;
        }
        return total;
    }
	
	
	this.odustani = function(){
    	$location.path("/");
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