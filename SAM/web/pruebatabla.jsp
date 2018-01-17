<%-- 
    Document   : pruebatabla
    Created on : 18-ago-2016, 17:41:14
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
        // Change the selector if needed
var $table = $('table.scroll'),
    $bodyCells = $table.find('tbody tr:first').children(),
    colWidth;

// Adjust the width of thead cells when window resizes
$(window).resize(function() {
    // Get the tbody columns width array
    colWidth = $bodyCells.map(function() {
        return $(this).width();
    }).get();
    
    // Set the width of thead columns
    $table.find('thead tr').children().each(function(i, v) {
        $(v).width(colWidth[i]);
    });    
}).resize(); // Trigger resize handler
    </script>
    <body>
       <table class="scroll">
    <thead>
        <tr>
            <th>Head 1</th>
            <th>Head 2</th>
            <th>Head 3</th>
            <th>Head 4</th>
            <th>Head 5</th>
            <th>Head 1</th>
            <th>Head 2</th>
            <th>Head 3</th>
            <th>Head 4</th>
            <th>Head 5</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr> 
         <tr>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr> 
         <tr>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
            <td>Content 1</td>
            <td>Content 2</td>
            <td>Content 3</td>
            <td>Content 4</td>
            <td>Content 5</td>
        </tr>
    </tbody>
</table>
    </body>
</html>
