 $(function() {
	 var currentDate = new Date();
    $( "#fromDate" ).datepicker({
		dateFormat:'dd/mm/yy'
	});
	$( "#fromDate" ).datepicker( "setDate", new Date());
	
	$( "#toDate" ).datepicker(
		{dateFormat:'dd/mm/yy'}
	);
	$( "#toDate" ).datepicker( "setDate", new Date());
	
	$( "#countDate" ).val(1);
	
	$( ".day-trip" ).sortable({
		connectWith: ".day-trip"
    });
	
	$("#add-tour").click(function(){
		clickDisplayTour();
	});
	
	addAction();
	
	$("#btn-create-tour").click(function(){
		var fromDateInput = $("#fromDate").val();
		var toDateInput = $("#toDate").val();
		/*var countDate = parseInt($("#countDate").val());*/
		
		var fromDate = $.datepicker.parseDate("dd/mm/yy", fromDateInput);
		var toDate = $.datepicker.parseDate("dd/mm/yy", toDateInput);
		var oneDay = 24*60*60*1000;
		var diff = Math.round(Math.abs((toDate.getTime() - fromDate.getTime())/(oneDay))) + 1;
		var html = '';
		for(var i = 0 ;i < diff;i++){
			html+= '<div class="schedule-day">';
				html+= '<div class="day-header">';
					html+= '<div class="day-time">Ngày ' +(i+1);
					if(fromDate != null){
						fromDate.setDate(fromDate.getDate() + i);
						html+= ' : ';
						html+= $.datepicker.formatDate("dd/mm/yy",fromDate);
					}
					html+= '</div>';
					html+= '<div class="remove-all-trip"></div>';
					html+= '<div class="add-trip"></div>';
				html+= '</div>';
				html+= '<div class="day-tour">';
					html+= '<ul class="day-trip">';
					html+= '</ul>';
				html+= '</div>';		
			html+='</div>';
		}
		$('.schedule-detail').html(html);
		addAction();
	});
});

var isDisplayTour = true;

function addAction(){
	
	$(".action-trip .remove-trip").click(function(){
		removeLine(this);
	});
	
	$(".add-trip").click(function(){
		var newLine = $("<li class='action-trip ui-sortable-handle'><div class='direction2'></div><input class='time' name='time' value=''></input><input class='position' name='position'></input><input class='fee' name='fee' value=''></input><div class='remove-trip'></div></li>");
		
		$(this).parent().parent().find(".day-trip").append(newLine);
		
		$(newLine).find(".remove-trip").click(function(){
			removeLine(this);
		});
	});
	
	$(".remove-all-trip").click(function(){
		if(confirm('Bạn có chắc muốn xóa toàn bộ ngày?')){
			$(this).parent().parent().find(".action-trip").remove();
		}
	});
	
}

function removeLine(obj){
	if(confirm('Bạn có chắc muốn xóa?')){
		$(obj).parent().remove();
	}
}

function clickDisplayTour(){
	if(isDisplayTour){
		isDisplayTour = false;
		$("#right-body").hide();
		$("#left-body").width('100%');
	}else{
		isDisplayTour = true;
		$("#right-body").show( );
		var rightWidth = $("#right-body").width() ;
		$("#left-body").width( 'calc(100% - '+rightWidth+'px)' );
	}
	
} 