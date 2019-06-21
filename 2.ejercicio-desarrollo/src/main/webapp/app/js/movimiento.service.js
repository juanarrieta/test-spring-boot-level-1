angular.module('GestionApp').factory('Movimiento', Movimiento);

Movimiento.$inject = [ '$resource' ];

function Movimiento($resource) {
	var resourceUrl = 'api/movimiento/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}