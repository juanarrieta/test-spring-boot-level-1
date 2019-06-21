$(document).ready(function(){
	$("#titular_jur").hide();
	$("#tbl_jur").hide();
	$("#titular_fis").hide();
	$("#tbl_fis").hide();
	
	$(".enviar").click(function() {
		$("#titular_fisicoRut").prop('disabled', false);
		$("#titular_juridicoRut").prop('disabled', false);
		$("#tipo").prop('disabled', false);
	});
	
	$("#tipo").change(function() {
		if($("#tipo").val()=="1"){ 
			$("#titular_fis").show();
			$("#titular_jur").hide();
			$("#tbl_fis").show();
			$("#tbl_jur").hide();
		}
		else{ 
			$("#titular_fis").hide();
			$("#titular_jur").show();
			$("#tbl_fis").hide();
			$("#tbl_jur").show();
		}	
	});
});

