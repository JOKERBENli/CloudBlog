package com.cloudblog.note.web;

import com.cloudblog.note.po.User;
import com.cloudblog.note.result.ResultInfo;
import com.cloudblog.note.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionName = request.getParameter("actionName");//接受用户行为
        //判断状态，调用对应方法
        if("login".equals(actionName)){
            //用户登录
            userLogin(request,response);
        }
    }
    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取表单提交的请求参数（姓名、密码）
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        // 2.调用Service层的方法，返回ResultInfo对象
        ResultInfo<User> resultInfo = userService.userLogin(userName, userPwd);

        // 3.判断是否登录成功
        if (resultInfo.getCode() == 1) { // 如果成功
            // 将用户信息设置到session作用域中
            request.getSession().setAttribute("user", resultInfo.getResult());
            // 判断用户是否选择记住密码（rem的值是1）
            String rem = request.getParameter("rem");
            // 如果是，将用户姓名与密码存到cookie中，设置失效时间，并响应给客户端
            if ("1".equals(rem)) {
                // 得到Cookie对象
                Cookie cookie = new Cookie("user", userName + "-" + userPwd);
                // 设置失效时间
                cookie.setMaxAge(3 * 24 * 60 * 60);
                // 响应给客户端
                response.addCookie(cookie);
            } else {
                // 如果否，清空原有的cookie对象
                Cookie cookie = new Cookie("user", null);
                // 删除cookie, 设置maxAge为0，即设置cookie失效
                cookie.setMaxAge(0);
                // 响应给客户端
                response.addCookie(cookie);
            }
            // 重定向跳转到index页面
            response.sendRedirect("index"); // 通过重定向懂IndexServlet控制器，设置请求域参数后，动态显示index.jsp右边的页面
        } else { // 如果失败
            // 将resultInfo对象设置到request作用域中
            request.setAttribute("resultInfo", resultInfo);
            // 请求转发跳到登录页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void userLogOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 销毁Session对象
        request.getSession().invalidate();
        // 2. 删除Cookie对象，由于cookie没有单独的删除方法，所以设置他的过期时间为0，就好了
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0); // 设置0，表示删除cookie
        response.addCookie(cookie); // 把cookie响应出去
        // 3. 重定向跳转到登录页面
        response.sendRedirect("login.jsp");
    }

    private void userCenter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置首页动态包含的页面值
        request.setAttribute("changePage", "user/info.jsp"); // 设置需要的参数后再次请求转发到目标页面

        // 2.请求转发跳转到index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
