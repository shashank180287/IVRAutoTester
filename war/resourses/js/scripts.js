$(document).ready(function() {
	$("ul#nav li a").addClass("js");
	$("ul#nav li a").hover(
      function () {
        $(this).stop(true,true).animate({backgroundPosition:"(0 0)"}, 200);
        $(this).animate({backgroundPosition:"(0 -5px)"}, 150);
      }, 
      function () {
        $(this).animate({backgroundPosition:"(0 -149px)"}, 200);

      }
    );
    $("#validate-div").hide();
    $("#validate-div-text").hide();
    $("#func-test-div").hide();
    $("#func-test-div-text").hide();
    $("#error_panel").hide();
});
function StartTesting(){
    $("#validate-div").show();
    $("#validate_img").attr("src","resourses/processing.gif");
    $("#validate-div-text").show();
    $("#test_button").attr('disabled','disabled');
    var url = $("#app_vxml_url").val();
    $.getJSON("validate?url="+url, function(jd) {
       if(jd.status == "Error"){
    	    $("#validate_img").attr("src","resourses/warning.jpg");
    	    $("#validate-div-text").text("Error Occured");
    	    $("#error_panel").show();
            $("#error_panel").html('<p>' + jd.message+ '</p>');
            $("#test_button").removeAttr('disabled');
       }else{
    	   $("#validate_img").attr("src","resourses/validated.jpg");
    	   $("#validate-div-text").text("VoiceXML Validated Successfully");
    	   $("#error_panel").hide();
		    
    	   $("#func-test-div").show();
		   $("#func-test_img").attr("src","resourses/processing.gif");
		   $("#func-test-div-text").show();
       }
    });
}