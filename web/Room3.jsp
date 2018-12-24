<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="logic.ReqResWorker" %>
<html id="13">
<head>
    <title>Room3</title>


    <script src="JS_Files/JS_Function.js"></script>
    <script type="text/javascript">


        var xmlreq = newXMLHttpRequest();
        var updateID = "13";
        var updateElement = 2;
        var nameJSP = "Room3.jsp";


        // Функция автообновления страницы ч/з каждые 2 сек
        function autoUpdatePage(nameJSP, XMLHttpReguest, updateElement) {
            setInterval(function () {
                XMLHttpReguest.open("POST", "Room3.jsp", true);
                XMLHttpReguest.setRequestHeader("Content-Type",
                    "application/x-www-form-urlencoded");
                XMLHttpReguest.onreadystatechange = updatePage;
                XMLHttpReguest.send("lamp=" + 200 + "&id=" + updateElement);
            }, 2000);
        }


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


        function updatePage() {
            if (xmlreq.readyState == 4)
                if (xmlreq.status == 200) {
                    document.getElementById("13").innerHTML = xmlreq.responseText;
                }
        }


    </script>
</head>
<body onload="autoUpdatePage(nameJSP,xmlreq,updateElement)">
<h1>Комната 3 </h1>
<button id="2" input type="button" onclick="changeState(this,updateID,nameJSP,xmlreq,updatePage())">Выключатель
</button>
<%
    ReqResWorker reqResWorker3 = new ReqResWorker(request, response);
    reqResWorker3.checkResponse();
%>

</body>
</html>
