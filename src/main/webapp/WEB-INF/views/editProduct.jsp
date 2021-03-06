<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Add Product</h1>
          <p class="lead">Add a new Product</p>
        </div>
        
        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct" method="post" 
        commandName="product" enctype="multipart/form-data">
        <form:hidden path="productId" value="${product.productId}"/>
           <div class="form-group">
               <label for="name">Name</label>
               <form:input path="productName" id="name" class="form-control" value="${product.productName}"/>          
           </div>
           
           <div class="form-group">
               <label for="category">Category</label>
               <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" 
                         value="instrument" />Instrument</label>
               <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" 
                         value="record" />Record</label>
               <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" 
                         value="accessory" />Accessory</label>    
           </div>
           
           <div class="form-group">
               <label for="description">Description</label>
               <form:textarea path="productDescription" id="description" class="form-control" 
                                      value="${product.productDescription}"/>          
           </div>
           
           <div class="form-group">
               <label for="price">Price</label>
               <form:input path="productPrice" id="price" class="form-control" 
                                 value="${product.productPrice}"/>          
           </div>
           
           <div class="form-group">
               <label for="condition">Condition</label>
               <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" 
                         value="new" />New</label>
               <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" 
                         value="used" />Used</label>
               
           </div>
           
           <div class="form-group">
               <label for="status">Status</label>
               <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" 
                         value="active" />Active</label>
               <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                         value="inactive" />In Active</label>
               
           </div>
           
           <div class="form-group">
               <label for="unitInStock">Unit in Stock</label>
               <form:input path="unitInStock" id="unitInStock" class="form-control" 
                                 value="${product.unitInStock}"/>          
           </div>
           
           <div class="form-group">
               <label for="manifacturer">Manufacturer</label>
               <form:input path="productManifacturer" id="manifacturer" class="form-control" 
                                 value="${product.productManifacturer}"/>          
           </div>
           
           <div class="form-group">
               <label class="control-label" for="image">Upload Picture</label>
               <form:input path="productImage" id="image" type="file" class="form:input-large"  />
           </div>
           
           <br>
           <input type="submit" value="submit" class="btn btn-primary" />
           <a href="<c:url value="/admin/productInventory" />" class="btn btn-warning">Cancel</a>
           
        </form:form>
        
 
 <%@ include file="/WEB-INF/views/template/footer.jsp" %>   

        
