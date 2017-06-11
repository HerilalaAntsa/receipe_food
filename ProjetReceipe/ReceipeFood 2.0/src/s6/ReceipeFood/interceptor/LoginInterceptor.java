package s6.ReceipeFood.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import s6.ReceipeFood.modele.Utilisateur;

public class LoginInterceptor  extends AbstractInterceptor {

        @Override
        public String intercept(ActionInvocation invocation) throws Exception {
                Map<String, Object> session = invocation.getInvocationContext().getSession();

                Utilisateur user = (Utilisateur) session.get("user");

                if (user == null) {
                		System.out.println("Login denied...");
                        return Action.LOGIN;
                } 
            			System.out.println("Login accepted...");
                        return invocation.invoke();
        }
}