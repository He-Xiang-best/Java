import com.blog.entity.User;
import com.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

 /** 
 * @ClassName: myRealm
 * @describe:Shiro自定义Realm
 */
public class myRealm  extends AuthorizingRealm{
	@Resource 
	private UserService userService;

	@Override
//	授权查询回调函数
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
//	认证回调函数,进行登陆认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=(String)token.getPrincipal();//获取用户名
		User user=userService.getUserByUsername(username);
		if(user==null)
		{
			throw new UnknownAccountException("没有找到该账号");  
		}
		if(user!=null)
		{
			SecurityUtils.getSubject().getSession().setAttribute("user", user);
			AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getUserPass(),"myRealm");
			return authenticationInfo;
		}
		return null;
	}
	
}
