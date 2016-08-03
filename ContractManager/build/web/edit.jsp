<%@page import="com.leapfrog.contactmanager.entity.Manager"%>
<%@page import="com.leapfrog.contactmanager.dao.impl.ManagerDAOImpl"%>
<%@page import="com.leapfrog.contactmanager.dao.ManagerDAO"%>
<% 
    Manager m=new Manager();
    ManagerDAO managerDAO=new ManagerDAOImpl();
    if(request.getParameter("id")==null || request.getParameter("id").isEmpty()){
        response.sendRedirect("index.jsp?error");
    }
    else{
        int id=Integer.parseInt(request.getParameter("id"));
        m=managerDAO.getByID(id);
        
    }
    %>
<%@include file="header.jsp" %>
<h2>Edit Record</h2>
<form>
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" class="form-control" required="required" placeholder="Enter the Name" value="<%=m.getName() %>">   
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="email" name="email" class="form-control" required="required" placeholder="Enter Email" value="<%=m.getEmail() %>">
    </div>
    <div class="form-group">
        <label>Phone</label>
        <input type="tel" name="phone" class="form-control" required="required" placeholder="Enter Contact number" value="<%=m.getPhone() %>">   
    </div>
    <div class="form-group">
        <label>Address</label>
        <input type="text" name="address" class="form-control" required="required" placeholder="Enter address" value="<%=m.getAddress()%> ">  
    </div>
    <div class="form-group">
        <label>Date Of Birth</label>
        <input type="date" name="DAO" class="form-control" required="required" placeholder="Enter DOB" value="<%=m.getDOB() %>">
    </div>
     <div>
        <button type="submit" class="btn btn-success">Save</button>
        <button type="submit" class="btn btn-danger"><a href="index.jsp">Cancel</a></button>
    </div>
    
</form>
<%@include file="footer.jsp" %>