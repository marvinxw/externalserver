package com.eppen.externalserver.web;

import com.alibaba.fastjson.JSONObject;
import com.eppen.externalserver.common.ApiResponse;
import com.eppen.externalserver.models.ExternalTable;
import com.eppen.externalserver.repository.ExternalTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/external")
public class ExternalServerController {

    @Autowired
    private ExternalTableRepository externalTableRepository;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResponse<ExternalTable> save(@ModelAttribute(value="externalTable") ExternalTable externalTable) {

        externalTable.setDelFlag(1l);
        externalTableRepository.save(externalTable);
        ApiResponse<ExternalTable> res = new ApiResponse<>();
        res.setCode(ApiResponse.OK);
        res.setData(externalTable);
        res.setMsg("成功!!!");

        return res;
    }

    @RequestMapping("")
    public String index(ModelMap map) {
        return "index";
    }

    @RequestMapping(value = "get/{timestamp}", method = RequestMethod.GET)
    public ApiResponse<List<Map<String, Object>>> getDatabaseList(@PathVariable String timestamp) {

        List<Map<String, Object>> externalTableList = externalTableRepository.getAllByUpdateTimeLimitn(timestamp);

        ApiResponse<List<Map<String, Object>>> res = new ApiResponse<>();
        res.setCode(ApiResponse.OK);
        res.setData(externalTableList);
        res.setMsg("成功!!!");

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
