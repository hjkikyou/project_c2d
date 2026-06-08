package com.comdog.c2d.domain.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comdog.c2d.dto.ProductDto;

/***************사용자 페이지********************/
@Controller
@RequestMapping("/user/product")
public class UserProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/purchase_list")
    public String getPurchaseList(
    		@RequestParam(name="categoryId", required = false) Long categoryId,
    		Model model){
		
		// 1. 카테고리 번호 없이 주소창에 직접 치고 들어오면 메인 페이지로 돌려보냅니다.
        if (categoryId == null) {
            return "redirect:/"; 
        }
        
        // 2. 꼬리표가 정상적으로 있다면 해당 카테고리(+하위) 상품만 조회합니다.
        List<ProductDto> products = service.findProductsWithSubCategories(categoryId);
        
        // 3. 카테고리 이름 넘기기
        String categoryName = service.findCategoryNameById(categoryId);
        
        model.addAttribute("productList", products);
        model.addAttribute("categoryName", categoryName);
		
        return "user/product/purchase_list";
    }
	
	// 대여 목록도 똑같이 처리
    @GetMapping("/rental_list")
    public String getRentalList(
            @RequestParam(name = "categoryId", required = false) Long categoryId, 
            Model model) {
        
        if (categoryId == null) {
            return "redirect:/"; 
        }
        
     // 1. 메인 카테고리 데이터 조회 
        List<ProductDto> products = service.findProductsWithSubCategories(categoryId);
        model.addAttribute("productList", products);
        model.addAttribute("categoryName", service.findCategoryNameById(categoryId));
        
     // ==========================================
     // 2. 대분류별 특별 섹션 매핑 로직
     // ==========================================
        Long specialCategoryId = null; //초기값 null
        
        //categoryId에 따라 특별 카테고리ID 지정
        switch (categoryId.intValue()) {
        case 1: specialCategoryId = 14L; break; // PC -> 미니 PC
        case 3: specialCategoryId = 34L; break; // 모니터 -> 휴대용 모니터
        case 4: specialCategoryId = 44L; break; // 노트북 -> 경량 특화 노트북
    }
     // 특별 카테고리 ID가 세팅되었다면 (즉, 1, 3, 4번 카테고리라면)
        if (specialCategoryId != null) {
            // 특별 카테고리의 이름과 상품 리스트를 조회해서 Model에 담기
            model.addAttribute("specialName", service.findCategoryNameById(specialCategoryId));
            model.addAttribute("specialList", service.findProductsWithSubCategories(specialCategoryId));
        }
        
        return "user/product/rental_list";
    }
	
    
    @GetMapping("/rental_list_more")
    public String getRentalListMore(
    		@RequestParam(name = "categoryId", required = false) Long categoryId,
    		Model model){
    	
    	if (categoryId == null) return "redirect:/";
    	
    	List<ProductDto> products = service.findProductsWithSubCategories(categoryId);
    	
    	model.addAttribute("productList", products);
    	model.addAttribute("categoryName", service.findCategoryNameById(categoryId));
    	
        return "user/product/rental_list_more";
    }
    
    @GetMapping("/assembly_pc_purchase_list")
    public String productCtPcList(){
        return "user/product/assembly_pc_purchase_list";
    }
    
    @GetMapping("/assembly_pc_rental_list")
    public String rentalCtPcList(){
        return "user/product/assembly_pc_rental_list";
    }
    
    @GetMapping("/assembly_pc_detail")
    public String ctPcDetail(Model model) {
        ProductDto product = new ProductDto();
        product.setName("테스트 PC");
        product.setBrand("HP");
        product.setModelName("프로 데스크 4 G1i");
        product.setBasePrice(3000000);
        product.setStockQuantity(10);
        model.addAttribute("product", product);
        return "user/product/assembly_pc_detail";
    }
    
    @GetMapping("/product_list")
    public String productList(){
        return "user/product/product_list";
    }
	
}
	
