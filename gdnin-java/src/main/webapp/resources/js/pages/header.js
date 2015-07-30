var app = angular.module('app', []);

app.controller('LocationController', function ($scope, $location) {
    if($location.$$absUrl.lastIndexOf('/contacts') > 0){
        $scope.activeURL = 'contacts';
    } else{
        $scope.activeURL = 'home';
    }
});