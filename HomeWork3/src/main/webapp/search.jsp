<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="css/style.css">
            <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <link rel="stylesheet" href="/resources/demos/style.css">
            <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
            <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <script>
            $( function() {
              $( "#datepicker1" ).datepicker();

            } );
            </script>
    </head>
    <body>
        <div class="container">
                    <div class="regbox box">
                <h1> <p>Поиск рейсов</p> </h1>
        <form action="search" method="POST">

                   <p>Дата вылета</p>
        <input type="text" placeholder="число / месяц / год" id="datepicker1" name="dateDeparture" required>
                   <p>Аэропорт вылета</p>
        <select name="airportDeparture"  id="dropdown1">
             <c:forEach items="${airports}" var="airport">
                 <option value="${airport.airport_name}">${airport}</option>
             </c:forEach>
        </select>
                  <p>Аэропорт прилёта</p>
        <select name="airportArrival"  id="dropdown2">
              <c:forEach items="${airports}" var="airport">
                <option value="${airport.airport_name}">${airport}</option>
              </c:forEach>
        </select>
                   <input type="submit" value="Поиск">
                </form>
               <c:choose>
                       <c:when test="${requestScope.error}">
                       <p style="color:red;">${requestScope.message}</p>
                       </c:when>
                       <c:otherwise>
                       <c:choose>
                               <c:when test="${requestScope.flight}">

                               <table>
                                   <c:forEach items="${flights}" var="flight">
                                       <tr>
                                           <td><c:out value="${flight.flight_no}" /></td>
                                           <td><c:out value="${flight.scheduled_departure}" /></td>
                                           <td><c:out value="${flight.scheduled_arrival}" /></td>
                                           <td><c:out value="${flight.departure_airport_name}" /></td>
                                           <td><c:out value="${flight.arrival_airport_name}" /></td>
                                           <td><c:out value="${flight.status}" /></td>
                                       </tr>
                                   </c:forEach>
                               </table>
                               <form action="search" method="post">
                                   <input type="hidden" name="firstrow" value="${firstrow}">
                                   <input type="hidden" name="rowcount" value="${rowcount}">
                                   <input type="submit" name="page" value="next">
                                   <input type="submit" name="page" value="previous">
                               </form>


                         <table border="3", align="center">
                               <caption>Все подходящие рейсы</caption>
                                 <tr>
                                   <th>Номер рейса</th>
                                   <th>Время вылета</th>
                                   <th>Время прилёта</th>
                                   <th>Аэропорт вылета</th>
                                   <th>Аэропорт прилёта</th>
                                   <th>Статус</th>
                                 </tr>
                                   <c:forEach items="${flights}" var="flight">
                                       <tr>
                                           <td><c:out value="${flight.flight_no}" /></td>
                                           <td><c:out value="${flight.scheduled_departure}" /></td>
                                           <td><c:out value="${flight.scheduled_arrival}" /></td>
                                           <td><c:out value="${flight.departure_airport_name}" /></td>
                                           <td><c:out value="${flight.arrival_airport_name}" /></td>
                                           <td><c:out value="${flight.status}" /></td>
                                       </tr>
                                   </c:forEach>
                               </table>
                               </c:when>
                               <c:otherwise>
                               <p></p>
                               </c:otherwise>
                           </c:choose>
                       </c:otherwise>
                   </c:choose>


</div>
</div>

</body>
</html>