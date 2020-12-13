package com.liu.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.FriendLink;
import com.liu.pojo.Picture;
import com.liu.service.PictureService;
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
 * @create 2020-12-08 14:53
 */
@Controller
@RequestMapping("/admin")
public class PictureController {
    @Autowired
    PictureService pictureService;
    @RequestMapping("/pictures")
    public String toPicturs(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,5);
        List<Picture> pictures = pictureService.pictureList();
        PageInfo<Picture> pageInfo = new PageInfo<Picture>(pictures);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/pictures";
    }
    @RequestMapping("/pictures/input")
    public String toPicturesInput(Model model){
        model.addAttribute("picture",new Picture());
        return "admin/pictures-input";
    }
    @PostMapping(value = "/pictures")
    public String addPictures(@Valid Picture picture, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "admin/pictures-input";
        }
        int i = pictureService.addPicture(picture);
        if(i>0){
            attributes.addFlashAttribute("msg","新增成功");
        }else {
            attributes.addFlashAttribute("msg","新增失败");
        }
        return "redirect:/admin/pictures";
    }
    @GetMapping("/deletepicture/{id}")
    public String deletePicture(@PathVariable("id") Long id, RedirectAttributes attributes){
        int i = pictureService.deletePicture(id);
        System.out.println(i);
        if(i>0){
            attributes.addFlashAttribute("msg","删除成功！！！");
        }else {
            attributes.addFlashAttribute("msg","删除失败！！！");
        }
        return "redirect:/admin/pictures";
    }
    @GetMapping("/pictures/input/{id}")
    public String toUpdatePage(@PathVariable("id") Long id,Model model){
        Picture picture = pictureService.getPictureById(id);
        model.addAttribute("picture",picture);
        return "admin/pictures-input";
    }
    @PostMapping("/pictures/{id}")
    public String updatePicture(@Valid Picture picture,RedirectAttributes attributes){
        int i = pictureService.updatePicture(picture);
        if(i>0){
            attributes.addFlashAttribute("msg","修改成功");
        }else {
            attributes.addFlashAttribute("msg","修改失败");
        }
        return "redirect:/admin/pictures";
    }
}
