package s6.ReceipeFood.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class LoginAdminInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
            Map<String, Object> session = invocation.getInvocationContext().getSession();

            if (!session.containsKey("admin")) {
            		System.out.println("Login admin denied...");
                    return Action.LOGIN;
            } 
        			System.out.println("Login admin accepted...");
                    return invocation.invoke();
    }
}
