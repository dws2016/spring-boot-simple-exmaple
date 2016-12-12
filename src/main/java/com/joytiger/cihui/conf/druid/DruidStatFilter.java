package com.joytiger.cihui.conf.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by Administrator on 2016/11/7.
 */

@WebFilter(filterName = "druidWebStatFilter",urlPatterns = "/*",initParams = {@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") // 忽略资源
 })
public class DruidStatFilter extends WebStatFilter {
}
