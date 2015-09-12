package interceptor;

import java.util.*;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginCheck extends AbstractInterceptor{

	public String intercept(ActionInvocation ai) throws Exception {
		
		Map session = ai.getInvocationContext().getSession();
		User user = (User)session.get("loginUser");
		if(user != null){
			return ai.invoke();
		}else{
			ActionContext actionContext = ai.getInvocationContext();
			actionContext.put("prompt", "您还没有登录，请先登录！");
			return "fail";
		}
	}

}
