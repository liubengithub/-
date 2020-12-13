package com.liu.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.Type;
import com.liu.service.TypeService;
import com.liu.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author root
 * @create 2020-12-05 15:16
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    TypeService typeService;
//    @GetMapping("/types")
//    @ResponseBody
//    public MsgUtils list(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
//        //desc降序
//        PageHelper.startPage(pageNum,10);
//        List<Type> types = typeService.typeList();
//        PageInfo<Type> pageInfo = new PageInfo<>(types);
//        return MsgUtils.success().add("pageInfo",pageInfo);
//    }
   @GetMapping("/types")
    public String types(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Model model){
       PageHelper.startPage(pageNum,5);
       List<Type> types = typeService.typeList();
       PageInfo<Type> pageInfo = new PageInfo<Type>(types);
       model.addAttribute("pageInfo",pageInfo);
       return "admin/types";
   }
   @GetMapping("/types/input")
   public String toAddPage(Model model){
       model.addAttribute("type",new Type());
       return "admin/types-input";
   }
   //提交新增表单
   @PostMapping("/types")
   public String post(String name, @Valid Type type, BindingResult result, RedirectAttributes attributes){
       Type type1 = typeService.getTypeByName(name);
       if(type1 != null){
        attributes.addFlashAttribute("msg","提示：不能添加重复的分类");
        return "redirect:/admin/types/input";
       }
       int i = typeService.saveType(type);
       if(i>0){
           attributes.addFlashAttribute("msg","添加成功");
       }else {
           attributes.addFlashAttribute("msg","添加失败");
       }
       return "redirect:/admin/types";
   }
   @GetMapping("/deletetype/{id}")
    public String deleteType(@PathVariable("id") Long id,RedirectAttributes attributes){
       int i = typeService.deleteTypeById(id);
       System.out.println(i);
       if(i>0){
           attributes.addFlashAttribute("msg","删除成功！！！");
       }else {
           attributes.addFlashAttribute("msg","删除失败！！！");
       }
       return "redirect:/admin/types";
   }
   @GetMapping("/types/input/{id}")
   public String toUpdatePage(@PathVariable Long id,Model model){
       Type type = typeService.getTypeById(id);
       model.addAttribute("type",type);
       return "admin/types-input";
   }
   @PostMapping("/types/{id}")
    public String updateTypes(@Valid Type type,@PathVariable Long id,String name,RedirectAttributes attributes){
       Type type1 = typeService.getTypeByName(name);
       if(type1 != null){
           attributes.addFlashAttribute("msg","提示：不能添加重复的分类");
           return "redirect:/admin/types/input/{id}";
       }

       int i = typeService.updateType(type);
       if(i>0){
           attributes.addFlashAttribute("msg","修改成功");
       }else {
           attributes.addFlashAttribute("msg","修改失败");
       }
       return "redirect:/admin/types";
   }
}
