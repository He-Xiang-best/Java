import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
* @ClassName: InitArticleData
* @describe:监听器，用于启动服务器时显示主页得信息
*/
public class InitArticleData implements ServletContextListener,ApplicationContextAware{

   public static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");

   public void contextInitialized(ServletContextEvent sce) {
//		ServletContext application=sce.getServletContext();
//		ArticleService articleService=(ArticleService) applicationContext.getBean("articleService");
//		CategoryService categoryService=(CategoryService) applicationContext.getBean("categoryService");
//		TagService tagService=(TagService) applicationContext.getBean("tagService");
//		PageService pageService=(PageService) applicationContext.getBean("pageService");
//		UserService userService=(UserService) applicationContext.getBean("userService");
//		ResolveToc resolveToc=new ResolveToc();
//		Integer articleCount=articleService.countArticle();//获取博客总数
//		Integer pageSize=7;
//		List<Article> articles=articleService.lisRecenttArticle(pageSize);
//		for(Article article:articles)
//		{
//			article.setSummary(resolveToc.summary(article.getHtmlContent()));
//		}
//		int totalPage=(int)Math.ceil(articleCount*1.0/pageSize);//获取总的页数
//		Integer categoryCount=categoryService.listCategory().size();
//		Integer tagCount=tagService.listTag().size();
//		User user=userService.getUser(1);
//		user.setTags(user.getPersonTag().split(" "));
//		application.setAttribute("articles", articles);
//		application.setAttribute("articleCount", articleCount);
//		application.setAttribute("categoryCount", categoryCount);
//		application.setAttribute("tagCount", tagCount);
//		application.setAttribute("firsttotalPage", totalPage);
//		application.setAttribute("firstnowPage", 1);
//		application.setAttribute("page", pageService.getPage(1));
//		application.setAttribute("inform", user);
   }

   public void contextDestroyed(ServletContextEvent sce) { }
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException { }

}
