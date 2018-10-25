<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name = "length" type="java.lang.Integer"  required="false"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--length :5

=====logging=====
--%>
<%-- length 속성이 없을 경우 length 기본값 20으로 표현 --%>
<c:set var="length" value="${length == null ? 20 : length }"/>
<%-- <c:if test="${length!=null }"> --%>
<font color="${color }">
	<c:forEach begin="1" end="${length }" >=</c:forEach>
		logging
	<c:forEach begin="1" end="${length }" >=</c:forEach><br/>
</font>
<%-- </c:if> --%>
<%-- <c:if test="${length==null }"> --%>
<%-- <font color="${color }"> --%>
<%-- 	<c:forEach begin="1" end="20" >=</c:forEach> --%>
<!-- 		logging -->
<%-- 	<c:forEach begin="1" end="20" >=</c:forEach><br/> --%>
<!-- </font> -->
<%-- </c:if> --%>



