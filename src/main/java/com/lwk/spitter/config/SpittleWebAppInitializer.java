package com.lwk.spitter.config;

import com.lwk.spitter.controller.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by lianjia on 2017-5-18.
 *
 * 配置DispatcherServlet
 */
public class SpittleWebAppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        //ContextLoaderListener加载应用中的其他bean，这些bean通常是驱动应用后端
        //的中间层和数据层组件
        return new Class<?>[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //DispatcherServlet加载包含web组件的bean，如控制器，视图解析器以及处理
        //器映射等，这些组件都定义在WebConfig配置类中
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //映射路径为"/"，表示这是应用默认的servlet
        return new String[] {"/"};
    }
}
