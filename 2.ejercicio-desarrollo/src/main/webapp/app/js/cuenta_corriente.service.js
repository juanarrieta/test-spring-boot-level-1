angular.module('GestionApp').factory('CuentaCorriente', CuentaCorriente);

CuentaCorriente.$inject = [ '$resource' ];

function CuentaCorriente($resource) {
	var resourceUrl = 'api/cuenta_corriente/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}