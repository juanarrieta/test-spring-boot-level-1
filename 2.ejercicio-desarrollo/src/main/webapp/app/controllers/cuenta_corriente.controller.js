angular.module("GestionApp").controller("CuentaCorrienteController", CuentaCorrienteController);

CuentaCorrienteController.inject = [ '$scope', 'CuentaCorriente', 'TitularFisico', 'TitularJuridico', 'Movimiento' ];

function CuentaCorrienteController($scope, CuentaCorriente, TitularFisico, TitularJuridico, Movimiento) {
	
	//metodos para consultas
	$scope.cuentas = CuentaCorriente.query();
	$scope.movimientos = Movimiento.query();

	//metodo para guardar 
	$scope.saveCuenta = function() {
		var b=true;
		
		$scope.cuentas.forEach(function(cta) { 
			if(cta['num_cuenta'] == $scope.cuenta.num_cuenta) {
				b=false;
			}
		});	
		
		if(b){
			if(angular.equals($scope.tipo, "1")){
				$scope.titulares.forEach(function(titu) {
					if(titu['rut'] == $scope.titular){
						$scope.cuenta.titular_fis = titu;
					}
				});
			}
			else{
				$scope.titulares.forEach(function(titu) {
					if(titu['rut'] == $scope.titular){
						$scope.cuenta.titular_jur = titu;
					}
				});
			}
		
			CuentaCorriente.save($scope.cuenta, function() {
				$scope.cuentas = CuentaCorriente.query();
			});			
			
			alert("La cuenta fue registrada exitosamente");
		}
		else{
			alert("Ya hay una cuenta registrada con ese numero de cuenta");
		}
		
	}

	//metodo para eliminar
	$scope.deleteCuenta = function(cuenta) {
		var v=true;
		
		$scope.movimientos.forEach(function(mov) { 
			if(mov['cuenta']['num_cuenta'] == cuenta.num_cuenta) {
				v=false;
			}
		});	
		
		if(v){
			cuenta.$delete({id: cuenta.num_cuenta}, function() {
				$scope.cuentas = CuentaCorriente.query();
			});
		}
		else{
			alert("No se puede eliminar la cuenta, ya que esta posee registro de movimientos.");
		}
	}
	
	//metodo para cargas el combo de los titulares
	$scope.change = function() {
		if(angular.equals($scope.tipo, "1")){
			$scope.titulares = TitularFisico.query();
		}
		else{
			$scope.titulares = TitularJuridico.query();
		}
	}
}