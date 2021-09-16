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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/musics")
@PropertySource("classpath:upload_file.properties")
public class MusicController {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IMusicService musicService;
    @GetMapping("")
    public String home(Model model){
        List<Music> musicList = musicService.findAll();
        System.out.println(musicList.size());
        model.addAttribute("list", musicList);
        return "home";
    }

    @GetMapping("/create")
    public ModelAndView creatForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new MusicForm());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createNewStudent(@ModelAttribute MusicForm musicForm){
        //B1: luu file vao vung nho
        //d:/kieuanh/img1.jpg
        MultipartFile multipartFile = musicForm.getMusic();
        //img1.jpg
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //B2: Tao moi doi tuong Student tu studentForm
        Music music1 = new Music();
        music1.setMusic(fileName);
        music1.setId(musicForm.getId());
        music1.setNameMusic(musicForm.getNameMusic());
        music1.setAuthor(musicForm.getAuthor());
        music1.setCategory(musicForm.getCategory());
        //b3: Save lai student
        musicService.save(music1);
        return "redirect:/musics";
    }




}
