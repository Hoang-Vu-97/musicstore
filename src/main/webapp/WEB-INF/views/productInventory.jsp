<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Product Inventory</h1>
          <p class="lead">This is product inventory page!</p>
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
               <th></th>
               <th></th>
            </tr>
          </thead>
          <c:forEach items="${productList}" var="product">
            <tr >
               <td><img src="<c:url value="/resource/images/${product.productId}.png"/>"  
               style="height:150px; width:200px"alt="image" /></td>
               <td>${product.productName}</td>
               <td>${product.productDescription}</td>
               <td>${product.productManifacturer}</td>
               <td>${product.productPrice}<span> $</span></td>
               <td>${product.unitInStock}</td>
               <td><a href="<c:url value="/productList/viewProduct/${product.productId}" />">
               <span class="glyphicon glyphicon-info-sign"></span></a>
               <a href="<c:url value="/admin/productInventory/deleteProduct/${product.productId}" />">
               <span class="glyphicon glyphicon-remove"></span></a>
               <a href="<c:url value="/admin/productInventory/editProduct/${product.productId}" />">
               <span class="glyphicon glyphicon-pencil"></span></a></td>
            </tr>
          </c:forEach>
        </table>
        
        <a class="btn btn-primary"  href="<c:url value="/admin/productInventory/addProduct"   />">Add product</a>
 <%@ include file="/WEB-INF/views/template/footer.jsp" %>   

        
