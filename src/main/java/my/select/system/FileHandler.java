package my.select.system;

import my.select.enums.ResponseMsgEnum;
import my.select.netData.down.DownBase;
import my.select.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

/**
 * Created by wpp on 2017/5/25.
 *
 */
@RequestMapping("/system")
@Controller
public class FileHandler {

    @RequestMapping("/savePhoto")
    @ResponseBody
    public String savePhoto(MultipartFile file){
        DownBase down = new DownBase();
        String basePath = "E:\\IDEA_Workspace\\select2\\src\\main\\webapp\\img\\index";
        String fileName = (new Date()).getTime()+ "_" + file.getOriginalFilename();
        //保存文件到指定目录
        String savePath = basePath + fileName;
        File saveFile = new File(savePath);
        try{
            file.transferTo(saveFile);
            down.setData(fileName);
            down.setState(ResponseMsgEnum.OK.getId());
            down.setMsg(ResponseMsgEnum.OK.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            down.setData(null);
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }
        //页面显示用户上传的图片
        return StringUtil.ObjectToJsonString(down);
    }
}
