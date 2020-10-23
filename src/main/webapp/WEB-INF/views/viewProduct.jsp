<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Product Details</h1>
          <p class="lead">Here is the detail information of the product.</p>
        </div>
        
        <div class="container">
          <div class="row">
             <div class="col-md-6">
                <img src="<c:url value="/resource/images/${product.productId}.png"/>"  
               style="height:300px; width:400px"alt="image" />
             </div>
             <div class="col-md-6">
                <h1>${product.productName}</h1>
                <p><b>Description:</b> ${product.productDescription}</p>
                <p><b>Manufacturer:</b> ${product.productManifacturer}</p>
                <p><b>Quantity:</b> ${product.unitInStock}</p>
             </div>
          </div>
        </div>
 
 <%@ include file="/WEB-INF/views/template/footer.jsp" %>   