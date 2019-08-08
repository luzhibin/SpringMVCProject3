package web.controller;

import domain.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
//@SessionAttributes() ---> 将模型中的某个属性暂存到 HttpSession 中，以便多个请求之间可以共享这个属性
/*value
	通过指定key将model数据放到session域当中
type
	把指定类型的模型数据放到session域当中
		*/
//把model中key为name的值存到session中-----》@SessionAttributes("name")
//@SessionAttributes(value = {"name","name2"})
/*@SessionAttributes(types = String.class)*/
@SessionAttributes(value = "sessionGoodsKey" )
public class MyController {

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("使用ModelAndView传值");
        //把数据写到request域中
        modelAndView.addObject("name","luzhibin");
        modelAndView.setViewName("result.jsp");
        return modelAndView;
    }

    @RequestMapping("testModel")
    public String testModel(Model model){
        //把数据写到request域（使用（key，value）的形式）
        model.addAttribute("name","luzhibin");
        //	以属性的类型为键添加属性
        //添加对象   以属性的类型首字母小写为键  添加属性
        Goods myGoods = new Goods();
        myGoods.setName("basketball");
        myGoods.setPrice("100");
        model.addAttribute(myGoods);
        System.out.println(model.asMap());//以首字母类型小写为key
 /*----------------------------------------------------------------------------------------------*/

        //将attributes中的内容复制到当前的model中
        //如果当前model存在相同内容，会被覆盖
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","weiguangyi");
        hashMap.put("Dog",1022);
        model.addAllAttributes(hashMap);
        System.out.println(model.asMap());
/*--------------------------------------------------------------------------------------------------*/

        //以集合中数据的类型做为key，
        //将所提供的Collection中的所有属性复制到这个Map中,
        //如果有同类型会存在覆盖现象
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("CXK");
        arrayList.add(100);
        model.addAllAttributes(arrayList);
        model.addAllAttributes(arrayList);
        System.out.println(model.asMap());
        return "result.jsp";
    }

    @RequestMapping("testMap")
    public String testMap(Map map){
        map.put("key1","value1");
        map.put("key2","value2");
        return "result.jsp";
    }

    @RequestMapping("testSession")
    public String testSession(Model model){
        model.addAttribute("name","luzhibin001");
        model.addAttribute("name2","value2");
        return "result2.jsp";
    }

    @RequestMapping("testSession2")
    // 使用@SessionAttribute来访问预先存在的全局会话属性
    //如果没有，就会报错
    public String testSession2(@SessionAttribute("name") String name){
        System.out.println(name);
        return "result3.jsp";
    }

    @RequestMapping("testSession3")
    public String testSession3(Model model){
        Goods goods = new Goods();
        goods.setName("sessionGoodsName");
        goods.setPrice("sessionGoodsPrice");
        model.addAttribute("sessionGoodsKey",goods);
        return "result3.jsp";
    }

    //此方法就会在对应的映射方法执行之前自动调用
    //并且会自动的将model提前传到方法中
    @ModelAttribute
    public void testModelAttribute(Model model){
        //会先把session中的内容放到model
        //在ModelAttribute写的内容会覆盖掉session的内容
        System.out.println("--------------------------");
        System.out.println(model);
        System.out.println("ModelAttribute执行了");
    }
    @RequestMapping("testModelAttribute")
    //会自动的把对应的模型存放在model中
    public String testModelAttribute(@ModelAttribute("mygoods") Goods mygoods,Model model){
        System.out.println(mygoods);
        System.out.println(model.asMap());
        return "result3.jsp";
    }
}
