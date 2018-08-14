<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="h" uri="http://myfaces.apache.org/tomahawk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
</head>
<body>
<table align="center">
    <tr>
        <td><a href="/">Home</a>
        </td>
        <td><a href="register">Register</a>
        </td>
    </tr>
</table>

<spring:url value="/users" var="userActionUrl" />

<c:choose>
    <c:when test="${userModel == null}">
        <f:form method="post" modelAttribute="userForm" action="/register">
            <f:errors path="name" />

            <table>
                <tr>
                    <td><f:label path="name">Name</f:label></td>
                    <td><f:input path="name"/></td>
                </tr>
                <tr>
                    <td><f:label path="email">Email</f:label></td>
                    <td><f:input path="email"/></td>
                </tr>
                <tr>
                    <td><f:label path="password">Password</f:label></td>
                    <td><f:input path="password" /></td>
                </tr>
                <tr>
                    <td><f:label path="country.id">Country</f:label></td>
                    <td><f:select path="country.id" items="${countryList}" itemValue="id" itemLabel="name"/></td>
                </tr>
                <tr>
                    <td align="right"><button type="submit" name="method" value="register">Submit</button></td>
                </tr>
            </table>

        </f:form>

        <br/><br/>
        <table border="1" cellpadding="4" cellspacing="0">
            <c:forEach var="user" items="${userList}">
                <tr >
                    <td><c:out value="${user.id}"  /></td>
                    <td><c:out value="${user.name}"  /></td>
                    <td><c:out value="${user.email}"  /></td>
                    <td><c:out value="${user.country.name}"/></td>
                    <td width="120" align="center">EDIT / DEL</td>
                </tr>
            </c:forEach>
        </table>

    </c:when>
    <c:otherwise>
        ${userModel}
    </c:otherwise>
</c:choose>


</body>
</html>
