<%@ page import="logic.ReqResWorker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html id="10">
<head>
    <script type="text/javascript">


        var xmlreq = newXMLHttpRequest();
        var nameJSP = "MainJsp.jsp";


        function newXMLHttpRequest() {
            xmlreq = false;
            if (window.XMLHttpRequest) {
                xmlreq = new XMLHttpRequest()
            } else if (window.ActiveXObject) {
                try {
                    xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e1) {
                    try {
                        xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e2) {
                    }
                }
            }
            return xmlreq;
        }

        // Функция обнавления главной страницы
        // function updateMainPage(XMLHttpReguest) {
        //     setInterval(function () {
        //         XMLHttpReguest.open("POST","MainJsp.jsp", true);
        //         XMLHttpReguest.setRequestHeader("Content-Type",
        //             "application/x-www-form-urlencoded");
        //         XMLHttpReguest.onreadystatechange = updatePage();
        //         XMLHttpReguest.send("lamp=" + 300);
        //
        //     }, 2000);
        // }

        function updatePage() {
            if (xmlreq.readyState == 4)
                if (xmlreq.status == 200) {
                    document.getElementById("10").innerHTML = xmlreq.responseText;
                }
        }

    </script>
    <title>JavaEE</title>
</head>
<body onload="updateMainPage(xmlreq)">
<h1>Test</h1>
<form action="Room1.jsp" method="post">
    <button input type="submit" name="id" value="0">Комната 1</button>
</form>
<form action="Room2.jsp" method="post">
    <button input type="submit" name="id" value="1">Комната 2</button>
</form>
<form action="Room3.jsp" method="post">
    <button input type="submit" name="id" value="2">Комната 3</button>
</form>

<% ReqResWorker main = new ReqResWorker(request, response);
    main.checkResponse();
%>
</body>
</html>
