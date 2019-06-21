angular.module("GestionApp").controller("TitularController", TitularController);

TitularController.inject = [ '$scope', 'TitularFisico', 'TitularJuridico', 'CuentaCorriente' ];

function TitularController($scope, TitularFisico, TitularJuridico, CuentaCorriente) {
	var save=1;
	//metodos para consultar todos los titulares
	$scope.cuentas = CuentaCorriente.query();
	$scope.titulares_juridicos = TitularJuridico.query();
	$scope.titulares_fisicos = TitularFisico.query();
	
	$scope.titular_fisico = {};
	$scope.titular_juridico = {};
	
	$scope.buttonText="Guardar";
	
	
	//metodo para guardar y actualiar
	$scope.saveTitular = function() {
		var b=true;
		if(angular.equals($scope.tipo, "1")){
			if (save == 0) {
				TitularFisico.update($scope.titular_fisico, function() {
					$scope.titulares_fisicos = TitularFisico.query();
					$scope.titular_fisico = {};
					$scope.buttonText="Guardar";
					save=1;
				});
				alert("El titular fue actualizado correctamente");	
			} else {
				$scope.titulares_fisicos.forEach(function(titu) { 
					if(titu['rut'] == $scope.titular_fisico.rut) {
						b=false;
					}
				});	
				
				if(b){
					TitularFisico.save($scope.titular_fisico, function() {
						$scope.titulares_fisicos = TitularFisico.query();
						$scope.titular_fisico = {};
					});
					alert("El titular fue registrado exitosamente");
				}
				else{
					alert("Ya hay un titular registrado con ese numero de rut");
				}
			}
		}
		else{
			if (save == 0) {
				TitularJuridico.update($scope.titular_juridico, function() {
					$scope.titulares_juridicos = TitularJuridico.query();
					$scope.titular_juridico = {};
					$scope.buttonText="Guardar";
					save=1;
				});
				alert("El titular fue actualizado correctamente");	
			} else {
				$scope.titulares_juridicos.forEach(function(titu) { 
					if(titu['rut'] == $scope.titular_juridico.rut) {
						b=false;
					}
				});	
				
				if(b){
					TitularJuridico.save($scope.titular_juridico, function() {
						$scope.titulares_juridicos = TitularJuridico.query();
						$scope.titular_juridico = {}; 
					});
					alert("El titular fue registrado exitosamente");
				}
				else{
					alert("Ya hay un titular registrado con ese numero de rut");
				}	
			}
		}
	}

	//metodo para iniciar la actualizacion
	$scope.updateTitularInit = function(titular) {
		$scope.buttonText="Actualizar";
		$scope.titular_fisico = titular;
		$scope.titular_juridico = titular;
		var fecha = new Date($scope.titular_juridico.anio_fund);
		$scope.titular_juridico.anio_fund = fecha.getFullYear() +"-"+ fecha.getMonth() +"-"+ fecha.getDate();
		save=0;
		$("#titular_fisicoRut").prop('disabled', true);
		$("#titular_juridicoRut").prop('disabled', true);
		$("#tipo").prop('disabled', true);
	}

	//metodo para eliminar un titular
	$scope.deleteTitular = function(titular) {
		var v = true;
		if(angular.equals($scope.tipo, "1")){
			$scope.cuentas.forEach(function(cta) {
				if(cta['titular_fis'] !== null){
					if(cta['titular_fis']['rut'] == titular.rut){
						v = false;
					}
					
					if(v){
						titular.$delete({id: titular.rut}, function() {
							$scope.titulares_fisicos = TitularFisico.query();
						});
					}
				}
			});
			
			if(!v)
				alert("El titular tiene asociada una cuenta corriente, elimine primero la cuenta.");
		}
		else{
			$scope.cuentas.forEach(function(cta) {
				if(cta['titular_jur'] !== null){
					if(cta['titular_jur']['rut'] == titular.rut){
						v = false;
					}
					
					if(v){
						titular.$delete({id: titular.rut}, function() {
							$scope.titulares_juridicos = TitularJuridico.query();
						});
					}
				}
			});
			
			if(!v)
				alert("El titular tiene asociada una cuenta corriente, elimine primero la cuenta.");
		}
	}
}