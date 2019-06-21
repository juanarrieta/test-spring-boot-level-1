angular.module("GestionApp").controller("MovimientoController", MovimientoController);

MovimientoController.inject = [ '$scope', 'CuentaCorriente', 'Movimiento' ];

function MovimientoController($scope, CuentaCorriente, Movimiento) {
	
	//metodos para consultas
	$scope.cuentas = CuentaCorriente.query();
	$scope.movimientos = {};
	$scope.moves = Movimiento.query();
	
	//metodo para guardar 
	$scope.saveMovimiento = function() {
		var b=true;
		var sobre_giro;
		
		if($scope.num_cuenta == undefined || $scope.movimiento.tipo == undefined || $scope.movimiento.importe == undefined || $scope.movimiento.fecha == undefined){
			alert("Hay campos vacios porfavor llene todos los campos");
		}
		else{
			$scope.cuentas.forEach(function(cta) { 
				if(cta['num_cuenta'] == $scope.num_cuenta) {
					if(angular.equals($scope.movimiento.tipo,"debito")){
						sobre_giro = cta['saldo'] - $scope.movimiento.importe;
					}
					else{
						sobre_giro = cta['saldo'] + $scope.movimiento.importe;
					}
					
					if(angular.equals(cta['moneda'],"peso")){
						if(sobre_giro < -1000){
							b=false;
						}
					}
					if(angular.equals(cta['moneda'],"dolar")){
						if(sobre_giro < -300){
							b=false;
						}
					}
					if(angular.equals(cta['moneda'],"euro")){
						if(sobre_giro < -150){
							b=false;
						}
					}
				}
			});	
		
			if(b){
				$scope.cuentas.forEach(function(cta) {
					if(cta['num_cuenta'] == $scope.num_cuenta){
						$scope.movimiento.cuenta = cta;
					}
				});
					
				Movimiento.save($scope.movimiento, function() {
					$scope.moves = Movimiento.query();
					$scope.cuentas = CuentaCorriente.query();
					$scope.buscar();
				});
				alert("La transaccion fue registrada exitosamente, presione buscar para visualizar el registro");
			}
			else{
				alert("La transaccion ha sido cancelada, ya que el movimiento ocaciona un sobregiro de la cuenta.");
			}
		}
	}

	//metodo para buscar movimientos por numero de cuenta
	$scope.buscar = function() {
		var mov =[];
		$scope.moves.forEach(function(move) {
			if(move['cuenta']['num_cuenta'] == $scope.num_cuenta){
				mov.push(move);
			}
		});
		$scope.movimientos = mov;
	}
}