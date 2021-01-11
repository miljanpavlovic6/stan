(function(){
	
	var app = angular.module("app");
	
	app.service("sobeDataService", function($http, $route, $timeout){
	var self = this;
	var baseSobeUrl = "/api/sobe";
	var baseStavkeUrl = "/api/stavke";
	
	//GET ALL SOBE
	self.getSobe = function(){
		var promise1 = $http.get(baseSobeUrl);
		var promise2 = promise1.then(function(response){
			return response.data;
		});
		return promise2;
	}
	//GET ALL STAVKE
	self.getStavke = function(){
		var promise1 = $http.get(baseStavkeUrl);
		var promise2 = promise1.then(function(response){
			return response.data;
		});
		return promise2;
	}
	//GET BY ID SOBE
	self.getSobeById = function(id){
		var promise1 = $http.get(baseSobeUrl + "/" + id);
		var promise2 = promise1.then(function(response){
			return response.data;
		});
		return promise2;
	}
	
	//GET BY ID STAVKE
	self.getStavkeById = function(id){
		var promise1 = $http.get(baseStavkeUrl + "/" + id);
		var promise2 = promise1.then(function(response){
			return response.data;
		});
		return promise2;
	}
	
	//SAVE NEW SOBA
    self.createSoba = function(sobaData){
       return $http.post(baseSobeUrl + "/", sobaData)
       .then(function(response){
           console.log(response);
       });
       
   }
  //SAVE SOBA BY ID - EDIT
    self.editSoba = function(id){
       return $http.put(baseSobeUrl + "/" + id)
       .then(function(response){
           console.log(response);
       });
       
   }
    
    
    
    
    
	
	//DELETE SOBA
	self.deleteSobaa = function(id){
	$http.delete(baseSobeUrl + "/" + id).then(
	            function success(data){
	            	
	            },
	            function error(data){
	                alert("Neuspesno brisanje!");
	            }
	        );
	 $timeout(function () {
         // 3000 ms delay to reload the page.
         $route.reload();
     }, 2000);
	}
		
		
		
		
	})
	
})();