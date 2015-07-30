var app = angular.module('gdnin', []);

app.controller('LoginController', function($scope, $location) {
    var url = "" + $location.$$absUrl;
    $scope.displayLoginError = (url.indexOf("error") >= 0);
});

