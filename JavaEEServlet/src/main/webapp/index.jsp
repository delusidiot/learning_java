<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="get" action="login" enctype="text/plain">
    <label> id
        <input type="text" name="user_id"/> <br>
    </label>

    <label> password
        <input type="password" name="user_password"/> <br>
    </label>

    <input id="java" type="checkbox" name="subject" value="Java"/>
    <label for="java"> Java </label>

    <input id="c" type="checkbox" name="subject" value="C"/>
    <label for="c"> C/C++ </label>

    <input id="javascript" type="checkbox" name="subject" value="Javascript"/>
    <label for="javascript">Javascript</label>

    <input id="rust" type="checkbox" name="subject" value="Rust"/>
    <label for="rust">Rust</label>

    <input id="python" type="checkbox" name="subject" value="Python"/>
    <label for="python">Python</label> <br>

    <input type="submit" value="Login"/> <input type="reset" value="reset"/>
</form>

</body>
</html>