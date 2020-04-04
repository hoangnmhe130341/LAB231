
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <h1>${error}</h1>
        </div>
        <div style="height: 650px; width: 100%; background-color: #722f31;"></div>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>
