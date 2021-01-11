var app = angular.module('app', ['ngRoute']);


app.config(function($routeProvider){
    $routeProvider
        .when('/korisnici',{
            templateUrl: '/views/users.html',
            controller: 'usersController'
        })
         .when('/',{
            templateUrl: '/views/stan.html',
            controller: 'stanController'
        })
         .when('/sobe/edit/:id',{
            templateUrl: '/views/sobaEdit.html',
            controller: 'stanEditController'
        })
        
       
        .otherwise(
            { redirectTo: '/'}
        );
});

