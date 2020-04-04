<%-- 
    Document   : index
    Created on : Jan 13, 2020, 2:56:27 PM
    Author     : hoangnm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Digital News</title>
        <link href="public/css/index.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="main-container">
            <jsp:include page="component/header.jsp"/>
            <div class="main-content">
                <div class="content-left">
                    <div class="left-body">
                        <c:choose>
                            <c:when test="${listFiveRecentNews.size() <= 0 || listFiveRecentNews == null}">
                                <h3>Nothing News !!!</h3>
                            </c:when>
                            <c:otherwise>
                                
                                    <h3>${listFiveRecentNews.get(0).title}</h3>
                                
                                <div class="image">
                                    <img src="public/images/${listFiveRecentNews.get(0).image}" alt=""/>
                                </div>
                                <div class="article">
                                    <p>${listFiveRecentNews.get(0).content}</p>
                                    <br> <br>
                                    <p>${listFiveRecentNews.get(0).shortContent}</p>
                                </div>
                                <div class="author">
                                    <div class="icon1"></div>
                                    <div class="icon2"></div>
                                    ${listFiveRecentNews.get(0).author} | ${listFiveRecentNews.get(0).getDateFormat()}
                                </div>
                            </c:otherwise>
                        </c:choose>                                
                    </div>
                </div>
                <div class="content-right">
                    <div class="right-body">
                        <h3>Digital News</h3>
                        <p>${listFiveRecentNews.get(0).shortDes}...</p>
                        <h3 class="panel">Search</h3>
                        <form class="search" method="post" action="search">
                            <input type="text" name="txtSearch" class="txtSearch" required>
                            <input type="submit"class="btnGo" value="Go">
                        </form>
                        <p class="panel">Last Article</p>
                        <div class="top5-news">
                            <c:forEach items="${listFiveRecentNews}" var="n">
                                <div class="link-news">
                                    <a href="view?id=${n.id}">${n.title}</a><br>                                   
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
    </body>
</html>
