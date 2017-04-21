<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <link rel='stylesheet' href='fullcalendar/fullcalendar.css' />
<script src='lib/jquery.min.js'></script>
<script src='lib/moment.min.js'></script>
<script src='fullcalendar/fullcalendar.js'></script>
<script>

   $(document).ready(function() {

    // page is now ready, initialize the calendar...

        $('#calendar').fullCalendar({
            dayClick: function() {
                alert('a day has been clicked!');
            }
        });
        
        $('#my-next-button').click(function() {
             $('#calendar').fullCalendar('next');
        });
    });



</script>
</head>
<body>  
    <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>

        <div id='calendar'></div>

        <center>
    </center>
    <h1>Necessita js para implementar calendário</h1>
    </body>
</html>
