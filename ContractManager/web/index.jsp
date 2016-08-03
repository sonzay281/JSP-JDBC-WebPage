<%@page import="com.leapfrog.contactmanager.entity.Manager"%>
<%@page import="com.leapfrog.contactmanager.dao.impl.ManagerDAOImpl"%>
<%@page import="com.leapfrog.contactmanager.dao.ManagerDAO"%>
<%@include file="header.jsp" %>
<h2> Contact Manager</h2>
<div class="pull-right"><a href="add.jsp" class="brn btn-primary medium"><span class="glyphicon glyphicon-plus"></span>Add</a></div>
<table class="table table-striped table-responsive table-hover table-bordered">
    <tr class="bg-info"><th>ID</th>                   
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>DOB</th> 
        <th class="center-block">Loan Details</th>
        <th>Action</th> 
    </tr>
    <tr><%
        ManagerDAO managerDAO = new ManagerDAOImpl();
        for (Manager m : managerDAO.getAll()) {
        %>
        <th><%=m.getId()%></th>                   
        <th><%=m.getName()%></th> 
        <th> <%=m.getEmail()%></th>                   
        <th><%=m.getPhone()%></th>
        <th><%=m.getAddress()%></th>                   
        <th><%=m.getDOB()%></th>
        <th> 
            <a href="loan_details.jsp?id=<%=m.getId()%>" class="btn btn-info center-block" target="_blank">
                <span class="bg-info"></span>View
            </a>
        <th>
            <a   href="edit.jsp?id=<%=m.getId()%>" target="_blank" class="btn btn-success">
                <span class="glyphicon glyphicon-pencil">Edit</span>
            </a>
            <a  href="delete.jsp?id=<%=m.getId()%>" target="_blank" class="btn btn-danger">
                <span class="glyphicon glyphicon-trash">Delete</span>
            </a>
        </th>
   </tr>
    <% }%>
</table>
<%@include file="footer.jsp" %>
