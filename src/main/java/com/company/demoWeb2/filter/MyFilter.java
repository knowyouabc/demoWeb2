package com.company.demoWeb2.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/MyFilter/*")
public class MyFilter implements Filter {

        @Override
        public void init(FilterConfig fc) {
            //一般用于加载资源
            String a = "aa";
        }

        @Override
        public void doFilter(ServletRequest srq, ServletResponse srp, FilterChain fc) throws IOException, ServletException {
            //执行内容1，主要是统一操作request
            String a = "aa";
            fc.doFilter(srq, srp);//表示过滤操作完之后放行
            //放行的页面执行完成后，继续执行内容2，主要是统一操作response
        }

        @Override
        public void destroy() {
            //一般用于释放资源
            String a = "aa";
        }

}
