<!-- 设置 isELIgnored 为 false 表示不忽略el表达式，即使用el表达式 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="ContentType" content="text/html; charset=utf-8"/>
    <title>云博客注册页</title>
    <link href="static/css/login.css" rel="stylesheet" type="text/css"/>
    <script src="static/js/jquery-1.11.3.js" type=text/javascript></script>
    <!-- 引入 util.js，使用他里面的判空方法，注意这里的引入顺序-->
    <script src="static/js/util.js" type="text/javascript"></script>
    <script src="static/js/config.js" type=text/javascript></script>

</head>
<body>
    <!--head-->
    <div id="head">
        <div class="top">
            <a href="http://localhost:8080/cblog/login.jsp">个人博客注册</a>
            <a href="http://localhost:8080/cblog/register.jsp">/登录</a>
        </div>
    </div>

    <!--login box-->
    <div class="wrapper">
        <div id="box">
            <div class="loginbar">用户注册</div>
            <div id="tabcon">
                <div class="box show">
                    <!-- 登录表单，提交到后台servlet的地址为 user -->
                    <form action="register" method="post" id="registerForm">
                        <%-- actionName表示用户行为，通过这个参数可以在 UserServlet 中判断用户当前想要操作的功能 --%>
                        <%-- 其实就是为了不用写多个servlet而加了一个标志 --%>
                        <input type="hidden" name="actionName" value="register"/>

                        <input type="text" class="user yahei16" id="userName" name="userName" style="width: 248px" placeholder="请输入用户名"/><br/><br/>

                        <input type="password" class="pwd yahei16" id="userPwd" name="userPwd" style="width: 248px" placeholder="请输入密码"/><br/><br/>

                        <input type="text" class="user yahei16" id="nickName" name="nickName" style="width: 248px" placeholder="请输入名称"/><br/><br/>


<%--                        <input name="rem" type="checkbox" value="1" class="inputcheckbox"/> <label>记住我</label>--%>

                        <span id="msg" style="color: red; font-size: 12px; margin-left: 10px;">${resultInfo.msg}</span><br/><br/>

                        <input type="button" class="log jc yahei16" value="注 册" onclick="checkRegister()"
                               style="margin-right: 15px"/>

                        <input type="reset" value="取 消" class="reg jc yahei18" onclick="clearContent()"/>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div id="flash">
        <div class="pos">
            <a bgUrl="static/images/banner-bg1.jpg" id="flash1" style="display:block;"><img
                    src="static/images/banner_pic1.jpg"></a>
            <a bgUrl="" id="flash2"><img src="static/images/banner-pic2.jpg"></a><%--static/images/banner-bg2.jpg--%>

        </div>
        <div class="flash_bar">
            <div class="dq" id="f1" onclick="changeflash(1)"></div>
            <div class="no" id="f2" onclick="changeflash(2)"></div>
        </div>
    </div>

    <!--bottom-->
    <div id="bottom">
        <div id="copyright">
            <div class="quick">
                <ul>
                    <li><input type="button" class="quickbd iphone"
                               onclick="location.href=''"/></li>
                    <li><input type="button" class="quickbd android"
                               onclick="location.href=''"/></li>
                    <li><input type="button" class="quickbd pc"
                               onclick="location.href=''"/></li>
                    <div class="clr"></div>
                </ul>
                <div class="clr"></div>
            </div>
            <div class="text">
                Copyright © 2020-2023 <a href="https://blog.csdn.net/qq_45179904?type=blog"> 广州黄埔区 </a> All Rights Reserved
            </div>
        </div>
    </div>

    <div style="margin: 30px 0px auto; text-align: center">
        <p style="color:#333">人生最美好的状态，是安安静静地扎根，默默无闻地汲取养分。终有一天破土而出，定会惊艳众人。</p>
<%--        <span>人生最美好的状态，是安安静静地扎根，默默无闻地汲取养分。终有一天破土而出，定会惊艳众人</span>--%>
    </div>
</body>

</html>

