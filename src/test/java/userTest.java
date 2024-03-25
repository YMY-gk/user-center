import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.jersey.spi.container.WebApplication;
import com.user.UserApplication;
import com.user.common.result.user.ISysPermissionService;
import com.user.common.result.user.impl.SysPermissionService;
import com.user.domain.SysPermission;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserApplication.class})
public class userTest {

    @Resource
    private ISysPermissionService sysPermissionService;

    @Test
    public void msg() {
        String result = HttpUtil.get("http://localhost:8001/user/v2/api-docs");
        JSONObject jsonObject = JSONUtil.parseObj(result);
        JSONObject jsonArray = jsonObject.getJSONObject("paths");
        String basePath = jsonObject.getStr("basePath");
        jsonArray.keySet().forEach(item -> {
            String url = basePath + item;
            QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(SysPermission::getUrl,url);
            SysPermission permission   = sysPermissionService.getOne(queryWrapper);
            if (ObjectUtil.isNotEmpty(permission)){
                return;
            }
            permission = new SysPermission();
            JSONObject object = jsonArray.getJSONObject(item);
            JSONObject get = object.getJSONObject("get");
            JSONObject post = object.getJSONObject("post");
            String name = null;
            String type = null;
            String source = null;
            if (ObjectUtil.isNotEmpty(post)) {
                source = post.getJSONArray("tags").getStr(0);
                name = source + "-" + post.getStr("summary");
                type = "POST";
            } else if (ObjectUtil.isNotEmpty(get)) {
                source = get.getJSONArray("tags").getStr(0);
                name = source + "-" + get.getStr("summary");
                type = "GET";
            } else {
                return;
            }

            permission.setUrl(url)
                    .setName(name)
                    .setSource(source)
                    .setType(type)
                    .setIsOpen(0)
                    .setCreateBy("系统同步");
            log.info("接口参数：{}", permission);
            sysPermissionService.save(permission);
        });

    }
}
