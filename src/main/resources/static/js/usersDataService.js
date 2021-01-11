(function(){

var app = angular.module("app");

app.service("usersDataService", function($http){
	var self = this;
	var baseUrl = "/api/users";
	
	//GET ALL USERS
	self.getUsers = function(){
		var promise1 = $http.get(baseUrl);
		var promise2 = promise1.then(function(response){
			return response.data;
		});
		return promise2;
	}
	
    //EDIT USER
    self.saveUser = function(userData){
       return $http.put(baseUrl +"/" + userData.id, userData)
        .then(function(response){
            console.log(response);

        });
    }

    //SAVE NEW USER
        self.createUser = function(userData){
           return $http.post(baseUrl + "/", userData)
           .then(function(response){
               console.log(response);
           });
       }
	
    //DELETE USER
        self.deleteUserID = function(userData){
        	return $http.delete(baseUrl + "/" + userData.id)
        	.then(function(response){
        		console.log(response);
        	});
        }
        
	
	
	
	
	
})

})();