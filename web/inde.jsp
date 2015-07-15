<%--
  Created by IntelliJ IDEA.
  User: Alexej
  Date: 15.07.2015
  Time: 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calc</title>

    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/forIndex.js"></script>
    <link href="style/calc.css" rel="stylesheet">
</head>
<body>
<br>
<div class="calc">
    <table>
        <tr>
            <td colspan=4 class="display">
            </td>
        </tr>
        <tr>
            <td colspan=4 class="button" action="reset">
                Reset
            </td>
        </tr>
        <tr>
            <td class="button" action="added" value="7">
                7
            </td>
            <td class="button" action="added" value="8">
                8
            </td>
            <td class="button" action="added" value="9">
                9
            </td>
            <td class="button" action="operation" value="*">
                *
            </td>
        </tr>
        <tr>
            <td class="button" action="added" value="4">
                4
            </td>
            <td class="button" action="added" value="5">
                5
            </td>
            <td class="button" action="added" value="6">
                6
            </td>
            <td class="button" action="operation" value="/">
                /
            </td>
        </tr>
        <tr>
            <td class="button" action="added" value="1">
                1
            </td>
            <td class="button" action="added" value="2">
                2
            </td>
            <td class="button" action="added" value="3">
                3
            </td>
            <td class="button"  action="run" rowspan=2 value="=">
                =
            </td>
        </tr>
        <tr>
            <td class="button" action="added" value="0">
                0
            </td>
            <td class="button" action="operation" value="+">
                +
            </td>
            <td class="button" action="operation" value="-">
                -
            </td>
        </tr>
    </table>
</div>
</body>
</html>
