angular.module('GestionApp').factory('TitularJuridico', TitularJuridico);

TitularJuridico.$inject = [ '$resource' ];

function TitularJuridico($resource) {
	var resourceUrl = 'api/titular_juridico/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}