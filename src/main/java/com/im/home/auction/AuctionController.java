package com.im.home.auction;

import java.io.EOFException;
import java.lang.reflect.Member;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import com.im.home.auction.product.ProductMapper;
import com.im.home.auction.product.ProductVO;
import com.im.home.members.MembersMapper;
import com.im.home.members.MembersService;
import com.im.home.members.MembersVO;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/auction/*")
@Slf4j
public class AuctionController {
	
	@Autowired
	private MembersMapper membersMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	private AuctionService auctionService;
	
	
	@GetMapping("vidu")
	public void viduTest() {
		
		
	}

	
	
	
	@GetMapping("test")
	@ResponseBody
	public void testest() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//1.Header
		
		HttpHeaders headers = new HttpHeaders();
		
		//header : key : value 형식
		//headers.add("key","value");
		//headers.set헤더명("값");
		
		//2. 파라미

		
		
		
		
		
//		MembersVO membersVO = auctionService 
//		
//		//= membersMapper.getMembersLogin("goody");
//		
//		return membersVO;
	}
	
	
	@GetMapping("chat")
	public void chatTest() {
		log.info("@chatController, chat Get()");
		
	}
	
	
	
	@GetMapping("detail")
	public String getDetail() throws Exception{
		return "auction/detail";
	}
	
	@GetMapping("add")
	public ModelAndView setAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductVO> productVOs = productMapper.getList();
		
		mv.addObject("list", productVOs);
		mv.setViewName("auction/add");
		
		return mv;
		
		
	
	}
	
	@PostMapping("add")
	public void setAdd(AuctionVO auctionVO) throws Exception{
		
	}
	
	
	@PostMapping("asking")
	@ResponseBody
	public void setAddAskingPrice(AskingPriceVO askingPriceVO) throws Exception{
		
	}
	
	@GetMapping("list")
	public void getList() throws Exception{
		
	}
	
	
	@GetMapping("nick")
	@ResponseBody
	public String getNick(MembersVO membersVO,
			@RequestParam String nickName ,
			Principal principal, 
			Authentication authentication, Cookie cookie) throws Exception{
		
		log.info("Principal : {}", principal);
		
		
		return principal.getName();
	}
	
	
	
	// ======================================= 판매 상품 ===========================================
	
	
	@GetMapping("product/add")
	public String setProductAdd() throws Exception{
		return "item/add";
	}
	
	
	@PostMapping("product/add")
	public String setProductAdd(ProductVO productVO) throws Exception{
		int result = productMapper.setAdd(productVO);
		
		return "redirect:/auction/list";
		
	}
	
	@GetMapping("product/list")
	public ModelAndView getProductList() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductVO> productVOs = productMapper.getList();
		
		mv.addObject("list", productVOs);
		mv.setViewName("item/list");
		
		return mv;
		
	}
	
	
	
	
}
