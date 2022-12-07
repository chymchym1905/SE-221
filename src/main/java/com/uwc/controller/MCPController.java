package com.uwc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uwc.dto.MCPDto;
import com.uwc.service.MCPService;

@Controller
@RequestMapping("mcp")
public class MCPController {
	@Autowired
	private MCPService mcpService;
	
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<MCPDto> listMCP = mcpService.findAll();
		model.addAttribute("mcps", listMCP);
		return "mcp/mcp-index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("mcp", new MCPDto());
		return "mcp/mcp-add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(ModelMap model, @ModelAttribute("mcp") MCPDto mcp, 
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		if (errors.hasErrors()) {
			return "mcp/mcp-add";
		}
		try {
			mcpService.add(mcp);
			return "redirect:/mcp";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "mcp/mcp-add";
		}
	}
	
	@RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
	public String edit(ModelMap model, @PathVariable("id") int id) {
		MCPDto mcp =  mcpService.findById(id);
		model.addAttribute("editmcp", mcp);
		return "mcp/mcp-edit";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String editPost(ModelMap model,  @PathVariable("id") int id, MCPDto mcp,
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		if (errors.hasErrors()) {
			mcp.setId(id);
			return "mcp/mcp-edit";
		}
		try {
			mcpService.update(mcp);
			return "redirect:/mcp";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Cập nhật thất bại");
			return "mcp/mcp-edit";
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		mcpService.delete(id);
		return "redirect:/MCP";
	}
	
}
