package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j //로깅기능을 위한 어노테이션 추가
@Controller
public class  ArticleController {
    @Autowired //스프링부트가 미리 생성해놓은 리파지터리 객체주입(DI, 의존성 주입)
    // 컨트롤러의 필드에 붙이면 스프링부트가 만들어놓은 객체 가져와주입시켜줌.
    private ArticleRepository articleRepository; // articleRepository 객체 선언
    @GetMapping("/articles/new") // url요청 접수
    public String newArticleForm() { //뷰페이지를 보여준다. newmustache 파일 보여주는거임
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
//        System.out.println(form.toString());
        //1. DTO를 엔티티로변환
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println(article.toString()); // DTO가 엔티티로 잘 변환되었는지 확인출력.
        //2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
        log.info(saved.toString());
        //스프링부트에서는 객체를 만들지 않아도됨. 알아서 만들어줌. new 필요없엉
//        System.out.println(saved.toString()); // article이 데베에 잘 저장되었는지 확인 출력.
        return "redirect:/articles/"+saved.getId(); //리다이렉트 작성 위치
    }
    
    @GetMapping("/articles/{id}") // 데이터조회요청을 접수함.
    public String show(@PathVariable Long id, Model model) {//매개변수로 id를 받는다.
        log.info("id = " + id); //id받았는지 로그로 확인
//        1. id를 조회해 DB에서 해당데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
//        2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("article", articleEntity);
//        3. 조회한 데이터를 사용자에게 보여주기 위한 뷰 페이지 만들고 반환하기
        return "articles/show"; //목록으로 돌아가기 링크 넣을 뷰파일 확인완료!
    }
        @GetMapping("/articles")
        public String index(Model model){ //객체받아오고
        //1. 모든 데이터 가져오기.
            List<Article> articleEntityList = articleRepository.findAll();
//            2. 모델에 데이터 등록하기
            model.addAttribute("articleList", articleEntityList);
//                    3. 뷰페이지 설정하기
            return"articles/index";
        }
        
    }



