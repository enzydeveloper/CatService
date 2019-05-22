
$(document).ready(function(){
	$.ajax({
	    type: "GET",
	    url: "http://localhost:8080/api/allCatFacts",
	    dataType: 'json',
	    success: function (data) {
	    	
	        // Create a new table
	        var table = document.createElement("table");

			//Only create a table if we got a valid response and it has data to return		
			if(data != null)
			{
				var singleElement = data[0];

    	        // Create a header row
    	        // NOTE: this assumes that the json returns just one type of object
    	        // 		This won't work if there is a mixture of domain types returned
    	        var thead = document.createElement('thead');
       	        var tr = document.createElement('tr');
    	        for (var key in singleElement) 
    	        {
        	        var th = document.createElement('th');
        	        th.innerHTML = key;
        	        tr.appendChild(th);
    	        }
    	        thead.appendChild(tr);
    	        table.appendChild(thead);
    	        
    	        

       	        var tbody = document.createElement('tbody');

    	        // Add the table rows
    	        for (var index in data) 
	        	{
    	        	var arrayElement = data[index];
       	            var tr = document.createElement('tr');
        	        for (var key in arrayElement) 
        	        {
        	            var value = arrayElement[key];
        	            
        	            var td = document.createElement('td');
        	            td.innerHTML = value;
        	            tr.appendChild(td);
        	            tbody.appendChild(tr);
        	        }
	        	}
    	        table.appendChild(tbody);
    	        table.setAttribute("id", "catTable");

    	        // Add the created table to the HTML page
    	        document.body.appendChild(table);
    	        
    	        

    	        $('#catTable').dataTable();
			}
			else
			{
			
			}
	    }
	});
});


$(document).ready(function(){
    $('#myTable').dataTable();
});







