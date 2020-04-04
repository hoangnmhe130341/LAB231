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
                            <c:when test="${listSearch.size() <= 0 || listFiveRecentNews == null}">
                                <h3>Not Found</h3>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${listSearch}" var="i">
                                    <div class="article-search">
                                        <div class="title">
                                            <a href="view?id=${i.id}">${i.title}</a>
                                        </div>
                                        <div class="image-search">
                                            <img src="public/images/${i.image}" alt=""/>
                                        </div>
                                        <div class="text-search">
                                            ${i.shortDes}
                                        </div>
                                    </div>
                                </c:forEach>
                                <div class="pagging">
                                   
                                    <c:forEach begin="1" end="${totalPage}" var="i">
                                        <a href="search?&page=${i}">${i}</a>
                                    </c:forEach>                                    
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
                            <input type="submit" class="btnGo" value="Go">
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
