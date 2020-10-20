<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>All Products</h1>
          <p class="lead">Check out all the awesome products in our store!</p>
        </div>
        
        <table class="table table-striped table-hover">
          <thead>
            <tr class="bg-success">
               <th>Image thumbnail</th>
               <th>Name</th>
               <th>Description</th>
               <th>Manufacter</th>
               <th>Price</th>
               <th>Quantity</th>
            </tr>
          </thead>
          <c:forEach items="${productList}" var="product">
            <tr >
               <td><img src="#" alt="image" /></td>
               <td>${product.productName}</td>
               <td>${product.productDescription}</td>
               <td>${product.productManifacturer}</td>
               <td>${product.productPrice}<span> $</span></td>
               <td>${product.unitInStock}</td>
               <td><a href="<c:url value="/productList/viewProduct/${product.productId}" />">
               <span class="glyphicon glyphicon-info-sign"></span></a></td>
            </tr>
          </c:forEach>
        </table>
 
 <%@ include file="/WEB-INF/views/template/footer.jsp" %>   

        
