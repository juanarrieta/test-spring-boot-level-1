angular.module("GestionApp").controller("LoginController", LoginController);

LoginController.inject = [ '$scope', 'User' ];

function LoginController($scope, User) {
	
	$scope.users = User.query();

	$scope.login = function() {
		$scope.users.forEach(function(usu) { //alert(JSON.stringify(usu['user']));
			if(usu['user'] == $scope.user.user && usu['pwd'] == $scope.user.pwd) {
				window.location.href = "http://localhost:8080/app/view/titulares.html?";
			}
			else {
				alert('Usuario o clave erroneas, intentalo de nuevo');
			}
		});
	}	
}