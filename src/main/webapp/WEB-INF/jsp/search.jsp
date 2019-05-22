<!doctype html>
<head>
<title>Cat-search</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<LINK REL=StyleSheet HREF="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" TYPE="text/css"/>

<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-touch.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-animate.js"></script>

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-grid/4.6.3/ui-grid.pagination.min.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-grid/4.6.3/ui-grid.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-grid/4.6.3/ui-grid.css" type="text/css">


<script>
	// 	Setup jquery accordian
	$( function() {
	    $( "#accordion" ).accordion(
	   		{
				collapsible: true,
				heightStyle: "2em"
	   		});
  	} );

	// Helper function during button press so users don't spam the search button
	function disableSearchButton(flag) {
		$("#btn-search").prop("disabled", flag);
		if(flag == true)
		{
			$("#load-spinner").show();
		}
		else
		{
			$("#load-spinner").hide();
		}
	}

</script>




<script>
	var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.resizeColumns', 'ui.grid.moveColumns', 'ui.grid.pagination']);
	
	app.controller('MainCtrl', ['$scope', '$http', function ($scope, $http) {

	    $scope.search = function()
	    {
	    	//Gather all the FORM elements and build a json string to send via POST
			var search = {}
			var formElements = document.forms["search-form"].getElementsByTagName("input");
			for (i = 0; i < formElements.length; i++) 
			{
				var formElement = formElements[i];
				if(formElement.type == 'text' && formElement.value !== "")
				{
					search[formElement.id] = formElement.value;
				}
				//Handle chekbox type inputs as well for binding boolean model
				else if(formElement.type == 'checkbox')
				{
					if(formElement.checked)
					{
						search[formElement.id] = 1;
					}
					else
					{
						search[formElement.id] = 0;
					}
				}
			}
			console.log("Searching: ",JSON.stringify(search));
			// Disble the search button
			disableSearchButton(true);
			
			$http({
    			url : "${home}/api/searchCat",
    			method : "POST",
    			data : JSON.stringify(search),
    			headers : {	"X-CSRF-TOKEN" : "${_csrf.token}" },
    			timeout : 100000
			}).then(function successCallback(response) {
				disableSearchButton(false);
				
				//Close up the search area to make room for the data grid
				$( "#accordion" ).accordion( "option", "active", false, "animate", 400 );
				
				//Clear Data
    			$scope.gridOptions.data.length=0;
				
		        // this callback will be called asynchronously
		        // when the response is available
				console.log("search SUCCESS: ", response);
// 				display(response.data.result);
				$scope.gridOptions.data = response.data;
				
			},function errorCallback(response) {
				disableSearchButton(false);
				//Clear Data
    			$scope.gridOptions.data.length=0;
				
		        // called asynchronously if an error occurs
		        // or server returns response with an error status.
				console.log("search FAILURE: ", response);
		        
		        //Set the text for the user to see error recieved
		        $scope.error = response.statusText +'\n' + response.data.msg;
            }); 
	    }
		
		
	    $scope.gridOptions = {};	     
	    $scope.gridOptions.enableFiltering = true;
	    $scope.gridOptions.enableColumnResizing = true;
		
	    $scope.gridOptions.columnDefs = [
	          { name: 'type',	displayName: "Cat Type",				 	headerCellClass: $scope.highlightFilteredHeader, minWidth: 200, width:'*'},
	          { name: 'text',	displayName: "Cat fact",				 	headerCellClass: $scope.highlightFilteredHeader, minWidth: 200, width:'*'},

	        ];
		}]);
	    
	    
	    

</script>



</head>
<html>
<body>

	
	<div ng-app="app" id="ngController" ng-controller="MainCtrl">
		<div id="accordion">
			<h3>Search Options</h3>
			<div id="" class="container-fluid bg-light ">
				<form class="" id="search-form">
					<div class="form-row align-items-center justify-content-center">

						<div class="col-md-2 pt-1">
							<input type=text class="form-control-sm" placeholder="Cat type"
								id="type">
						</div>
						<div class="col-md-2 pt-1">
							<input type=text class="form-control-sm" placeholder="Fact Text"
								id="text">
						</div>
						
						<div class="col-md-2">
							<button ng-click="search()" type="button" id="btn-search" class="btn btn-primary btn-block">
								<!-- Hide spinner until it's clicked -->
								<span style="display: none;" id="load-spinner" class="spinner-border spinner-border-sm"></span> 
								Search
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

		<div id="feedback">{{error}}</div>

		<div class="gridContainer">
			<div id="grid1" ui-grid="gridOptions" class="grid"
				ui-grid-resize-columns ui-grid-move-columns ui-grid-pagination></div>
		</div>




	</div>

</body>
</html>