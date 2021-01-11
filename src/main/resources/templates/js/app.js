var app = angular.module('app', ['ngRoute']);


app.config(function($routeProvider){
    $routeProvider
        .when('/korisnici',{
            templateUrl: 'users.html',
            controller: 'usersController'
        })
         .when('/stan',{
            templateUrl: 'stan.html',
            controller: 'stanController'
        })
         .when('/sobe/edit/:id',{
            templateUrl: 'sobaEdit.html',
            controller: 'stanEditController'
        })
        
       
        .otherwise(
            { redirectTo: '/'}
        );
});

