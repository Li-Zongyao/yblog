package com.yanger.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanger.blog.service.ConstService;
import com.yanger.blog.vo.ArticleVo;
import com.yanger.blog.vo.ConstVo;
import com.yanger.blog.vo.PageQueryVo;
import com.yanger.common.vo.ApiResponse;
import com.yanger.mybatis.util.ResultPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
//@Token
@RestController
@RequestMapping("/const")
public class ConstApi {
	
	@Autowired
	ConstService constService;
	
	/**
	 * <p>Description: 查询常量表分页数据 </p>  
	 * @author YangHao  
	 * @date 2018年9月6日-下午11:07:41
	 * @return
	 */
	@ApiOperation(value = "查询常量表分页数据", notes = "")
	@PostMapping("/list")
	public ApiResponse<ResultPage<ConstVo>> articleList(@RequestBody PageQueryVo pageQueryVo){
		ApiResponse<ResultPage<ConstVo>> api = new ApiResponse<>();
		try {
			ResultPage<ConstVo> page = constService.getPageData(pageQueryVo);
			api.setData(page);
		} catch (Exception e) {
			api.error("加载常量表分页失败");
			e.printStackTrace();
		}
		return api;
	}
	
	/**
	 * <p>Description: 新增常量 </p>  
	 * @author YangHao  
	 * @date 2018年11月29日-下午10:02:38
	 * @param articleVo
	 * @return
	 */
	@ApiOperation(value = "新增常量", notes = "")
	@PutMapping("/add")
	public ApiResponse<String> articleAdd(@RequestBody ConstVo constVo){
		ApiResponse<String> api = new ApiResponse<>();
		try {
			constService.addArticle(constVo);
		} catch (Exception e) {
			api.error("新增常量处理失败");
			e.printStackTrace();
		}
		return api;
	}

}
