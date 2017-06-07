package servlets;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Денис on 07.06.2017.
 */
public class FilterDemo implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ipAddress = servletRequest.getRemoteAddr();
        String dateTime = new Date().toString();

        System.out.println("\n\n==============================================\n");

        System.out.println("Request...");
        System.out.println("Date/Time: " + dateTime);
        System.out.println("IP:" + ipAddress);

        System.out.println("\n==============================================\n");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
