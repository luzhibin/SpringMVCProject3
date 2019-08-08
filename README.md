# SpringMVCProject3总结

## SpringMVC测试工程3：

### 项目环境：

	IDE工具：IDEA、JDK1.8+Tomcat8.5.33、SpringMVC框架版本：spring-webmvc-5.0.7.RELEASE
	所需jar包：存放在\web\WEB-INF\lib目录下

### SpringMVC的传值方式总结：
#### 一.ModelMap

					ModelMap对象主要用于传递控制方法处理数据到结果页面
					也就是说我们把结果页面上需要的数据放到ModelMap对象中即可
					request对象的setAttribute方法的作用: 用来在一个请求过程中传递处理的数据。 
					使用方法与model一样
					
#### 二.Model

				1. Model 和 ModelMap 的实例都是spirng mvc框架来自动创建并作为控制器方法参数传入，用户无需自己创建
				    可以简单地将model的实现类理解成一个Map
					Request级别的模型数据
					Model 是一个接口， 其实现类为ExtendedModelMap，继承了ModelMap类
						
				2.方法介绍：
				
					Model addAttribute(String attributeName, Object attributeValue);
						添加键值属性对
					
					Map<String, Object> asMap();
						将当前的model转换成Map
						
					Model addAllAttributes(Map<String, ?> attributes);
						将attributes中的内容复制到当前的model中
						如果当前model存在相同内容，会被覆盖
						
					Model addAllAttributes(Collection<?> attributeValues);
						以集合中数据的类型做为key，
						将所提供的Collection中的所有属性复制到这个Map中,
						如果有同类型会存在覆盖现象
					
					Model mergeAttributes(Map<String, ?> attributes);
						将attributes中的内容复制到当前的model中
						如果当前model存在相同内容，不会被覆盖
					
					boolean containsAttribute(String attributeName);
						
#### 三. ModelAndView

				需要自己创建
				既包含模型也包含视图

#### 四. @SessionAttributes注解

				将模型中的某个属性暂存到 HttpSession 中，以便多个请求之间可以共享这个属性
				
				value：通过指定key将model数据放到session域当中
				
				type：把指定类型的模型数据放到session域当中 
			
#### 五.@SessionAttribute注解

				 使用@SessionAttribute来访问预先存在的全局会话属性
				 
#### 六.@ModelAttribute
	* 作用：
		* 修改处理方法的参数时,自动把该参数放到model当中
		* 在方法定义上使用 @ModelAttribute 注解,Spring MVC 在调用目标处理方法前，会先逐个调用在方法级上标注了@ModelAttribute 的方法。
		