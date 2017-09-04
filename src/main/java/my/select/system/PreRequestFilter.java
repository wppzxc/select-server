package my.select.system;


import my.select.netData.down.privilege.RMenu;
import my.select.netData.login.NetUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wpp on 2017/4/20.
 */
public class PreRequestFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//         判断不是登录、登出、获取头像和无权限请求
        if( !request.getRequestURL().toString().contains("/login") &&
                !request.getRequestURL().toString().contains("/logout") &&
                !request.getRequestURL().toString().contains("/noPrivilege") &&
                !request.getRequestURL().toString().contains("/img") &&
                !request.getRequestURL().toString().contains("/timeout")) {
            // 用户登录是否失效
            NetUser user = (NetUser) request.getSession().getAttribute("user");
            if ( user == null || !user.getToken().equals(request.getRequestedSessionId()) ) {
//                response.sendRedirect("/system/timeout");
                request.getRequestDispatcher("/system/timeout").forward(request,response);
                return;
            }
            List<RMenu> menus = (List<RMenu>)request.getSession().getAttribute("menus");
            if(menus != null){
                int i = 0;
                for(RMenu m:menus){
                    if(request.getRequestURI().contains(m.getEnName())){
                        i++;
                    }
                }
                if(i <= 0){
                    request.getRequestDispatcher("/system/noPrivilege").forward(request,response);
                    return;
                }
            }else {
                request.getRequestDispatcher("/system/noPrivilege").forward(request,response);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
