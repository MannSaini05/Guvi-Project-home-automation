<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>User Profile</title>
    <style>
        body { font-family: Arial, sans-serif; }
        h1, h2 { color: #333; }
        table { width: 50%; border-collapse: collapse; margin: 20px 0; }
        td, th { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }
    </style>
</head>
<body>
    <h2>User Profile</h2>
    
    <p><strong>Welcome, <%= request.getAttribute("username") %></strong></p>

    <h3>User Information:</h3>
    <table>
        <tr>
            <th>Username</th>
            <td>${username}</td>  <!-- Using EL to inject username from the servlet -->
        </tr>
        <tr>
            <th>Email</th>
            <td>${email}</td>  <!-- Using EL to inject email -->
        </tr>
        <tr>
            <th>Account Created</th>
            <td>${creationDate}</td>  <!-- Assuming the servlet passes creation date -->
        </tr>
        <tr>
            <th>Status</th>
            <td>${status}</td>  <!-- Assuming the servlet passes user status -->
        </tr>
    </table>

    <p><a href="logout">Logout</a></p> <!-- Logout functionality, optional -->

</body>
</html>
