angular.module('GestionApp').factory('TitularFisico', TitularFisico);

TitularFisico.$inject = [ '$resource' ];

function TitularFisico($resource) {
	var resourceUrl = 'api/titular_fisico/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}