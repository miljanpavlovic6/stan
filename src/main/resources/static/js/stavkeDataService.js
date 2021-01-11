(function(){
	
	var app = angular.module("app");
	
	app.service("stavkeDataService", function($http, $route, $timeout){
	var self = this;
	var baseUrl = "/api/stavke";
	
	//GET ALL STAVKE
	self.getStavke = function(){
		var promise1 = $http.get(baseUrl);
		var promise2 = promise1.then(function(response){
			return response.data;
		});
		return promise2;
	}
	//GET BY ID STAVKE
	self.getStavkeById = function(id){
		var promise1 = $http.get(baseUrl + "/" + id);
		var promise2 = promise1.then(function(response){
			return response.data;
		});
		return promise2;
	}
	
    //EDIT STAVKA
    self.saveStavka = function(stavkaData){
       return $http.put(baseUrl +"/" + stavkaData.id, stavkaData)
        .then(function(response){
            console.log(response);

        });
    }

    //SAVE NEW STAVKA
        self.createStavka = function(stavkaData){
           return $http.post(baseUrl + "/", stavkaData)
           .then(function(response){
               console.log(response);
           });
       }
	
    //DELETE STAVKA
        self.deleteStavkaID = function(id){
        	return $http.delete(baseUrl + "/" + id)
        	.then(function(response){
        		console.log(response);
        	});
        }
		
		
		
	})
	
})();