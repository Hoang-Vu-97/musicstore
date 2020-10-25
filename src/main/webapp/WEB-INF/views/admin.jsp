<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Administrator page</h1>
          <p class="lead">This is administrator page!</p>
        </div>
        
        <c:if test="${pageContext.request.userPrincipal.name != null}">
               <h2>
                   Welcome: ${pageContext.request.userPrincipal.name}     
               </h2>
        </c:if>
        <h3>
                  <a href="<c:url value="/admin/productInventory"   />">Product Inventory</a>
        </h3>
        <p>Here you can view, check, modify product inventory!</p>
        <c:url  var="logoutUrl"  value="/logout" />
        <form action="${logoutUrl}" method="post">
             <input type="submit" value="Logout" class="btn btn-primary" />
             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
        </form>
        
 
 <%@ include file="/WEB-INF/views/template/footer.jsp" %>   

        
