package com.eppen.externalserver.web;

import com.alibaba.fastjson.JSONObject;
import com.eppen.externalserver.common.ApiResponse;
import com.eppen.externalserver.models.ExternalTable;
import com.eppen.externalserver.repository.ExternalTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/external")
public class ExternalServerController {

    @Autowired
    private ExternalTableRepository externalTableRepository;

    @RequestMapping("")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");

        map.put("message", "hello eppon");

        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<ExternalTable> save(@ModelAttribute(value="externalTable") ExternalTable externalTable) {

//        ExternalTable externalTable = JSONObject.parseObject(requestBody, ExternalTable.class);

        externalTable = externalTableRepository.save(externalTable);

        ApiResponse<ExternalTable> res = new ApiResponse<>();
        res.setCode(ApiResponse.OK);
        res.setMsg("SUCCESS");
        res.setData(externalTable);
        return res;
    }
//    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
//    @ResponseBody
//    public ApiResponse<ExternalTable> addDatabase(@RequestBody String requestBody) {
//
//        ExternalTable externalTable = JSONObject.parseObject(requestBody, ExternalTable.class);
//
//        externalTable = externalTableRepository.save(externalTable);
//
//        ApiResponse<ExternalTable> res = new ApiResponse<>();
//        res.setCode(ApiResponse.OK);
//        res.setMsg("SUCCESS");
//        res.setData(externalTable);
//        return res;
//    }
}
