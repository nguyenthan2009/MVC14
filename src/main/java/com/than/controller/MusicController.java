package com.than.controller;

import com.than.model.Music;
import com.than.model.MusicForm;
import com.than.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:upload_file.properties")
public class MusicController {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IMusicService musicService;
    @GetMapping("/musics")
    public String home(Model model){
        List<Music> musicList = musicService.findAll();
        System.out.println(musicList.size());
        model.addAttribute("list", musicList);
        return "home";
    }

    @GetMapping("/create")
    public ModelAndView creatForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("music", new MusicForm());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createNewMusic(@ModelAttribute MusicForm musicForm){
        MultipartFile multipartFile = musicForm.getMusic();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music1 = new Music();
        music1.setMusic(fileName);
        music1.setId(musicForm.getId());
        music1.setNameMusic(musicForm.getNameMusic());
        music1.setAuthor(musicForm.getAuthor());
        music1.setCategory(musicForm.getCategory());
        musicService.save(music1);
        System.out.println(music1);
        return "redirect:/musics";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Music music = musicService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("editForm",music);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("editForm") Music music, MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        music.setMusic(fileName);
        musicService.save(music);
        return "redirect:/musics";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id){
        Music blog = musicService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("deleteForm",blog);
        return modelAndView;
    }
    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute("deleteForm") Music music){
        musicService.delete(music.getId());
        return "redirect:/musics";
    }

}
